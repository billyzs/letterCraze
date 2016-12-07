package common.model;

import java.util.ArrayList;

public abstract class Level{
	public static final String type = "";
	Board board;
	String name;
	Word currentWord;
	Dictionary dict;
	int currentPoints;
	int highscore;
	int[] starVals = new int[3];
	int targetScore;
	boolean unlocked;

    ArrayList<String> submittedWords = new ArrayList<String>();

	public void setName(String name) {
		this.name = name;
	}

	public void setDict(Dictionary dict) {
		this.dict = dict;
	}

	public void setCurrentPoints(int currentPoints) {
		this.currentPoints = currentPoints;
	}

	public void setHighscore(int highscore) {
		this.highscore = highscore;
	}

	public void setStarVals(int[] starVals) {
		this.starVals = starVals;
	}

	public boolean isUnlocked() {
		return unlocked;
	}

	public void setUnlocked(boolean unlocked) {
		this.unlocked = unlocked;
	}

	public void setSubmittedWords(ArrayList<String> submittedWords) {
		this.submittedWords = submittedWords;
	}

	//need to establish dictionary implementation
	


	public Level(){} //empty constructor to make creation of view and controller easier?
	public Level(Board b, String n, Dictionary d, int hs, int[] sv, boolean ul){
		this.board = b;
		this.name = n;
		this.dict = d;
		this.highscore = hs;
		this.starVals = sv;
		this.unlocked = ul;
		this.currentWord = new Word();
		this.initialize();
	}

	public void initialize(){
		this.currentWord.initialize();
		this.board.initialize();

		//remove all words from submitted words array
		for(int k = 0; k < this.submittedWords.size(); k++){
			submittedWords.remove(k);
		}

		this.currentPoints = 0;
	}
	
	//saves the level to a file
	//  This will eventually go to a common.controller I think
	public abstract void save(String filename);
	
	protected void repopulate(){
		//TODO fill empty cells at bottom
	}

	/**
	 * Performs upward gravity on the board.
	 * @return
	 */
	public boolean floatTiles(){
		//start looping from second row
		ArrayList<ArrayList<Tile>> tiles = this.board.getTiles();
		for(int r = 0; r < tiles.size(); r++){
			ArrayList<Tile> thisRow = tiles.get(r);
			
            for(int c = 0; c < tiles.get(r).size(); c++){
            	
            	//If this is empty
            	Tile tile = thisRow.get(c);
            	if(!tile.isNull() && tile.isEmpty()){
            		
            		//Find the next floatable and set it there
            		Tile foundTile = getNextFloatTile(r+1, c);
            		thisRow.get(c).setLetters(foundTile.getLetters());
            		
            		//set next tile to empty
            		foundTile.setLetters("");
            	}
            }
		}
		
		return true;
	}

	/**
	 * Gets the next tile to move up, searching a specific column. 
	 * @param startRow
	 * The first Row to start looking on.
	 * @param col
	 * The column to search down.
	 * @return
	 * Returns the Tile it found.
	 */
	protected Tile getNextFloatTile(int startRow, int col){
		int r;

		ArrayList<ArrayList<Tile>> tiles = this.board.getTiles();

		//Cycle through remaining rows
		for(r = startRow; r < tiles.size(); r++){
			ArrayList<Tile> row = tiles.get(r);
			
			//find next non-empty tile
			if(!row.get(col).isNull())
                if(!(row.get(col).isEmpty()))
                    return row.get(col);
		}

		//make new random tiles
        Tile result = new Tile(r,col);
		result.setRandLetter();

		return result; 
	}
	
	public abstract String getType();

	public String getName() { return this.name; }
	public Board getBoard() { return this.board; }
	public int getHighscore() { return this.highscore; }
	public int[] getStarVals() { return this.starVals; }
	public ArrayList<String> getSubmittedWords(){ return this.submittedWords; }

	public int getCurrentPoints(){return currentPoints;};
	public void setPoints(int i) {
		this.currentPoints = i;
	}
	
	//done if current points is greater than 1 star
	public boolean isComplete(){return this.currentPoints >= this.starVals[0];}
	public void addPoints(int i) {this.currentPoints += i;};
	public boolean getUnlocked() {return this.unlocked;}
	public int getTargetScore() {return this.targetScore;}
	public Dictionary getDict(){ return this.dict;}

	public Word getCurrentWord() {
		return this.currentWord;
	}
	public void addSubmittedWord(String s) {
		this.submittedWords.add(s);
	}
	public void resetCurrentWord() { this.currentWord.reset(); }
	public void setBoard(Board prevBoard) {
		this.board = prevBoard;
	}
	public void setCurrentWord(Word word) {
		this.currentWord = word;
	}

	/**
	 * responisble for updating the highscore to the new current points, if it's greater
	 */
	public void updateHighscore() {
		if(this.currentPoints > this.highscore)
			this.highscore = this.currentPoints;
	}

}
