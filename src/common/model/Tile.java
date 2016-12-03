package common.model;

public class Tile {
	String letters;
	int score;
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
	
	
	protected void initialize(){
		//set the score probably
	}
	
	protected boolean isEmpty(){
		if(this.letters.equals(""))
			return true;
		return false;
	}
	
	protected void makeEmpty(){
		this.letters = "";
	}
	
	protected int getRow(){ return this.row;}
	protected int getCol(){ return this.col;}
	
	protected void setRow(int i){this.row = i;}
	protected void setCol(int i){this.col = i;}

	protected boolean isAdjacent(Tile t){
		return false;
	}

	public int getScore(){return this.score;}
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
}
