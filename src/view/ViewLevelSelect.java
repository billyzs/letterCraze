package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;


public class ViewLevelSelect extends JPanel{
	JButton btnThisLevel;
	JLabel lblSequence;
	JLabel lblHighScore;
	JLabel lblStart;
	JLabel lblLcoked;
	
	public ViewLevelSelect() {
		
		btnThisLevel = new JButton("Level Name");
		btnThisLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		lblSequence = new JLabel("a number");
		add(lblSequence);
		add(btnThisLevel);
		
		lblHighScore = new JLabel("Previous High score");
		add(lblHighScore);
		
		lblStart = new JLabel("***");
		add(lblStart);
		
		lblLcoked = new JLabel("A padlock");
		add(lblLcoked);
	}
	
}
