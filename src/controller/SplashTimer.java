package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import application.Application;
import view.MenuView;
import view.WelcomeView;

public class SplashTimer implements ActionListener{

	WelcomeView welcome;
	MenuView menu;

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
