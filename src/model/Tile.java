package model;

public class Tile {
	String letters;
	int score;
	int row;
	int col;
	
	public Tile(String l, int s, int r, int c){
		this.letters = l;
		this.score = s;
		this.row = r;
		this.col = c;
	}
	
	protected void initialize(){
		//set the score
	}
	
	protected boolean isAdjacent(Tile t){
		return false;
	}

	public int getScore(){return score;}
}
