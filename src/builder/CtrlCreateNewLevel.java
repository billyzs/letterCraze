package builder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
public class CtrlCreateNewLevel implements ActionListener{

	// The builder
	Application app;
	// The builder's model
	Model model;
	// A new level to be built
	Level theLevel;

	public CtrlCreateNewLevel(Application a) {
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
		levelType = levelType.substring(0,1).toUpperCase() + levelType.substring(1).toLowerCase();
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
				case "Themed":
					level = new ThemeLevel(emptyBoard, name, dict, highScore, starVal, unlocked);
					break;
				default:
					throw new IllegalArgumentException("CtrlCreateNewLevel::createNewLevel: cannot parse" + levelType);
			}
		} catch (IllegalFormatCodePointException e){
			e.printStackTrace();
		} catch (IOException ioe){
			System.err.println(ioe.getMessage()+" Check that you have the right files in test execution root");
			ioe.printStackTrace();
		} finally {
			level = null;
		}
		return level;
	}

	/**
	 * Calls the createnewLevel method, creates the level and brings up a view
	 * @param ae
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		// JComboBox jcb = (JComboBox) ae.getSource();
		// String type = (String) jcb.getSelectedItem();
		String levelType = (String) ((JComboBox) ae.getSource()).getSelectedItem();
		Level newLevel;
		try {
			newLevel = createNewLevel(levelType);
		} catch (Exception e) {
			e.printStackTrace();
			newLevel = null;
		}
		if (!(newLevel==null)){
			// bring up the level building view

		}
		else{
			System.err.println("Created an empty new level");
		}

	}
		/*if (type.equals("Puzzle")) {
			*//** If level is of type puzzle, we can assume two things are true regardless
			 * of how user builds it:
			 * 1) It will have a board built out of 6x6 shape
			 * 2) It will use the default dictionary
			 *//*
			ArrayList<ArrayList<Tile>> tiles = new ArrayList<ArrayList<Tile>>();
			ArrayList<Tile> row = new ArrayList<Tile>();
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 6; j++) {
					row.add(new Tile(i,j));
				}
				tiles.add(row);
				row.clear();
			}

			try {
				//Note all values besides the board and the dictionary can be changed in builder
				theLevel = new PuzzleLevel(new Board(tiles),"Unnamed",new Dictionary(),0,new int[3],0,true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//Check that there isnt already a level view
		if(ContentPane.getCurrentLevelView() != null) {
			ContentPane.getCurrentLevelView().hide();
		}
		//Check that there isnt already a level common.view
		if(ContentPane.getCurrentLevelView() != null){
			ContentPane.getCurrentLevelView().hide();

			System.out.println("tried to load 2 levels");
		}

		//send the level view to application, show it
		ContentPane.setCurrentLevelView(new LevelView(theLevel));

		//initialize Controllers
		ContentPane.getCurrentLevelView().getExitButton().addActionListener(new ExitLevelController(app));
		ContentPane.getCurrentLevelView().show();

		//set the level as current level in the common.model
		this.model.setLevel(theLevel);

		//hide the menu
		this.app.getMenu().hide();

	}*/


}
