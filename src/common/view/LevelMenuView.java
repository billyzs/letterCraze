package common.view;

import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import common.model.Level;
public class LevelMenuView extends JPanel implements IView {
	JButton btnThisLevel;
	JLabel lblSequence;
	JLabel lblHighScore;
	JLabel lblStar;
	JLabel lblLocked;
	Image[] stars = new Image[3];
//	GRect background;
	
	public LevelMenuView(int seq, Level l){
		
		super();
		btnThisLevel = new JButton(l.getName());
				
		//I added 1 to the sequence, to make it 1-15
		lblSequence = new JLabel(Integer.toString(seq + 1));
		add(lblSequence);
		add(btnThisLevel);
		
		lblHighScore = new JLabel(Integer.toString(l.getHighscore()));
		add(lblHighScore);
		
		lblStar = new JLabel("���������"); //��� or ��� based on completion
		add(lblStar);
		
		lblLocked = new JLabel("Unlocked"); //TODO ���� or ���� based on lock/unlocked
		add(lblLocked);
		this.setSize(900, 45); //TODO standardize size
	}
	
	//TODO Listeners for the button???
	// I envisioned this common.view to be shared btwn the builder and the app,
	// so the child classes would implement listeners from different controllers to either start at game, or start modifying a game
	
	public JLabel getLabelSequence(){return lblSequence;}
	public JLabel getLabelHighScore(){return lblHighScore;}
	public JLabel getLabelStar(){return lblStar;};
	public JLabel getLabelLocked(){return lblLocked;}
	public JButton getButton(){ return this.btnThisLevel;};

	@Override
	public void show() {
		// TODO Auto-generated method stub
		this.setVisible(true);

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		this.setVisible(false);
	}

}
