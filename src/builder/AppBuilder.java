package builder;
import common.application.Application;
import common.model.*;
import common.view.LevelMenuView;
import common.view.MenuView;

import java.awt.*;
import java.util.ArrayList;

/** Main class for the Builder app. Handles the initial loading of levels and displaying of level
 * Created by billyzs on 11/30/16.
 */
public class AppBuilder extends Application{

    ViewMenu viewMenu;
    ViewWelcome welcome;
    ViewBuildLevel viewBuildLevel;
    CtrlSaveLevel ctrlSaveLevel;
    ArrayList<CtrlModifyLevel> ctrModifyLevels = new ArrayList<CtrlModifyLevel>();

    public ArrayList<CtrlModifyLevel> getCtrModifyLevels() {
        return ctrModifyLevels;
    }

    public void setCtrModifyLevels(ArrayList<CtrlModifyLevel> ctrModifyLevels) {
        this.ctrModifyLevels = ctrModifyLevels;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void setViewMenu(ViewMenu viewMenu) {
        this.viewMenu = viewMenu;
    }

    public void setWelcome(ViewWelcome welcome) {
        this.welcome = welcome;
    }

    public AppBuilder(Model m){
        super(m);

        viewMenu = new ViewMenu(m);
        welcome = new ViewWelcome(viewMenu);
        initializeModel();
        initializeControllers();
    }

    /**
     * Model only needs a currentLevel for builder
     * TODO Once we have a folder with levels, load the levels into model here
     */
    private void initializeModel(){

    }

    private void initializeControllers(){
        int i = 0;
        System.out.println(this.viewMenu.getLevelMenuViews().size());
        for(LevelMenuView lmv : this.viewMenu.getLevelMenuViews()){
            CtrlModifyLevel c = new CtrlModifyLevel(this, lmv);
            // System.out.println(lmv.getTheLevel().getType());
            this.ctrModifyLevels.add(c);
            lmv.getButton().addActionListener(this.ctrModifyLevels.get(i++));

        }
        // viewMenu.boxCreateNewLevel.addActionListener(ctrlModifyLevel);
    }

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // TODO move to initializeModel()
                    Level testLevel = (PuzzleLevel) loadLevel("Puzzle_Level_1.lvl");
                    ArrayList<Level> levels = new ArrayList<Level>(18);

                    for (int k = 0; k < 15; k++)
                        levels.add(testLevel);

                    Model builderModel = new Model(levels);
					builderModel.addLevel(builderModel.createNewLevel(builderModel.Puzzle));
					builderModel.addLevel(builderModel.createNewLevel(builderModel.Lightning));
					builderModel.addLevel(builderModel.createNewLevel(builderModel.Theme));

					/*//need to set all letters to "";
					for(Level l : builderModel.getLevels()){
						for(ArrayList<Tile> row : l.getBoard().getTiles()){
							for(Tile t : row){
								t.setLetters("");
							}
						}
					}
					*/

                    AppBuilder frame = new AppBuilder(builderModel);

                    // ViewBuildLevel vbl = new ViewBuildLevel(builderModel.getLevels().get(17));
                    frame.welcome.show();
                    frame.setVisible(true);
                    //frame.initializeControllers();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public Model getModel() {
        return model;
    }

    public ViewMenu getViewMenu() {
        return viewMenu;
    }

    @Override
    public ViewWelcome getWelcome() {
        return welcome;
    }

    public ViewBuildLevel getViewBuildLevel() {
        return viewBuildLevel;
    }

    public void setViewBuildLevel(ViewBuildLevel viewBuildLevel) {
        this.viewBuildLevel = viewBuildLevel;
    }

    public CtrlSaveLevel getCtrlSaveLevel() {
        return ctrlSaveLevel;
    }

    public void setCtrlSaveLevel(CtrlSaveLevel ctrlSaveLevel) {
        this.ctrlSaveLevel = ctrlSaveLevel;
    }

    @Override
    public ViewMenu getMenu() {
        return this.viewMenu;
    }
}
