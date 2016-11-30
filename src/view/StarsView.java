package view;

import javax.swing.JPanel;
import javax.swing.JProgressBar;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class StarsView extends JPanel {

	/**
	 * Create the panel.
	 */
	public StarsView() {
		setLayout(null);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(6, 6, 231, 21);
		progressBar.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		progressBar.setValue(66);
		progressBar.setPreferredSize(new Dimension(400, 10));
		add(progressBar);
		
		JLabel label_1 = new JLabel("���");
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(64, 21, 34, 27);
		add(label_1);
		
		JLabel label = new JLabel("���");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		label.setBounds(140, 21, 34, 27);
		add(label);
		
		JLabel label_2 = new JLabel("���");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		label_2.setBounds(218, 21, 34, 27);
		add(label_2);

	}

}
