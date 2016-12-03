package common.view;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SubmittedWordsView extends JPanel implements IView {
	private JTextField textField;
	
	public SubmittedWordsView(){

		this.initialize();
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Create the panel.
	 */
	public void initialize() {
		
		JLabel lblSubmittedWords = new JLabel("Submitted Words");
		lblSubmittedWords.setBounds(61, 44, 148, 22);
		lblSubmittedWords.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblSubmittedWords.setHorizontalAlignment(SwingConstants.CENTER);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(197, 6, 76, 29);
		
		JLabel lblWord = new JLabel("Word");
		lblWord.setBounds(119, 78, 32, 16);
		lblWord.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label = new JLabel("Word");
		label.setBounds(119, 106, 32, 16);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel label_1 = new JLabel("Word");
		label_1.setBounds(119, 134, 32, 16);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		setLayout(null);
		
		JLabel label_2 = new JLabel("Word");
		label_2.setBounds(119, 162, 32, 16);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		add(label_2);
		add(btnSubmit);
		add(lblSubmittedWords);
		add(label);
		add(lblWord);
		add(label_1);
		
		JLabel label_3 = new JLabel("Word");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setBounds(119, 190, 32, 16);
		add(label_3);
		
		JLabel label_4 = new JLabel("Word");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setBounds(119, 218, 32, 16);
		add(label_4);
		
		JLabel label_5 = new JLabel("Word");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setBounds(119, 246, 32, 16);
		add(label_5);
		
		JLabel label_6 = new JLabel("Word");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setBounds(119, 274, 32, 16);
		add(label_6);
		
		JLabel label_7 = new JLabel("Word");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setBounds(119, 302, 32, 16);
		add(label_7);
		
		JLabel label_8 = new JLabel("Word");
		label_8.setHorizontalAlignment(SwingConstants.CENTER);
		label_8.setBounds(119, 330, 32, 16);
		add(label_8);
		
		JLabel label_9 = new JLabel("Word");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setBounds(119, 358, 32, 16);
		add(label_9);
		
		JLabel lblXxxxx = new JLabel("Current Word:");
		lblXxxxx.setHorizontalAlignment(SwingConstants.LEFT);
		lblXxxxx.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblXxxxx.setBounds(6, 7, 106, 22);
		add(lblXxxxx);
		
		JLabel lblXxxxxxxx = new JLabel("XXXXXXXX");
		lblXxxxxxxx.setHorizontalAlignment(SwingConstants.LEFT);
		lblXxxxxxxx.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblXxxxxxxx.setBounds(98, 8, 100, 22);
		add(lblXxxxxxxx);

	}
}