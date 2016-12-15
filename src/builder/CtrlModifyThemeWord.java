package builder;

import common.model.ThemeLevel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by billyzs on 12/15/16.
 */
public class CtrlModifyThemeWord implements ActionListener {
	ThemeLevel themeLevel;
	public CtrlModifyThemeWord(ThemeLevel lvl) {
		themeLevel = lvl;
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		String oldTheme = themeLevel.getTheme();
		String newThemeword = ((JTextField) actionEvent.getSource()).getText();
		themeLevel.setTheme(newThemeword);
		System.out.println("Changed theme from " + oldTheme + " to " + newThemeword);
	}
}
