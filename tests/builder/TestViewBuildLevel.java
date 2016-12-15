package builder;

import static common.application.Application.loadLevel;
import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import common.model.Level;
import common.model.PuzzleLevel;
import common.view.LevelMenuView;

public class TestViewBuildLevel {

	@Test
	public void testConstruct() {
		Level l;
		try {
			l = (PuzzleLevel)loadLevel("Puzzle_Level_1.lvl");
			LevelMenuView lmv = new LevelMenuView(0, l);
			ViewBuildLevel vbl = new ViewBuildLevel(lmv);
			assertTrue(vbl != null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
