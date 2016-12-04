package builder;

import common.model.Model;
import common.view.LevelMenuView;
import common.view.MenuView;

import javax.swing.*;
import java.awt.*;

/**
 * Created by billyzs on 11/30/16.
 */
public class ViewMenu extends MenuView{
    JComboBox boxCreateNewLevel;
    public ViewMenu(Model m){
        super(m);
        //TODO stars, locks, previous high scores shouldn't be needed.
        for(LevelMenuView lmv : this.getLevelMenuViews()){
            lmv.getLabelHighScore().setVisible(false);
            lmv.getLabelLocked().setVisible(false);
            lmv.getLabelStar().setVisible(false);
            //TODO add controller for buttons in lmv
        }

        int numLevels = m.getLevels().size();
        setLayout(new GridLayout(numLevels+1, 1, 0, 0));
        boxCreateNewLevel = new JComboBox(new DefaultComboBoxModel(new String[] {"Puzzle", "Lightening", "Theme"}));
        add(boxCreateNewLevel);
        boxCreateNewLevel.setVisible(true);
        //TODO Controller for this action

    }
}
