package common.model;

public interface IMove {
	
	public void doMove();
	public void undo();
	public boolean isValid(); 
}
