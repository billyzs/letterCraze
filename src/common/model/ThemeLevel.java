package common.model;

public class ThemeLevel extends Level {
	public static final String type = "Theme";

	public ThemeLevel(Board b, String n, Dictionary d, int hs, int sv, boolean ul){
		super(b,n,d,hs,sv,ul);
	}
	
	protected void repopulate(){
		//do nothing
	}
	
	protected void populateThemeWords(){
		//algorithmically add all words in the dictionary to the board
	}

	@Override
	public void initialize() {
		// TODO Auto-generated method stub
		
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
