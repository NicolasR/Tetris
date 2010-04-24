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
	 * post: getBoard() == Board:goLeft() ????????
	 */
	public void goLeft();
	
	/**
	 * pre: isRunning() == true
	 * post: getScore()@pre == getScore()
	 * post: needNext() == false
	 * post: getBoard() == Board:goRight() ????????????
	 */
	public void goRight();
	
	/**
	 * pre: isRunning() == true
	 * post: getScore() == getScore@pre + 20 + (Board:getNbLastCleaned()*50)
	 * post: needNext() == true
	 * post: getBoard() == Board:doBottom() ?????????
	 */
	public void goDown();
	
	/**
	 * pre: isRunning() == true
	 * post: getScore()@pre == getScore()
	 * post: needNext() == false
	 * post: getBoard() == Board:doRotateLeft() ??????????
	 */
	public void rotateLeft();
	
	/**
	 * pre: isRunning() == true
	 * post: getScore()@pre == getScore()
	 * post: needNext() == false
	 * post: getBoard() == Board:doRotateRight() ?????????
	 */
	public void rotateRight();
	
	/**
	 * pre: isRunning() == true
	 * post: getScore()@pre == getScore()
	 * post: needNext() == false
	 * post: getBoard() == Board:step() ???????
	 */
	public void step();
	
	/**
	 * pre: isRunning() == true
	 * post: getScore()@pre == getScore()
	 * post: needNext() == false
	 * post: getBoard() == Board:insert(bloc) bloc aléatoire.... ?????
	 */
	public void next();
}
