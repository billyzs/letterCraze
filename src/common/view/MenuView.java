package common.view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import common.model.Level;
import common.model.Model;

/**
 * <code>JPanel</code> object to show the main menu of letterCraze.
 * @author Grant Espe
 * @author Santiago Sade de la Paz
 */
public class MenuView  extends JPanel implements IView {
	//decided to make it an arraylist because 
	//  the size could change due to custom levels
	
	ArrayList<LevelMenuView> lmv;
	Model currentGame;

	/**
	 * Default constructor.
	 * @param m
	 */
	public MenuView(Model m){
		super();

		currentGame = m;
        lmv = new ArrayList<LevelMenuView>();

		int numLevels = currentGame.getLevels().size();

		setLayout(new GridLayout(numLevels, 1, 0, 0));
		int seq = 0;

		this.setSize(900, 620); //TODO standardize
		for (Level l : currentGame.getLevels()){
			LevelMenuView thisLevelView = new LevelMenuView(seq, l);
			lmv.add(thisLevelView);
			this.add(thisLevelView);

			// lmv.add(new LevelMenuView(seq, l));
			// add(lmv.get(seq)); // for the layout
			seq++;
		}
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		ContentPane.get().add(this);
		ContentPane.get().invalidate();
		ContentPane.get().validate();
		
		for (LevelMenuView l : lmv){
			l.refresh();
		}
		
	}

	@Override
	public void hide() {
		// todo auto-generated method stub
		ContentPane.get().remove(this);
		ContentPane.get().invalidate();
		ContentPane.get().validate();
	}

	public ArrayList<LevelMenuView> getLevelMenuViews(){
		return this.lmv;
	}

}
