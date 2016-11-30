package view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.Level;
import model.Model;

public class MenuView  extends JPanel implements IView{
	//decided to make it an arraylist because 
	//  the size could change due to custom levels
	ArrayList<LevelMenuView> lmv = new ArrayList<LevelMenuView>();
	public MenuView(Model currentGame){
		super();
		int numLevels = currentGame.getLevels().size();
		setLayout(new GridLayout(numLevels, 1, 0, 0));
		int seq = 0;
		this.setSize(900, 620); //TODO standardize
		for (Level l : currentGame.getLevels()){
			LevelMenuView thisLevelView = new LevelMenuView(seq, l);
			thisLevelView.setVisible(true);
			lmv.add(thisLevelView);
			this.add(thisLevelView);
			// lmv.add(new LevelMenuView(seq, l));
			// add(lmv.get(seq)); // for the layout
			seq++;
		}
		this.show();
		
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		this.setVisible(true);

	}
	@Override
	public void hide() {
		// TODO Auto-generated method stub
		this.setVisible(false);

	}

}
