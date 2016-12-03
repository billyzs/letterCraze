package common.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import common.application.Application;
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
		

		//Check that there isnt already a level view
		if(ContentPane.getCurrentLevelView() != null) {
			ContentPane.getCurrentLevelView().hide();
		}
		//Check that there isnt already a level common.view
		if(ContentPane.getCurrentLevelView() != null){
            ContentPane.getCurrentLevelView().hide();

            System.out.println("tried to load 2 levels");
		}


		//send the level view to application, show it
		ContentPane.setCurrentLevelView(new LevelView(theLevel));

		//send the level common.view to common.application, show it
			ContentPane.setCurrentLevelView(new LevelView(theLevel));

		
		//initialize Controllers
		ContentPane.getCurrentLevelView().getExitButton().addActionListener(new ExitLevelController(app));
		ContentPane.getCurrentLevelView().show();
		
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				TileView t = ContentPane.getCurrentLevelView().getBoardView().getTileViews().get(i).get(j);
				t.addMouseListener(new SelectTileController(app, t));
			}
		}
			
		
		//set the level as current level in the common.model
		this.model.setLevel(theLevel);

        //hide the menu
		this.app.getMenu().hide();
	}
}