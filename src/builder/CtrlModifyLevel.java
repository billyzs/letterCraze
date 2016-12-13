package builder;
import java.awt.event.*;
import java.util.ArrayList;

import common.model.*;
import common.view.ContentPane;
import common.view.LevelMenuView;
import common.view.TileView;
/**
 * <code>ActionListener</code> controller to handle bringing up the level building view based on
 *  user's selection of which level to modify.
 * @author Created by billyzs on 12/6/16.
 */
public class CtrlModifyLevel implements ActionListener {
	/**
	 * Attributes of the <code>CtrlModifyLevel</code> object.
	 */
	int seq;
	LevelMenuView lmv;
	Level theLevel;
	Level backup;
	AppBuilder builder;
	CtrlSubmitWords ctrlSubmitWords;
	CtrlModifyTargetScore ctrlModifyTargetScore;
	ViewBuildLevel viewBuildLevel;
	CtrlExitWithoutSaving ctrlExitWithoutSaving;

	/** Returns the controller responsible for exiting a level without saving.
	 * 
	 * @return CtrlExitWithoutSaving
	 */
	public CtrlExitWithoutSaving getCtrlExitWithoutSaving() {
		return ctrlExitWithoutSaving;
	}

	/** Give this <code>CtrlModifyLevel</code> object another controller responsible for exiting a level without saving.
	 * 
	 */
	public void setCtrlExitWithoutSaving(CtrlExitWithoutSaving ctrlExitWithoutSaving) {
		this.ctrlExitWithoutSaving = ctrlExitWithoutSaving;
	}

	/** Returns the controller responsible for changing the name of a level.
	 * 
	 * @return CtrlChangeLevelName
	 */
	public CtrlChangeLevelName getCtrlChangeLevelName() {
		return ctrlChangeLevelName;
	}

	/** Give this <code>CtrlModifyLevel</code> object another controller responsible for changing the name of a level.
	 * 
	 */
	public void setCtrlChangeLevelName(CtrlChangeLevelName ctrlChangeLevelName) {
		this.ctrlChangeLevelName = ctrlChangeLevelName;
	}

	/** Returns the controller responsible for previewing a level.
	 * 
	 * @return CtrlPreview
	 */
	public CtrlPreview getCtrlPreview() {
		return ctrlPreview;
	}

	/** Give this <code>CtrlModifyLevel</code> object another controller responsible for previewing a level.
	 * 
	 */
	public void setCtrlPreview(CtrlPreview ctrlPreview) {
		this.ctrlPreview = ctrlPreview;
	}

	/** Returns the controller responsible for deleting a level.
	 * 
	 * @return CtrlDeleteLevel
	 */
	public CtrlDeleteLevel getCtrlDeleteLevel() {
		return ctrlDeleteLevel;
	}

	/** Give this <code>CtrlModifyLevel</code> object another controller responsible for deleting a level.
	 * 
	 */
	public void setCtrlDeleteLevel(CtrlDeleteLevel ctrlDeleteLevel) {
		this.ctrlDeleteLevel = ctrlDeleteLevel;
	}

	/**
	 * More attributes of the <code>CtrlModifyLevel</code> class.
	 */
	CtrlSaveLevel ctrlSaveLevel;
	CtrlChangeLevelName ctrlChangeLevelName;
	CtrlPreview ctrlPreview;
	CtrlDeleteLevel ctrlDeleteLevel;
	
	/** Returns the <code>seq</code> attribute.
	 * 
	 * @return seq <code>Integer</code> object.
	 */
	public int getSeq() {
		return seq;
	}

	/** Set the <code>seq</code> <code>Integer</code> attribute.
	 * 
	 * @param seq
	 */
	public void setSeq(int seq) {
		this.seq = seq;
	}

	/** Returns the <code>lmv</code> attribute.
	 * 
	 * @return 
	 */
	public LevelMenuView getLmv() {
		return lmv;
	}

	/** Set the <code>lmv</code> <code>LevelMenuView</code> attribute.
	 * 
	 * @param lmv
	 */
	public void setLmv(LevelMenuView lmv) {
		this.lmv = lmv;
	}

	/** Returns the <code>seq</code> attribute.
	 * 
	 * @return <code>seq</code> Integer object.
	 */
	public Level getTheLevel() {
		return theLevel;
	}

	/** Set the <code>theLevel</code> <code>Level</code> attribute.
	 * 
	 * @param theLevel
	 */
	public void setTheLevel(Level theLevel) {
		this.theLevel = theLevel;
	}

	/** Returns the <code>backup</code> attribute.
	 * 
	 * @return <code>seq</code> <code>Level</code> object.
	 */
	public Level getBackup() {
		return backup;
	}

