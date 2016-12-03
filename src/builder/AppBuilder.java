package builder;
import common.application.Application;
import common.model.Level;
import common.model.Model;
import common.model.PuzzleLevel;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by billyzs on 11/30/16.
 */
public class AppBuilder extends Application{
    @Override
    public Model getModel() {
        return model;
    }

    public ViewMenu getViewMenu() {
        return viewMenu;
    }

    @Override
    public ViewWelcome getWelcome() {
        return welcome;
    }

    Model model;
    ViewMenu viewMenu;
    ViewWelcome welcome;

    public AppBuilder(Model m){
        super(m);
        viewMenu = new ViewMenu(m);
        welcome = new ViewWelcome(viewMenu);
    }


    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    Level testLevel = (PuzzleLevel)loadLevel("TestingLevel.lvl");
                    ArrayList<Level> levels = new ArrayList<Level>();

                    for(int k = 0; k < 15;k++)
                        levels.add(testLevel);

                    AppBuilder frame = new AppBuilder(new Model(levels));

                    frame.welcome.show();
                    frame.setVisible(true);

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        });
    }

}
