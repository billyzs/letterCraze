package common.view;

import javax.swing.JPanel;
import javax.swing.JProgressBar;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import common.model.Level;

public class StarsView extends JPanel {

	int score;
	int targetScore;
	Level level;
	JProgressBar progressBar;
	JLabel currentScorelabel;
	JLabel label_1;
	JLabel label_2;
	JLabel label_3;
	
	public StarsView(Level l) {
		this.level = l;
		targetScore = this.level.getTargetScore();
		setLayout(null);
		
		progressBar = new JProgressBar();
		progressBar.setMaximum(targetScore);
		progressBar.setBounds(6, 6, 231, 21);
		progressBar.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		progressBar.setValue(0);
		progressBar.setPreferredSize(new Dimension(400, 10));
		add(progressBar);
		
		label_1 = new JLabel("\u2606"); // "\u2605" is black, "\u2606" is white
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(64, 21, 34, 27);
		add(label_1);
		
		label_2 = new JLabel("\u2606");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		label_2.setBounds(140, 21, 34, 27);
		add(label_2);
		
		label_3 = new JLabel("\u2606");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		label_3.setBounds(218, 21, 34, 27);
		add(label_3);
		
		currentScorelabel = new JLabel("000");
		currentScorelabel.setBounds(6, 29, 61, 16);
		add(currentScorelabel);
	}

	public void refresh() {
		score = this.level.getCurrentPoints();
		this.currentScorelabel.setText(""+score);
		this.progressBar.setValue(score);
		
		if(score >= (targetScore/3)){
			label_1.setText("\u2605"); // ONE STAR UNLOCKED "\u2605" is black, "\u2606" is white
		} else {
			label_1.setText("\u2606");
		}
		
		if(score >= (2*(targetScore/3))){
			label_2.setText("\u2605"); // TWO STARS UNLOCKED "\u2605" is black, "\u2606" is white
		} else {
			label_2.setText("\u2606");
		}
		
		if(score >= targetScore){
			label_3.setText("\u2605"); // THREE STARS UNLOCKED "\u2605" is black, "\u2606" is white
		} else {
			label_3.setText("\u2606");
		}
		
		this.repaint();
		
	}

}
