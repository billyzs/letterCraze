package common.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import common.view.MenuView;
import common.view.WelcomeView;

/**
* <code>ActionListener</code> controller for timing the splash screen introduction to a letterCraze application.
* @author Team Technetium
*/
public class SplashTimer implements ActionListener{

	WelcomeView welcome;
	MenuView menu;

	/**
	 * @param wv A WelcomeView object.
	 * @param mv A MenuView object.
	 */
	public SplashTimer(WelcomeView wv, MenuView mv){
		welcome = wv;
		menu = mv;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		welcome.hide();
		menu.show();
	}

}
