package builder;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;

import common.model.*;
import common.view.*;
/**
 * Boundary object for the viewing of a level currently being built.
 * @author Created by billyzs on 12/3/16.
 */
public class ViewBuildLevel extends LevelView implements IView{

	// Application app;
    Level level;

    /**
     * The Swing attributes.
     */
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
	JLabel prompt;
	JTextField timeLimit;
	JLabel timePrompt;
	JLabel lblMaxWords;
	JTextField jtfMaxWords;
	JButton btnSaveDict;
	/**
	 * Returns the <code>fieldChangeLevelName</code> <code>JTextfield</code> attribute.
	 * @return fieldChangeLevelName
	 */
	public JTextField getFieldChangeLevelName() {
		return fieldChangeLevelName;
	}

	public void setFieldChangeLevelName(JTextField fieldChangeLevelName) {
		this.fieldChangeLevelName = fieldChangeLevelName;
	}

	JTextField fieldChangeLevelName;
	public LevelMenuView getLmv() {
		return lmv;
	}

	public void setLmv(LevelMenuView lmv) {
		this.lmv = lmv;
	}

	/**
	 * Returns the <code>seq</code> <code>Integer</code> attribute.
	 * @return seq
	 */
	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	LevelMenuView lmv;
	int seq;
	/**
	 * Returns the <code>btnSaveDict</code> <code>JButton</code> attribute.
	 * @return fieldChangeLevelName
	 */
	public JButton getBtnSaveDict() {
		return btnSaveDict;
	}

	public void setBtnSaveDict(JButton btnSaveDict) {
		this.btnSaveDict = btnSaveDict;
	}


	public JTextField getTimeLimit() {
		return timeLimit;
	}

	public void setTimeLimit(JTextField timeLimit) {
		this.timeLimit = timeLimit;
	}

	public JLabel getTimePrompt() {
		return timePrompt;
	}

	public void setTimePrompt(JLabel timePrompt) {
		this.timePrompt = timePrompt;
	}

	public JLabel getLblMaxWords() {
		return lblMaxWords;
	}

	public void setLblMaxWords(JLabel lblMaxWords) {
		this.lblMaxWords = lblMaxWords;
	}

	public JTextField getJtfMaxWords() {
		return jtfMaxWords;
	}

	public void setJtfMaxWords(JTextField jtfMaxWords) {
		this.jtfMaxWords = jtfMaxWords;
	}

	/**
     * Create the panel.
     * @param lmv
     */
	public ViewBuildLevel(LevelMenuView lmv) {

        // app = a;
		this.lmv = lmv;
		this.seq = lmv.getSeq();
        level = lmv.getTheLevel();
        panel = new BoardView(level.getBoard());
        panel.setBounds(12, 41, 577, 569);
        btnExitWithoutSaving = new JButton("Exit without saving");
        btnExitWithoutSaving.setBounds(6, 6, 146, 29);


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


        lblLevelSettings = new JLabel("Enter new level name (Hit enter to save)");
        // lblLevelSettings.setHorizontalAlignment(SwingConstants.CENTER);
        lblLevelSettings.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
        lblLevelSettings.setBounds(601, 41, 180, 22);
        add(lblLevelSettings);
		fieldChangeLevelName = new JTextField(level.getName());
		fieldChangeLevelName.setBounds(601, 64, 148, 22);
		// fieldChangeLevelName.setHorizontalAlignment(SwingConstants.CENTER);
		add(fieldChangeLevelName);
		lblPointThresholds = new JLabel("Points for ★★★: (Hit enter to save)");
		lblPointThresholds.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
        lblPointThresholds.setBounds(601, 140, 480, 16);
        add(lblPointThresholds);
        starVal3 = new JTextField(Integer.toString(level.getTargetScore()));
        starVal3.setColumns(10);
        starVal3.setBounds(601, 157, 77, 26);
        add(starVal3);

        if(level.getType() == Model.Puzzle){
        	lblMaxWords = new JLabel("Max words allowed");
        	jtfMaxWords = new JTextField();
        	jtfMaxWords.setText(Integer.toString(((PuzzleLevel) level).getMaxWords()));
			lblMaxWords.setBounds(601, 184, 200, 26);
			jtfMaxWords.setBounds(601, 211, 77, 26);
			add(lblMaxWords);
			add(jtfMaxWords);
		}

		if(level.getType() == Model.Lightning){

			timeLimit = new JTextField(Integer.toString(((LightningLevel) level).getTimerSeconds()));
			timePrompt = new JLabel("Time limit (seconds)");
			timePrompt.setBounds(601, 184, 200, 26);
			timeLimit.setBounds(601, 211, 77, 26);
			add(timePrompt);
			add(timeLimit);
		}
		if(level.getType() == "Theme") {
			JLabel lblInsertDesiredWords = new JLabel("Insert dictionary words (separate with commas)");
			lblInsertDesiredWords.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
			lblInsertDesiredWords.setBounds(601, 271, 293, 16);
			add(lblInsertDesiredWords);
			textPane = new JTextPane();
			textPane.setText(((ThemeLevel) level).getWords());
			// load dict words into textpane

			textPane.setBounds(601, 299, 293, 81);
			btnSaveDict = new JButton("Save Words");
			btnSaveDict.setBounds(601, 381, 200, 29);
			prompt = new JLabel("");
			prompt.setBounds(601, 411, 293, 50);
			add(textPane);
			add(prompt);
			add(btnSaveDict);
		}
		this.hideLetters();
    }

