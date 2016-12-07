package builder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.IllegalFormatCodePointException;

import javax.swing.JComboBox;

import common.application.Application;
import common.controller.ExitLevelController;
import common.model.*;
import common.view.ContentPane;
import common.view.LevelView;
/**
 * Controller to handle bringing up the level building view.
 * Handles user's selection of type of level to build.
 * Created by billyzs on 12/6/16.
 */
public class CtrlCreateNewLevel implements ActionListener, MouseListener{

	// The builder
	Application app;
	// The builder's model
	Model model;
	// A new level to be built
	Level theLevel;
	JComboBox dropDown;

	public CtrlCreateNewLevel(AppBuilder a) {
		this.app = a;
		this.model = a.getModel();
	}

	/**
	 * Creates new level based on type.
	 * @param levelType one of "Puzzle", "Lightening", "Theme"
	 * @return a new level with empty board, name, starval, highscore, unlocked=false;
	 * dict = default for lightening, puzzle, empty for theme;
	 */
	public Level createNewLevel(String levelType) throws Exception{
		// standardize input
		//levelType = levelType.substring(0,1).toUpperCase() + levelType.substring(1).toLowerCase();
		Board emptyBoard = new Board();
		emptyBoard.setEmptyBoard();
		String name = "";
		int[] starVal = {0,0,0};
		int highScore = 0;
		int maxWords = 100; //for puzzle
		boolean unlocked = false;
		Dictionary dict = new Dictionary(new HashSet<String>());
		Level level;
		try{
			switch (levelType){
				case "Puzzle":
					dict = new Dictionary();
					level = new PuzzleLevel(emptyBoard,name, dict, highScore, starVal, maxWords, unlocked);
					break;
				case "Lightening":
					dict = new Dictionary();
					level =  new LightningLevel(emptyBoard, name, dict, highScore, starVal, unlocked);
					break;
				case "Theme":
					level = new ThemeLevel(emptyBoard, name, dict, highScore, starVal, unlocked);
					break;
				default:
					throw new IllegalArgumentException("CtrlCreateNewLevel::createNewLevel: cannot parse: " + levelType);
			}
		} catch (IllegalFormatCodePointException e){
			e.printStackTrace();
			level = null;
		} catch (IOException ioe){
			System.err.println(ioe.getMessage()+" Check that you have the right files in test execution root");
			ioe.printStackTrace();
			level = null;
		} catch (Exception ee){
			ee.printStackTrace();
			level = null;
		}
		return level;
	}

	/**
	 * Calls the createnewLevel method, creates the level and brings up a view
	 * @param ae should be the JCombox that is the drop down menu with 3 types of levels
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		// JComboBox jcb = (JComboBox) ae.getSource();
		// String type = (String) jcb.getSelectedItem();
		String levelType = (String) ((JComboBox) ae.getSource()).getSelectedItem();
		System.out.println("Selected " + levelType);
		Level newLevel;
		try {
			newLevel = createNewLevel(levelType);
		} catch (Exception e) {
			e.printStackTrace();
			newLevel = null;
		}
		if (!(newLevel==null)){
			// bring up the level building view
			ViewBuildLevel viewBuildLevel = new ViewBuildLevel(app, newLevel);
			viewBuildLevel.setVisible(true);
			//app.getMenu().setVisible(false);
			ContentPane.setCurrentLevelView(viewBuildLevel);
			//app.getMenu().hide();

		}
		else{
			System.err.println("CtrnCreateNewLevel::actionPerformed: Created an empty new level");
		}

	}



}
