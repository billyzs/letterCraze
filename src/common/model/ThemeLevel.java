package common.model;

import java.util.ArrayList;

public class ThemeLevel extends Level {
	public static final String type = "Theme";

	public ThemeLevel(Board b, String n, Dictionary d, int hs, int sv, boolean ul){
		super(b,n,d,hs,sv,ul);
		//this.initialize();
	}
	
	protected void repopulate(){
		//do nothing
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

}
