package builder;

import java.awt.Font;

import javax.swing.*;

import common.application.Application;
import common.controller.ExitLevelController;
import common.model.Level;
import common.view.*;
/**
 * Created by billyzs on 12/3/16.
 */
public class ViewBuildLevel extends LevelView implements IView{

    // Application app;
    Level level;
    //TODO what are the textFields?
    private JTextField starVal1;
    private JTextField starVal2;
    private JTextField starVal3;
	JButton btnExitWithoutSaving;
	JLabel lblChooseAtLeast;
	JButton btnSaveChanges;
	JButton btnDeleteLevel;
	JButton btnPreviewLevel;
	JLabel lblLevelSettings;
	JLabel lblPointThresholds;
	BoardView panel;
	JTextPane textPane;
	/**
     * Create the panel.
     */

    public ViewBuildLevel(Level l) {


        //TODO TEST!!!
        // app = a;
        level = l;
        panel = new BoardView(l.getBoard());
        panel.setBounds(12, 41, 577, 569);
        btnExitWithoutSaving = new JButton("Exit without saving");
        btnExitWithoutSaving.setBounds(6, 6, 146, 29);
        //TODO Should ExitLevelController be used??
        // btnExitWithoutSaving.addActionListener(new ExitLevelController(a));
        lblChooseAtLeast = new JLabel("Select at least 9 adjacent tiles:");
        lblChooseAtLeast.setBounds(158, 8, 293, 20);
        lblChooseAtLeast.setHorizontalAlignment(SwingConstants.LEFT);
        lblChooseAtLeast.setFont(new Font("Lucida Grande", Font.PLAIN, 16));

        btnSaveChanges = new JButton("Save");
        btnSaveChanges.setBounds(812, 6, 82, 29);

        btnDeleteLevel = new JButton("Delete Level");
        btnDeleteLevel.setBounds(600, 6, 120, 29);

        btnPreviewLevel = new JButton("Preview");
        btnPreviewLevel.setBounds(720, 6, 91, 29);
        setLayout(null);
        add(panel);
        add(btnExitWithoutSaving);
        add(lblChooseAtLeast);
        add(btnDeleteLevel);
        add(btnPreviewLevel);
        add(btnSaveChanges);

        // Not needed, should be done in previous view

        JComboBox comboBox = new JComboBox();
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"Puzzle", "Lighting", "Theme"}));
        comboBox.setBounds(675, 85, 108, 27);
        add(comboBox);

        JLabel lblLevelType = new JLabel("Level type:");
        lblLevelType.setBounds(601, 89, 82, 16);
        add(lblLevelType);

        lblLevelSettings = new JLabel("Level Settings");
        lblLevelSettings.setHorizontalAlignment(SwingConstants.CENTER);
        lblLevelSettings.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lblLevelSettings.setBounds(680, 41, 148, 22);
        add(lblLevelSettings);

		lblPointThresholds = new JLabel("Point thresholds:");
        lblPointThresholds.setBounds(601, 140, 108, 16);
        add(lblPointThresholds);

        //TODO looks like these fields are for starVals, and need controllers

        starVal1 = new JTextField();
        starVal1.setBounds(658, 163, 77, 26);
        add(starVal1);
        starVal1.setColumns(10);

        starVal2 = new JTextField();
        starVal2.setColumns(10);
        starVal2.setBounds(658, 185, 77, 26);
        add(starVal2);

        starVal3 = new JTextField();
        starVal3.setColumns(10);
        starVal3.setBounds(658, 207, 77, 26);
        add(starVal3);

        // Elements that won't require a controller
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

        JLabel lblInsertDesiredWords = new JLabel("Words if level type Theme, separate with commas");
        lblInsertDesiredWords.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
        lblInsertDesiredWords.setBounds(601, 271, 293, 16);
        add(lblInsertDesiredWords);

        textPane = new JTextPane();
        textPane.setBounds(601, 299, 293, 81);
        add(textPane);

    }

    @Override
    public void show(){
    	System.out.println("show this BuildLevelView");

        //ContentPane.get().add(this);
		ContentPane.get().add(this);
		ContentPane.setCurrentLevelView(this);
        // refresh
        ContentPane.get().invalidate();
		ContentPane.get().validate();

        // ContentPane.get().repaint();
    }

    @Override
    public void hide() {
        // TODO Auto-generated method stub
        // ContentPane.get().setVisible(false);
        // ContentPane.get().invalidate();
        // ContentPane.get().validate();
    }


}
