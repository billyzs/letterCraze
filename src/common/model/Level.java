package common.model;

import java.util.ArrayList;

/**
 * Parent class of all levels in letterCraze containing data and functions used by all levels.
 * @author Grant Espe
 */
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
	
	/**
	 * Empty constructor to allow easier creation of boundary and controller objects.
	 */
	public Level(){} 
	
	/**
	 * Default constructor.
	 * @param b A Board
	 * @param n A Name
	 * @param d A Dictionary
	 * @param hs A High-score
	 * @param ts A target score
	 * @param ul Whether or not this level is unlocked
	 */
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

	/**
	 * Initialize level and all objects associated with it.
	 */
	public void initialize(){
		this.currentWord.initialize();
		this.board.initialize();

		//remove all words from submitted words array
		for(int k = this.submittedWords.size()-1; k >= 0; k--){
			submittedWords.remove(k);
		}

		this.currentPoints = 0;
	}
	
	/** Saves the level to a file, either this or a common.controller is used to do this for extensions of <code>Level</code>.
	 */
	public abstract void save(String filename);
	
	/**
	 * Repopulates the <code>Board</code> of this <code>Level</code>.
	 */
	public void repopulate(){
		this.board.fillEmpty();
	}

	/**
	 * Performs upward gravity on the board.
	 * @return Whether or not gravity was successful.
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
	 * @param startRow The first Row to start looking on.
	 * @param col column to search down.
	 * @return the Tile it found.
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
	
	/**
	 * Add points to this level's score, done if current points are sufficient for 1 star.
	 * @param i Number of points to add.
	 */
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
	 * Responisble for updating the highscore to the new current points, if it's greater.
	 */
	public void updateHighscore() {
		if(this.currentPoints > this.highscore)
			this.highscore = this.currentPoints;
	}

	/**
	 * Responsible for teardown, opposite of init.
	 */
	public void terminate() {
	}
	
	

}
