package common.model;

import javax.swing.Timer;

public class LightningLevel extends Level{
	Timer timer;
	int timerSeconds;
	public static final String type = "Lightning";

	public LightningLevel(Board b, String n, Dictionary d, int hs, int ts, boolean ul, int timerSeconds){
		super(b,n,d,hs,ts,ul);
		this.timerSeconds = timerSeconds;
	}
	
	@Override
	public void initialize() {
		this.currentWord.initialize();
		this.board.initialize();

		//remove all words from submitted words array
		for(int k = this.submittedWords.size()-1; k >= 0; k--){
			submittedWords.remove(k);
		}

		this.currentPoints = 0;
	}

	@Override
	public String getType() {
		return "Lightning";
	}

	@Override
	public void save(String filename) {
		// TODO Auto-generated method stub
		
	}
	
	public int getTimerSeconds() { return this.timerSeconds; }

}
