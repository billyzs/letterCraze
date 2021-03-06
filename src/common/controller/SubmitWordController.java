package common.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import common.application.Application;
import game.move.*;
import common.model.Level;
import common.model.Model;
import common.model.Word;
import common.view.ContentPane;

/**
* <code>ActionListener</code> controller for submitting words.
* @author Team Technetium
*/
public class SubmitWordController implements ActionListener{

	Application app;
	Model model;
	Level level;
	
	/**
	 * @param a A letterCraze application.
	 * @param l A level.
	 */
	public SubmitWordController(Application a, Level l){
		this.app = a;
		this.model= app.getModel();
		this.level = l;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		
		//get the word and add the points, if it is a valid word
		Word theWord = this.level.getCurrentWord();
		
		SubmitWordMove move = new SubmitWordMove(this.level);
		
		if(move.isValid()){
			move.doMove();
            model.addMove(move);
            
            //float tiles
            this.level.floatTiles();
            
            //repopulate empties
            this.level.repopulate();
		}
		
		/*if(level.getDict().isWord(theWord.toString())){
            int points = theWord.computeScore();
            this.level.addPoints(points);
            this.level.addSubmittedWord(theWord.toString());
            this.level.resetCurrentWord();
		}*/

		//refresh all
		ContentPane.getCurrentLevelView().refresh();
		ContentPane.getCurrentLevelView().getSubmittedWordsView().refresh();
		
		System.out.println(this.level.getCurrentPoints());
		ContentPane.getCurrentLevelView().getStarsView().refresh();
		
		ContentPane.get().invalidate();
		ContentPane.get().validate();
		
		
	}
}
