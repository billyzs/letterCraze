package common.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import common.application.Application;
import common.model.Level;
import common.model.Model;
import common.view.ContentPane;

/**
* <code>ActionListener</code> controller for reseting a level and forfeiting current score.
* @author Team Technetium
*/
public class ResetLevelController implements ActionListener{
	
	Application app;
	Model model;
	Level theLevel;
	
	/**
	 * @param a A letterCraze application.
	 * @param l A level being played.
	 */
	public ResetLevelController(Application a, Level l){
		this.theLevel = l;
		this.app = a;
		this.model= app.getModel();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		//Set moves to be empty
		this.model.resetMoves();

		//reinit the level
		this.theLevel.initialize();

		//refresh the LevelView
		ContentPane.getCurrentLevelView().refresh();
		
	}
}