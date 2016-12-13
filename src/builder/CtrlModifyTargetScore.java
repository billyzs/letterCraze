package builder;

import common.model.Level;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by billyzs on 12/8/16.
 */
public class CtrlModifyTargetScore implements ActionListener {
	Level theLevel;
	public CtrlModifyTargetScore(Level l){
		theLevel = l;
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		int newTargetScore = Integer.parseInt(((JTextField) actionEvent.getSource()).getText());
		theLevel.setTargetScore(newTargetScore);
		System.out.println("Set new target score to " + Integer.toString(newTargetScore));
	}
}
