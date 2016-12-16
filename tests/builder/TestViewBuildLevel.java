package builder;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;

import org.junit.Test;

import builder.ChooseTileController;
import common.application.Application;
import common.model.Board;
import common.model.Model;
import common.model.NullTile;
import common.model.Tile;
import common.view.ContentPane;
import common.view.LevelMenuView;
import common.view.TileView;


public class TestViewBuildLevel {
	
	@Test
	public void testViewBuildLevel(){
		try {
			ViewBuildLevel vbl = new ViewBuildLevel(new LevelMenuView(25, Application.loadLevel("Lightning_Level_Test.lvl")));
			vbl.setJtfMaxWords(null);
            AppBuilder builder = new AppBuilder(new Model(Application.loadDefaultLevels()));
            
            //select the first puzzle level and load it
            builder.getMenu().getLevelMenuViews().get(0).getButton().doClick();
            ContentPane.getCurrentLevelView().refresh();
            
            //ensure the proper level was loaded
            assertTrue(ContentPane.getCurrentLevelView().getLevel().equals(builder.getModel().getLevels().get(0)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testViewBuildLevelTheme(){
		AppBuilder builder = new AppBuilder(new Model(Application.loadDefaultLevels()));
		
		//select the first lightning level and load it
		builder.getMenu().getLevelMenuViews().get(2).getButton().doClick();
		ContentPane.getCurrentLevelView().refresh();
		
		//ensure the proper level was loaded
		assertTrue(ContentPane.getCurrentLevelView().getLevel().equals(builder.getModel().getLevels().get(2)));
	}
}
