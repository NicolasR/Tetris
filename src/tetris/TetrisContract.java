package tetris;

import grid.GridContract;
import block.BlockContract;
import board.BoardContract;

public class TetrisContract extends TetrisDecorator {

	public TetrisContract(TetrisService f) {
		super(f);
	}
	
	public void checkInvariants(){
		if (!(super.getScore() >= 0))
			throw new Error("[TETRIS]Invariant(1) invalide");
		
		if (!(super.isFinished() != super.isRunning()))
			throw new Error("[TETRIS]Invariant(2) invalide");
	}

	public boolean needNext(){
		checkInvariants();
		
		if (isRunning() == false)
			throw new Error("[TETRIS]pre(1)(needNext) invalide");
		
		boolean temp = super.needNext();
		
		checkInvariants();
		return temp;
	}
	
	public void init(){
		super.init();
		if (!(getScore() == 0))
			throw new Error("[TETRIS]post(1)(init) invalide");
		
		
		//POST BOARD:init
		BoardContract board = getBoard();
		if (!(getBoard().isBlock() == false)) {
			throw new Error("[TETRIS]post(2.1)(init) invalide");
		}
		
		if (!(board.getgrid().getWidth() == 10 && board.getgrid().getHeight() == 22)) {
			throw new Error("[TETRIS]post(2.2)(init) invalide");
		}
		if (!(board.getNbLastCleaned() == 0)) {
			throw new Error("[TETRIS]post(2.3)(init) invalide");
		}
		if (!(board.getXMinBlock() == 0 && board.getYMinBlock() == 0)) {
			throw new Error("[TETRIS]post(2.4)(init) invalide");
		}
		
		
		if (!(isRunning() == true))
			throw new Error("[TETRIS]post(3)(init) invalide");
		if (!(needNext() == true))
			throw new Error("[TETRIS]post(4)(init) invalide");
		checkInvariants();
	}
	
	public void goLeft(){
		checkInvariants();
		if (!(isRunning() == true))
			throw new Error("[TETRIS]pre(1)(goLeft) invalide");
		
		int getScore_atPre = getScore();
		BlockContract getcurrentBlock_atPre = getBoard().getcurrentBlock();
		GridContract getgrid_atPre = getBoard().getgrid();
		int getNbLastCleaned_atPre = getBoard().getNbLastCleaned();
		boolean isBlock_atPre = getBoard().isBlock();
		int getXMinBlock_atPre = getBoard().getXMinBlock();
		int getYMinBlock_atPre = getBoard().getYMinBlock();
		boolean cangoLeft_atPre = getBoard().cangoLeft();
		
		super.goLeft();
		
		if (!(getScore() == getScore_atPre))
			throw new Error("[TETRIS]post(1)(goLeft) invalide");
		if (!(needNext() == false))
			throw new Error("[TETRIS]post(2)(goLeft) invalide");
		
		//POST BOARD:doLeft
		BoardContract board = getBoard();
		if(!(board.getcurrentBlock() == getcurrentBlock_atPre)) {
			throw new Error("[TETRIS]post(3.1)(goLeft) invalide");
		}
		if(!(board.getgrid() == getgrid_atPre)) {
			throw new Error("[TETRIS]post(3.2)(goLeft) invalide");
		}
		if(!(board.getNbLastCleaned() == getNbLastCleaned_atPre)) {
			throw new Error("[TETRIS]post(3.3)(goLeft) invalide");
		}
		if(!(board.isBlock() == isBlock_atPre)) {
			throw new Error("[TETRIS]post(3.4)(goLeft) invalide");
		}
		if (cangoLeft_atPre)
			if (!(board.getXMinBlock() == getXMinBlock_atPre-1)) {
				throw new Error("[TETRIS]post(3.5)(goLeft) invalide");
			}
		if (!(board.getYMinBlock() == getYMinBlock_atPre)) {
			throw new Error("[TETRIS]post(3.6)(goLeft) invalide");
		}
		
		
		
		checkInvariants();
	}
	
	public void goRight(){
		checkInvariants();
		if (!(isRunning() == true))
			throw new Error("[TETRIS]pre(1)(goRight) invalide");
		
		int getScore_atPre = getScore();
		
		BlockContract getcurrentBlock_atPre = getBoard().getcurrentBlock();
		GridContract getgrid_atPre = getBoard().getgrid();
		int getNbLastCleaned_atPre = getBoard().getNbLastCleaned();
		boolean isBlock_atPre = getBoard().isBlock();
		int getXMinBlock_atPre = getBoard().getXMinBlock();
		int getYMinBlock_atPre = getBoard().getYMinBlock();
		boolean cangoRight_atPre = getBoard().cangoRight();
		
		super.goRight();
		
		if (!(getScore() == getScore_atPre))
			throw new Error("[TETRIS]post(1)(goRight) invalide");
		if (!(needNext() == false))
			throw new Error("[TETRIS]post(2)(goRight) invalide");
		
		//POST BOARD:doRight
		BoardContract board = getBoard();
		if(!(board.getcurrentBlock() == getcurrentBlock_atPre)) {
			throw new Error("[TETRIS]post(3.1)(goRight) invalide");
		}
		if(!(board.getgrid() == getgrid_atPre)) {
			throw new Error("[TETRIS]post(3.2)(goRight) invalide");
		}
		if(!(board.getNbLastCleaned() == getNbLastCleaned_atPre)) {
			throw new Error("[TETRIS]post(3.3)(goRight) invalide");
		}
		if(!(board.isBlock() == isBlock_atPre)) {
			throw new Error("[TETRIS]post(3.4)(goRight) invalide");
		}
		if (cangoRight_atPre)
			if (!( board.getXMinBlock() == getXMinBlock_atPre+1)) {
				throw new Error("[TETRIS]post(3.5)(goRight) invalide");
			}
		if (!(board.getYMinBlock() == getYMinBlock_atPre)) {
			throw new Error("[TETRIS]post(3.6)(goRight) invalide");
		}
		checkInvariants();
	}
	
