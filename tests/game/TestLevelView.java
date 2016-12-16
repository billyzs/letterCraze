package game;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import common.model.Level;
import common.model.Model;
import common.model.PuzzleLevel;
import common.view.ContentPane;

import static common.application.Application.loadLevel;

public class TestLevelView {

	@Test
	public void testLevelView(){
		try{
			
			ArrayList<Level> levels = AppGame.loadDefaultLevels();
			Model m = new Model(levels);
			AppGame app = new AppGame(m);
			assertTrue(app.getModel().getLevels().size() == 15); //check number of levels
            app.getMenu().show();
            
            //simulate button press
            app.getMenu().getLevelMenuViews().get(1).getButton().doClick();
            ContentPane.getCurrentLevelView().refresh();
            
            ContentPane.getCurrentLevelView().getLevel().addSubmittedWord("TEST");
            ContentPane.getCurrentLevelView().getSubmittedWordsView().refresh();

            assertTrue(app.getModel().getLevels().get(1).equals(ContentPane.getCurrentLevelView().getLevel()));

			
		} catch(Exception e){
			e.printStackTrace();
			fail();
		}
	}
}
