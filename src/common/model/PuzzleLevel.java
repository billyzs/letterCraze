package common.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PuzzleLevel extends Level{
	public static final String type = "Puzzle";
	int maxWords;

	public PuzzleLevel(Board b, String n, Dictionary d, int hs, int sv, boolean ul, int mw){
		super(b,n,d,hs,sv,ul);
		this.maxWords = mw;
	}
	
	public String getType(){
		return "Puzzle";
	}
	

	@Override
	//Saves the level in ascii
	//TODO save maxwords somehow?
	public void save(String filename) {
		try{
		    PrintWriter wr = new PrintWriter("./levels/" + filename + ".lvl", "UTF-8");
		    //write out to disk
		    wr.println(this.getType());
		    wr.println(this.getName());
		    wr.println("" + this.getHighscore());
		    wr.println("" + this.getTargetScore());
		    wr.println("" + this.isUnlocked());
		    ArrayList<ArrayList<Tile>> tiles = this.getBoard().getTiles();
		    
		    //output the board as an array of 0's and 1's
		    for(ArrayList<Tile> row : tiles){
		    	for(Tile t : row){
		    		//if the tile is empty, output 0, otherwise 1
		    		if(t.isEmpty() || t.getLetters().equals(""))
                        wr.print("0");
		    		else
		    			wr.print("1");
		    	}
		    	wr.print("\n");
		    }
		    
		    wr.print("" + this.maxWords);
            wr.print("\n");
		    
		    wr.close();
		} catch (IOException e) {
            e.printStackTrace();
		}
	}

}
