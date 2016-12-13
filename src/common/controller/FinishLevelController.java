package common.controller;

import common.model.*;
import common.view.ContentPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import common.application.*;

public class FinishLevelController implements ActionListener{
	
	Application app;
	Model model;
	Level theLevel;
	
	public FinishLevelController(Application a, Level l){
		this.theLevel = l;
		this.app = a;
		this.model= app.getModel();
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		
		//update the highscore
		this.theLevel.updateHighscore();

		//save the level to filename, go back to main menu
		this.theLevel.save(this.theLevel.getName());
		
		//Terminate the level
		this.theLevel.terminate();

		//hide the current level view
		ContentPane.getCurrentLevelView().hide();
		
		//unlock levels if necessary
		this.model.unlockLevels();

		//hide the current level common.view
		this.app.getMenu().show();
		
		//set it to null
		ContentPane.setCurrentLevelView(null);
	
		//set the current level to null in common.model
		this.model.setLevel(null);
		
		//show the menu
		this.app.getMenu().show();
	}
}
