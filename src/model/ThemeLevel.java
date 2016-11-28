package model;

public class ThemeLevel extends Level {

	public ThemeLevel(Board b, String n, Dictionary d, int hs, int[] sv){
		super(b,n,d,hs,sv);
	}
	
	protected void repopulate(){
		//do nothing
	}
	
	protected void populateThemeWords(){
		//algorithmically add all words in the dictionary to the board
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

}
