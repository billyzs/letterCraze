package builder;
import common.application.Application;
import common.model.*;
import common.view.LevelMenuView;
import common.view.MenuView;

import java.awt.*;
import java.util.ArrayList;

/** Main class for the Builder app. Handles the initial loading and displaying of levels.
 * 
 * @author Created by billyzs on 11/30/16.
 */
public class AppBuilder extends Application{

	/**
	 * Attributes of the builder.
	 */
    ViewMenu viewMenu;
    ViewWelcome welcome;
    ViewBuildLevel viewBuildLevel;
    CtrlSaveLevel ctrlSaveLevel;
    ArrayList<CtrlModifyLevel> ctrModifyLevels = new ArrayList<CtrlModifyLevel>();

    /** Get the <code>CtrlModifyLevel</code> objects of this builder.
     * @return <code>ArrayList</code> of all <code>CtrlModifyLevel</code> controllers in this builder.
     */
    public ArrayList<CtrlModifyLevel> getCtrModifyLevels() {
        return ctrModifyLevels;
    }

    /**
     * Set <code>CtrlModifyLevel</code> controllers of this builder.
     * @param ctrModifyLevels
     */
    public void setCtrModifyLevels(ArrayList<CtrlModifyLevel> ctrModifyLevels) {
        this.ctrModifyLevels = ctrModifyLevels;
    }
    
    /**
     * Set the <code>Model</code> object of this builder.
     * @param ctrModifyLevels
     */
    public void setModel(Model model) {
        this.model = model;
    }

    /**
     * Set the <code>ViewMenu</code> object of this builder.
     * @param viewMenu
     */
    public void setViewMenu(ViewMenu viewMenu) {
        this.viewMenu = viewMenu;
    }

    /**
     * Set the <code>ViewWelcome</code> object of this builder.
     * @param welcome
     */
    public void setWelcome(ViewWelcome welcome) {
        this.welcome = welcome;
    }

    /**
     * Default constructor for <code>AppBuilder</code> object which takes in the various entity objects 
     * that are contained in a <code>Model</code> object.
     * 
     * @param m The <Model> object.
     */
    public AppBuilder(Model m){
        super(m);

        viewMenu = new ViewMenu(m);
        welcome = new ViewWelcome(viewMenu);
        initializeModel();
        initializeControllers();
    }

    /**
     * Model only needs a currentLevel for builder.
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

    /** Launches the <code>AppBuilder</code>.
     * 
     * @param args
     */
    public static void main(String[] args){
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // TODO move to initializeModel()
                    //Level testLevel = (PuzzleLevel) loadLevel("Puzzle_Level_1.lvl");
                    ArrayList<Level> levels = loadDefaultLevels();//new ArrayList<Level>(18);
                    
                    //for (int k = 0; k < 15; k++)
                     //   levels.add(testLevel);

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

    /** Get the <code>ViewMenu</code> object of this builder.
     * @return <code>ViewMenu</code> object of this builder.
     */
    public ViewMenu getViewMenu() {
        return viewMenu;
    }

    @Override
    public ViewWelcome getWelcome() {
        return welcome;
    }

    /** Get the <code>ViewBuildLevel</code> object of this builder.
     * @return <code>ViewBuildLevel</code> object of this builder.
     */
    public ViewBuildLevel getViewBuildLevel() {
        return viewBuildLevel;
    }

    /**
     * Set the <code>ViewBuildLevel</code> object of this builder.
     * @param viewBuildLevel
     */
    public void setViewBuildLevel(ViewBuildLevel viewBuildLevel) {
        this.viewBuildLevel = viewBuildLevel;
    }

    /** Get the <code>CtrlSaveLevel</code> object of this builder.
     * @return <code>CtrlSaveLevel</code> object of this builder.
     */
    public CtrlSaveLevel getCtrlSaveLevel() {
        return ctrlSaveLevel;
    }

    /**
     * Set the <code>CtrlSaveLevel</code> object of this builder.
     * @param ctrSaveLevel
     */
    public void setCtrlSaveLevel(CtrlSaveLevel ctrlSaveLevel) {
        this.ctrlSaveLevel = ctrlSaveLevel;
    }

    @Override
    public ViewMenu getMenu() {
        return this.viewMenu;
    }
}
