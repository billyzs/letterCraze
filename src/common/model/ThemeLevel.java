package common.model;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A <code>Level</code> subclass in which letters are not replaced and only specific words may be submitted.
 * @author Grant Espe
 */
public class ThemeLevel extends Level {
	public static final String type = "Theme";

	/**
	 * Same constructor as superclass.
	 * @param b
	 * @param n
	 * @param d
	 * @param hs
	 * @param sv
	 * @param ul
	 */
	public ThemeLevel(Board b, String n, Dictionary d, int hs, int sv, boolean ul){
		super(b,n,d,hs,sv,ul);
		//this.initialize();
	}
	
	@Override
	public void repopulate(){
		//do nothing
		System.out.println("\n\nREPOPULATE THEME\n\n");
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
			this.board.add(s,10);
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
	public void save(String filename) {
		// TODO Auto-generated method stub
		
	}

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

}
