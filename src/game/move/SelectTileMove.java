package game.move;

import common.model.*;

public class SelectTileMove implements IMove{
	Model model;
	Tile tile;
	int row;
	int col;
	
	public SelectTileMove(Model m, Tile t){
		this.model = m;
		this.tile = t;
		this.row = this.tile.getRow();
		this.col = this.tile.getCol();
	}
	
	
	//selected the tile and adds it to the word
	public void doMove(){
		if(this.isValid()){
            this.tile.setSelected(true);
            this.model.getCurrentLevel().getCurrentWord().addTile(tile);
		}
	}

	//removes tile from word, deselects
	public void undo(){
		//deselect the tile at the position
		this.model.getCurrentLevel().getBoard().getTiles().get(row).get(col).setSelected(false);
		
		//remove last tile from the current word
		this.model.getCurrentLevel().getCurrentWord().removeLastTile();
	}
	
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
