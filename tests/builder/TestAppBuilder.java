package builder;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import common.application.Application;
import common.model.Level;
import common.model.Model;

public class TestAppBuilder {

	@Test
	public void testMain() {
		try {
            // TODO move to initializeModel()
            //Level testLevel = (PuzzleLevel) loadLevel("Puzzle_Level_1.lvl");
            ArrayList<Level> levels = Application.loadDefaultLevels();//new ArrayList<Level>(18);
            ArrayList<Level> customs = Application.loadOtherLevels();
            levels.addAll(customs);
            
            //for (int k = 0; k < 15; k++)
             //   levels.add(testLevel);

            Model builderModel = new Model(levels);
			builderModel.addLevel(builderModel.createNewLevel(builderModel.Puzzle));
			builderModel.addLevel(builderModel.createNewLevel(builderModel.Lightning));
			builderModel.addLevel(builderModel.createNewLevel(builderModel.Theme));

			/*//need to set all letters to "";
			for(Level l : builderModel.getLevels()){
				for(ArrayList<Tile> row : l.getBoard().getTiles()){
					for(Tile t : row){
						t.setLetters("");
					}
				}
			}
			*/

            AppBuilder frame = new AppBuilder(builderModel);

            // ViewBuildLevel vbl = new ViewBuildLevel(builderModel.getLevels().get(17));
            frame.welcome.show();
            frame.setVisible(true);
            

			assertTrue(frame.isVisible());
			assertTrue(levels.size() >= 15);
		
		} catch (Exception e) {
		e.printStackTrace();
		}
	}

}
