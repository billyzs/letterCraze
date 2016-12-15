package builder;
import java.awt.event.*;
import java.util.ArrayList;

import common.model.*;
import common.view.ContentPane;
import common.view.LevelMenuView;
import common.view.TileView;
/**
 * <code>ActionListener</code> controller to handle bringing up the level building view, based on user's selection of which level to modify.
 * Created by billyzs on 12/6/16.
 */
public class CtrlModifyLevel implements ActionListener {
	int seq;
	LevelMenuView lmv;
	Level theLevel;
	Level backup;
	AppBuilder builder;
	CtrlSubmitWords ctrlSubmitWords;
	CtrlModifyTargetScore ctrlModifyTargetScore;
	ViewBuildLevel viewBuildLevel;
	CtrlExitWithoutSaving ctrlExitWithoutSaving;
	CtrlModifyMaxWords ctrlModifyMaxWords;
	CtrlModifyThemeWord ctrlModifyThemeWord;

	public CtrlModifyThemeWord getCtrlModifyThemeWord() {
		return ctrlModifyThemeWord;
	}

	public void setCtrlModifyThemeWord(CtrlModifyThemeWord ctrlModifyThemeWord) {
		this.ctrlModifyThemeWord = ctrlModifyThemeWord;
	}

	public CtrlModifyMaxWords getCtrlModifyMaxWords() {
		return ctrlModifyMaxWords;
	}

	public void setCtrlModifyMaxWords(CtrlModifyMaxWords ctrlModifyMaxWords) {
		this.ctrlModifyMaxWords = ctrlModifyMaxWords;
	}

	public CtrlModifyTimeLimit getCtrlModifyTimeLimit() {
		return ctrlModifyTimeLimit;
	}

	public void setCtrlModifyTimeLimit(CtrlModifyTimeLimit ctrlModifyTimeLimit) {
		this.ctrlModifyTimeLimit = ctrlModifyTimeLimit;
	}

	CtrlModifyTimeLimit ctrlModifyTimeLimit;
	public CtrlExitWithoutSaving getCtrlExitWithoutSaving() {
		return ctrlExitWithoutSaving;
	}

	public void setCtrlExitWithoutSaving(CtrlExitWithoutSaving ctrlExitWithoutSaving) {
		this.ctrlExitWithoutSaving = ctrlExitWithoutSaving;
	}

	public CtrlChangeLevelName getCtrlChangeLevelName() {
		return ctrlChangeLevelName;
	}

	public void setCtrlChangeLevelName(CtrlChangeLevelName ctrlChangeLevelName) {
		this.ctrlChangeLevelName = ctrlChangeLevelName;
	}

	public CtrlPreview getCtrlPreview() {
		return ctrlPreview;
	}

	public void setCtrlPreview(CtrlPreview ctrlPreview) {
		this.ctrlPreview = ctrlPreview;
	}

	public CtrlDeleteLevel getCtrlDeleteLevel() {
		return ctrlDeleteLevel;
	}

	public void setCtrlDeleteLevel(CtrlDeleteLevel ctrlDeleteLevel) {
		this.ctrlDeleteLevel = ctrlDeleteLevel;
	}

	CtrlSaveLevel ctrlSaveLevel;
	CtrlChangeLevelName ctrlChangeLevelName;
	CtrlPreview ctrlPreview;
	CtrlDeleteLevel ctrlDeleteLevel;
	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public LevelMenuView getLmv() {
		return lmv;
	}

	public void setLmv(LevelMenuView lmv) {
		this.lmv = lmv;
	}

	public Level getTheLevel() {
		return theLevel;
	}

	public void setTheLevel(Level theLevel) {
		this.theLevel = theLevel;
	}

	public Level getBackup() {
		return backup;
	}

	public void setBackup(Level backup) {
		this.backup = backup;
	}

	public AppBuilder getBuilder() {
		return builder;
	}

	public void setBuilder(AppBuilder builder) {
		this.builder = builder;
	}

	public CtrlSubmitWords getCtrlSubmitWords() {
		return ctrlSubmitWords;
	}

	public void setCtrlSubmitWords(CtrlSubmitWords ctrlSubmitWords) {
		this.ctrlSubmitWords = ctrlSubmitWords;
	}

	public CtrlModifyTargetScore getCtrlModifyTargetScore() {
		return ctrlModifyTargetScore;
	}

	public void setCtrlModifyTargetScore(CtrlModifyTargetScore ctrlModifyTargetScore) {
		this.ctrlModifyTargetScore = ctrlModifyTargetScore;
	}

	public ViewBuildLevel getViewBuildLevel() {
		return viewBuildLevel;
	}

