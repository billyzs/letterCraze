package common.model;

import java.util.ArrayList;

public class Word {
	ArrayList<Tile> tiles = new ArrayList<Tile>(1);
	
	public Word(Tile t){
		//set the first tiles to be the given arg
		tiles.set(0, t);
	}

	public Word(){
		//init new arraylist
		tiles = new ArrayList<Tile>();
	}
	
	protected void addTile(Tile t){
		this.tiles.add(t);
	}
	
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
	
	//Converts List of Tiles to String Form
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

}
