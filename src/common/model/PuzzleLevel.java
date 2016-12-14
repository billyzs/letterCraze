package common.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * A <code>Level</code> subclass where only a limited number of <code>Word</code>s may be submitted, and
 * where score is calculated based off the letters in a word as well as its length.
 * @author Grant Espe
 *
 */
public class PuzzleLevel extends Level{
	public static final String type = "Puzzle";

	public void setMaxWords(int maxWords) {
		this.maxWords = maxWords;
	}

	int maxWords;

	/**
	 * Same constructor as superclass with an extra parameter.
	 * @param b
	 * @param n
	 * @param d
	 * @param hs
	 * @param sv
	 * @param ul
	 * @param mw The maximum number of words allowed to be entered.
	 */
	public PuzzleLevel(Board b, String n, Dictionary d, int hs, int sv, boolean ul, int mw){
		super(b,n,d,hs,sv,ul);
		this.maxWords = mw;
	}
	
	public String getType(){
		return "Puzzle";
	}
	
	@Override
	public int getMaxWords(){ return this.maxWords;}
	

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

	/**
	 * Compute score based off letter frequency.
	 * @return Collective score.
	 */
	@Override
	public int computeScore(Word word){
		//cycle through tiles and add score
		int score = 0;
		for(Tile t : word.getTiles()){
			score += this.getLetterScore(t.getLetters());
		}
		return score;
	}
	
	protected int getLetterScore(String s){
		
		int score = 0;

		//String to char
		char c = s.charAt(0);
		switch(c){
            case 'E': case 'T':
            	score = 1;
            	break;
            case 'A': case 'O': case'I':case'N':
            case'S': case'H':case'R':
            	score = 2;
            	break;
            case'D':case'L':case'C':case'U':
            case'M':case'W':
            	score = 3;
            	break;
            case'F':case'G':case'Y':case'P': case'B':
            	score = 4;
            	break;
            case'V':case'K':
            	score = 5;
            	break;
            case'J':case'X':
            	score = 7;
            	break;
            case'Z':
            	score = 8;
            	break;
            case'Q':
            	score = 11;
            	break;
		}
           
		return score;
	}

}
