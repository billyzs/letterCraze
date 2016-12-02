package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import view.*;
import application.Application;

public class ExitLevelController implements ActionListener{
	Application app;
	Model model;

	public ExitLevelController(Application a){
		this.app = a;
		this.model = a.getModel();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
        // TODO Auto-generated method stub
		
		//hide the current level view
		ContentPane.getCurrentLevelView().hide();
		
		//set it to null
		ContentPane.setCurrentLevelView(null);
		
		//set the current level to null in model
		this.model.setLevel(null);
		
		//show the menu
		this.app.getMenu().show();
	}
}
