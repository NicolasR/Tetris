package board;

import block.BlockContract;
import grid.*;

public interface BoardService {
	
	/** Observators*/
	public BlockContract getcurrentBlock();
	public GridContract getgrid();
	public int getNbLastCleaned();
	public boolean canRotateLeft();
		//pre: isBlock()
	public boolean canRotateRight();
		//pre: isBlock()
	public boolean cangoLeft();
		//pre: isBlock()
	public boolean cangoRight();
		//pre: isBlock()
	public boolean isBlock();
		//pre: isBlock()
	public boolean isBottom();
		//pre: isBlock()
	public boolean isConflict();
		//pre: isBlock()
	public int getXblock(int x);
	public int getYblock(int y);
	public int getXMinBlock();
	public int getYMinBlock();
	public int getBottomHeight();
		//pre: x>=1 && x<=getgrid().getWidth()
		//pre: y>=1 && y<=getgrid().getHeight()

	/** Invariants
	 * getXMinblock >= 0 && getXblock <= getgrid().getWidth - getcurrentBlock.getSize()
	 * getYMinblock >= 0 && getYblock <= getgrid().getWidth - getcurrentBlock.getSize()
	 */
	
	/** Constructors
	 * Initialise
	 * pre: x > 0 && y > 0 && y >= x
	 * post: isBlock() == false
	 * post: getgrid().getWidth == x && getgrid().getHeight == y
	 * post: getNbLastCleaned() == 0
	 * post: getXMinBlock() == 0 && getYMinBlock() == 0
	 */
	public void init(int x, int y);
	
	
	/** Operators */
	
	/**
	 * pre: isBlock() && canRotateLeft()
	 * post: getXMinBlock()@pre == getXMinBlock()
	 * post: getYMinBlock()@pre == getYMinBlock()
	 */
	public void doRotateLeft();
	
	/**
	 * pre: isBlock() && cangoLeft()
	 * post: getXMinBlock() == getXMinBlock()@pre -1
	 * post: getYMinBlock()@pre == getYMinBlock()
	 */
	public void doLeft();
	
	/**
	 * pre: isBlock() && canRotateRight()
	 * post: getXMinBlock()@pre == getXMinBlock()
	 * post: getYMinBlock()@pre == getYMinBlock()
	 */
	public void doRotateRight();
	
	/**
	 * pre: isBlock() && cangoRight()
	 * post: getXMinBlock() == getXMinBlock()@pre +1
	 * post: getYMinBlock()@pre == getYMinBlock()
	 */
	public void doRight();
	
	/**
	 * pre: isBlock()
	 * post: getXMinBlock()@pre == getXMinBlock()
	 * post: getYMinBlock()@pre + getBottomHeight() == getYMinBlock()
	 */
	public void doBottom();
	
	/**
	 * pre: isBlock()
	 * post: getXMinBlock()@pre == getXMinBlock()
	 * post: getYMinBlock()@pre + 1 == getYMinBlock()
	 */
	public void step();
	
	/**
	 * pre: isBlock() == false
	 * post: getcurrentBlock() == bloc
	 * 
	 */
	public void insert(BlockContract bloc);
	
	/**
	 * pre: isBlock()
	 * post: isBlock() == false
	 * post: getXMinBlock() != 0 && getYMinBlock() != 0
	 */
	public void remove();

}
