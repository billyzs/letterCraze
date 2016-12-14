package common.model;

/**
 * A child of <code>Tile</code> with no ability to be made selectable.
 * @author Grant Espe
 *
 */
public class NullTile extends Tile{

	public NullTile(int r, int c) {
		super(r, c);
		this.letters = "";
		this.selected = false;
	}
	
	public NullTile(Tile t) {
		super(t.getRow(), t.getCol());
		this.letters = "";
		this.selected = false;
	}

	public boolean isNull(){
		return true;
	}

	public boolean isSelectable(){return false;}

	public void recoverState(Tile t) {
		this.row = t.getRow();
		this.col = t.getCol();
	}
	
	public String setRandLetter(){
		return (this.letters="s");
	}
	
}
