package builder;

import common.model.Level;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <code>ActionListener</code> controller that allows user to change a level's name when building it.
 * @author Created by billyzs on 12/8/16.
 */
public class CtrlChangeLevelName implements ActionListener {
	Level theLevel;

	CtrlChangeLevelName(Level l){
		this.theLevel = l;
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		String newLevelName = ((JTextField) actionEvent.getSource()).getText();
		System.out.println("Changing name from "+ theLevel.getName() + " to " + newLevelName);
		theLevel.setName(newLevelName);
	}
}
