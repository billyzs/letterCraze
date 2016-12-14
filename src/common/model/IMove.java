package common.model;

/**
 * Interface for common behavior in all moves.
 */
public interface IMove {
	
	public void doMove();
	public void undo();
	public boolean isValid(); 
}
