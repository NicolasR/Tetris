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
		
		if (super.isRunning() == false)
			throw new Error("[TETRIS]pre(1)(needNext) invalide");
		
		boolean temp = super.needNext();
		
		checkInvariants();
		return temp;
	}
	
	public void init(){
		super.init();
		if (super.getScore() != 0)
			throw new Error("[TETRIS]post(1)(init) invalide");
		//????? post2
		
		if (super.isRunning() == false)
			throw new Error("[TETRIS]post(3)(init) invalide");
		if (super.needNext() == false)
			throw new Error("[TETRIS]post(4)(init) invalide");
		checkInvariants();
	}
	
	public void goLeft(){
		checkInvariants();
		if (super.isRunning() != true)
			throw new Error("[TETRIS]pre(1)(goLeft) invalide");
		
		int getScore_atPre = super.getScore();
		
		super.goLeft();
		
		if (super.getScore() != getScore_atPre)
			throw new Error("[TETRIS]post(1)(goLeft) invalide");
		if (super.needNext() != false)
			throw new Error("[TETRIS]post(2)(goLeft) invalide");
		//????? post 3
		checkInvariants();
	}
	
	public void goRight(){
		checkInvariants();
		if (super.isRunning() != true)
			throw new Error("[TETRIS]pre(1)(goLeft) invalide");
		
		int getScore_atPre = super.getScore();
		
		super.goRight();
		
		if (super.getScore() != getScore_atPre)
			throw new Error("[TETRIS]post(1)(goLeft) invalide");
		if (super.needNext() != false)
			throw new Error("[TETRIS]post(2)(goLeft) invalide");
		//????? post 3
		checkInvariants();
	}
	
	public void goDown(){
		checkInvariants();
		if (super.isRunning() != true)
			throw new Error("[TETRIS]pre(1)(goDown) invalide");
		
		int getScore_atPre = super.getScore();
		super.goDown();
		
		if (super.getScore() != (getScore_atPre + 20 + super.getBoard().getNbLastCleaned()))
			throw new Error("[TETRIS]post(1)(goDown) invalide");
		if (super.needNext() != true)
			throw new Error("[TETRIS]post(2)(goDown) invalide");
		//????? post 3
		checkInvariants();
	}
	
	public void rotateLeft(){
		checkInvariants();
		if (super.isRunning() != true)
			throw new Error("[TETRIS]pre(1)(rotateLeft) invalide");
		
		int getScore_atPre = super.getScore();
		super.rotateLeft();
		
		if (super.getScore() != getScore_atPre)
			throw new Error("[TETRIS]post(1)(rotateLeft) invalide");
		if (super.needNext() != false)
			throw new Error("[TETRIS]post(2)(rotateLeft) invalide");
		//????? post 3
		
		checkInvariants();
	}
	
	public void rotateRight(){
		checkInvariants();
		if (super.isRunning() != true)
			throw new Error("[TETRIS]pre(1)(rotateRight) invalide");
		
		int getScore_atPre = super.getScore();
		super.rotateRight();
		
		if (super.getScore() != getScore_atPre)
			throw new Error("[TETRIS]post(1)(rotateRight) invalide");
		if (super.needNext() != false)
			throw new Error("[TETRIS]post(2)(rotateRight) invalide");
		//????? post 3
		
		checkInvariants();
	}
	
	public void step(){
		checkInvariants();
		if (super.isRunning() != true)
			throw new Error("[TETRIS]pre(1)(rotateLeft) invalide");
		
		int getScore_atPre = super.getScore();
		super.rotateLeft();
		
		if (super.getScore() != getScore_atPre)
			throw new Error("[TETRIS]post(1)(rotateLeft) invalide");
		if (super.needNext() != false)
			throw new Error("[TETRIS]post(2)(rotateLeft) invalide");
		//????? post 3
		
		checkInvariants();
	}
	
	public void next(){
		checkInvariants();
		if (super.isRunning() != true)
			throw new Error("[TETRIS]pre(1)(rotateLeft) invalide");
		
		int getScore_atPre = super.getScore();
		super.rotateLeft();
		
		if (super.getScore() != getScore_atPre)
			throw new Error("[TETRIS]post(1)(rotateLeft) invalide");
		if (super.needNext() != false)
			throw new Error("[TETRIS]post(2)(rotateLeft) invalide");
		//????? post 3
		
		checkInvariants();
	}
}
