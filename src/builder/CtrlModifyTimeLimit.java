package builder;

import common.model.Level;
import common.model.LightningLevel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/** Controller for modifying the time limit for Lightning Levels
 * Created by billyzs on 12/13/16.
 */
public class CtrlModifyTimeLimit implements ActionListener{
	Level theLevel;
	public CtrlModifyTimeLimit(Level l){
		this.theLevel = l;
	}

	/**
	 * Gets the new limit in seconds
	 * @param actionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		int newTimeLimit = Integer.parseInt(((JTextField) actionEvent.getSource()).getText());
		((LightningLevel) theLevel).setTimerSeconds(newTimeLimit);
		System.out.println("change timer limit to " + Integer.toString(newTimeLimit));
	}
}
