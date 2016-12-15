package common.model;
import static org.junit.Assert.*;
import java.io.IOException;
import java.util.ArrayList;

import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by billyzs on 12/5/16.
*/
public class TestBoard extends TestCase{
	private Board board;
	private ArrayList<ArrayList<Tile>> tiles;

    @Before
    public void setUp() throws Exception {
    	board = new Board();
    }

    @After
    public void tearDown() throws Exception {
    	board = new Board();
    }
    @Test
    public void testReset(){
    	Board b = new Board();
		b.setEmptyBoard();
		assertFalse(b.tiles.isEmpty());
		assertEquals(6, b.tiles.size());
		for(ArrayList<Tile> row : b.tiles){
			assertEquals(6, row.size());
			for(Tile t: row){
				assertEquals("", t.getLetters());
			}
		}

		b.tiles.get(0).get(3).setLetters("Qu");
		assertEquals("Qu", b.getLetterAt(0, 3));
		b.setEmptyBoard();
		for(ArrayList<Tile> row : b.tiles){
			for(Tile t: row){
				assertEquals("", t.getLetters());
			}
		}
	}

	public void testConstructor(){
	}

}

