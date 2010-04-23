package board;

import grid.GridImpl;

public interface BoardService {
	
	/** Observators*/
	public int getNbLastCleaned();
//	public BlockService getBlock();
	
	/** Constructors
	 * Initialise
	 * pre: x > 0 && y > 0 && y >= x
	 */
	public void init(int x, int y);
	
	
	/** Operators */
	
	public void doRotateLeft();
	
	public void doLeft();
	
	public void doRotateRight();
	
	public void doRight();
	
	public void doBottom();
	
//	public void insert(Block bloc);
}
