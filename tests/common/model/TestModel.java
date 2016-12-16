package common.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Stack;

import org.junit.Before;
import org.junit.Test;

import game.move.SubmitWordMove;

import static common.application.Application.loadLevel;


/**
 * Test the <code>Model</code> class.
 * @author Adam Camilli (aocamilli@wpi.edu)
 *
 */
public class TestModel {

	Model m;
	ArrayList<Level> levels;
	
	@Before
	public void setup() {
		levels = new ArrayList<Level>();
		try {
			levels.add((PuzzleLevel)loadLevel("Puzzle_Level_1.lvl"));
			levels.add((PuzzleLevel)loadLevel("Puzzle_Level_2.lvl"));
		} catch(Exception e){
			e.printStackTrace();
			fail();
		} m = new Model(levels);
		
	}
	
	@Test
	public void testConstructors() {
		//Test default constructor
		ArrayList<Level> empty = new ArrayList<Level>();
		Model m1 = new Model(empty);
		assertEquals(m1.levels,empty);
		assertEquals(m1.moves,new Stack<IMove>());
		
		//Test empty constructor
		Model m2 = new Model();
		assertEquals(m2.moves,new Stack<IMove>());

	}
	
	@Test
	public void testMethods() {
		//Test getters/setters
		m.setLevel(m.levels.get(0));
		assertEquals(m.getCurrentLevel(),m.levels.get(0));
		assertEquals(m.getLevels(),levels);
		
		//Test creating new levels and unlocking them
		m.createNewLevel("Puzzle");
		try {
			m.createNewLevel("Puzzle","test_P");
			m.createNewLevel("Lightning", "test_L");
			m.createNewLevel("Theme", "test_T");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		//Test unlocking and adding levels
		m.unlockLevels();
		try {
			m.addLevel((PuzzleLevel)loadLevel("Puzzle_Level_2.lvl"));
		} catch(Exception e){
			e.printStackTrace();
			fail();
		}
		
		//Test adding, popping, and resetting move stack
		SubmitWordMove move1 = new SubmitWordMove(m.getLevels().get(0));
		SubmitWordMove move2 = new SubmitWordMove(m.getLevels().get(1));
		SubmitWordMove move3 = new SubmitWordMove(m.getLevels().get(2));
		m.addMove(move1);
		m.addMove(move2);
		m.addMove(move3);
		assertEquals(m.popMove(),move3);
		m.resetMoves();
		assertTrue(m.moves.isEmpty());
		assertEquals(m.popMove(),null);
	}

}
