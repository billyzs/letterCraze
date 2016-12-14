package game;

import common.application.Application;
import common.controller.StartLevelController;
import common.model.Level;
import common.model.LightningLevel;
import common.model.Model;
import common.model.PuzzleLevel;
import common.view.LevelMenuView;
import common.view.LevelView;
import common.view.MenuView;
import common.view.WelcomeView;
import common.controller.*;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.Timer;

/**
 * The letterCraze game subclass of <code>Application</code>.
 * @author Grant Espe
 */
public class AppGame extends Application{

	/**
	 * The default constructor which takes all entity objects in the <code>Model</code> container.
	 * @param m The Model
	 */
    public AppGame(Model m) {
		super(m);
		this.menu = new MenuView(m);
		this.welcome = new WelcomeView(this.menu);

		//initialize controllers for levelviewbuttons
		int seq = 0;
		for(LevelMenuView almv : menu.getLevelMenuViews()){
            almv.getButton().addActionListener(new StartLevelController(this, this.model.getLevels().get(seq)));
            seq++;
		}
	}

    //Not yet used
    public void initializeControllers(){
    }

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

                    //Level testLevel = (PuzzleLevel)loadLevel("Puzzle_Level_1.lvl");
                    ArrayList<Level> levels = loadDefaultLevels();//new ArrayList<Level>();
                    ArrayList<Level> customs = loadOtherLevels();
                   
                    //Add customs to levels
                    levels.addAll(customs);
                     
                    /*
                     * for(int k = 0; k < 15;k++)
                        levels.add(testLevel);
                        */

					AppGame frame = new AppGame(new Model(levels));

                    frame.getWelcome().show();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}
	
}
