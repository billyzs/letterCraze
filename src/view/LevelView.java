package view;


import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import application.Application;
import controller.ExitLevelController;
import model.Level;

public class LevelView extends JPanel implements IView {
	BoardView board;
	StarsView stars;
	SubmittedWordsView submittedWords;
	JButton exit;
	JButton reset;
	JButton finish;
	JButton undo;
	JButton submitWord;
	JLabel currentWord;
	JLabel name;
	JLabel timer;
	Level level;
	
	GroupLayout layout;
	
	
	public LevelView(Level l){
		this.level = l;

		BoardView panel = new BoardView("X");
		
		JButton button = new JButton("Exit");
		
		JButton button_1 = new JButton("Reset");
		
		JButton button_2 = new JButton("Undo");
		
		JLabel label = new JLabel("1 - This is the name level and theme if needed");

		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JButton button_3 = new JButton("Finish Level");
		
		JLabel label_1 = new JLabel("000");
		
		StarsView panel_1 = new StarsView();
		
		SubmittedWordsView panel_2 = new SubmittedWordsView();
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
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(button_2, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 456, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(button_3, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(button)
						.addComponent(button_1)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
							.addComponent(button_2)
							.addComponent(button_3)
							.addComponent(label_1)
							.addComponent(label, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)))
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
		this.exit = button;
		this.reset = button_1;
		this.undo = button_2;
		this.name = label;
		this.finish = button_3;
		this.stars = panel_1;
		this.submittedWords = panel_2;
		this.layout = groupLayout;

		//Add to the content pane and show
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

	public JButton getExitButton() { return this.exit; }
	public JButton getResetButton() { return this.reset; }
	public JButton getFinishButton() { return this.finish; }
	public JButton getUndoButton() { return this.undo; }
}
