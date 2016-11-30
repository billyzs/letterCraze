package builder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableModel;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import view.ViewLevelSelect;

public class BuilderApp extends JFrame {

	private JPanel contentPane;
	private JTextField txtSelectALevel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuilderApp frame = new BuilderApp();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BuilderApp() {
		setTitle("LetterCraze Builder");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 591);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		txtSelectALevel = new JTextField();
		txtSelectALevel.setText("Select a level to build or modify");
		txtSelectALevel.setColumns(10);
		
		Box horizontalBox = Box.createHorizontalBox();
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		
		JButton button = new JButton("New button");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		horizontalBox_1.add(button);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		
		JButton button_1 = new JButton("New button");
		horizontalBox_2.add(button_1);
		
		JLabel label = new JLabel("New label");
		label.setAlignmentX(1.0f);
		horizontalBox_2.add(label);
		
		Box horizontalBox_3 = Box.createHorizontalBox();
		
		JButton button_2 = new JButton("New button");
		horizontalBox_3.add(button_2);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setAlignmentX(1.0f);
		horizontalBox_3.add(label_1);
		
		Box horizontalBox_4 = Box.createHorizontalBox();
		
		JButton button_3 = new JButton("New button");
		horizontalBox_4.add(button_3);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setAlignmentX(1.0f);
		horizontalBox_4.add(label_2);
		
		Box horizontalBox_5 = Box.createHorizontalBox();
		
		JButton button_4 = new JButton("New button");
		horizontalBox_5.add(button_4);
		
		JLabel label_3 = new JLabel("New label");
		label_3.setAlignmentX(1.0f);
		horizontalBox_5.add(label_3);
		
		Box horizontalBox_6 = Box.createHorizontalBox();
		
		JButton button_5 = new JButton("New button");
		horizontalBox_6.add(button_5);
		
		JLabel label_4 = new JLabel("New label");
		label_4.setAlignmentX(1.0f);
		horizontalBox_6.add(label_4);
		
		Box horizontalBox_7 = Box.createHorizontalBox();
		
		JButton button_6 = new JButton("New button");
		horizontalBox_7.add(button_6);
		
		JLabel label_5 = new JLabel("New label");
		label_5.setAlignmentX(1.0f);
		horizontalBox_7.add(label_5);
		
		Box horizontalBox_8 = Box.createHorizontalBox();
		
		JButton button_7 = new JButton("New button");
		horizontalBox_8.add(button_7);
		
		JLabel label_6 = new JLabel("New label");
		label_6.setAlignmentX(1.0f);
		horizontalBox_8.add(label_6);
		
		Box horizontalBox_9 = Box.createHorizontalBox();
		
		JButton button_8 = new JButton("New button");
		horizontalBox_9.add(button_8);
		
		JLabel label_7 = new JLabel("New label");
		label_7.setAlignmentX(1.0f);
		horizontalBox_9.add(label_7);
		
		Box horizontalBox_10 = Box.createHorizontalBox();
		
		JButton button_9 = new JButton("New button");
		horizontalBox_10.add(button_9);
		
		JLabel label_8 = new JLabel("New label");
		label_8.setAlignmentX(1.0f);
		horizontalBox_10.add(label_8);
		
		Box horizontalBox_11 = Box.createHorizontalBox();
		
		JButton button_10 = new JButton("New button");
		horizontalBox_11.add(button_10);
		
		JLabel label_9 = new JLabel("New label");
		label_9.setAlignmentX(1.0f);
		horizontalBox_11.add(label_9);
		
		Box horizontalBox_12 = Box.createHorizontalBox();
		
		JButton button_11 = new JButton("New button");
		horizontalBox_12.add(button_11);
		
		JLabel label_10 = new JLabel("New label");
		label_10.setAlignmentX(1.0f);
		horizontalBox_12.add(label_10);
		
		Box horizontalBox_13 = Box.createHorizontalBox();
		
		JButton button_12 = new JButton("New button");
		horizontalBox_13.add(button_12);
		
