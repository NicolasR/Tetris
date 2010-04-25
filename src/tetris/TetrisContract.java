package tetris;

public class TetrisContract extends TetrisDecorator {

	public TetrisContract(TetrisService f) {
		super(f);
	}
	
	public void checkInvariants(){
		if (super.getScore() < 0)
			throw new Error("[TETRIS]Invariant(1) invalide");
		
		if (super.isFinished() == super.isRunning())
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
		if (getScore() != 0)
			throw new Error("[TETRIS]post(1)(init) invalide");
		//????? post2
		
		if (isRunning() == false)
			throw new Error("[TETRIS]post(3)(init) invalide");
		if (needNext() == false)
			throw new Error("[TETRIS]post(4)(init) invalide");
		checkInvariants();
	}
	
	public void goLeft(){
		checkInvariants();
		if (isRunning() != true)
			throw new Error("[TETRIS]pre(1)(goLeft) invalide");
		
		int getScore_atPre = getScore();
		
		super.goLeft();
		
		if (getScore() != getScore_atPre)
			throw new Error("[TETRIS]post(1)(goLeft) invalide");
		if (needNext() != false)
			throw new Error("[TETRIS]post(2)(goLeft) invalide");
		//????? post 3
		checkInvariants();
	}
	
	public void goRight(){
		checkInvariants();
		if (isRunning() != true)
			throw new Error("[TETRIS]pre(1)(goRight) invalide");
		
		int getScore_atPre = getScore();
		
		super.goRight();
		
		if (getScore() != getScore_atPre)
			throw new Error("[TETRIS]post(1)(goRight) invalide");
		if (needNext() != false)
			throw new Error("[TETRIS]post(2)(goRight) invalide");
		//????? post 3
		checkInvariants();
	}
	
	public void goDown(){
		checkInvariants();
		if (isRunning() != true)
			throw new Error("[TETRIS]pre(1)(goDown) invalide");
		
		int getScore_atPre = getScore();
		super.goDown();
		
		if (getScore() != (getScore_atPre + 20 + getBoard().getNbLastCleaned()))
			throw new Error("[TETRIS]post(1)(goDown) invalide");
		if (needNext() != true)
			throw new Error("[TETRIS]post(2)(goDown) invalide");
		//????? post 3
		checkInvariants();
	}
	
	public void rotateLeft(){
		checkInvariants();
		if (isRunning() != true)
			throw new Error("[TETRIS]pre(1)(rotateLeft) invalide");
		
		int getScore_atPre = getScore();
		super.rotateLeft();
		
		if (getScore() != getScore_atPre)
			throw new Error("[TETRIS]post(1)(rotateLeft) invalide");
		if (needNext() != false)
			throw new Error("[TETRIS]post(2)(rotateLeft) invalide");
		//????? post 3
		
		checkInvariants();
	}
	
	public void rotateRight(){
		checkInvariants();
		if (isRunning() != true)
			throw new Error("[TETRIS]pre(1)(rotateRight) invalide");
		
		int getScore_atPre = getScore();
		super.rotateRight();
		
		if (getScore() != getScore_atPre)
			throw new Error("[TETRIS]post(1)(rotateRight) invalide");
		if (needNext() != false)
			throw new Error("[TETRIS]post(2)(rotateRight) invalide");
		//????? post 3
		
		checkInvariants();
	}
	
	public void step(){
		checkInvariants();
		if (super.isRunning() != true)
			throw new Error("[TETRIS]pre(1)(step) invalide");
		
		int getScore_atPre = super.getScore();
		super.rotateLeft();
		
		if (getBoard().isBottom()){
			if (needNext() == false)
				throw new Error("[TETRIS]post(1)(step) invalide");
			else{
				if (getScore() != getScore_atPre + 20 + (getBoard().getNbLastCleaned()*50))
					throw new Error("[TETRIS]post(3)(step) invalide");
			}
		}
		else{
			if (needNext() == true)
				throw new Error("[TETRIS]post(2)(step) invalide");
			else{
				if (getScore() != getScore_atPre)
					throw new Error("[TETRIS]post(4)(step) invalide");
			}
		}
		//????? post 3
		
		checkInvariants();
	}
	
	public void next(){
		checkInvariants();
		if (isRunning() != true)
			throw new Error("[TETRIS]pre(1)(rotateLeft) invalide");
		
		int getScore_atPre = getScore();
		super.rotateLeft();
		
		if (getScore() != getScore_atPre)
			throw new Error("[TETRIS]post(1)(rotateLeft) invalide");
		if (needNext() != false)
			throw new Error("[TETRIS]post(2)(rotateLeft) invalide");
		//????? post 3
		
		checkInvariants();
	}
}
