package common.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class BuilderView extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public BuilderView() {
		
		BoardView panel = new BoardView("");
		panel.setBounds(12, 41, 577, 569);
		
		
		JButton btnExitWithoutSaving = new JButton("Exit without saving");
		btnExitWithoutSaving.setBounds(6, 6, 146, 29);
		
		JLabel lblChooseAtLeast = new JLabel("Select at least 9 adjacent tiles:");
		lblChooseAtLeast.setBounds(158, 8, 293, 20);
		lblChooseAtLeast.setHorizontalAlignment(SwingConstants.LEFT);
		lblChooseAtLeast.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		
		JButton btnSaveChanges = new JButton("Save");
		btnSaveChanges.setBounds(812, 6, 82, 29);
		
		JButton btnDeleteLevel = new JButton("Delete Level");
		btnDeleteLevel.setBounds(600, 6, 120, 29);
		
		JButton btnPreviewLevel = new JButton("Preview");
		btnPreviewLevel.setBounds(720, 6, 91, 29);
		setLayout(null);
		add(panel);
		add(btnExitWithoutSaving);
		add(lblChooseAtLeast);
		add(btnDeleteLevel);
		add(btnPreviewLevel);
		add(btnSaveChanges);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Puzzle", "Lighting", "Theme"}));
		comboBox.setBounds(675, 85, 108, 27);
		add(comboBox);
		
		JLabel lblLevelType = new JLabel("Level type:");
		lblLevelType.setBounds(601, 89, 82, 16);
		add(lblLevelType);
		
		JLabel lblLevelSettings = new JLabel("Level Settings");
		lblLevelSettings.setHorizontalAlignment(SwingConstants.CENTER);
		lblLevelSettings.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblLevelSettings.setBounds(680, 41, 148, 22);
		add(lblLevelSettings);
		
		JLabel lblPointThresholds = new JLabel("Point thresholds:");
		lblPointThresholds.setBounds(601, 140, 108, 16);
		add(lblPointThresholds);
		
		JLabel label = new JLabel("★");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(601, 168, 52, 16);
		add(label);
		
		JLabel label_1 = new JLabel("★ ★");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setBounds(601, 190, 52, 16);
		add(label_1);
		
		JLabel label_2 = new JLabel("★ ★ ★");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(601, 212, 52, 16);
		add(label_2);
		
		textField = new JTextField();
		textField.setBounds(658, 163, 77, 26);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(658, 185, 77, 26);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(658, 207, 77, 26);
		add(textField_2);
		
		JLabel lblInsertDesiredWords = new JLabel("Words if level type Theme, separate with commas");
		lblInsertDesiredWords.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		lblInsertDesiredWords.setBounds(601, 271, 293, 16);
		add(lblInsertDesiredWords);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(601, 299, 293, 81);
		add(textPane);

	}
}
