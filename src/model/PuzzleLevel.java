package model;

public class PuzzleLevel extends Level{
	int maxWords;

	public PuzzleLevel(Board b, String n, Dictionary d, int hs, int[] sv, int mw){
		super(b,n,d,hs,sv);
		this.maxWords = mw;
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

}
