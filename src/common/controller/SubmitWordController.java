package common.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import common.application.Application;
import common.model.Level;
import common.model.Model;
import common.model.Word;

public class SubmitWordController implements ActionListener{

	Application app;
	Model model;
	Level level;
	
	public SubmitWordController(Application a, Level l){
		this.app = a;
		this.model= app.getModel();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		//get the word and add the points, if it is a valid word
		Word theWord = this.level.popCurrentWord();
		int points = theWord.computeScore();
		this.level.addPoints(points);
		
	}

}
