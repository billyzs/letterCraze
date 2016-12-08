package builder;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.IllegalFormatCodePointException;

import javax.swing.JComboBox;

import common.application.Application;
import common.controller.ExitLevelController;
import common.model.*;
import common.view.ContentPane;
import common.view.LevelMenuView;
import common.view.LevelView;
import common.view.TileView;
/**
 * Controller to handle bringing up the level building view.
 * Handles user's selection of which level to modity
 * Created by billyzs on 12/6/16.
 */
public class CtrlModifyLevel implements ActionListener {

	// Level theLevel;
	LevelMenuView lmv;
	Level theLevel;
	AppBuilder builder;
	public CtrlModifyLevel(AppBuilder app, LevelMenuView lmv) {
		this.theLevel = lmv.getTheLevel();
		this.lmv = lmv;
		this.builder = app;
	}

	public Level createNewLevel(String levelType) throws Exception {
		// standardize input
		//levelType = levelType.substring(0,1).toUpperCase() + levelType.substring(1).toLowerCase();
		Board emptyBoard = new Board();
		emptyBoard.setEmptyBoard();
		String name = "";
		int[] starVal = {0, 0, 0};
		int highScore = 0;
		int maxWords = 100; //for puzzle
		boolean unlocked = false;
		Dictionary dict = new Dictionary(new HashSet<String>());
		Level level;
		try {
			switch (levelType) {
				case "Puzzle":
					dict = new Dictionary();
					level = new PuzzleLevel(emptyBoard, name, dict, highScore, starVal, maxWords, unlocked);
					break;
				case "Lightening":
					dict = new Dictionary();
					level = new LightningLevel(emptyBoard, name, dict, highScore, starVal, unlocked);
					break;
				case "Theme":
					level = new ThemeLevel(emptyBoard, name, dict, highScore, starVal, unlocked);
					break;
				default:
					throw new IllegalArgumentException("CtrlModifyLevel::createNewLevel: cannot parse: " + levelType);
			}
		} catch (IllegalFormatCodePointException e) {
			e.printStackTrace();
			level = null;
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage() + " Check that you have the right files in test execution root");
			ioe.printStackTrace();
			level = null;
		} catch (Exception ee) {
			ee.printStackTrace();
			level = null;
		}
		return level;
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
			ViewBuildLevel vbl = new ViewBuildLevel(theLevel);
			this.builder.viewBuildLevel = vbl;
			// this.builder.add(vbl);
			//ContentPane.get().setVisible(false);
			//builder.getMenu().hide();
			// ContentPane.get();
			ContentPane.setCurrentLevelView(vbl);
			((ViewBuildLevel) ContentPane.getCurrentLevelView()).show();
			builder.getMenu().hide();
			
			builder.getModel().setLevel(theLevel);;
			
			
			//Assign the TileView ChooseTileControllers
			for(ArrayList<TileView> row : vbl.getBoardView().getTileViews()){
				for(TileView t : row){
                    t.addMouseListener(new ChooseTileController(this.builder, t));
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
