package model;

import java.util.Arrays;

public class Level {
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
	
	protected void initialize(){
	}
	
	protected Word popCurrentWord(){
		return null;
	}
	
	protected void repopulate(){
	}

}
