package common.model;

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
				if(t == null)
					this.tiles.get(this.tiles.size()-1).add(null);
				else
                    this.tiles.get(this.tiles.size()-1).add(new Tile(t));
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
				if(t == null)
					this.tiles.get(r).set(c, null);
				else
                    this.tiles.get(r).get(c).recoverState(t);
				c++;
			}
			r++;
		}
	}
	
	

}
