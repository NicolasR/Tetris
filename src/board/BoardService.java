package board;

import grid.*;

public interface BoardService {
	
	/** Observators*/
	public BlockService getcurrentBlock();
	public GridService getgrid();
	public int getNbLastCleaned();
	public boolean canRotateLeft();
	public boolean canRotateRight();
	public boolean cangoLeft();
	public boolean cangoRight();
	public boolean isBlock();
	
	/** Constructors
	 * Initialise
	 * pre: x > 0 && y > 0 && y >= x
	 * post: isBlock() == false
	 * post: getgrid().getWidth == x && getgrid().getHeight == y
	 * post: getNbLastCleaned() == 0
	 */
	public void init(int x, int y);
	
	
	/** Operators */
	
	/**
	 * pre: isBlock() && canRotateLeft()
	 */
	public void doRotateLeft();
	
	/**
	 * pre: isBlock() && cangoLeft()
	 */
	public void doLeft();
	
	/**
	 * pre: isBlock() && canRotateRight()
	 */
	public void doRotateRight();
	
	/**
	 * pre: isBlock() && cangoRight()
	 */
	public void doRight();
	
	/**
	 * pre: isBlock()
	 */
	public void doBottom();
	
	/**
	 * pre: isBlock()
	 */
	public void step();
	
	/**
	 * pre: isBlock() == false
	 * post: Block:init(Random {2,3,4})
	 * post: getBlock() == bloc
	 * 
	 */
	public void insert(BlockService bloc);
	
	/**
	 * pre: isBlock()
	 * post: isBlock() == false
	 */
	public void remove();
}
