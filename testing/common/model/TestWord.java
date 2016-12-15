package common.model;

import static common.application.Application.loadLevel;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class TestWord {

	@Test
	public void testScore() {
		Tile t = new Tile("T", 0, 0);
		Word w = new Word();
		w.addTile(t);
		assertTrue(w.computeScore() == 1);
		Tile a = new Tile("A", 1, 0);
		w.addTile(a);
		assertTrue(w.computeScore() == 3);
		Tile d = new Tile("D", 2, 0);
		w.addTile(d);
		assertTrue(w.computeScore() == 6);
		Tile f = new Tile("F", 3, 0);
		w.addTile(f);
		assertTrue(w.computeScore() == 10);
		Tile v = new Tile("V", 4, 0);
		w.addTile(v);
		assertTrue(w.computeScore() == 15);
		Tile j = new Tile("J", 5, 0);
		w.addTile(j);
		assertTrue(w.computeScore() == 22);
		Tile z = new Tile("Z", 5, 1);
		w.addTile(z);
		assertTrue(w.computeScore() == 30);
		Tile q = new Tile("Q", 5, 2);
		w.addTile(q);
		assertTrue(w.computeScore() == 41);
	}
	
	@Test
	public void testLastTile(){
		Word w= new Word();
		Tile f = new Tile("F", 3, 0);
		Tile v = new Tile("V", 4, 0);
		assertTrue(w.getLastTile() == null);
		w.addTile(f);
		assertTrue(w.getLastTile().getLetters().equals(f.getLetters()));
		w.addTile(v);
		assertTrue(w.getLastTile().getLetters().equals(v.getLetters()));
		w.removeLastTile();
		assertTrue(w.toString().equals(f.getLetters()));
		w.removeLastTile();
		assertTrue(w.getLastTile() == null);
	}
	
	@Test
	public void testCopyConstruct(){
		Board b = new Board();
		b.setEmptyBoard();
		b.add("ABC", 10);
		Word w1 = new Word();
		int ax = -1;
		int ay = -1;
		int bx = -1;
		int by = -1;
		int cx = -1;
		int cy = -1;
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				if(b.getLetterAt(i, j).equals("A")){
					w1.addTile(new Tile("A", i, j));
					ax = i;
					ay = j;
				}
			}
		}
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				if(b.getLetterAt(i, j).equals("B")){
					w1.addTile(new Tile("B", i, j));
					bx = i;
					by = j;
				}
			}
		}
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				if(b.getLetterAt(i, j).equals("C")){
					w1.addTile(new Tile("C", i, j));
					cx = i;
					cy = j;
				}
			}
		}
		Word w2 = new Word(w1, b);
		
		assertTrue(w2.toString().equals(w1.toString()));
		assertTrue(w2.getTiles().get(0).getCol() == ay);
		assertTrue(w2.getTiles().get(0).getRow() == ax);
		assertTrue(w2.getTiles().get(1).getCol() == by);
		assertTrue(w2.getTiles().get(1).getRow() == bx);
		assertTrue(w2.getTiles().get(2).getCol() == cy);
		assertTrue(w2.getTiles().get(2).getRow() == cx);
	}

}
