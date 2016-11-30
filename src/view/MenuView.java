package view;

import java.util.ArrayList;

import javax.swing.JPanel;

import model.Level;
import model.Model;
import java.awt.GridLayout;

public class MenuView  extends JPanel implements IView{
	//decided to make it an arraylist because 
	//  the size could change due to custom levels
	ArrayList<LevelMenuView> lmv;
	public MenuView(Model currentGame){
		setLayout(new GridLayout(16, 1, 0, 0));
		int seq = 0;
		for (Level l : currentGame.getLevels()){
			LevelMenuView thisLevelView = new LevelMenuView(seq, l);
			lmv.add(thisLevelView);
			add(thisLevelView); // for the layout
			seq++;
		}
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
