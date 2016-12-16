package builder;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.Test;

import common.application.Application;
import common.model.Level;
import common.model.Model;
import common.model.PuzzleLevel;
import common.view.LevelMenuView;

public class TestCtrlSaveLevel {

    
    @Test
    public void testPuzzle() throws Exception {
    	AppBuilder ab = new AppBuilder(new Model(Application.loadDefaultLevels()));

    	//load a level, save it, reload, and test that it was reloaded properly
        PuzzleLevel level1 = (PuzzleLevel) Application.loadLevel("Puzzle_Level_1.lvl");
        CtrlSaveLevel csl = new CtrlSaveLevel(new CtrlModifyLevel(ab, new LevelMenuView(15, level1)),level1);
        csl.saveLevelToFile(level1, "");

        PuzzleLevel level2 = (PuzzleLevel) Application.loadLevel("Puzzle_Level_Test.lvl");
        assertEquals(36, level1.getBoard().countActiveTiles());
    }

}
