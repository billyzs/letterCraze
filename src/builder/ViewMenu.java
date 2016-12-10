package builder;

import common.model.LightningLevel;
import common.model.Model;
import common.model.PuzzleLevel;
import common.model.ThemeLevel;
import common.view.ContentPane;
import common.view.IView;
import common.view.LevelMenuView;
import common.view.MenuView;

import javax.swing.*;
import java.awt.*;

/**
 * Created by billyzs on 11/30/16.
 */
public class ViewMenu extends MenuView implements IView{
    //JComboBox boxCreateNewLevel;


    public ViewMenu(Model m){

        super(m);

        //TODO stars, locks, previous high scores shouldn't be needed.
        for(LevelMenuView lmv : this.getLevelMenuViews()){
            lmv.getLabelHighScore().setVisible(false);
            //lmv.getLabelLocked().setVisible(false);
            lmv.getLabelStar().setVisible(false);
            String btnString = "";
            if(lmv.getTheLevel().getName() != ""){
                btnString = "Modify " + lmv.getTheLevel().getName();
            }
            else{ // is an empty new level
                btnString = "Create a new " + lmv.getTheLevel().getType() + " level";
            }
            lmv.getButton().setText(btnString);
            lmv.getButton().setEnabled(true); // should be able to edit a locked level
            lmv.getLblTitle().setVisible(false); //upstream introduced unwanted changes AGAIN
            //TODO add controller for buttons in lmv

        }

        int numLevels = m.getLevels().size();
        setLayout(new GridLayout(numLevels, 1, 0, 0)); // +3 because of the 3 new buttons



        //TODO Controller for this action

    }

    @Override
    public void show() {
        System.out.println("Showing ViewMenu");

        ContentPane.get().add(this);
        ContentPane.get().invalidate();
        ContentPane.get().validate();
    }

    @Override
    public void hide() {
        ContentPane.get().remove(this);
        // setVisible(false);
        ContentPane.get().invalidate();
        ContentPane.get().validate();
    }
}
