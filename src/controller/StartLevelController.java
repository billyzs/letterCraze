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
		if(ContentPane.getCurrentLevelView() != null){
            ContentPane.getCurrentLevelView().hide();
            System.out.println("tried to load 2 levels");
		}

		//send the level view to application, show it
		ContentPane.setCurrentLevelView(new LevelView(theLevel));
		
		//initialize Controllers
		ContentPane.getCurrentLevelView().getExitButton().addActionListener(new ExitLevelController(app));

		ContentPane.getCurrentLevelView().show();
		
		//set the level as current level in the model
		this.model.setLevel(theLevel);

        //hide the menu
		this.app.getMenu().hide();
	}
}