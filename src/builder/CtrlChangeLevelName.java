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
	ViewBuildLevel viewBuildLevel;

	CtrlChangeLevelName(ViewBuildLevel vbl, Level l){
		this.theLevel = l;
		this.viewBuildLevel = vbl;
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		viewBuildLevel.getPrompt().setText("");
		String newLevelName = "";
		String newLevelSeq = ((JTextField) actionEvent.getSource()).getText();
		if (newLevelSeq.length() == 1 && "12345".contains(newLevelSeq)){
			newLevelName = theLevel.getPartialFileName() + newLevelSeq;
			System.out.println("Changing name from "+ theLevel.getName() + " to " + newLevelName);
			theLevel.setName(newLevelName);
		}
		else{
			viewBuildLevel.getPrompt().setText("Enter 1, 2, 3, 4 or 5");
			viewBuildLevel.getPrompt().setVisible(true);
		}
	}
}
