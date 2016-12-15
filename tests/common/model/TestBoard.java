package common.model;

import static org.junit.Assert.*;

import org.junit.Test;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import common.model.Board;
import common.model.Tile;

public class TestBoard {

	
	@Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
    @Test
    public void testReset(){
    	Board b = new Board();
		b.setEmptyBoard();
		assertFalse(b.getTiles().isEmpty());
		assertEquals(6, b.getTiles().size());
		for(ArrayList<Tile> row : b.getTiles()){
			assertEquals(6, row.size());
			for(Tile t: row){
				assertEquals("", t.getLetters());
			}
		}

		b.getTiles().get(0).get(3).setLetters("Qu");
		assertEquals("Qu", b.getLetterAt(0, 3));
		b.setEmptyBoard();
		for(ArrayList<Tile> row : b.getTiles()){
			for(Tile t: row){
				assertEquals("", t.getLetters());
			}
		}
	}
    @Test
    public void testAdd(){ // FOUND ISSUE OF DOUBLE OF THE FIRST LETTER BEING PUT IN, CORRCETED
    	Board b = new Board();
    	b.setEmptyBoard();
    	b.add("ZYXWUV", 10);
    	int posX = -1;
    	int posY = -1;
    	int lettersFound = 0;
    	String thisLetter;
       	for(int i = 0; i < 6; i++){
    		for(int j = 0; j < 6; j++){
    			thisLetter = b.getLetterAt(i, j);
    			if(thisLetter.equals("Z")){
    				posX = i;
    				posY = j;
    				lettersFound = 1;
    			}
    			
    		}
    	}
       	
       	int yVals[], xVals[], wVals[], uVals[], vVals[];
       	
       	yVals = checkAdj(posX, posY, lettersFound, "Y", b);
       	xVals = checkAdj(yVals[0], yVals[1], yVals[2], "X", b);
       	wVals = checkAdj(xVals[0], xVals[1], xVals[2], "W", b);
       	uVals = checkAdj(wVals[0], wVals[1], wVals[2], "U", b);
       	vVals = checkAdj(uVals[0], uVals[1], uVals[2], "V", b);
       	
       	assertTrue(vVals[2] == 6);
    }
    public int[] checkAdj(int posX, int posY, int lettersFound, String s, Board b){
    	int vals[] = {posX, posY, lettersFound};
    	if(posX < 5 && posY < 5){
    		if(b.getLetterAt(posX+1, posY+1).equals(s)){
    			vals[2]++;
    			vals[0]++;
    			vals[1]++;
    		}
    	
    		if(b.getLetterAt(posX+1, posY).equals(s)){
    			vals[2]++;
    			vals[0]++;
    			
    		}
    	}
    	if(posX < 5 && posY > 0){
    		if(b.getLetterAt(posX+1, posY-1).equals(s)){
    			vals[2]++;
    			vals[0]++;
    			vals[1]--;
    		}
    	}
    	if(posY < 5){
    		if(b.getLetterAt(posX, posY+1).equals(s)){
    			vals[2]++;
    			vals[1]++;
    		}
    	}
    	if(posY > 0){
    		if(b.getLetterAt(posX, posY-1).equals(s)){
    			vals[2]++;
    			vals[1]--;
    		}
    	}
    	if(posX > 0 && posY < 5){
    		if(b.getLetterAt(posX-1, posY+1).equals(s)){
    			vals[2]++;
    			vals[0]--;
    			vals[1]++;
    		}
    	}
    	if(posX > 0){
    		if(b.getLetterAt(posX-1, posY).equals(s)){
    			vals[2]++;
    			vals[0]--;
    		}
    	}
    	if(posX > 0 && posY > 0){
    		if(b.getLetterAt(posX-1, posY-1).equals(s)){
    			vals[2]++;
    			vals[0]--;
    			vals[1]--;
    		}
    	}
    	return vals;
    }
    
    @Test
    public void testAddFails(){
    	Board b = new Board();
    	b.setEmptyBoard();
    	b.add("ZYXWUV", 0);
    	for(int i = 0; i < 6; i++){
    		for(int j = 0; j < 6; j++){
    			assertTrue(b.getLetterAt(i, j).isEmpty());
    		}
    	}
    	b.initialize();
    	b.add("ZYXWUV", 10);
    	b.setEmptyBoard();
    	b.add("ABCDEFGHIJKLMNOPQRSTUVWXYZPOIUYTREW", 1);
    	
    	
    }
    
    @Test
    public void testFillEmpty(){
    	Board b = new Board();
    	b.setEmptyBoard();
    	b.fillEmpty();
    	for(int i = 0; i < 6; i++){
    		for(int j = 0; j < 6; j++){
    			assertFalse(b.getLetterAt(i, j).isEmpty());
    		}
    	}
    	
    }
    
    @Test
    public void testRecoverClonedBoard(){
    	Board b1 = new Board();
    	Board b2 = new Board();
    	b1.setEmptyBoard();
    	b1.initialize();
    	b2.setEmptyBoard();
    	Board b3 = new Board(b1);
    	b2.recoverState(b3);
    	
    	for(int i = 0; i < 6; i++){
    		for(int j = 0; j < 6; j++){
    			assertTrue(b1.getLetterAt(i, j).equals(b2.getLetterAt(i, j)));
    		}
    	}
    	
    	
    }
    
    @Test
    public void testCountActive(){
    	Board b1 = new Board();
    	b1.setEmptyBoard();
    	b1.initialize();
    	assertTrue(b1.countActiveTiles() == 36);
    	b1.at(2, 2).setSelected(true);
    	b1.at(2, 3).setSelected(true);
    	assertTrue(b1.countActiveTiles() == 34);
    }
    
    @Test
    public void testClear(){
    	Board b1 = new Board();
    	b1.setEmptyBoard();
    	b1.fillEmpty();
    	b1.clear();
    	for(int i = 0; i < 6; i++){
    		for(int j = 0; j < 6; j++){
    			assertTrue(b1.getLetterAt(i, j).equals(""));
    		}
    	}
    }

}