	public void goDown(){
		checkInvariants();
		if (!(isRunning() == true))
			throw new Error("[TETRIS]pre(1)(goDown) invalide");
		
		boolean isBottom_atPre = getBoard().isBottom();
		int getScore_atPre = getScore();
		BlockContract getcurrentBlock_atPre = getBoard().getcurrentBlock();
		GridContract getgrid_atPre = getBoard().getgrid();
		boolean isBlock_atPre = getBoard().isBlock();
		int getXMinBlock_atPre = getBoard().getXMinBlock();
		int getYMinBlock_atPre = getBoard().getYMinBlock();
		int getBottomHeight_atPre = getBoard().getBottomHeight();
		
		super.goDown();
		
		if (!isBottom_atPre){
			if (!(getScore_atPre+20+50*(getBoard().getNbLastCleaned()) == getScore()))
				throw new Error("[TETRIS]post(1)(goDown) invalide");
			
			if (!(needNext() == true))
				throw new Error("[TETRIS]post(2)(goDown) invalide");
		}

		//POST BOARD:doBottom
		BoardContract board = getBoard();
		if(!(board.getcurrentBlock() == getcurrentBlock_atPre)) {
			throw new Error("[TETRIS]post(3.1)(goDown) invalide");
		}
		if(!(board.getgrid() == getgrid_atPre)) {
			throw new Error("[TETRIS]post(3.2)(goDown) invalide");
		}
		if(!(board.isBlock() == isBlock_atPre)) {
			throw new Error("[TETRIS]post(3.3)(goDown) invalide");
		}
		if (!(board.getXMinBlock() == getXMinBlock_atPre)) {
			throw new Error("[TETRIS]post(3.4)(goDown) invalide");
		}
		if (!(board.getYMinBlock() == getYMinBlock_atPre+getBottomHeight_atPre)) {
			throw new Error("[TETRIS]post(3.5)(goDown) invalide");
		}
		if(!(board.getBottomHeight() == 0)) {
			throw new Error("[TETRIS]post(3.6)(goDown) invalide");
		}
		checkInvariants();
	}
	
	public void rotateLeft(){
		checkInvariants();
		if (!(isRunning() == true))
			throw new Error("[TETRIS]pre(1)(rotateLeft) invalide");
		
		int getScore_atPre = getScore();
		BlockContract getcurrentBlock_atPre = getBoard().getcurrentBlock();
		GridContract getgrid_atPre = getBoard().getgrid();
		int getNbLastCleaned_atPre = getBoard().getNbLastCleaned();
		boolean isBlock_atPre = getBoard().isBlock();
		int getXMinBlock_atPre = getBoard().getXMinBlock();
		int getYMinBlock_atPre = getBoard().getYMinBlock();
		
		super.rotateLeft();
		
		if (!(getScore() == getScore_atPre))
			throw new Error("[TETRIS]post(1)(rotateLeft) invalide");
		if (!(needNext() == false))
			throw new Error("[TETRIS]post(2)(rotateLeft) invalide");
		
		//POST BOARD:doRotateLeft
		BoardContract board = getBoard();
		if(!(board.getcurrentBlock() == getcurrentBlock_atPre)) {
			throw new Error("[TETRIS]post(3.1)(rotateLeft) invalide");
		}
		if(!(board.getgrid() == getgrid_atPre)) {
			throw new Error("[TETRIS]post(3.2)(rotateLeft) invalide");
		}
		if(!(board.getNbLastCleaned() == getNbLastCleaned_atPre)) {
			throw new Error("[TETRIS]post(3.3)(rotateLeft) invalide");
		}
		if(!(board.isBlock() == isBlock_atPre)) {
			throw new Error("[TETRIS]post(3.4)(rotateLeft) invalide");
		}
		if (!(board.getXMinBlock() == getXMinBlock_atPre)) {
			throw new Error("[TETRIS]post(3.5)(rotateLeft) invalide");
		}
		if (!(board.getYMinBlock() == getYMinBlock_atPre)) {
			throw new Error("[TETRIS]post(3.6)(rotateLeft) invalide");
		}
		
		checkInvariants();
	}
	
