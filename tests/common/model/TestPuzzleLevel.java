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
	
	@Test 
	public void testOther() {
		try{
			PuzzleLevel testLevel = (PuzzleLevel)loadLevel("Puzzle_Level_1.lvl");
			assertEquals(1,testLevel.getLetterScore("E"));
			assertEquals(2,testLevel.getLetterScore("A"));
			assertEquals(3,testLevel.getLetterScore("D"));
			assertEquals(4,testLevel.getLetterScore("G"));
			assertEquals(5,testLevel.getLetterScore("K"));
			assertEquals(7,testLevel.getLetterScore("J"));
			assertEquals(8,testLevel.getLetterScore("Z"));
			assertEquals(11,testLevel.getLetterScore("Q"));
			
			Tile t = new Tile("A",0,0);
			Word w = new Word();
			w.addTile(t);
			assertEquals(2,testLevel.computeScore(w));
		} catch (Exception e) {
			fail();
		}
	}

}
