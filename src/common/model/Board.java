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
}
