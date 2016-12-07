package common.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import common.application.Application;
import common.model.Level;
import common.model.Model;
import common.view.ContentPane;

public class ResetLevelController implements ActionListener{
	
	Application app;
	Model model;
	Level theLevel;
	
	
	public ResetLevelController(Application a, Level l){
		this.theLevel = l;
		this.app = a;
		this.model= app.getModel();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		//reinit the level
		this.theLevel.initialize();

		//refresh the LevelView
		ContentPane.getCurrentLevelView().refresh();
	}
}