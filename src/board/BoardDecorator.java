package board;

import block.BlockContract;
import grid.GridContract;

public abstract class BoardDecorator {
	BoardService delegate;
	
	public BoardDecorator(BoardService f){
		this.delegate = f;
	}
	
	public BlockContract getcurrentBlock(){
		return this.delegate.getcurrentBlock();
	}
	
	public int getXMinBlock(){
		return this.delegate.getXMinBlock();
	}
	
	public int getYMinBlock(){
		return this.delegate.getYMinBlock();
	}
	
	public int getBottomHeight(){
		return this.delegate.getBottomHeight();
	}
	
	public GridContract getgrid(){
		return this.delegate.getgrid();
	}
	
	public int getNbLastCleaned(){
		return this.delegate.getNbLastCleaned();
	}
	
	public boolean canRotateLeft(){
		return this.delegate.canRotateLeft();
	}
	
	public boolean canRotateRight(){
		return this.delegate.canRotateRight();
	}
	
	public boolean cangoLeft(){
		return this.delegate.cangoLeft();
	}
	
	public boolean cangoRight(){
		return this.delegate.cangoRight();
	}
	
	public boolean isBlock(){
		return this.delegate.isBlock();
	}
	
	public boolean isBottom(){
		return this.delegate.isBottom();
	}
	
	public boolean isConflict(){
		return this.delegate.isConflict();
	}

	public int getXblock(int x){
		return this.delegate.getXblock(x);
	}
	
	public int getYblock(int y){
		return this.delegate.getYblock(y);
	}
	
	public void init(int x, int y){
		this.delegate.init(x, y);
	}
	
	public void doRotateLeft(){
		this.delegate.doRotateLeft();
	}
	
	public void doLeft(){
		this.delegate.doLeft();
	}
	
	public void doRotateRight(){
		this.delegate.doRotateRight();
	}
	
	public void doRight(){
		this.delegate.doRight();
	}
	
	public void doBottom(){
		this.delegate.doBottom();
	}
	
	public void step(){
		this.delegate.step();
	}
	
	public void insert(BlockContract bloc){
		this.delegate.insert(bloc);
	}
	
	public void remove(){
		this.delegate.remove();
	}
}
