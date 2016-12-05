package common.model;

import java.util.ArrayList;
import java.util.Stack;

public class Model {
	Stack<IMove> moves;
	ArrayList<Level> levels;
	Level currentLevel;
	
	public Model(ArrayList<Level> l){
		this.levels = l;
	}
	
	public void setLevel(Level l){ this.currentLevel = l; }
	public ArrayList<Level> getLevels(){return levels;}

	public Level getCurrentLevel() {
		return this.currentLevel;
	}

	//adds a move to the list
	public void addMove(IMove move) {
		moves.add(move);
	}
	
	//returns a move and removes it from the list of moves
	public IMove popMove(){
		if(moves.size() > 0)
            return moves.pop();
		return null;
	}

	//reinit the move array, for starting new levels w]]]
	public void resetMoves() {
		this.moves = new Stack<IMove>();
	}

}

