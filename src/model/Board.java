package model;

import java.util.ArrayList;

public class Board {
	ArrayList<Tile> tiles;
	
	public Board(ArrayList<Tile> t){
		tiles = t;
	}
	
	protected boolean floatTiles(){
		return false;
	}
	

}
