package view;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.StartLevelController;
import model.Level;
public class LevelMenuView extends JPanel implements IView {
	JButton btnThisLevel;
	JLabel lblSequence;
	JLabel lblHighScore;
	JLabel lblStar;
	JLabel lblLocked;
	Image[] stars = new Image[3];
//	GRect background;
	
	public LevelMenuView(int seq, Level l, StartLevelController slc) {
		
		btnThisLevel = new JButton(l.getName());
		btnThisLevel.addActionListener(slc);
		
		lblSequence = new JLabel(Integer.toString(seq));
		add(lblSequence);
		add(btnThisLevel);
		
		lblHighScore = new JLabel(Integer.toString(l.getHighscore()));
		add(lblHighScore);
		
		lblStar = new JLabel("***"); //TODO replace with proper icons
		add(lblStar);
		
		lblLocked = new JLabel("A padlock"); //TODO 
		add(lblLocked);
	}
	
	// Listeners for the button???
	JLabel getLabelSequence(){return lblSequence;}
	JLabel getLabelHighScore(){return lblHighScore;}
	JLabel getLabelStar(){return lblStar;};
	JLabel getLabelLocked(){return lblLocked;}
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
