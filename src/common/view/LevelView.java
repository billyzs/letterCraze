package common.view;


import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.SwingConstants;

import common.model.Level;

public class LevelView extends JPanel implements IView {
	BoardView board;
	StarsView stars;
	SubmittedWordsView submittedWords;
	JButton exit;
	JButton reset;
	JButton finish;
	JButton undo;
//	JButton submitWord;
	JLabel currentWord;
	JLabel name;
	JLabel timer;
	Level level;
	
	GroupLayout layout;
	
	public LevelView(){};
	public LevelView(Level l){
		this.level = l;

		BoardView panel = new BoardView(level.getBoard());
		JButton exit = new JButton("Exit");
		JButton reset = new JButton("Reset");
		JButton undo = new JButton("Undo");
		JButton finish = new JButton("Finish Level");
		JLabel name = new JLabel(level.getName());
		JLabel timer = new JLabel("000");
		StarsView panel_1 = new StarsView(level);
		
		SubmittedWordsView panel_2 = new SubmittedWordsView(this.level.getSubmittedWords(), this.level.getCurrentWord());

		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
	
		GroupLayout groupLayout = new GroupLayout(this);

		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(6)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 577, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
								.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
									.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 254, GroupLayout.PREFERRED_SIZE)
									.addGap(22))))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(exit, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(reset, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(undo, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(name, GroupLayout.PREFERRED_SIZE, 456, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(timer, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(finish, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(exit)
						.addComponent(reset)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(undo)
							.addComponent(finish)
							.addComponent(timer)
							.addComponent(name, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 569, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 394, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

		//Convert shitty window builder to normal vars
		this.board = panel;
		this.exit = exit;
		this.reset = reset;
		this.undo = undo;
		this.name = name;
		this.finish = finish;
		this.stars = panel_1;
		this.submittedWords = panel_2;
		this.layout = groupLayout;

		//Grey out finishbutton if necesary
		if(this.level.getCurrentPoints() >= (this.level.getTargetScore()/3))
            this.finish.setEnabled(true);
		else
			this.finish.setEnabled(false);

		//Add to the content pane and show
		
		System.out.println(this.getBackground().toString());
	}
	
	@Override
	public void show(){
		ContentPane.get().add(this);
		//this.app.setLevelView(this);

		//refresh
		ContentPane.get().invalidate();
		ContentPane.get().validate();
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		ContentPane.get().remove(this);
		ContentPane.get().invalidate();
		ContentPane.get().validate();
	}

	//GETTERS
	public JButton getExitButton() { return this.exit; }
	public JButton getResetButton() { return this.reset; }
	public JButton getFinishButton() { return this.finish; }
	public JButton getUndoButton() { return this.undo; }
	public BoardView getBoardView() { return this.board; }
	public SubmittedWordsView getSubmittedWordsView() { return this.submittedWords; }
	public StarsView getStarsView() { return this.stars; }

	//Redisplays all tilesviews, might do other stuff later
	public void refresh() {
		for(ArrayList<TileView> row : this.board.getTileViews()){
            for(TileView tv : row){
                tv.updateColor();
                tv.updateLabel();
                this.stars.refresh();
            }
		}

		//Redisplay submitted words
		this.submittedWords.refresh();
		this.stars.refresh();
		
		//Grey out finishbutton if necesary
		if(this.level.getCurrentPoints() >= (this.level.getTargetScore()/3))
            this.finish.setEnabled(true);
		else
			this.finish.setEnabled(false);
	}
	public Level getLevel() {
		return this.level;
	}

	
}
