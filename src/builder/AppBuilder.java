package builder;
import common.application.Application;
import common.model.Level;
import common.model.Model;
import common.model.PuzzleLevel;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by billyzs on 11/30/16.
 */
public class AppBuilder extends Application{

    Model model;
    ViewMenu viewMenu;
    ViewWelcome welcome;
    ViewBuildLevel viewBuildLevel;
    CtrlSaveLevel ctrlSaveLevel;
    CtrlCreateNewLevel ctrlCreateNewLevel;

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
        //TODO move to initializer function
        viewMenu = new ViewMenu(m);
        welcome = new ViewWelcome(viewMenu);
        initializeControllers();
    }

    /**
     * Model only needs a currentLevel for builder
     * TODO does builder need undo & redo???
     */
    private void initializeModel(){

    }
    private void initializeControllers(){
        ctrlCreateNewLevel = new CtrlCreateNewLevel(this);
        // viewMenu.boxCreateNewLevel.addActionListener(ctrlCreateNewLevel);
    }

    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {

                    Level testLevel = (PuzzleLevel)loadLevel("TestingLevel.lvl");
                    ArrayList<Level> levels = new ArrayList<Level>();

                    for(int k = 0; k < 15;k++)
                        levels.add(testLevel);

                    AppBuilder frame = new AppBuilder(new Model(levels));

                    frame.welcome.show();
                    frame.setVisible(true);
                    frame.initializeControllers();

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

    public CtrlCreateNewLevel getCtrlCreateNewLevel() {
        return ctrlCreateNewLevel;
    }

    public void setCtrlCreateNewLevel(CtrlCreateNewLevel ctrlCreateNewLevel) {
        this.ctrlCreateNewLevel = ctrlCreateNewLevel;
    }

}
