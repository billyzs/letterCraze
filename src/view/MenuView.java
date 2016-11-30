package view;

import java.util.ArrayList;

import javax.swing.JPanel;

import application.Application;
import controller.StartLevelController;
import model.Level;
import model.Model;
import java.awt.GridLayout;

public class MenuView  extends JPanel implements IView{
	//decided to make it an arraylist because 
	//  the size could change due to custom levels
	
	ArrayList<LevelMenuView> lmv;
	public MenuView(Application app){
		setLayout(new GridLayout(16, 1, 0, 0));
		int seq = 0;
		for (Level l : app.getModel().getLevels()){
			LevelMenuView thisLevelView = new LevelMenuView(seq, l, new StartLevelController(app));
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

	public ArrayList<LevelMenuView> getLevelMenuViews(){
		return this.lmv;
	}
	
	//returns the index for a particular levelmenuview
	public int getLevelIndex(LevelMenuView l){
		for(int k = 0; k < this.lmv.size(); k++){
			if(this.lmv.get(k) == l)
				return k;
		}
		return -1;
	}

}
