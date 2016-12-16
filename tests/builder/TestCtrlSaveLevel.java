package builder;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.Test;

import common.application.Application;
import common.model.Level;

public class TestCtrlSaveLevel {

	// load a level into buffer1 from disk, create level1;
    // save level to disk; read saved file into buffer2, create level2
    // buffer1 == buffer2?
    // level1 == level2?
	
    public void doTest(String inFileName) throws Exception{
        Application app = new Application();
        String testFile = inFileName;
        String outputFile = "reference.lvl";
        Level level1 = app.loadLevel(testFile);
        CtrlSaveLevel csl = new CtrlSaveLevel(null, level1);
        csl.saveLevelToFile(level1, outputFile);
        Level level2 = app.loadLevel(outputFile);
        // lvl 1 == lvl2??
        assertEquals(level1.getName(), level2.getName());
        assertEquals(level1.getType(), level2.getType());
        assertEquals(level1.getHighscore(), level2.getHighscore());
        assertEquals(36, level1.getBoard().countActiveTiles());


        BufferedReader buffer1 = new BufferedReader(new FileReader(testFile));
        BufferedReader buffer2 = new BufferedReader(new FileReader(outputFile));
        String line1;
        int lineNum = 0;
        while((line1=buffer1.readLine()) != null && lineNum < 13){ // don't need to check the dict
            lineNum++;
            String line2 = buffer2.readLine();
            assertEquals(line1, line2);
        }
    }
    @Test
    public void testPuzzle() throws Exception {
        doTest("Puzzle_Level_Test.lvl");
    }
    /*
    public void testTheme() throws Exception{
        test("Theme_Level1.lvl");
        Application app = new Application();
        String testFile = "TestingTheme.lvl";
        String outputFile = "reference.lvl";
        Level level1 = app.loadLevel(testFile);
        Level level2 = app.loadLevel(outputFile);
        Iterator<String> iter = level1.getDict().getTable().iterator();
        while(iter.hasNext()){
            assertTrue(level2.getDict().isWord(iter.next()));
        }

    }
    */

}
