package common.model;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.Timer;
import common.controller.TimerController;

/**
 * A <code>Level</code> subclass which is timed and calculates score based solely off of the number of words formed.
 * @author Grant Espe
 *
 */
public class LightningLevel extends Level{
	Timer timer;

	public void setTimerSeconds(int timerSeconds) {
		this.timerSeconds = timerSeconds;
	}

	int timerSeconds;
	public static final String type = "Lightning";

	
	/**
	 * Same constructor as superclass with an extra parameter.
	 * @param b
	 * @param n
	 * @param d
	 * @param hs
	 * @param ts
	 * @param ul
	 * @param timerSeconds How long user has to complete level.
	 */
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
		
        this.setTimer(new Timer(1000, new TimerController(this)));
		this.timer.start();
		//timer = new Timer(1000, new TimerController(this, )); TODO ??????
	}
	
	@Override
	public void terminate(){
		this.timer.stop();
	}

	@Override
	public String getType() {
		return "Lightning";
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
		    		if(t.isEmpty() || t.getLetters().equals(""))
                        wr.print("0");
		    		else
		    			wr.print("1");
		    	}
		    	wr.print("\n");
		    }
		    wr.println(this.getTimerSeconds());
		    wr.close();
		} catch (IOException e) {
            e.printStackTrace();
		}
	}
	
	public int getTimerSeconds() { return this.timerSeconds; }
	public Timer getTimer() { return this.timer; }
	public void setTimer(Timer timer2) {this.timer = timer2;}

	@Override
	/**
	 * Compute score for lightning levels, 1 point per word.
	 */
	public int computeScore(Word word) {
		return 1;
	}

}
