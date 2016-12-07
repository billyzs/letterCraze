package builder;

import common.model.Model;
import common.model.PuzzleLevel;
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
    JButton btnPuzzle;
    JButton btnLightening;
    JButton btnTheme;

    public JButton getBtnPuzzle() {
        return btnPuzzle;
    }

    public void setBtnPuzzle(JButton btnPuzzle) {
        this.btnPuzzle = btnPuzzle;
    }

    public JButton getBtnLightening() {
        return btnLightening;
    }

    public void setBtnLightening(JButton btnLightening) {
        this.btnLightening = btnLightening;
    }

    public JButton getBtnTheme() {
        return btnTheme;
    }

    public void setBtnTheme(JButton btnTheme) {
        this.btnTheme = btnTheme;
    }

    public ViewMenu(Model m){
        // PuzzleLevel puzzleLevel = m.
        super(m);
        //TODO stars, locks, previous high scores shouldn't be needed.
        for(LevelMenuView lmv : this.getLevelMenuViews()){
            lmv.getLabelHighScore().setVisible(false);
            lmv.getLabelLocked().setVisible(false);
            lmv.getLabelStar().setVisible(false);
            lmv.getButton().setText("Modify "+ lmv.getTheLevel().getName());
            //TODO add controller for buttons in lmv
        }

        int numLevels = m.getLevels().size();
        setLayout(new GridLayout(numLevels+3, 1, 0, 0)); // +3 because of the 3 new buttons



        //TODO Controller for this action

    }

}
