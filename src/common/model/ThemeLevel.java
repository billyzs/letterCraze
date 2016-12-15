package common.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * A <code>Level</code> subclass in which letters are not replaced and only specific words may be submitted.
 * @author Grant Espe
 */
public class ThemeLevel extends Level {
	public static final String type = "Theme";
	protected String theme;


	@Override
	public String getPartialFileName() {
		return this.partialFileName;
	}

	String partialFileName = "Theme_Level_";

	/**
	 * Same constructor as superclass.
	 * @param b
	 * @param n
	 * @param d
	 * @param hs
	 * @param sv
	 * @param ul
	 */
	public ThemeLevel(Board b, String n, Dictionary d, int hs, int sv, boolean ul, String th){
		super(b,n,d,hs,sv,ul);
		//this.initialize();
		this.theme = th;
		this.targetScore = this.dict.getTable().size();
	}
	
	@Override
	public void repopulate(){
		//do nothing
		//System.out.println("\n\nREPOPULATE THEME\n\n");
	}
	
	/**
	 * Go through the Dictionary, add all words to the board with algorithm.
	 */
	protected void populateThemeWords(){
		ArrayList<String> strings = new ArrayList<String>(this.dict.getTable());
		
		System.out.println(strings);

		//add the strings to the board
		for(String s : strings){
			s = s.toUpperCase();
			//10 is arbitrary number of tries per word
			this.board.add(s,20);
		}
		
	}

	@Override
	public void initialize(){
		this.currentWord.initialize();

		//remove all words from submitted words array
		for(int k = this.submittedWords.size()-1; k >= 0; k--){
			submittedWords.remove(k);
		}
		
		this.board.clear();
		this.populateThemeWords();

		//randomize other letters
		this.board.fillEmpty();

		this.currentPoints = 0;
	}

	//because dicitonary needs to be saved to disk
	protected Dictionary getDictionary(){ return this.dict; }

	@Override
	public String getType() {
		return "Theme";
	}

	@Override
	//Saves the level in ascii
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
		    		if(t.isNull())
                        wr.print("0");
		    		else
		    			wr.print("1");
		    	}
		    	wr.println();

		    }
            // write the dict to end of file
            Iterator<String> itr = this.getDict().getTable().iterator();

            while(itr.hasNext()){
                String s = itr.next();
                wr.println(s);
            }
            
            wr.println(this.getTheme());
		    wr.close();
		} catch (IOException e) {
            e.printStackTrace();
		}
	}
	
	public String getTheme(){return this.theme;}
	public String setTheme(String s){ return (this.theme = s);}

	/**
	 * @return comma separated string containing all words in the dict, in no particular order.
	 */
	public String getWords(){
		String out = "";
		Iterator<String> iter = this.getDict().getTable().iterator();
		while (iter.hasNext()){
			out += iter.next() + ", ";
		}
		return out;
	}

	@Override
	/**
	 * Compute Score for Theme Levels 1 point per word.
	 */
	public int computeScore(Word word) {
		/**int totalWords = this.getSubmittedWords().size();
		ArrayList<String> strings = new ArrayList<String>();
		strings.addAll(this.dict.getTable());
		*/

		return 1;
	}

}
