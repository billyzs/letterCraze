package common.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.IllegalFormatCodePointException;
import java.util.Stack;

/**
 * Top-level container for all letterCraze entity objects.
 * @author Grant Espe
 *
 */
public class Model {
	Stack<IMove> moves;
	ArrayList<Level> levels;
	Level currentLevel;

	public static final String Puzzle = "Puzzle";
	public static final String Theme = "Theme";
	public static final String Lightning = "Lightning";

	/**
	 * @param l An ArrayList of levels.
	 */
	public Model(ArrayList<Level> l){
		this.levels = l;
		this.moves = new Stack<IMove>();
	}

	public Model() {
		this.moves = new Stack<IMove>();
	}

	public void setLevel(Level l){ this.currentLevel = l; }

	public ArrayList<Level> getLevels(){return levels;}

	public Level getCurrentLevel() {
		return this.currentLevel;
	}

	/**
	 * Adds a move to the list of moves.
	 * @param move
	 */
	public void addMove(IMove move) {
		moves.add(move);
	}
	
	/**
	 * Remove all moves.
	 */
	public void resetMoves(){
		for(int k = this.moves.size()-1; k >= 0; k--)
			this.moves.remove(k);
	}
	
	/**
	 * Returns a move and removes it from the list of moves.
	 * @return A move.
	 */
	public IMove popMove(){
		if(moves.size() > 0)
            return moves.pop();
		return null;
	}

	//reinit the move array, for starting new levels w]]]
//public void resetMoves() { this.moves = new Stack<IMove>(); }

	public void addLevel(Level l){this.levels.add(l);}
	
	/**
	 * Creates new level based on type.
	 * @param levelType one of "Puzzle", "Lightning", "Theme"
	 * @return a new level with empty 6*6 board, name, starval, highscore, unlocked=false, dict = default for lightning, puzzle, empty for theme;
	 */
	public Level createNewLevel(String levelType){
		// standardize input
		//levelType = levelType.substring(0,1).toUpperCase() + levelType.substring(1).toLowerCase();
		Board emptyBoard = new Board();
		emptyBoard.setEmptyBoard();
		String name = "";
		int starVal = 0;
		int highScore = 0;
		//int maxWords = 100; //for puzzle
		boolean unlocked = false;
		Dictionary dict = new Dictionary(new HashSet<String>());
		Level level;
		int lightningSeconds = 66;
		try{
			switch (levelType){
				case "Puzzle":
					dict = new Dictionary();
					level = new PuzzleLevel(emptyBoard,name, dict, highScore, starVal, unlocked, 3);
					break;
				case "Lightning":
					dict = new Dictionary();
					level =  new LightningLevel(emptyBoard, name, dict, highScore, starVal, unlocked, lightningSeconds); //TODO santiago
					break;
				case "Theme":
					level = new ThemeLevel(emptyBoard, name, dict, highScore, starVal, unlocked, "");
					break;
				default:
					throw new IllegalArgumentException("CtrlModifyLevel::createNewLevel: cannot parse " + levelType);
			}
		} catch (IllegalFormatCodePointException e){
			e.printStackTrace();
			level = null;
		} catch (IOException ioe){
			System.err.println(ioe.getMessage()+" Check that you have the right files in test execution root");
			ioe.printStackTrace();
			level = null;
		} catch (Exception ee){
			ee.printStackTrace();
			level = null;
		}
		return level;
	}
	public Level createNewLevel(String levelType, String levelName) throws Exception{
		Level l = this.createNewLevel(levelType);
		l.setName(levelName);
		return l;
	}

	/**
	 * Cycles through the levels, and unlocks any new levels.
	 */
	public void unlockLevels() {
		for(int k = 0; k < this.levels.size()-1; k++){
			if(this.levels.get(k).isComplete()){
				//save next level, set unlocked
				Level next = this.levels.get(k+1);
				next.setUnlocked(true);
				next.save(next.getName());
			}

		}
	}
}

