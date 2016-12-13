package builder;

import common.model.Level;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * <code>ActionListener</code> controller for setting or changing the name of a level being created in an <code>AppBuilder</code> object.
 * 
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