		JLabel label_11 = new JLabel("New label");
		label_11.setAlignmentX(1.0f);
		horizontalBox_13.add(label_11);
		
		Box horizontalBox_14 = Box.createHorizontalBox();
		
		JButton button_13 = new JButton("New button");
		horizontalBox_14.add(button_13);
		
		JLabel label_12 = new JLabel("New label");
		label_12.setAlignmentX(1.0f);
		horizontalBox_14.add(label_12);
		
		Box horizontalBox_15 = Box.createHorizontalBox();
		
		JButton button_14 = new JButton("New button");
		horizontalBox_15.add(button_14);
		
		JLabel label_13 = new JLabel("New label");
		label_13.setAlignmentX(1.0f);
		horizontalBox_15.add(label_13);
		
		ViewLevelSelect viewLevelSelect = new ViewLevelSelect();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(horizontalBox, GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(txtSelectALevel, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
							.addGap(99)
							.addComponent(viewLevelSelect, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
						.addComponent(horizontalBox_1, GroupLayout.PREFERRED_SIZE, 556, GroupLayout.PREFERRED_SIZE)
						.addComponent(horizontalBox_2, GroupLayout.PREFERRED_SIZE, 556, GroupLayout.PREFERRED_SIZE)
						.addComponent(horizontalBox_3, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 556, GroupLayout.PREFERRED_SIZE)
						.addComponent(horizontalBox_4, GroupLayout.PREFERRED_SIZE, 556, GroupLayout.PREFERRED_SIZE)
						.addComponent(horizontalBox_5, GroupLayout.PREFERRED_SIZE, 556, GroupLayout.PREFERRED_SIZE)
						.addComponent(horizontalBox_6, GroupLayout.PREFERRED_SIZE, 556, GroupLayout.PREFERRED_SIZE)
						.addComponent(horizontalBox_7, GroupLayout.PREFERRED_SIZE, 556, GroupLayout.PREFERRED_SIZE)
						.addComponent(horizontalBox_8, GroupLayout.PREFERRED_SIZE, 556, GroupLayout.PREFERRED_SIZE)
						.addComponent(horizontalBox_9, GroupLayout.PREFERRED_SIZE, 556, GroupLayout.PREFERRED_SIZE)
						.addComponent(horizontalBox_10, GroupLayout.PREFERRED_SIZE, 556, GroupLayout.PREFERRED_SIZE)
						.addComponent(horizontalBox_11, GroupLayout.PREFERRED_SIZE, 556, GroupLayout.PREFERRED_SIZE)
						.addComponent(horizontalBox_12, GroupLayout.PREFERRED_SIZE, 556, GroupLayout.PREFERRED_SIZE)
						.addComponent(horizontalBox_13, GroupLayout.PREFERRED_SIZE, 556, GroupLayout.PREFERRED_SIZE)
						.addComponent(horizontalBox_14, GroupLayout.PREFERRED_SIZE, 556, GroupLayout.PREFERRED_SIZE)
						.addComponent(horizontalBox_15, GroupLayout.PREFERRED_SIZE, 556, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(viewLevelSelect, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(txtSelectALevel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(horizontalBox, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(horizontalBox_1, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(horizontalBox_2, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(horizontalBox_3, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(horizontalBox_4, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(horizontalBox_5, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(horizontalBox_6, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(horizontalBox_7, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(horizontalBox_8, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(horizontalBox_9, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(horizontalBox_10, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(horizontalBox_11, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(horizontalBox_12, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(horizontalBox_13, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(horizontalBox_14, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(horizontalBox_15, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setAlignmentX(Component.RIGHT_ALIGNMENT);
		horizontalBox_1.add(lblNewLabel);
		
		JButton btnNewLevel = new JButton("Create a new level");
		btnNewLevel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) { //TODO subtitute with proper controller class functions
			}
		});
		horizontalBox.add(btnNewLevel);
		contentPane.setLayout(gl_contentPane);
	}
}
