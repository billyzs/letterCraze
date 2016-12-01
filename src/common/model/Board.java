package common.model;

import java.util.ArrayList;

public class Board {
	ArrayList<ArrayList<Tile>> tiles;

	public Board(ArrayList<ArrayList<Tile>> t){
		tiles = t;
	}
	public Board(){} // empty constructor for test
	protected boolean floatTiles(){
		return false;
	}

	public ArrayList<ArrayList<Tile>> getTiles() {
		return this.tiles;
	}
	
	

}
