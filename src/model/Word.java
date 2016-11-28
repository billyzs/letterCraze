package model;

import java.util.ArrayList;

public class Word {
	ArrayList<Tile> tiles = new ArrayList<Tile>(1);
	
	public Word(Tile t){
		//set the first tiles to be the given arg
		tiles.set(0, t);
	}
	
	protected void addTile(Tile t){
		this.tiles.add(t);
	}
	
	protected int computeScore(){
		return -1;
	}
	
	public String toString(){
		return "";
	}
	
	protected boolean isValid(){
		return false;
	}

}
