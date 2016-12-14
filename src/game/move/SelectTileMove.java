package game.move;

import common.model.*;

/**
 * Move representing the action of selecting a tile.
 * @author Team Technetium
 *
 */
public class SelectTileMove implements IMove{
	Model model;
	Tile tile;
	int row;
	int col;
	
	/**
	 * Default constructor.
	 * @param m An Application Model
	 * @param t A Tile
	 */
	public SelectTileMove(Model m, Tile t){
		this.model = m;
		this.tile = t;
		this.row = this.tile.getRow();
		this.col = this.tile.getCol();
	}
	
	
	/**
	 * Selects this <code>Tile</code> and adds it to a <code>Word</code>.
	 */
	public void doMove(){
		if(this.isValid()){
            this.tile.setSelected(true);
            this.model.getCurrentLevel().getCurrentWord().addTile(tile);
		}
	}

	/**
	 * Removes this <code>Tile</code> from word, and then deselects it.
	 */
	public void undo(){
		//deselect the tile at the position
		this.model.getCurrentLevel().getBoard().getTiles().get(row).get(col).setSelected(false);
		
		//remove last tile from the current word
		this.model.getCurrentLevel().getCurrentWord().removeLastTile();
	}
	
	/**
	 * Returns whether or not this move is valid.
	 * @return True if move is valid.
	 */
	//mind the short circuit evaluation
	public boolean isValid(){
		String type = this.model.getCurrentLevel().getType();
		
		if(!this.tile.isSelectable() || this.tile.isSelected()){
			return false;
		}
		
		if((type == "Lightning") && (((LightningLevel)(this.model.getCurrentLevel())).isTimeOver())) {
			return false;
		}
		
		Word currentWord = this.model.getCurrentLevel().getCurrentWord();
		Tile prevTile = currentWord.getLastTile();
		
		//valid if the tile is selectable and adjacent to recent tile
		// or if current word is empty
		if(currentWord.isEmpty() || this.tile.isAdjacent(prevTile)){
			return true;
		}
		return false;
	
	}

}
