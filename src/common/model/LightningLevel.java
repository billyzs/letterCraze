package common.model;

import javax.swing.Timer;

public class LightningLevel extends Level{
	Timer timer;

	public LightningLevel(Board b, String n, Dictionary d, int hs, int[] sv, boolean ul){
		super(b,n,d,hs,sv,ul);
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getType() {
		return "Lightning";
	}

	@Override
	public void save(String filename) {
		// TODO Auto-generated method stub
		
	}

}
