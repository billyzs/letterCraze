package builder;
import common.model.Level;
import common.model.Model;
import common.model.PuzzleLevel;
import junit.framework.TestCase;

import java.util.ArrayList;

import static common.application.Application.loadLevel;

/**
 * Created by billyzs on 12/6/16.
 */
public class testCtrlCreateNewLevel extends TestCase{

	public void testCreatenewLevel(){
		try{
			Level testLevel = (PuzzleLevel)loadLevel("TestingLevel.lvl");
			ArrayList<Level> levels = new ArrayList<Level>();
			for(int k = 0; k < 15;k++)
				levels.add(testLevel);
			Model m = new Model(levels);
			AppBuilder app = new AppBuilder(m);
			CtrlCreateNewLevel c = new CtrlCreateNewLevel(app);
			Level l = c.createNewLevel("Puzzle");
			assertEquals("Puzzle", l.getType());
			assertTrue(l.getDict().isWord("good"));
			assertFalse(l.getDict().isWord("sldjflsag"));
		} catch(Exception e){
			e.printStackTrace();
			fail();
		}
	}
}
