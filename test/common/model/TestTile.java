package common.model;

import junit.framework.TestCase;

/**
 * Created by billyzs on 12/14/16.
 */
public class TestTile extends TestCase {
	private Tile t, t1;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		t = new Tile(1,2);
		t1 = new Tile("qu", 1, 2);
	}

	@Override
	protected void tearDown() throws Exception {
		this.setUp();
	}

	public void testTileConstructor(){
		assertEquals(1, t.getRow());
		assertEquals(2, t.getCol());

		assertEquals("qu", t1.getLetters());
		t = new Tile(t1);
		assertEquals(t1.getLetters(), t.getLetters());
		assertEquals(t1.getRow(), t.getRow());
		assertEquals(t1.getCol(), t.getCol());
	}

	public void testIsEmpty(){
		assertFalse(t1.isEmpty());
		assertTrue(t.isEmpty());
	}

	public void testMakeEmpty(){
		t1.makeEmpty();
		assertTrue(t1.isEmpty());
	}

	public void testSetters(){
		t.setRow(2);
		t.setCol(3);
		assertEquals(2, t.getRow());
		assertEquals(3, t.getCol());
		assertFalse(t1.selected);
		t1.setSelected(true);
		assertTrue(t1.isSelected());
	}

	public void testSelect(){
		assertTrue(t1.isSelectable());
	}

	public void testAdj(){
		t.setCol(1);
		assertTrue(t.isAdjacent(t1));
		t.setCol(2);
		assertTrue(t.isAdjacent(t1));
	}

	public void testNull(){
		assertFalse(t.isNull());
		assertFalse(t1.isNull());
	}

	public void testRandLetter(){
		t.testableSetRandLetter(0.99);
		assertEquals("Y",t.getLetters());
	}

}
