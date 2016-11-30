package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import application.Application;
import model.*;
import view.*;

// Controller for starting levels from the main menu
public class StartLevelController implements ActionListener{
	
	Application app;
	Model model;
	Level theLevel;
	
	public StartLevelController(Application a, Level l){
		this.theLevel = l;
		this.app = a;
		this.model= app.getModel();
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {

		//get the button that pressed this, find which level it corresponds to
		//LevelMenuView lmv = (LevelMenuView)ae.getSource();

		//int index = this.app.getMenu().getLevelIndex(lmv);
		
		//get the respective level from the model
		//Level theLevel = this.model.getLevels().get(index);
		
		//Check that there isnt already a level view
		if(this.app.getCurrentLevelView() != null){
            this.app.getCurrentLevelView().hide();
            System.out.println("tried to load 2 levels");
		}
		
		//hide the menu

		//send the level view to application, show it
		this.app.setLevelView(new LevelView(app, theLevel));
		this.app.getCurrentLevelView().show();
		
		//set the level as current level in the model
		this.model.setLevel(theLevel);
		this.app.getMenu().hide();
	}
}