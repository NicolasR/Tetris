package board;

import block.BlockContract;

public class BoardContract extends BoardDecorator {

	public BoardContract(BoardService f) {
		super(f);
	}

	public void checkInvariants(){
		
	}
	
	public void init(int x, int y){
		if (x == 0 || y == 0 || y < x)
			throw new Error("[BOARD]pre(1)(init) invalide");
		
		super.init(x, y);
		
		if (super.isBlock() != false)
			throw new Error("[BOARD]post(1)(init) invalide");
		if (super.getgrid().getWidth() != x || super.getgrid().getWidth() != y)
			throw new Error("[BOARD]post(2)(init) invalide");
		if (super.getNbLastCleaned() != 0)
			throw new Error("[BOARD]post(3)(init) invalide");
		
		checkInvariants();
	}
	
	public void doRotateLeft(){
		checkInvariants();
		if (super.isBlock() == false || super.canRotateLeft() == false)
			throw new Error("[BOARD]pre(1)(doRotateLeft) invalide");
		
		super.doRotateLeft();
		
		checkInvariants();
	}
	
	public void doLeft(){
		checkInvariants();
		if (super.isBlock() == false || super.cangoLeft() == false)
			throw new Error("[BOARD]pre(1)(doLeft) invalide");
		
		super.doLeft();
		
		checkInvariants();
	}
	
	public void doRotateRight(){
		checkInvariants();
		if (super.isBlock() == false || super.canRotateRight() == false)
			throw new Error("[BOARD]pre(1)(doRotateRight) invalide");
		
		super.canRotateRight();
		
		checkInvariants();
	}
	
	public void doRight(){
		checkInvariants();
		if (super.isBlock() == false || super.cangoRight() == false)
			throw new Error("[BOARD]pre(1)(doRight) invalide");
		
		super.doRight();
		
		checkInvariants();
	}
	
	public void doBottom(){
		checkInvariants();
		if (super.isBlock() == false)
			throw new Error("[BOARD]pre(1)(doBottom) invalide");
		
		super.doBottom();
		
		checkInvariants();
	}
	
	public void step(){
		checkInvariants();
		if(super.isBlock() == false)
			throw new Error("[BOARD]pre(1)(step) invalide");
		
		super.step();
		
		checkInvariants();
	}
	
	public void insert(BlockContract bloc){
		checkInvariants();
		if (super.isBlock() == true)
			throw new Error("[BOARD]pre(1)(insert) invalide");
		
		super.insert(bloc);
		
		/*post: Block:init(Random {2,3,4}) Vérif*/
		if (super.isBlock() == false)
			throw new Error("[BOARD]post(1)(insert) invalide");
		if (super.getcurrentBlock() != bloc)
			throw new Error("[BOARD]post(2)(insert) invalide");
		checkInvariants();
	}
	
	public void remove(){
		checkInvariants();
		
		if(super.isBlock() == false)
			throw new Error("[BOARD]pre(1)(remove) invalide");
		
		super.remove();
		
		if (super.isBlock() != false)
			throw new Error("[BOARD]post(1)(remove) invalide");
		
		checkInvariants();
	}
	
}
