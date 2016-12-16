package common.model;

import static common.application.Application.loadLevel;
import static org.junit.Assert.*;

import org.junit.Test;

public class TestThemeLevel {

	@Test
	public void testSave() { //Adds one to the previous values to ensure modification of file and checks
		try{
			ThemeLevel testLevel = (ThemeLevel)loadLevel("Theme_Level_Test.lvl");
			testLevel.setName("TEST NAME");
			testLevel.setHighscore(testLevel.getHighscore()+1);
			testLevel.setUnlocked(true);
			testLevel.setTheme("waytotest");
			testLevel.save("Theme_Level_Test");
			testLevel.initialize();
			testLevel.computeScore(new Word());
			ThemeLevel testLevel2 = (ThemeLevel)loadLevel("Theme_Level_Test.lvl");
			assertTrue(testLevel2.getName().equals("TEST NAME"));
			assertTrue(testLevel2.getHighscore() == testLevel.getHighscore());
			assertTrue(testLevel2.getTargetScore() == testLevel.getTargetScore());
			assertTrue(testLevel.getWords().equals("cat, fish, bird, dog, pig, "));
			assertTrue(testLevel2.isUnlocked());
			assertTrue(testLevel2.getTheme().equals(testLevel.getTheme()));
		}catch(Exception e){}	
	}

}
