package common.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import common.model.Level;
import common.model.PuzzleLevel;
import common.model.Tile;
import common.model.Word;

import static common.application.Application.loadLevel;

public class TestLevel {

	Level testLevel;
	@Before
	public void setUp() {
		try{
			this.testLevel = (PuzzleLevel)loadLevel("Puzzle_Level_1.lvl");
		}catch(Exception e){}	
	}
	@Test
	public void testInitialCurrentWord(){
		assertTrue(testLevel.getCurrentWord().isEmpty());				
	}
	@Test
	public void testSetCurrentWord(){
		Word testWord = new Word();
		testWord.addTile(new Tile("t", 1, 1));
		testWord.addTile(new Tile("o", 2, 1));
		testLevel.setCurrentWord(testWord);
		assertTrue(testLevel.getCurrentWord().toString().equals("to"));
		
	}
	@Test
	public void testResetCurrentWord(){
		Word testWord = new Word();
		testWord.addTile(new Tile("t", 1, 1));
		testWord.addTile(new Tile("o", 2, 1));
		testLevel.setCurrentWord(testWord);
		testLevel.resetCurrentWord();
		assertTrue(testLevel.getCurrentWord().isEmpty());
		
	}
	@Test
	public void testPoints(){
		assertTrue(testLevel.isUnlocked());
		assertFalse(testLevel.isComplete());
		assertTrue(testLevel.getCurrentPoints() == 0);
		testLevel.addPoints(1000);
		testLevel.updateHighscore();
		assertTrue(testLevel.isComplete());
		assertTrue(testLevel.getCurrentPoints() == 1000);
		testLevel.setCurrentPoints(1);
		assertTrue(testLevel.getCurrentPoints() == 1);
		testLevel.updateHighscore();
		assertTrue(testLevel.isComplete());
	}
	
	@Test
	public void testFloat(){
		Board b = new Board();
		b.setEmptyBoard();
		b.add("ABCDEF", 10);
		testLevel.setBoard(b);
		testLevel.floatTiles();
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				if(!testLevel.getBoard().getLetterAt(i, j).equals("")){
					assertTrue((i == 0) || !(testLevel.getBoard().getLetterAt(i-1, j).equals("")));
				}
			}
		}
	}
	
	
	//Should test for submitted words removed 
	@Test
	public void testInit(){
		testLevel.getBoard().setEmptyBoard();
		testLevel.initialize();
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				assertTrue(!testLevel.getBoard().getLetterAt(i, j).equals(""));
				
			}
		}
	}
	
	@Test
	public void testSetnGet(){
		Word testWord = new Word();
		testWord.addTile(new Tile("t", 1, 1));
		testWord.addTile(new Tile("o", 2, 1));
		testLevel.setCurrentWord(testWord);
		assertTrue(testLevel.getCurrentWord().toString().equals(testWord.toString()));
		String[] dictWords = {"yo","dog"};
		Dictionary newDic = new Dictionary(dictWords);
		testLevel.setDict(newDic);
		assertTrue(testLevel.getDict().getTable().contains(dictWords[0]) && testLevel.getDict().getTable().contains(dictWords[1]) && testLevel.getDict().getTable().size() == 2);
		testLevel.setHighscore(12);
		assertTrue(testLevel.getHighscore() == 12);
		testLevel.setName("NEW NAME");
		assertTrue(testLevel.getName().equals("NEW NAME"));
		testLevel.setTargetScore(32);
		assertTrue(testLevel.getTargetScore() == 32);
		testLevel.resetCurrentWord();
		assertTrue(testLevel.getCurrentWord().isEmpty());
		testLevel.addSubmittedWord(testWord.toString());
		assertTrue(testLevel.getSubmittedWords().toString().contains(testWord.toString()) && testLevel.getSubmittedWords().size() == 1);
		testLevel.setUnlocked(false);
		assertTrue(!testLevel.isUnlocked());
	}
}

