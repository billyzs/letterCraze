package builder;

import common.model.PuzzleLevel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import common.model.Level;
/**
 * Created by billyzs on 12/13/16.
 */
public class CtrlModifyMaxWords implements ActionListener {

	Level level;

	public CtrlModifyMaxWords(Level pl){
		this.level = pl;
	}

	/**
	 * Set the new max word limit
	 * @param actionEvent
	 */
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		int newMaxWords = Integer.parseInt(((JTextField) actionEvent.getSource()).getText());
		((PuzzleLevel) level).setMaxWords(newMaxWords);
		System.out.println("Change max words to " + Integer.toString(newMaxWords));
	}
}
