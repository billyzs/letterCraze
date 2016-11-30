package model;

import java.util.ArrayList;
import java.util.Stack;

public class Model {
	Stack<IMove> moves;
	ArrayList<Level> levels;
	Level currentLevel;
	
	public Model(ArrayList<Level> l){
		this.levels = l;
	}
	public ArrayList<Level> getLevels(){return levels;}
}