	public void rotateRight(){
		checkInvariants();
		if (!(isRunning() == true))
			throw new Error("[TETRIS]pre(1)(rotateRight) invalide");
		
		int getScore_atPre = getScore();
		BlockContract getcurrentBlock_atPre = getBoard().getcurrentBlock();
		GridContract getgrid_atPre = getBoard().getgrid();
		int getNbLastCleaned_atPre = getBoard().getNbLastCleaned();
		boolean isBlock_atPre = getBoard().isBlock();
		int getXMinBlock_atPre = getBoard().getXMinBlock();
		int getYMinBlock_atPre = getBoard().getYMinBlock();
		
		super.rotateRight();
		
		if (!(getScore() == getScore_atPre))
			throw new Error("[TETRIS]post(1)(rotateRight) invalide");
		if (!(needNext() == false))
			throw new Error("[TETRIS]post(2)(rotateRight) invalide");
		
		//POST BOARD:doRotateRight
		BoardContract board = getBoard();
		if(!(board.getcurrentBlock() == getcurrentBlock_atPre)) {
			throw new Error("[TETRIS]post(3.1)(rotateRight) invalide");
		}
		if(!(board.getgrid() == getgrid_atPre)) {
			throw new Error("[TETRIS]post(3.2)(rotateRight) invalide");
		}
		if(!(board.getNbLastCleaned() == getNbLastCleaned_atPre)) {
			throw new Error("[TETRIS]post(3.3)(rotateRight) invalide");
		}
		if(!(board.isBlock() == isBlock_atPre)) {
			throw new Error("[TETRIS]post(3.4)(rotateRight) invalide");
		}
		if (!(board.getXMinBlock() == getXMinBlock_atPre)) {
			throw new Error("[TETRIS]post(3.5)(rotateRight) invalide");
		}
		if (!(board.getYMinBlock() == getYMinBlock_atPre)) {
			throw new Error("[TETRIS]post(3.6)(rotateRight) invalide");
		}
		checkInvariants();
	}
	
	public void step(){
		checkInvariants();
		if (!(isRunning() == true))
			throw new Error("[TETRIS]pre(1)(step) invalide");
		
		int getScore_atPre = getScore();
		boolean isBottom_atPre = getBoard().isBottom();
		boolean needNext_atPre = needNext();
		
		GridContract getgrid_atPre = getBoard().getgrid();
		boolean isBlock_atPre = getBoard().isBlock();
		int getXMinBlock_atPre = getBoard().getXMinBlock();
		int getYMinBlock_atPre = getBoard().getYMinBlock();
		int getBottomHeight_atPre = getBoard().getBottomHeight();
		
		super.step();
		
		if (isBottom_atPre){
			if (isRunning()== true && needNext() == true)
				throw new Error("[TETRIS]post(1)(step) invalide");
			
			if (!needNext_atPre)
				if (!(getScore() == getScore_atPre + 20 + (getBoard().getNbLastCleaned()*50)))
					throw new Error("[TETRIS]post(3)(step) invalide");
			
		}
		else{
			if (!(needNext_atPre == needNext()))
				throw new Error("[TETRIS]post(2)(step) invalide");
			
			if (!(getScore() == getScore_atPre))
					throw new Error("[TETRIS]post(4)(step) invalide");
			
		}
		
		//POST BOARD:step
		BoardContract board = getBoard();
		if(!(board.getgrid() == getgrid_atPre)) {
			throw new Error("[TETRIS]post(3.1)(step) invalide");
		}
		if(!(board.isBlock() == isBlock_atPre)) {
			throw new Error("[TETRIS]post(3.2)(step) invalide");
		}
		if (!isBottom_atPre){
			if(!(board.getXMinBlock() == getXMinBlock_atPre)) {
				throw new Error("[TETRIS]post(3.3)(step) invalide");
			}
			
			if (!(board.getYMinBlock() == getYMinBlock_atPre+1)) {
				throw new Error("[TETRIS]post(3.4)(step) invalide");
			}
			if (!(board.getBottomHeight() == getBottomHeight_atPre-1)) {
				throw new Error("[TETRIS]post(3.5)(step) invalide");
			}
		}
		
		checkInvariants();
	}
	
	public void next(){
		checkInvariants();
		
		if (!(needNext() == true))
			throw new Error("[TETRIS]pre(1)(next) invalide");
		
		int getScore_atPre = getScore();
		GridContract getgrid_atPre = getBoard().getgrid();
		
		super.next();
		
		if (!(getScore() == getScore_atPre))
			throw new Error("[TETRIS]post(1)(next) invalide");
		if (!(needNext() == false))
			throw new Error("[TETRIS]post(2)(next) invalide");
		
		//POST BOARD:insert
		BoardContract board = getBoard();
		
		if(!(board.getgrid() == getgrid_atPre)) {
			throw new Error("[TETRIS]post(3.2)(next) invalide");
		}
		if(!(board.isBlock())) {
			throw new Error("[TETRIS]post(3.3)(next) invalide");
		}
		checkInvariants();
	}
}
