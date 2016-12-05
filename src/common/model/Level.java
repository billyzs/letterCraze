package common.model;

import java.util.ArrayList;

public abstract class Level{
	Board board;
	String name;
	Word currentWord;

	//need to establish dictionary implementation
	Dictionary dict;
	int currentPoints;
	int highscore;
	int[] starVals = new int[3];
	boolean unlocked;

    ArrayList<String> submittedWords = new ArrayList<String>();


	public Level(){} //empty constructor to make creation of view and controller easier?
	public Level(Board b, String n, Dictionary d, int hs, int[] sv, boolean ul){
		this.board = b;
		this.name = n;
		this.dict = d;
		this.highscore = hs;
		this.starVals = sv;
		this.unlocked = ul;
		this.currentWord = new Word();
	}

	protected abstract void initialize();
	
	//saves the level to a file
	//  This will eventually go to a common.controller I think
	public abstract void save(String filename);
	
	protected void repopulate(){
		//TODO fill empty tiles
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
	public Dictionary getDict(){ return this.dict;}

	public Word getCurrentWord() {
		return this.currentWord;
	}
	public void addSubmittedWord(String s) {
		this.submittedWords.add(s);
	}
	public void resetCurrentWord() { this.currentWord = new Word(); }
	public void setBoard(Board prevBoard) {
		this.board = prevBoard;
	}
	public void setCurrentWord(Word word) {
		this.currentWord = word;
	}

}
