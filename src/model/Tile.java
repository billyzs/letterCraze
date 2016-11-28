package model;

public class Tile {
	String letters;
	int score;
	int row;
	int col;
	
	public Tile(int r, int c){
		this.row = r;
		this.col = c;
	}

	public Tile(String l, int r, int c){
		this.letters = l;
		this.row = r;
		this.col = c;
	}
	
	
	protected void initialize(){
		//set the score probably
	}

	protected boolean isAdjacent(Tile t){
		return false;
	}

	public int getScore(){return this.score;}
	public String getLetters(){return this.letters;}
}
