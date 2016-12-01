package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import application.Application;
import common.model.*;
import common.view.*;

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
		
		//get the respective level from the common.model
		//Level theLevel = this.common.model.getLevels().get(index);
		
		//Check that there isnt already a level common.view
		if(this.app.getCurrentLevelView() != null){
            this.app.getCurrentLevelView().hide();
            System.out.println("tried to load 2 levels");
		}
		//hide the menu

		//send the level common.view to application, show it
		this.app.setLevelView(new LevelView(theLevel));
		
		//initialize Controllers
		this.app.getCurrentLevelView().getExitButton().addActionListener(new ExitLevelController(app));

		this.app.getCurrentLevelView().show();
		
		//set the level as current level in the common.model
		this.model.setLevel(theLevel);
		this.app.getMenu().hide();
	}
}