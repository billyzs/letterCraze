package common.model;

public class SelectTileMove implements IMove{
	Model model;
	Tile tile;
	
	public SelectTileMove(Model m, Tile t){
		this.model = m;
		this.tile = t;
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
		this.tile.setSelected(false);
		this.model.getCurrentLevel().getCurrentWord().removeLastTile();
	}
	
	//mind the short circuit evaluation
	public boolean isValid(){
		if(!this.tile.isSelectable())
			return false;
			
		Word currentWord = this.model.getCurrentLevel().getCurrentWord();
		Tile prevTile = currentWord.getLastTile();
		
		//valid if the tile is selectable and adjacent to recent tile
		// or if current word is empty
		if(currentWord.isEmpty() || this.tile.isAdjacent(prevTile))
			return true;

		return false;
	
	}

}
