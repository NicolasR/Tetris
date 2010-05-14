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
		
	public boolean isBottom();
		//pre: isBlock()
	public boolean isConflict();
		//pre: isBlock()
	public int getXblock(int x);
	public int getYblock(int y);
	public int getXMinBlock();
	public int getYMinBlock();
	public int getBottomHeight();
		//pre: isBlock()

	/** Invariants
	 * 1 <= getXblock(getcurrentBlock.getXMin()) && getXblock(getcurrentBlock.getXMax()) <= 
			super.getgrid().getWidth()+1
	 * 1 <= getYblock(getcurrentBlock.getYMin()) && getYblock(getcurrentBlock.getYMax()) <= 
			super.getgrid().getHeight()+1
	 * getNbLastCleaned() >= 0
	 */
	
	/** Constructors
	 * Initialise
	 * pre: x > 0 && y > 0 && y >= x
	 * post: getgrid() = Grid:init(x, y);
	 * post: isBlock() == false
	 * post: getgrid().getWidth() == x && getgrid().getHeight() == y
	 * post: getNbLastCleaned() == 0
	 * post: getXMinBlock() == 0 && getYMinBlock() == 0
	 */
	public void init(int x, int y);
	
	
	/** Operators */
	
	/**
	 * pre: isBlock() && canRotateLeft()
	 * post: getcurrentBlock() == getcurrentBlock()@pre
	 * post: getgrid()== getgrid()@pre
	 * post: getNbLastCleaned() == getNbLastCleaned()@pre
	 * post: isBlock() == isBlock()@pre
	 * post: getXMinBlock() == getXMinBlock()@pre
	 * post: getYMinBlock() == getYMinBlock()@pre
	 * post: getcurrentBlock() == getcurrentBlock()@pre.rotateLeft()
	 */
	public void doRotateLeft();
	
	/**
	 * pre: isBlock() && cangoLeft()
	 * post: getcurrentBlock() == getcurrentBlock()@pre
	 * post: getgrid() == getgrid()@pre
	 * post: getNbLastCleaned() == getNbLastCleaned()@pre
	 * post: isBlock() == isBlock()@pre
	 * post: getXMinBlock() == getXMinBlock()@pre -1
	 * post: getYMinBlock() == getYMinBlock()@pre 
	 */	
	public void doLeft();
	
	/**
	 * pre: isBlock() && canRotateRight()
	 * post: getcurrentBlock() == getcurrentBlock()@pre
	 * post: getgrid() == getgrid()@pre
	 * post: getNbLastCleaned() == getNbLastCleaned()@pre
	 * post: isBlock() == isBlock()@pre
	 * post: getXMinBlock() == getXMinBlock()@pre
	 * post: getYMinBlock() == getYMinBlock()@pre
	 * post: getcurrentBlock() == getcurrentBlock()@pre.rotateRight()
	 */	
	public void doRotateRight();
	
	/**
	 * pre: isBlock() && cangoRight()
	 * post: getcurrentBlock() == getcurrentBlock()@pre
	 * post: getgrid() == getgrid()@pre
	 * post: getNbLastCleaned() == getNbLastCleaned()@pre
	 * post: isBlock() == isBlock()@pre
	 * post: getXMinBlock() == getXMinBlock()@pre +1
	 * post: getYMinBlock() == getYMinBlock()@pre
	 */
	public void doRight();
	
	/**
	 * pre: isBlock()
	 * post: getcurrentBlock() == getcurrentBlock()@pre
	 * post: getgrid() == getgrid()@pre
	 * post: isBlock() == isBlock()@pre
	 * post: getXMinBlock() == getXMinBlock()@pre
	 * post:  getYMinBlock() == getYMinBlock()@pre + getBottomHeight()@pre
	 * post: getBottomHeight() == 0 
	 */
	public void doBottom();

	/**
	 * pre: isBlock()
	 * post: getgrid() == getgrid()@pre
	 * post: isBlock() == isBlock()@pre
	 * post: getXMinBlock() == getXMinBlock()@pre 
	 * post: getYMinBlock() getYMinBlock()@pre + 1
	 * post: getBottomHeight() == getBottomHeight()@pre-1
	 */
	public void step();
	
	/**
	 * pre: isBlock() == false
	 * post: getcurrentBlock() == block
	 * post: getgrid() == getgrid()@pre
	 * post: isBlock()
	 */
	public void insert(BlockContract block);

	/**
	 * pre: isBlock()
	 * post: getcurrentBlock() == null
	 * post: getgrid() == getgrid()@pre
	 * post: getNbLastCleaned() == getNbLastCleaned()@pre
	 * post: isBlock()== false
	 * post: getXMinBlock() == 0 
	 * post: getYMinBlock() == 0
	 */
	public void remove();

	/**
	 * pre : isBottom()
	 * post: getcurrentBlock() == getcurrentBlock()@pre
	 * post: getgrid() == getgrid()@pre
	 * 
	 */
	public void clean();

}
