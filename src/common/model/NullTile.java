package common.model;

public class NullTile extends Tile{

	public NullTile(int r, int c) {
		super(r, c);
		this.letters = null;
		this.selected = false;
	}
	
	public NullTile(Tile t) {
		super(t.getRow(),t.getCol());
	}

	public boolean isNull(){
		return true;
	}

	public boolean isSelectable(){return false;}

	public void recoverState(Tile t) {
		this.row = t.getRow();
		this.col = t.getCol();
	}

	
}