	/** Set the <code>backup</code> <code>Level</code> attribute.
	 * 
	 * @param backup
	 */
	public void setBackup(Level backup) {
		this.backup = backup;
	}

	/** Returns the <code>builder</code> attribute.
	 * 
	 * @return <code>builder</code> <code>AppBuilder</code> object.
	 */
	public AppBuilder getBuilder() {
		return builder;
	}

	/** Set the <code>builder</code> <code>AppBuilder</code> attribute.
	 * 
	 * @param builder
	 */
	public void setBuilder(AppBuilder builder) {
		this.builder = builder;
	}

	/** Returns the <code>ctrlSubmitWords</code> attribute.
	 * 
	 * @return <code>ctrlSubmitWorkds</code> <code>CtrlSubmitWords</code> object.
	 */
	public CtrlSubmitWords getCtrlSubmitWords() {
		return ctrlSubmitWords;
	}

	/** Set the <code>ctrlSubmitWords</code> <code>CtrlSubmitWords</code> attribute.
	 * 
	 * @param ctrlSubmitWords
	 */
	public void setCtrlSubmitWords(CtrlSubmitWords ctrlSubmitWords) {
		this.ctrlSubmitWords = ctrlSubmitWords;
	}

	/** Returns the <code>ctrlModifyTargetScore</code> attribute.
	 * 
	 * @return <code>ctrlModifyTargetScore</code> <code>CtrlModifyTargetScore</code> object.
	 */
	public CtrlModifyTargetScore getCtrlModifyTargetScore() {
		return ctrlModifyTargetScore;
	}

	/** Set the <code>ctrlModifyTargetScore</code> <code>CtrlModifyTargetScore</code> attribute.
	 * 
	 * @param ctrlModifyTargetScore
	 */
	public void setCtrlModifyTargetScore(CtrlModifyTargetScore ctrlModifyTargetScore) {
		this.ctrlModifyTargetScore = ctrlModifyTargetScore;
	}

	/** Returns the <code>viewBuildLevel</code> attribute.
	 * 
	 * @return <code>viewBuildLevel</code> <code>ViewBuildLevel</code> object.
	 */
	public ViewBuildLevel getViewBuildLevel() {
		return viewBuildLevel;
	}

	/** Set the <code>viewBuildLevel</code> <code>ViewBuildLevel</code> attribute.
	 * 
	 * @param viewBuildLevel
	 */
	public void setViewBuildLevel(ViewBuildLevel viewBuildLevel) {
		this.viewBuildLevel = viewBuildLevel;
	}

	/** Returns the <code>getCtrlSaveLevel</code> attribute.
	 * 
	 * @return <code>ctrlSaveLevel</code> <code>CtrlSaveLevel</code> object.
	 */
	public CtrlSaveLevel getCtrlSaveLevel() {
		return ctrlSaveLevel;
	}

	/** Set the <code>ctrlSaveLevel</code> <code>CtrlSaveLevel</code> attribute.
	 * 
	 * @param ctrlSaveLevel
	 */
	public void setCtrlSaveLevel(CtrlSaveLevel ctrlSaveLevel) {
		this.ctrlSaveLevel = ctrlSaveLevel;
	}

	public CtrlModifyLevel(AppBuilder app, LevelMenuView lmv) {
		this.theLevel = lmv.getTheLevel();
		this.lmv = lmv;
		this.seq = lmv.getSeq();
		this.builder = app;
		ctrlSaveLevel = new CtrlSaveLevel(theLevel);
		ctrlModifyTargetScore = new CtrlModifyTargetScore(theLevel);
		ctrlExitWithoutSaving = new CtrlExitWithoutSaving(this);
		ctrlChangeLevelName = new CtrlChangeLevelName(theLevel);

		// TODO TEST, or do we need a copy constructor for backup?
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
	 * Calls the createnewLevel method, creates the level and brings up a view
	 *
	 * @param ae should be the JCombox that is the drop down menu with 3 types of levels
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		System.out.println("mouse pressed on " + lmv.getSeq());
		try {
			ViewBuildLevel vbl = new ViewBuildLevel(lmv);
			this.builder.viewBuildLevel = vbl;
			this.viewBuildLevel = vbl;
			this.ctrlPreview = new CtrlPreview(vbl);
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
			// Submit words controller
			if(theLevel.getType() == "Theme"){
				ctrlSubmitWords = new CtrlSubmitWords(this.builder.viewBuildLevel, this.builder.viewBuildLevel.getTextPane(), this.builder);
				vbl.getBtnSaveDict().addActionListener(ctrlSubmitWords);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
