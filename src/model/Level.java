package model;

public abstract class Level{
	Board board;
	String name;
	Word currentWord;

	//need to establish dictionary implementation
	Dictionary dict;
	int currentPoints;
	int highscore;
	int[] starVals = new int[3];
	
	public Level(Board b, String n, Dictionary d, int hs, int[] sv){
		this.board = b;
		this.name = n;
		this.dict = d;
		this.highscore = hs;
		this.starVals = sv;
	}
	
	protected abstract void initialize();
	
	protected Word popCurrentWord(){
		//TODO remove tiles from board, ...
		return currentWord;
	}
	
	protected void repopulate(){
		//TODO fill empty tiles
	}

}
