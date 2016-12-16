package game;

import static org.junit.Assert.*;
import game.move.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import common.application.Application;
import common.model.Level;
import common.model.Model;
import common.model.PuzzleLevel;
import common.model.Tile;
import common.model.Word;
import common.view.ContentPane;

public class TestSubmitWordMove {
	PuzzleLevel pl;
	SubmitWordMove swm;

	
	@Test
	public void testDoAndUndo(){
		 try {
			pl = (PuzzleLevel) Application.loadLevel("Puzzle_Level_1.lvl");
            
            Word word = new Word();
            Tile t1 = new Tile(0,0);
            t1.setLetters("C");

            Tile t2 = new Tile(1,1);
            t2.setLetters("A");

            Tile t3 = new Tile(2,2);
            t3.setLetters("T");
            
            word.addTile(t1);
            word.addTile(t2);
            word.addTile(t3);

			pl.setCurrentWord(word);
            swm = new SubmitWordMove(pl);

            
            pl.setCurrentWord(word);
            
            assertTrue(swm.isValid());

            swm.doMove();
            swm.undo();
            
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
