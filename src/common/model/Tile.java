package common.model;

/**
 * A specific member of a <code>Board</code> object that is either non-selectable or selectable and blank or containing a letter.
 * @author Grant Espe
 */
public class Tile {
	String letters;
	int row;
	int col;
	boolean selected;
	
	/**
	 * Constructs a non-selectable tile with a random letter at specified location.
	 * @param r Row
	 * @param c Column
	 */
	public Tile(int r, int c){
		this.row = r;
		this.col = c;
		this.letters = "";
		this.selected = false;
		this.setRandLetter();
	}

	/**
	 * Default constructor of a selectable <code>Tile</code>/
	 * @param l A Letter object
	 * @param r A row
	 * @param c A column
	 */
	public Tile(String l, int r, int c){
		this.letters = l;
		this.row = r;
		this.col = c;
		this.selected = false;
	}
	
	/**
	 * Constructor for cloning other <code>Tile</code> objects.
	 * @param t A Tile to be cloned.
	 */
	public Tile(Tile t) {
		this.letters = t.getLetters();
		this.row = t.getRow();
		this.col = t.getCol();
		this.selected = t.isSelected();
	}
	
	protected boolean isEmpty(){
		if(this.isNull() || this.letters.equals(""))
			return true;
		return false;
	}
	
	/**
	 * Sets this <code>Tile</code> to be blank.
	 */
	public void makeEmpty(){
		this.letters = "";
	}
	
	public int getRow(){ return this.row;}
	public int getCol(){ return this.col;}
	
	protected void setRow(int i){this.row = i;}
	protected void setCol(int i){this.col = i;}
	public boolean isSelected(){return this.selected;}
	public void setSelected(boolean s){this.selected = s;}

	/**
	 * Returns whether this <code>Tile</code> and another are within 1 space of each other.
	 * @param t A possible adjacent Tile
	 * @return Whether this Tile and another are adjacent or not.
	 */
	public boolean isAdjacent(Tile t){
		if(t.getCol()+1 == this.getCol() || t.getCol()-1 == this.getCol() || t.getCol() == this.getCol())
            if(t.getRow()+1 == this.getRow() || t.getRow()-1 == this.getRow() || t.getRow() == this.getRow())
                return true;
		return false;
	}

	public String getLetters(){return this.letters;}

	/**
	 * Helper method to generate a letter with a specific probability based on how common it is in the English language.
	 * @return A one-character A-Z String.
	 */
	public String setRandLetter() {
		
		double r =  Math.random();
		return testableSetRandLetter(r);

	}

	public String testableSetRandLetter(double r){

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

		return (this.letters = "Z");

	}
	public boolean isSelectable(){return !(letters.equals(""));}

	public void setLetters(String s ) { this.letters = s; }
	
	public boolean isNull(){return false;}

	/**
	 * Recover the state of another <code>Tile</code>.
	 * @param t A Tile to be recovered.
	 */
	public void recoverState(Tile t) {
		this.letters = t.getLetters();
		this.row = t.getRow();
		this.col = t.getCol();
		this.selected = t.isSelected();
	}
}
