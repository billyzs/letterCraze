package common.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import common.model.*;
import common.application.Application;
import common.view.*;

/**
 * <code>ActionListener</code> controller for exiting a level via the Exit <code>JButton</code>.
 * @author Team Technetium
 */
public class ExitLevelController implements ActionListener{
	Application app;
	Model model;

	/**
	 * @param a A letterCraze application
	 */
	public ExitLevelController(Application a){
		this.app = a;
		this.model = a.getModel();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {

		//hide the current level view
		ContentPane.getCurrentLevelView().getLevel().terminate();
		ContentPane.getCurrentLevelView().hide();

		//Show the menu
		this.app.getMenu().show();
		
		//set it to null
		ContentPane.setCurrentLevelView(null);
		
		//set the current level to null in common.model
		this.model.setLevel(null);
		
		//show the menu
		this.app.getMenu().show();
	}
}
