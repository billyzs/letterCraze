package builder;

import common.model.Model;
import common.view.LevelMenuView;
import common.view.MenuView;
/**
 * Created by billyzs on 11/30/16.
 */
public class ViewBuilderMenu extends MenuView{
    public ViewBuilderMenu(Model m){
        super(m);
        //TODO stars, locks, previous high scores shouldn't be needed.
        for(LevelMenuView lmv : this.getLevelMenuViews()){
            lmv.getLabelHighScore().setVisible(false);
        }
        //TODO Add a new button for creating a new Level
    }
}
