
package common.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import common.application.Application;
import common.model.IMove;
import common.model.Model;
import common.view.ContentPane;

/**
* <code>ActionListener</code> controller for undoing a move (usually the actions of another controller).
* @author Team Technetium
*/
public class UndoController implements ActionListener{
	Application app;
	Model model;
	
	/**
	 * @param a A letterCraze application.
	 */
	public UndoController(Application a){
		this.app = a;
		this.model = a.getModel();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		//undo a move
		IMove move = this.model.popMove();
		if(move != null){
            move.undo();
            //update tileviews
            ContentPane.getCurrentLevelView().refresh();
		}
	}
}
