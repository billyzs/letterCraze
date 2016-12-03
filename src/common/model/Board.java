package common.model;

import java.util.ArrayList;

public class Board {
	ArrayList<ArrayList<Tile>> tiles;

	public Board(ArrayList<ArrayList<Tile>> t){
		tiles = t;
	}
	public Board(){} // empty constructor for test

	protected boolean floatTiles(){
		//start looping from second row
		for(int r = 0; r < tiles.size(); r++){
			ArrayList<Tile> thisRow = this.tiles.get(r);
			
            for(int c = 0; c < tiles.get(r).size(); c++){
            	
            	//If this is empty
            	if(thisRow.get(c).isEmpty()){
            		
            		//Find the next floatable and set it there
            		thisRow.set(c, getNextFloatTile(r+1, c));
            		thisRow.get(c).setRow(r);
            	}
            }
		}
		
		return false;
	}

	public ArrayList<ArrayList<Tile>> getTiles() {
		return this.tiles;
	}
	
	protected Tile getNextFloatTile(int startRow, int col){
		int r;

		//Cycle through remainging rows
		for(r = startRow; r < this.tiles.size(); r++){
			ArrayList<Tile> row = this.tiles.get(r);
			
			//find next non-empty tile
			if(!(row.get(col).isEmpty())){
				return row.get(col);
			}
		}

		//make new random tiles
        Tile result = new Tile(r,col);
		result.setRandLetter();

		return result; 
	}
	
	

}
