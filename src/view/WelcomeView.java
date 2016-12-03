package view;

import javax.swing.JLabel;

import application.Application;
import controller.SplashTimer;

import java.awt.*;
import javax.swing.*;

public class WelcomeView extends Canvas implements IView {
	Application app;

	public WelcomeView(Application a){
        this.app = a;
	}

	public void paint(Graphics g){
        java.net.URL url = this.getClass().getResource("/images/gameSplash.png");
        //System.out.print(url.toString());
        Image i = java.awt.Toolkit.getDefaultToolkit().getImage(url);
        g.drawImage(i, 100, 0, this);
        //System.out.println(i.getWidth(this) + " " + i.getHeight(this));
	}

	@Override
	public void show() {
        this.app.getContentPane().add(this);
        //this.app.getContentPane().setSize(1473,1854);
        //this.app.getContentPane().setVisible(true);
		this.app.getContentPane().invalidate();
		this.app.getContentPane().validate();

        int delay = 2000;
        SplashTimer tp = new SplashTimer(this.app);
        Timer t =new Timer(delay, tp);
        t.setRepeats(false);
        t.start();
	}

	@Override
	public void hide() {
		this.app.getContentPane().remove(this);
		this.app.getContentPane().invalidate();
		this.app.getContentPane().validate();
	}

}