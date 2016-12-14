package game.move;

import common.model.*;
import common.view.ContentPane;

/**
 * Move class representing the action of submitting a <code>Word</code>.
 * @author Team Technetium
 */
public class SubmitWordMove implements IMove{
	Level level;
	Board prevBoard;
	Word wordCopy;
	Word word;
	int points;
	
	/**
	 * Default constructor.
	 * @param l A Level
	 */
	public SubmitWordMove(Level l){
		this.level = l;
		this.prevBoard = new Board(this.level.getBoard());
		this.word = this.level.getCurrentWord();
		this.wordCopy = new Word(this.word, this.prevBoard);

		//clone the board before starting
		this.points = l.computeScore(this.word);
	}
	
	
	/**
	 * Adds <code>Word</code> to the submitted words, removes tiles from the <code>Level</code>.
	 */
	public void doMove(){
		if(this.isValid()){
			//add submitted word
			this.level.getSubmittedWords().add(word.toString());
			
			//empty tiles from word, and deselect
			for(Tile t : this.word.getTiles()){
				t.makeEmpty();
				t.setSelected(false);
			}

			//add points to level
			this.level.addPoints(points);
			
			//remove the word from level
			this.level.resetCurrentWord();
		}
	}

	/**
	 * Undo submission of <code>Word</code>.
	 */
	public void undo(){
		//move prevboard to the level
		this.level.getBoard().recoverState(this.prevBoard);

		//remove last word submitted
		this.level.getSubmittedWords().remove(this.level.getSubmittedWords().size()-1);
		
		//move the prevword to the level
		this.level.getCurrentWord().recoverState(this.level,this.wordCopy);
		
		//remove the points
		this.level.addPoints(-1 * this.points);
		
	}
	
	/**
	 * Move is valid if <code>Word</code> is valid.
	 */
	public boolean isValid(){
		String type = level.getType();
		if((type == "Lightning") && (((LightningLevel)(level)).isTimeOver())) {
			return false;
		}
		if(this.level.getDict().isWord(this.word.toString()))
			if(this.word.toString().length() >= 3 || this.level.getType().equals("Theme"))
                return true;
		return false;
	}

}