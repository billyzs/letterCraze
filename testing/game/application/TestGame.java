package game.application;
import game.*;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import common.model.Level;
import common.model.Model;
import common.model.PuzzleLevel;
import static common.application.Application.loadLevel;

public class TestGame {

	@Test
	public void testGameInit(){
		try{
			Level testLevel1 = (PuzzleLevel)loadLevel("Puzzle_Level_1.lvl");
			
			ArrayList<Level> levels = new ArrayList<Level>();
			for(int k = 0; k < 15;k++)
				levels.add(testLevel1);
			Model m = new Model(levels);
			AppGame app = new AppGame(m);
			
			assertTrue(app.getModel().getLevels().size() == 15); //check number of levels
			
		} catch(Exception e){
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void testCreateLvls(){
		try{
			Level testLevel = (PuzzleLevel)loadLevel("Puzzle_Level_1.lvl");
			ArrayList<Level> levels = new ArrayList<Level>();
			for(int k = 0; k < 15;k++)
				levels.add(testLevel);
			Model m = new Model(levels);
			AppGame app = new AppGame(m);
			
			
			assertTrue(app.getModel().createNewLevel("Puzzle").getType() == "Puzzle"); //check that the lvl was created with proper type
			assertTrue(app.getModel().createNewLevel("Lightning").getType() == "Lightning"); //check that the lvl was created with proper type
			assertTrue(app.getModel().createNewLevel("Theme").getType() == "Theme"); //check that the lvl was created with proper type
		} catch(Exception e){
			e.printStackTrace();
			fail();
		}
	}
	/*
	public void testMain(){
		try{
			Level testLevel1 = (PuzzleLevel)loadLevel("TestingLevel.lvl");
			ArrayList<Level> levels = new ArrayList<Level>();
			for(int k = 0; k < 15;k++)
				levels.add(testLevel1);
			Model m = new Model(levels);
			AppGame app = new AppGame(m);
			
			app.main(new String[1]);
			
			
			
			assertTrue(true); // is true if no exception is thrown
		} catch(Exception e){
			e.printStackTrace();
			assertTrue(false);
			fail();
		}
	}
	/*
	public void testLvlStart(){
		try{
			Level testLevel1 = (PuzzleLevel)loadLevel("TestingLevel.lvl");
			ArrayList<Level> levels = new ArrayList<Level>();
			for(int k = 0; k < 15;k++)
				levels.add(testLevel1);
			Model m = new Model(levels);
			AppGame app = new AppGame(m);
			
			app.main(new String[1]);
			
			StartLevelController startContrl = new StartLevelController(app, testLevel1);
			startContrl.actionPerformed(new ActionEvent());
			
		} catch(Exception e){
			e.printStackTrace();
			assertTrue(false);
			fail();
		}
	}
	*/
}
