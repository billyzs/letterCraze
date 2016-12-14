package common.view;

import common.controller.SplashTimer;

import java.awt.*;
import javax.swing.*;

/**
 * <code>Canvas</code> object to show the Welcome Splash Screen.
 * @author Grant Espe
 * @author Santiago Sade de la Paz
 */
public class WelcomeView extends Canvas implements IView {

	MenuView menu;
	public WelcomeView(MenuView mv){
		menu = mv;
	}

	/**
	 * Display splash screen image.
	 */
	public void paint(Graphics g){
        java.net.URL url = this.getClass().getResource("/images/gameSplashFixed.jpg");
        //System.out.print(url.toString());
        Image i = java.awt.Toolkit.getDefaultToolkit().getImage(url);
        g.drawImage(i, 0, 0, this);
        //System.out.println(i.getWidth(this) + " " + i.getHeight(this));
	}

	@Override
	public void show() {
        //this.app.getContentPane().add(this);
		ContentPane.get().add(this);
        //this.app.getContentPane().setSize(1473,1854);
        //this.app.getContentPane().setVisible(true);
		ContentPane.get().invalidate();
		ContentPane.get().validate();

        int delay = 2000;
        //Pass the menu to the timer common.controller
        SplashTimer tp = new SplashTimer(this, menu);
        Timer t =new Timer(delay, tp);
        t.setRepeats(false);
        t.start();
	}

	@Override
	public void hide() {
		ContentPane.get().remove(this);
		ContentPane.get().invalidate();
		ContentPane.get().validate();
	}

}