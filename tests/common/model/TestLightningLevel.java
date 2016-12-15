package common.model;

import static common.application.Application.loadLevel;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class TestLightningLevel {

	@Test
	public void testSave() { //Adds one to the previous values to ensure modification of file and checks
		try{
			LightningLevel testLevel = (LightningLevel)loadLevel("Lightning_Level_Test.lvl");
			testLevel.setName("TEST NAME");
			testLevel.setHighscore(testLevel.getHighscore()+1);
			testLevel.setTargetScore(testLevel.getTargetScore()+1);
			testLevel.setUnlocked(true);
			testLevel.setTimerSeconds(testLevel.getTimerSeconds()+1);
			testLevel.save("Lightning_Level_Test");
			LightningLevel testLevel2 = (LightningLevel)loadLevel("Lightning_Level_Test.lvl");
			assertTrue(testLevel2.getName().equals("TEST NAME"));
			assertTrue(testLevel2.getHighscore() == testLevel.getHighscore());
			assertTrue(testLevel2.getTargetScore() == testLevel.getTargetScore());
			assertTrue(testLevel2.isUnlocked());
			assertTrue(testLevel2.getTimerSeconds() == testLevel.getTimerSeconds());
		}catch(Exception e){}	
	}
	
	@Test
	public void testInit(){
		try {
			LightningLevel testLevel = (LightningLevel)loadLevel("Lightning_Level_Test.lvl");
			testLevel.initialize();
			for(int i = 0; i < 6; i++){
				for(int j = 0; j < 6; j++){
					assertTrue(!testLevel.getBoard().getLetterAt(i, j).equals(""));
				}
			}
			testLevel.terminate();
			
		} catch (IOException e) {}
	}
	
	

}