	/**
	 * Update the ViewBuildLevel to reflect changes, usually to show a tile has been selected.
	 */
    public void refresh(){
    	//update the color of the tiles
		for(ArrayList<TileView> row : this.panel.getTileViews()){
            for(TileView tv : row){
                tv.updateColor();
                tv.setLabel("");
            }
		}

		/*//Grey out finishbutton if necesary
		if(this.level.getCurrentPoints() >= (this.level.getTargetScore()/3))
            this.finish.setEnabled(true);
		else
			this.finish.setEnabled(false);
			*/
    }
    
    /**
     * Hide all letters in boardview.
     */
    public void hideLetters(){
		for(ArrayList<TileView> row : this.panel.getTileViews()){
            for(TileView tv : row){
                tv.setLabel("");
            }
		}
    }
	public void initialiizeControllers(){

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
        System.out.println("Hiding Viewbuildlevel");
		// ContentPane.get().setVisible(false);
		ContentPane.get().remove(this);
        ContentPane.get().invalidate();
        ContentPane.get().validate();
    }

    /**
	 * Returns the <code>panel</code> <code>BoardView</code> attribute.
	 * @return fieldChangeLevelName
	 */
    public BoardView getBoardView(){
    	return this.panel;
    }

    /**
	 * Returns the <code>level</code> <code>Level</code> attribute.
	 * @return level
	 */
	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	/**
	 * Returns the <code>starVal3</code> <code>JTextfield</code> attribute.
	 * @return starVal3
	 */
	public JTextField getStarVal3() {
		return starVal3;
	}

	public void setStarVal3(JTextField starVal3) {
		this.starVal3 = starVal3;
	}

	/**
	 * Returns the <code>getBtnExitWithoutSaving</code> <code>JButton</code> attribute.
	 * @return getBtnExitWithoutSaving
	 */
	public JButton getBtnExitWithoutSaving() {
		return btnExitWithoutSaving;
	}

	public void setBtnExitWithoutSaving(JButton btnExitWithoutSaving) {
		this.btnExitWithoutSaving = btnExitWithoutSaving;
	}

	/**
	 * Returns the <code>lblChooseAtLeast</code> <code>JLabel</code> attribute.
	 * @return lblChooseAtLeast
	 */
	public JLabel getLblChooseAtLeast() {
		return lblChooseAtLeast;
	}

	public void setLblChooseAtLeast(JLabel lblChooseAtLeast) {
		this.lblChooseAtLeast = lblChooseAtLeast;
	}

	/**
	 * Returns the <code>btnSaveChanges</code> <code>JButton</code> attribute.
	 * @return btnSaveChanges
	 */
	public JButton getBtnSaveChanges() {
		return btnSaveChanges;
	}

	public void setBtnSaveChanges(JButton btnSaveChanges) {
		this.btnSaveChanges = btnSaveChanges;
	}

	/**
	 * Returns the <code>btnDeleteLevel</code> <code>JButton</code> attribute.
	 * @return fieldChangeLevelName
	 */
	public JButton getBtnDeleteLevel() {
		return btnDeleteLevel;
	}

	public void setBtnDeleteLevel(JButton btnDeleteLevel) {
		this.btnDeleteLevel = btnDeleteLevel;
	}

	/**
	 * Returns the <code>btnPreviewLevel</code> <code>JButton</code> attribute.
	 * @return btnPreviewLevel
	 */
	public JButton getBtnPreviewLevel() {
		return btnPreviewLevel;
	}

	public void setBtnPreviewLevel(JButton btnPreviewLevel) {
		this.btnPreviewLevel = btnPreviewLevel;
	}

	/**
	 * Returns the <code>lvlLevelSettings</code> <code>JLabel</code> attribute.
	 * @return fieldChangeLevelName
	 */
	public JLabel getLblLevelSettings() {
		return lblLevelSettings;
	}

	public void setLblLevelSettings(JLabel lblLevelSettings) {
		this.lblLevelSettings = lblLevelSettings;
	}

	/**
	 * Returns the <code>lblPointThresholds</code> <code>JLabel</code> attribute.
	 * @return lblPointThresholds
	 */
	public JLabel getLblPointThresholds() {
		return lblPointThresholds;
	}

	public void setLblPointThresholds(JLabel lblPointThresholds) {
		this.lblPointThresholds = lblPointThresholds;
	}

	/**
	 * Returns the <code>panel</code> <code>BoardView</code> attribute.
	 * @return panel
	 */
	public BoardView getPanel() {
		return panel;
	}

	public void setPanel(BoardView panel) {
		this.panel = panel;
	}

	/**
	 * Returns the <code>textPane</code> <code>JTextPane</code> attribute.
	 * @return textPane
	 */
	public JTextPane getTextPane() {
		return textPane;
	}

	public void setTextPane(JTextPane textPane) {
		this.textPane = textPane;
	}

	/**
	 * Returns the <code>prompt</code> <code>JLabel</code> attribute.
	 * @return prompt
	 */
	public JLabel getPrompt() {
		return prompt;
	}

	public void setPrompt(JLabel prompt) {
		this.prompt = prompt;
	}
}
