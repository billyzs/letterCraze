package builder;
import common.view.MenuView;
import common.view.WelcomeView;

import java.awt.*;

/**
 * Created by billyzs on 11/30/16.
 */
public class ViewWelcome extends WelcomeView{
    String imagePath;
    public ViewWelcome(ViewMenu viewMenu){

        super(viewMenu);
        imagePath = "/images/builderSplash.png";
    }
    //TODO ask grant why we need this
    public void paint(Graphics g){
        java.net.URL url = this.getClass().getResource("/images/builderSplash.png");
        //System.out.print(url.toString());
        Image i = java.awt.Toolkit.getDefaultToolkit().getImage(url);
        g.drawImage(i, 100, 0, this);
        //System.out.println(i.getWidth(this) + " " + i.getHeight(this));
    }
}
