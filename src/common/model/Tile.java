package common.model;

public class Tile {
	String letters;
	int row;
	int col;
	boolean selected;
	
	//Random Letter Tile
	public Tile(int r, int c){
		this.row = r;
		this.col = c;
		this.letters = "";
		this.selected = false;
		this.setRandLetter();
	}

	public Tile(String l, int r, int c){
		this.letters = l;
		this.row = r;
		this.col = c;
		this.selected = false;
	}
	
	//for cloning tiles
	public Tile(Tile t) {
		this.letters = t.getLetters();
		this.row = t.getRow();
		this.col = t.getCol();
		this.selected = t.isSelected();
	}
	
	protected boolean isEmpty(){
		if(this.letters.equals(""))
			return true;
		return false;
	}
	
	public void makeEmpty(){
		this.letters = "";
	}
	
	public int getRow(){ return this.row;}
	public int getCol(){ return this.col;}
	
	protected void setRow(int i){this.row = i;}
	protected void setCol(int i){this.col = i;}
	public boolean isSelected(){return this.selected;}
	public void setSelected(boolean s){this.selected = s;}

	//returns true if they are within 1 of each other
	public boolean isAdjacent(Tile t){
		if(t.getCol()+1 == this.getCol() || t.getCol()-1 == this.getCol() || t.getCol() == this.getCol())
            if(t.getRow()+1 == this.getRow() || t.getRow()-1 == this.getRow() || t.getRow() == this.getRow())
                return true;
		return false;
	}

	public String getLetters(){return this.letters;}

	public String setRandLetter() {
		
		double r =  Math.random();

		double prob = 0.08167;
		if(r < prob)
			return (this.letters = "A");

		prob += 0.01492;
		if(r < prob)
			return (this.letters = "B");

		prob += 0.02782;
		if(r < prob)
			return (this.letters = "C");

		prob += 0.04253;
		if(r < prob)
			return (this.letters = "D");

		prob += 0.12702;
		if(r < prob)
			return (this.letters = "E");

		prob += 0.0228;
		if(r < prob)
			return (this.letters = "F");

		prob += 0.02015;
		if(r < prob)
			return (this.letters = "G");

		prob += 0.06094;
		if(r < prob)
			return (this.letters = "H");

		prob += 0.06966;
		if(r < prob)
			return (this.letters = "I");

		prob += 0.00153;
		if(r < prob)
			return (this.letters = "J");

		prob += 0.00772;
		if(r < prob)
			return (this.letters = "K");

		prob += 0.04025;
		if(r < prob)
			return (this.letters = "L");

		prob += 0.02406;
		if(r < prob)
			return (this.letters = "M");

		prob += 0.06749;
		if(r < prob)
			return (this.letters = "N");

		prob += 0.07507;
		if(r < prob)
			return (this.letters = "O");

		prob += 0.01929;
		if(r < prob)
			return (this.letters = "P");

		prob += 0.00095;
		if(r < prob)
			return (this.letters = "QU");

		prob += 0.05987;
		if(r < prob)
			return (this.letters = "R");

		prob += 0.06327;
		if(r < prob)
			return (this.letters = "S");

		prob += 0.09056;
		if(r < prob)
			return (this.letters = "T");

		prob += 0.02758;
		if(r < prob)
			return (this.letters = "U");

		prob += 0.00978;
		if(r < prob)
			return (this.letters = "V");

		prob += 0.02360;
		if(r < prob)
			return (this.letters = "W");

		prob += 0.00150;
		if(r < prob)
			return (this.letters = "X");

		prob += 0.01974;
		if(r < prob)
			return (this.letters = "Y");

		//dont think this is necessary
		/*prob += 0.00074;
		if(r <= prob)
		*/

        return (this.letters = "z");

	}
	public boolean isSelectable(){return !(letters == "");}

	public void setLetters(String s ) { this.letters = s; }

	public void recoverState(Tile t) {
		this.letters = t.getLetters();
		this.row = t.getRow();
		this.col = t.getCol();
		this.selected = t.isSelected();
	}
}
