package common.model;

public class Tile {
	String letters;
	int score;
	int row;
	int col;
	boolean selected;
	
	public Tile(int r, int c){
		this.row = r;
		this.col = c;
		//unselecteable tile
		this.letters = "";
	}

	public Tile(String l, int r, int c){
		this.letters = l;
		this.row = r;
		this.col = c;
	}
	
	
	protected void initialize(){
		//set the score probably
		selected = false;
	}

	protected boolean isAdjacent(Tile t){
		return false;
	}

	public int getScore(){return this.score;}
	public String getLetters(){return this.letters;}
	public boolean isSelected(){return this.selected;}
	public void setSelected(boolean s){this.selected = s;}
}
