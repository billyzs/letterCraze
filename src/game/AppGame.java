package game;

import common.application.Application;
import common.controller.StartLevelController;
import common.model.Level;
import common.model.Model;
import common.model.PuzzleLevel;
import common.view.LevelMenuView;
import common.view.LevelView;
import common.view.MenuView;
import common.view.WelcomeView;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by gtespe on 02/12/16.
 */
public class AppGame extends Application{

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

                    Level testLevel = (PuzzleLevel)loadLevel("TestingLevel.lvl");
                    ArrayList<Level> levels = new ArrayList<Level>();
                     
                    for(int k = 0; k < 15;k++)
                        levels.add(testLevel);

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
