package board;

import block.BlockContract;

public class BoardContract extends BoardDecorator {

	public BoardContract(BoardService f) {
		super(f);
	}

	public void checkInvariants(){
		int sizeblock = 0;
		if (super.isBlock())
			sizeblock = super.getcurrentBlock().getSize();
		if (super.getXMinBlock() < 0 || super.getXMinBlock() > 
		(super.getgrid().getWidth() - sizeblock))
				throw new Error("[BOARD]invariant(1) invalide");
		
		if (super.getYMinBlock() < 0 || super.getYMinBlock() > 
		(super.getgrid().getHeight() - sizeblock))
				throw new Error("[BOARD]invariant(2) invalide");
	}
	
	public void init(int x, int y){
		if (x == 0 || y == 0 || y < x)
			throw new Error("[BOARD]pre(1)(init) invalide");
		
		super.init(x, y);
		
		if (isBlock() != false)
			throw new Error("[BOARD]post(1)(init) invalide");
		if (getgrid().getWidth() != x || getgrid().getHeight() != y)
			throw new Error("[BOARD]post(2)(init) invalide");
		if (getNbLastCleaned() != 0)
			throw new Error("[BOARD]post(3)(init) invalide");
		if (getXMinBlock() != 0 || getYMinBlock() != 0)
			throw new Error("[BOARD]post(4)(init) invalide");
		
		checkInvariants();
	}
	
	public void doRotateLeft(){
		checkInvariants();
		if (isBlock() == false || canRotateLeft() == false)
			throw new Error("[BOARD]pre(1)(doRotateLeft) invalide");
		
		int getXMinBlock_atPre = getXMinBlock();
		int getYMinBlock_atPre = getYMinBlock();
		super.doRotateLeft();
		
		if (getXMinBlock_atPre != getXMinBlock())
			throw new Error("[BOARD]post(1)(doRotateLeft) invalide");
		if (getYMinBlock_atPre != getYMinBlock())
			throw new Error("[BOARD]post(2)(doRotateLeft) invalide");
		
		checkInvariants();
	}
	
	public void doLeft(){
		checkInvariants();
		if (isBlock() == false || cangoLeft() == false)
			throw new Error("[BOARD]pre(1)(doLeft) invalide");
		
		int getXMinBlock_atPre = getXMinBlock();
		int getYMinBlock_atPre = getYMinBlock();
		super.doLeft();
		
		if (getXMinBlock_atPre-1 != getXMinBlock())
			throw new Error("[BOARD]post(1)(doLeft) invalide");
		if (getYMinBlock_atPre != getYMinBlock())
			throw new Error("[BOARD]post(2)(doLeft) invalide");
		
		checkInvariants();
	}
	
	public void doRotateRight(){
		checkInvariants();
		if (isBlock() == false || canRotateRight() == false)
			throw new Error("[BOARD]pre(1)(doRotateRight) invalide");
		
		int getXMinBlock_atPre = getXMinBlock();
		int getYMinBlock_atPre = getYMinBlock();
		super.canRotateRight();
		
		if (getXMinBlock_atPre != getXMinBlock())
			throw new Error("[BOARD]post(1)(doRotateRight) invalide");
		if (getYMinBlock_atPre != getYMinBlock())
			throw new Error("[BOARD]post(2)(doRotateRight) invalide");
		
		
		checkInvariants();
	}
	
	public void doRight(){
		checkInvariants();
		if (isBlock() == false || cangoRight() == false)
			throw new Error("[BOARD]pre(1)(doRight) invalide");
		
		int getXMinBlock_atPre = getXMinBlock();
		int getYMinBlock_atPre = getYMinBlock();
		super.doRight();
		
		if (getXMinBlock_atPre+1 != getXMinBlock())
			throw new Error("[BOARD]post(1)(doRight) invalide");
		if (getYMinBlock_atPre != getYMinBlock())
			throw new Error("[BOARD]post(2)(doRight) invalide");
		
		checkInvariants();
	}
	
	public void doBottom(){
		checkInvariants();
		if (isBlock() == false)
			throw new Error("[BOARD]pre(1)(doBottom) invalide");
		
		int getXMinBlock_atPre = getXMinBlock();
		int getYMinBlock_atPre = getYMinBlock();
		super.doBottom();
		
		if (getXMinBlock_atPre+1 != getXMinBlock())
			throw new Error("[BOARD]post(1)(doBottom) invalide");
		if (getYMinBlock_atPre+getBottomHeight()!= getYMinBlock())
			throw new Error("[BOARD]post(2)(doBottom) invalide");
		
		checkInvariants();
	}
	
	public void step(){
		checkInvariants();
		if(isBlock() == false)
			throw new Error("[BOARD]pre(1)(step) invalide");
		
		int getXMinBlock_atPre = getXMinBlock();
		int getYMinBlock_atPre = getYMinBlock();
		super.step();
		
		if (getXMinBlock_atPre != getXMinBlock())
			throw new Error("[BOARD]post(1)(step) invalide");
		if (getYMinBlock_atPre+1 != getYMinBlock())
			throw new Error("[BOARD]post(2)(step) invalide");
		
		checkInvariants();
	}
	
	public void insert(BlockContract bloc){
		checkInvariants();
		if (isBlock() == true)
			throw new Error("[BOARD]pre(1)(insert) invalide");
		
		super.insert(bloc);
		
		/*post: Block:init(Random {2,3,4}) Vérif*/
		if (isBlock() == false)
			throw new Error("[BOARD]post(1)(insert) invalide");
		if (getcurrentBlock() != bloc)
			throw new Error("[BOARD]post(2)(insert) invalide");
		if (getXMinBlock() == 0 || getYMinBlock() == 0)
			throw new Error("[BOARD]post(3)(insert) invalide");
		checkInvariants();
	}
	
	public void remove(){
		checkInvariants();
		
		if(isBlock() == false)
			throw new Error("[BOARD]pre(1)(remove) invalide");
		
		super.remove();
		
		if (isBlock() != false)
			throw new Error("[BOARD]post(1)(remove) invalide");
		
		checkInvariants();
	}
	
}
