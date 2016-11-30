package view;

import java.util.ArrayList;

public class MenuView implements IView {
	//decided to make it an arraylist because 
	//  the size could change due to custom levels
	ArrayList<LevelMenuView> levels;
	
	@Override
	public void show() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	public ArrayList<LevelMenuView> getLevelMenuViews(){
		return this.levels;
	}
	
	//returns the index for a particular levelmenuview
	public int getLevelIndex(LevelMenuView lmv){
		for(int k = 0; k < this.levels.size(); k++){
			if(this.levels.get(k) == lmv)
				return k;
		}
		return -1;
	}

}
