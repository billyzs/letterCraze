package builder;
import common.view.MenuView;
import common.view.WelcomeView;

import java.awt.*;

/**
 * View of the welcome splash screen for the builder.
 * @author Created by billyzs on 11/30/16.
 */
public class ViewWelcome extends WelcomeView{
    String imagePath;
    public ViewWelcome(ViewMenu viewMenu){

        super(viewMenu);
        imagePath = "/images/builderSplashFixed.jpg";
    }
    /**
     * Obtains and draws the spash screen image, and then uses the java splash screen resource to proceed to next view.
     */
    public void paint(Graphics g){
        java.net.URL url = this.getClass().getResource("/images/builderSplashFixed.jpg");
        //System.out.print(url.toString());
        Image i = java.awt.Toolkit.getDefaultToolkit().getImage(url);
        g.drawImage(i, 0, 0, this);
        //System.out.println(i.getWidth(this) + " " + i.getHeight(this));
    }
}
