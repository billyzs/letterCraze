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
	String[] stars = new String[3];
	int highscore;
	int targetScore;

	public Level getTheLevel() {
		return theLevel;
	}

	Level theLevel;
//	GRect background;
	
	public LevelMenuView(int seq, Level l){
		
		super();
		theLevel = l;
		highscore = this.theLevel.getHighscore();
		targetScore = this.theLevel.getTargetScore();
		btnThisLevel = new JButton(l.getName());
				
		//I added 1 to the sequence, to make it 1-15
		lblSequence = new JLabel(Integer.toString(seq + 1));
		add(lblSequence);
		add(btnThisLevel);
		
		lblHighScore = new JLabel(Integer.toString(l.getHighscore()));
		add(lblHighScore);
		
		
		if(highscore >= (targetScore/3.0)){
			stars[0] ="\u2605"; // ONE STAR UNLOCKED "\u2605" is black, "\u2606" is white
		} else {
			stars[0] ="\u2606";
		}
		
		if(highscore >= (2.0*(targetScore/3.0))){
			stars[1] ="\u2605"; // TWO STARS UNLOCKED "\u2605" is black, "\u2606" is white
		} else {
			stars[1] ="\u2606";
		}
		
		if(highscore >= targetScore){
			stars[2] ="\u2605";// THREE STARS UNLOCKED "\u2605" is black, "\u2606" is white
		} else {
			stars[2] ="\u2606";
		}
		
		lblStar = new JLabel(stars[0] + stars[1] + stars[2]); //// "\u2605" is black, "\u2606" is white
		add(lblStar);
		
		this.setSize(900, 45); //TODO standardize size
		
		if (theLevel.isUnlocked()) {
			btnThisLevel.setEnabled(true);
			lblLocked = new JLabel("Unlocked");
			add(lblLocked);
		} else {
			btnThisLevel.setEnabled(false);
			lblLocked = new JLabel("Locked");
			add(lblLocked);
		}
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
		this.setVisible(true);

	}

	@Override
	public void hide() {
		this.setVisible(false);
	}
	
	public void refresh() {
		highscore = this.theLevel.getHighscore();
		
		if(highscore >= (targetScore/3)){
			stars[0] ="\u2605"; // ONE STAR UNLOCKED "\u2605" is black, "\u2606" is white
		} else {
			stars[0] ="\u2606";
		}
		
		if(highscore >= (2*(targetScore/3))){
			stars[1] ="\u2605"; // TWO STARS UNLOCKED "\u2605" is black, "\u2606" is white
		} else {
			stars[1] ="\u2606";
		}
		
		if(highscore >= targetScore){
			stars[2] ="\u2605";// THREE STARS UNLOCKED "\u2605" is black, "\u2606" is white
		} else {
			stars[2] ="\u2606";
		}
		
		lblStar.setText(stars[0] + stars[1] + stars[2]);
		lblHighScore.setText(""+ highscore);
		
		if (theLevel.isUnlocked()) {
			btnThisLevel.setEnabled(true);
			lblLocked.setText("Unlocked");
		} else {
			btnThisLevel.setEnabled(false);
			lblLocked.setText("Locked");
		}
		
		
	}

}
