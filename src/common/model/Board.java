package common.model;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Board {
	ArrayList<ArrayList<Tile>> tiles;

	public Board(ArrayList<ArrayList<Tile>> t){
		tiles = t;
	}

	public Board(){} // empty constructor for test
	
	//constructor for cloning
    public Board(Board b){
		//make new arraylist of tiles
		this.tiles = new ArrayList<ArrayList<Tile>>();
		
		//clone each tile
		for(ArrayList<Tile> row : b.getTiles()){
			tiles.add(new ArrayList<Tile>());
			for(Tile t : row){
				//if its null add a null tile
				if(t.isNull())
					this.tiles.get(this.tiles.size()-1).add(new NullTile(t));
				else
                    this.tiles.get(this.tiles.size()-1).add(new Tile(t));
			}
		}
	}
    
    //Reset each tile to be random
    public void initialize(){
		for(ArrayList<Tile> row : this.tiles){
			for(Tile t : row){
                t.setRandLetter();
                t.setSelected(false);
			}
		}
    }
    
    public void clear(){
		for(ArrayList<Tile> row : this.tiles){
			for(Tile t : row){
                t.setLetters("");
                t.setSelected(false);
			}
		}
    }
    

	public ArrayList<ArrayList<Tile>> getTiles() {
		return this.tiles;
	}
	
	public void recoverState(Board prevBoard) {
		int r = 0;
		for(ArrayList<Tile> row : prevBoard.getTiles()){
			int c =0;
			for(Tile t : row){
				/*if(t.isNull()l)
					this.tiles.get(r).get(c, recoverState(t));
				else
				*/
                this.tiles.get(r).get(c).recoverState(t);
				c++;
			}
			r++;
		}
	}

	/**
	 * set tiles to be an empty 6*6 array of tiles
	 */
	public void setEmptyBoard(){
		ArrayList<ArrayList<Tile>> newTiles = new ArrayList<ArrayList<Tile>>();
		// int i = 0, j = 0;
		for(int i=0; i < 6; i++){
			ArrayList<Tile> row = new ArrayList<Tile>(6);
			for(int j = 0; j < 6; j++){
				row.add(new Tile("", i, j));
			}
			newTiles.add(row);
		}
		tiles = newTiles;
	}

	// return the letter at specific position
	String getLetterAt(int row, int col){
		return tiles.get(row).get(col).getLetters();
	}
	public Tile at(int row, int col){ return tiles.get(row).get(col);}
	public int countActiveTiles(){
		int count = 36;
		for (ArrayList<Tile> row: this.getTiles()){
			for(Tile t : row){
				if (t.isSelected()){
					count--;
				};
			}
		}
		System.out.println(count);
		return count;
	}

	/** for theme levels, adds a string to a board
	 * 
	 * @param s The string to be added.
	 * @param remainingTries number of TRials left before algol gives up.
	 */
	public void add(String s, int remainingTries) {
		remainingTries--;

		if(remainingTries <= 0){
            System.out.println("\n Finished all tries for word: " + s);
			return;
		}

		//search and get all empty, nonnull tiles
		ArrayList<Tile> allEmpty = new ArrayList<Tile>();
		ArrayList<Tile> used = new ArrayList<Tile>();
		
		for(ArrayList<Tile> row : this.tiles){
			for(Tile t : row){
				if(!t.isNull() && t.isEmpty())
                    allEmpty.add(t);
			}
		}
		
		if(allEmpty.size() < s.length()){
            System.out.println("\n\nNOt Enough Tiles ON BOARD FOR THEME WORD: " + s);
			return;
		}
		
		//get a random tile to be first
		Tile firstTile = allEmpty.get((int)(Math.random()*allEmpty.size()));
		used.add(firstTile);
		
		int row = firstTile.getRow();
		int col = firstTile.getCol();
		
		//set the first letter
		tiles.get(row).get(col).setLetters("" + s.toCharArray()[0]);
		
		//set the rest
		for(int k = 0; k < s.length(); k++){
			//Empty adjacent tiles
            ArrayList<Tile> empties = getEmptyAdjacents(row,col);

            if(empties.size() == 0){
            	System.err.println("\n\nNO Empty adjacent tiles FOR THEME WORD, trying again: " + s);

            	//reset used tiles to blank and try again
            	// but if its at the last try, just leave chars.
            	if(remainingTries > 1)
                    for(Tile t : used)
                        t.setLetters("");

            	//try recursively
            	this.add(s, remainingTries);
            	return;
            }

            int rand = (int)(Math.random()*(empties.size()));
            Tile nextTile = empties.get(rand);
            used.add(nextTile);

            //set the letter to go there
            nextTile.setLetters("" + s.toCharArray()[k]);

            //set the rows and col of current letter
            row = nextTile.getRow();
            col = nextTile.getCol();
		}

		System.out.println("Done with word: " + s);
	}

	public ArrayList<Tile> getEmptyAdjacents(int row, int col) {
		ArrayList<Tile> result = new ArrayList<Tile>();

		for(int k = -1; k <= 1; k++){
			for(int i = -1; i <= 1; i++){
				if(row+k >= 0 && col+i >=0 && row+k < 6 && col+i < 6){
                    Tile t = this.tiles.get(row + k).get(col + i);
                    if(!t.isNull() && t.isEmpty())
                        result.add(t);
				}
			}
		}

		return result;
	}

	/**
	 * Fills the empty tiles with random letters
	 */
	public void fillEmpty() {
		for(ArrayList<Tile> row : this.tiles){
			for(Tile t : row){
				if(t.isEmpty())
                    t.setRandLetter();
			}
		}
	}
}
