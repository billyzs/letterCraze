package common.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import common.application.Application;
import game.move.*;
import common.model.Level;
import common.model.Model;
import common.model.Word;
import common.view.ContentPane;

public class SubmitWordController implements ActionListener{

	Application app;
	Model model;
	Level level;
	
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
		
		ContentPane.get().invalidate();
		ContentPane.get().validate();
		
	}
}
