package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import common.model.*;
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
		
		//hide the current level common.view
		this.app.getMenu().show();
		this.app.getCurrentLevelView().hide();
		
		//set it to null
		this.app.setLevelView(null);
		
		//set the current level to null in common.model
		this.model.setLevel(null);
		
		//show the menu
	}
}
