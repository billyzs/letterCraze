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

	public void setTargetScore(int targetScore) {
		this.targetScore = targetScore;
	}

	public boolean isUnlocked() {
		return unlocked;
	}
	
	public int getMaxWords(){
		return Integer.MAX_VALUE;
	}
	
	/**
	 * For unlocking next level.
	 * @return if this is complete, return true.
	 */
	public boolean isComplete(){
		return this.highscore >= (this.targetScore/3.0);
	}

	public void setUnlocked(boolean unlocked) {
		this.unlocked = unlocked;
	}

	public void setSubmittedWords(ArrayList<String> submittedWords) {
		this.submittedWords = submittedWords;
	}

	//need to establish dictionary implementation
	


	public Level(){} //empty constructor to make creation of view and controller easier?
	public Level(Board b, String n, Dictionary d, int hs, int ts, boolean ul){
		this.board = b;
		this.name = n;
		this.dict = d;
		this.highscore = hs;
		this.targetScore = ts;
		this.unlocked = ul;
		this.currentWord = new Word();
		//this.initialize();
	}

	public void initialize(){
		this.currentWord.initialize();
		this.board.initialize();

		//remove all words from submitted words array
		for(int k = this.submittedWords.size()-1; k >= 0; k--){
			submittedWords.remove(k);
		}

		this.currentPoints = 0;
	}
	
	//saves the level to a file
	//  This will eventually go to a common.controller I think
	public abstract void save(String filename);
	
	public void repopulate(){
		this.board.fillEmpty();
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

		//make new tiles
        Tile result = new Tile("",r,col);
		//result.setRandLetter();

		return result; 
	}
	
	public abstract String getType();

	public String getName() { return this.name; }
	public Board getBoard() { return this.board; }
	public int getHighscore() { return this.highscore; }
	public ArrayList<String> getSubmittedWords(){ return this.submittedWords; }

	public int getCurrentPoints(){return currentPoints;};
	public void setPoints(int i) {
		this.currentPoints = i;
	}
	
	//done if current points is greater than 1 star
	public void addPoints(int i) {this.currentPoints += i;};
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

	/**
	 * responsible for teardown, opposite of init.
	 */
	public void terminate() {
	}
	
	

}
