package view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

import application.Application;
import controller.StartLevelController;
import model.Level;
import model.Model;

public class MenuView  extends JPanel implements IView{
	//decided to make it an arraylist because 
	//  the size could change due to custom levels
	
	ArrayList<LevelMenuView> lmv;
	Application app;

	public MenuView(Application a){
		super();

		this.app = a;
        ArrayList<LevelMenuView> lmv = new ArrayList<LevelMenuView>();

		Model currentGame =this.app.getModel();
		int numLevels = currentGame.getLevels().size();

		setLayout(new GridLayout(numLevels, 1, 0, 0));
		int seq = 0;

		this.setSize(900, 620); //TODO standardize
		for (Level l : currentGame.getLevels()){
			LevelMenuView thisLevelView = new LevelMenuView(seq, l, new StartLevelController(app, l));
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
		this.app.getContentPane().add(this);
		this.app.getContentPane().invalidate();
		this.app.getContentPane().validate();
	}

	@Override
	public void hide() {
		// todo auto-generated method stub
		this.app.getContentPane().remove(this);
		this.app.getContentPane().invalidate();
		this.app.getContentPane().validate();
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
