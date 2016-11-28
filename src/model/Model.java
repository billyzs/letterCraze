package model;

import java.util.Stack;

public class Model {
	Stack<IMove> moves;
	Level[] levels;
	
	public Model(Level[] l){
		this.levels = l;
		
	}
}
