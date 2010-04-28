package tetris;

import board.*;

public interface TetrisService {
	/** Observators */
	public int getScore();
	public boolean isFinished();
	public boolean isRunning();
	public boolean needNext();
		//pre: isRunning == true
	public BoardContract getBoard();
	
	/** Invariants
	 * getScore() >= 0
	 * isFinished() = !isRunning
	 */
	
	/** Constructor
	 * Initialise
	 * post: getScore() == 0
	 * post: getBoard() == Board:init(10,22) ?????????
	 * post: isRunning() == true
	 * post: needNext() == true
	 */
	public void init();
	
	/** Operators */
	/**
	 * pre: isRunning() == true
	 * post: getScore()@pre == getScore()
	 * post: needNext() == false
	 * post: getBoard() == getBoard()@pre.goLeft() ????????
	 */
	public void goLeft();
	
	/**
	 * pre: isRunning() == true
	 * post: getScore()@pre == getScore()
	 * post: needNext() == false
	 * post: getBoard() == getBoard()@pre.goRight() ????????????
	 */
	public void goRight();
	
	/**
	 * pre: isRunning() == true
	 * post: getScore() == getScore@pre + 20 + (Board:getNbLastCleaned()*50)
	 * post: needNext() == true
	 * post: getBoard() == getBoard()@pre.doBottom() ?????????
	 */
	public void goDown();
	
	/**
	 * pre: isRunning() == true
	 * post: getScore()@pre == getScore()
	 * post: needNext() == false
	 * post: getBoard() == getBoard()@pre.doRotateLeft() ??????????
	 */
	public void rotateLeft();
	
	/**
	 * pre: isRunning() == true
	 * post: getScore()@pre == getScore()
	 * post: needNext() == false
	 * post: getBoard() == getBoard()@pre.doRotateRight() ?????????
	 */
	public void rotateRight();
	
	/**
	 * pre: isRunning() == true
	 * post: board:isBottom() => needNext() == true
	 * post: not(board:isBottom()) => needNext() == false
	 * post: needNext() == true => getScore() == getScore@pre + 20 + (Board:getNbLastCleaned()*50)
	 * post: needNext() == false => getScore()@pre == getScore()
	 * post: getBoard() == getBoard()@pre.step() ???????
	 */
	public void step();
	
	/**
	 * pre: needNext() == true
	 * post: getScore()@pre == getScore()
	 * post: needNext() == false
	 * post: getBoard() ==getBoard()@pre.insert(Block:init(???)) bloc aléatoire.... ?????
	 */
	public void next();
}
