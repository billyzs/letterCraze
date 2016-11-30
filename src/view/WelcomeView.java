package view;

import javax.swing.JLabel;

import application.Application;

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
        g.drawImage(i, 0, 0, this);
        //System.out.println(i.getWidth(this) + " " + i.getHeight(this));
	}

	@Override
	public void show() {
        this.app.getContentPane().add(this);
        //this.app.getContentPane().setSize(1473,1854);
        //this.app.getContentPane().setVisible(true);
		this.app.getContentPane().invalidate();
		this.app.getContentPane().validate();
	}

	@Override
	public void hide() {
		this.app.getContentPane().remove(this);
		this.app.getContentPane().invalidate();
		this.app.getContentPane().validate();
	}

}