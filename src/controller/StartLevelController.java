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
	
	public StartLevelController(Application a, Model m){
		this.app = a;
		this.model = m;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		LevelMenuView lmv = (LevelMenuView)ae.getSource();
		
	}

}