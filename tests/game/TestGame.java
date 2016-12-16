package game;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import common.model.Board;
import common.model.Dictionary;
import common.model.Level;
import common.model.Model;
import common.model.PuzzleLevel;
import game.AppGame;
import common.application.*;

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
		Model m = null;
		try{
			Level testLevel = (PuzzleLevel)loadLevel("Puzzle_Level_1.lvl");
			ArrayList<Level> levels = new ArrayList<Level>();
			for(int k = 0; k < 15;k++)
				levels.add(testLevel);
			m = new Model(levels);
			AppGame app = new AppGame(m);
			
			
			assertTrue(app.getModel().createNewLevel("Puzzle").getType() == "Puzzle"); //check that the lvl was created with proper type
			assertTrue(app.getModel().createNewLevel("Lightning").getType() == "Lightning"); //check that the lvl was created with proper type
			assertTrue(app.getModel().createNewLevel("Theme").getType() == "Theme"); //check that the lvl was created with proper type
			

		} catch(Exception e){
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testMain(){
		try {
			
            ArrayList<Level> levels = Application.loadDefaultLevels();//new ArrayList<Level>();
            ArrayList<Level> customs = Application.loadOtherLevels();
            //Add customs to levels
            levels.addAll(customs);
             
            /*
             * for(int k = 0; k < 15;k++)
                levels.add(testLevel);
                */

			AppGame frame = new AppGame(new Model(levels));

            frame.getWelcome().show();
			frame.setVisible(true);
			assertTrue(frame.isVisible());
			assertTrue(levels.size() >= 15);

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
