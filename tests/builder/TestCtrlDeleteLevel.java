package builder;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.swing.JButton;

import org.junit.Test;

import common.application.Application;
import common.model.Level;
import common.model.Model;
import common.model.PuzzleLevel;
import common.view.LevelMenuView;

public class TestCtrlDeleteLevel {

	@Test
	public void testCtrlDeleteLevel() {
		try {
            ArrayList<Level> levels = Application.loadDefaultLevels();//new ArrayList<Level>(18);
            ArrayList<Level> customs = Application.loadOtherLevels();
            levels.addAll(customs);

            Model builderModel = new Model(levels);

            AppBuilder app = new AppBuilder(builderModel);
            PuzzleLevel testLevel = (PuzzleLevel)builderModel.getLevels().get(0);
            
            testLevel.setName("LEVELTODELETE");
            testLevel.save(testLevel.getName());
            
            JButton b = new JButton();
            CtrlDeleteLevel c = new CtrlDeleteLevel(app, new ViewBuildLevel(new LevelMenuView(20, testLevel)));
            b.addActionListener(c);
            b.doClick();

		} catch (Exception e) {
		e.printStackTrace();
		}
	}
}
