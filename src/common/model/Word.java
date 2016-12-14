package common.model;

import java.util.ArrayList;

/**
 * A collection of <code>Tile</code> objects to be submitted and scored based on the type of level being played. 
 * @author Adam Camilli (aocamilli@wpi.edu)
 *
 */
public class Word {
	ArrayList<Tile> tiles = new ArrayList<Tile>(1);
	
	/**
	 * Default constructor.
	 * @param t A Tile
	 */
	public Word(Tile t){
		//set the first tiles to be the given arg
		tiles.set(0, t);
	}

	/**
	 * Empty constructor.
	 */
	public Word(){
		//init new arraylist
		tiles = new ArrayList<Tile>();
	}
	
	/**
	 * Constructor to copy a <code>Word</code> object from a previous <code>Board</code>. 
	 * @param w
	 * @param prevboard
	 */
	public Word(Word w, Board prevboard) {
		tiles = new ArrayList<Tile>();
		for(Tile t : w.getTiles()){
			//add the tiles from the prevboard, matching the current ones
			tiles.add(prevboard.getTiles().get(t.getRow()).get(t.getCol()));
		}
	}

	public void addTile(Tile t){
		this.tiles.add(t);
	}
	
	/**
	 * Compute score based off letter frequency.
	 * @return Collective score.
	 */
	public int computeScore(){
		//cycle through tiles and add score
		int score = 0;
		for(Tile t : tiles){
			score += this.getLetterScore(t.getLetters());
		}
		return score;
	}
	
	protected int getLetterScore(String s){
		
		int score = 0;

		//String to char
		char c = s.charAt(0);
		switch(c){
            case 'E': case 'T':
            	score = 1;
            	break;
            case 'A': case 'O': case'I':case'N':
            case'S': case'H':case'R':
            	score = 2;
            	break;
            case'D':case'L':case'C':case'U':
            case'M':case'W':
            	score = 3;
            	break;
            case'F':case'G':case'Y':case'P': case'B':
            	score = 4;
            	break;
            case'V':case'K':
            	score = 5;
            	break;
            case'J':case'X':
            	score = 7;
            	break;
            case'Z':
            	score = 8;
            	break;
            case'Q':
            	score = 11;
            	break;
		}
           
		return score;
	}
	
	/**
	 * Converts List of Tiles to String Form.
	 */
	public String toString(){
		String result = "";

		for(Tile t : tiles)
			result += t.getLetters();

		return result;
	}
	
	protected boolean isValid(){
		return false;
	}

	public boolean isEmpty(){
		return (this.tiles.size() == 0);
	}

	public Tile getLastTile() {
		if(this.isEmpty())
			return null;
		return this.tiles.get(this.tiles.size()-1);
	}
	
	public void removeLastTile(){
		if(this.isEmpty())
			return;
		this.tiles.remove(this.tiles.size()-1);
	}

	public ArrayList<Tile> getTiles() { return this.tiles; }

	/**
	 * Updates this word to reflect the state an old word.
	 * @param l Level for which it is being updated.
	 * @param copy An old word which the state will be updated to reflect.
	 */
	public void recoverState(Level l, Word copy) {
		this.tiles = new ArrayList<Tile>();
		Board b = l.getBoard();
		ArrayList<ArrayList<Tile>> btiles = b.getTiles();
		for(Tile t : copy.getTiles()){
			tiles.add(btiles.get(t.getRow()).get(t.getCol()));
		}
		
	}

	/**
	 * Empties the current word, resetting the tiles.
	 */
	public void reset() {
		this.tiles = new ArrayList<Tile>();
	}

	/**
	 * Simply invokes this.reset().
	 */
	public void initialize() {
		this.reset();
	}

}
