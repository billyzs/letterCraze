package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import application.Application;
import view.WelcomeView;

public class SplashTimer implements ActionListener{

	Application app;
	public SplashTimer(Application a){
		this.app = a;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.app.getWelcome().hide();
		this.app.getMenu().show();
	}

}
