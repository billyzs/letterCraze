package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.*;
import view.*;
import application.Application;

public class ExitLevelController implements ActionListener{
	Application app;
	Model model;

	public ExitLevelController(Application a, Model m){
		this.app = a;
		this.model = m;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub
		
	}

}
