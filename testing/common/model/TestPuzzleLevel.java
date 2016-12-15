package common.model;

import static common.application.Application.loadLevel;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestPuzzleLevel {

	@Test
	public void testSave() { //Adds one to the previous values to ensure modification of file and checks
		try{
			PuzzleLevel testLevel = (PuzzleLevel)loadLevel("Puzzle_Level_Test.lvl");
			testLevel.setName("TEST NAME");
			testLevel.setHighscore(testLevel.getHighscore()+1);
			testLevel.setTargetScore(testLevel.getTargetScore()+1);
			testLevel.setUnlocked(true);
			testLevel.setMaxWords(testLevel.getMaxWords()+1);
			testLevel.save("Puzzle_Level_Test");
			PuzzleLevel testLevel2 = (PuzzleLevel)loadLevel("Puzzle_Level_Test.lvl");
			assertTrue(testLevel2.getName().equals("TEST NAME"));
			assertTrue(testLevel2.getHighscore() == testLevel.getHighscore());
			assertTrue(testLevel2.getTargetScore() == testLevel.getTargetScore());
			assertTrue(testLevel2.isUnlocked());
			assertTrue(testLevel2.getMaxWords() == testLevel.getMaxWords());
		}catch(Exception e){}	
	}

}