	public void setViewBuildLevel(ViewBuildLevel viewBuildLevel) {
		this.viewBuildLevel = viewBuildLevel;
	}

	public CtrlSaveLevel getCtrlSaveLevel() {
		return ctrlSaveLevel;
	}

	public void setCtrlSaveLevel(CtrlSaveLevel ctrlSaveLevel) {
		this.ctrlSaveLevel = ctrlSaveLevel;
	}

	/**
	 * Default constructor.
	 * @param app
	 * @param lmv
	 */
	public CtrlModifyLevel(AppBuilder app, LevelMenuView lmv) {
		this.theLevel = lmv.getTheLevel();
		this.lmv = lmv;
		this.seq = lmv.getSeq();
		this.builder = app;
		ctrlSaveLevel = new CtrlSaveLevel(theLevel);
		ctrlModifyTargetScore = new CtrlModifyTargetScore(theLevel);
		ctrlExitWithoutSaving = new CtrlExitWithoutSaving(this);
		ctrlModifyTimeLimit = new CtrlModifyTimeLimit(theLevel);
		ctrlModifyMaxWords = new CtrlModifyMaxWords(theLevel);
		try{
			if (theLevel.getName() != ""){
				backup = builder.loadLevel(theLevel.getName()+".lvl");
			}
			else {
				backup = builder.getModel().createNewLevel(theLevel.getType(), theLevel.getName());
			}
		} catch (Exception e){
			System.err.println("unable to load");
			e.printStackTrace();
		}

	}

	/**
	 * Calls the createnewLevel method, creates the level and brings up a view.
	 *
	 * @param ae should be the JCombox that is the drop down menu with 3 types of levels.
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		System.out.println("mouse pressed on " + lmv.getSeq());
		try {
			ViewBuildLevel vbl = new ViewBuildLevel(lmv);
			this.builder.viewBuildLevel = vbl;
			this.viewBuildLevel = vbl;
			this.ctrlPreview = new CtrlPreview(vbl);
			ctrlChangeLevelName = new CtrlChangeLevelName(this.getViewBuildLevel(), theLevel);
			// this.builder.add(vbl);
			//ContentPane.get().setVisible(false);
			//builder.getMenu().hide();
			// ContentPane.get();
			ContentPane.setCurrentLevelView(vbl);
			((ViewBuildLevel) ContentPane.getCurrentLevelView()).show();
			builder.getMenu().hide();
			builder.getModel().setLevel(theLevel);

			//Assign the TileView ChooseTileControllers
			for(ArrayList<TileView> row : vbl.getBoardView().getTileViews()){
				for(TileView t : row){
                    t.addMouseListener(new ChooseTileController(this.builder, t));
				}
			}
			// Puzzle specific controllers (max word)
			if(theLevel.getType() == Model.Puzzle){
				vbl.getJtfMaxWords().addActionListener(ctrlModifyMaxWords);
			}

			// Lightning Specific controllers (Timer limit)
			if(theLevel.getType() == Model.Lightning){
				vbl.getTimeLimit().addActionListener(ctrlModifyTimeLimit);
			}

			// Submit words controller
			if(theLevel.getType() == "Theme"){
				ctrlSubmitWords = new CtrlSubmitWords(this.builder.viewBuildLevel, this.builder.viewBuildLevel.getTextPane(), this.builder);
				vbl.getBtnSaveDict().addActionListener(ctrlSubmitWords);
				ctrlModifyThemeWord = new CtrlModifyThemeWord((ThemeLevel)theLevel);
				vbl.getJtfThemeWord().addActionListener(ctrlModifyThemeWord);
				//added because theme levels don't need to set score 
				//SEE GROUP PROJECT POWERPOINT
				vbl.remove(vbl.getLblPointThresholds());
				vbl.remove(vbl.getStarVal3());

			}
			// Save level controller
			vbl.getBtnSaveChanges().addActionListener(ctrlSaveLevel);

			// Modify target score controller
			vbl.getStarVal3().addActionListener(ctrlModifyTargetScore);

			// Exit w/o saving ctrl
			vbl.getBtnExitWithoutSaving().addActionListener(ctrlExitWithoutSaving);

			// Change level name
			vbl.getFieldChangeLevelName().addActionListener(ctrlChangeLevelName);

			// preview controller
			vbl.getBtnPreviewLevel().addActionListener(this.ctrlPreview);

			// delete level
			ctrlDeleteLevel = new CtrlDeleteLevel(this.builder, this.getViewBuildLevel());
			vbl.getBtnDeleteLevel().addActionListener(this.ctrlDeleteLevel);

			// modify timer controller for Lightning


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
