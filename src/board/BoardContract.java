package board;

import grid.GridContract;
import block.BlockContract;

public class BoardContract extends BoardDecorator {

	public BoardContract(BoardService f) {
		super(f);
	}

	
	public void checkInvariants(){
		BlockContract block = super.getcurrentBlock();
		if (super.isBlock())
		{
			if (!(1<= super.getXblock(block.getXMin())  && super.getXblock(block.getXMax()) <= super.getgrid().getWidth()+1)) {
				throw new Error("[BOARD]invariant(1) invalide");
			}
			
			if (!(1<= super.getYblock(block.getYMin())  && super.getYblock(block.getYMax()) <= super.getgrid().getHeight()+1))
					throw new Error("[BOARD]invariant(2) invalide");
		}
				
		if (!(super.getNbLastCleaned() >= 0)) {
				throw new Error("[BOARD]invariant(3) invalide");
		}
	}
	
	
	public void init(int x, int y){
		if (!(x > 0 && y > 0 && y >= x)) {
			throw new Error("[BOARD]pre(1)(init) invalide");
		}
		super.init(x, y);
		checkInvariants();
		
		//POST Grid:init
		if (!(getgrid().getWidth() == x && getgrid().getHeight() == y))
			throw new Error("[BOARD]post(1.1)(init) invalide");
		
		for (int xtemp=1;xtemp <= getgrid().getWidth();xtemp++){
			for (int ytemp=1;ytemp <= getgrid().getHeight();ytemp++){
				if (!(!getgrid().isOccupied(xtemp,ytemp) && getgrid().canPut(xtemp, ytemp)))
					throw new Error("[BOARD]post(1.2)(init) invalide");
			}
		}
		
		if (!(super.isBlock() == false)) {
			throw new Error("[BOARD]post(2)(init) invalide");
		}
		if (!(super.getgrid().getWidth() == x && super.getgrid().getHeight() == y)) {
			throw new Error("[BOARD]post(3)(init) invalide");
		}
		if (!(super.getNbLastCleaned() == 0)) {
			throw new Error("[BOARD]post(4)(init) invalide");
		}
		if (!(super.getXMinBlock() == 0 && super.getYMinBlock() == 0)) {
			throw new Error("[BOARD]post(5)(init) invalide");
		}
	}
	
	
	public void doRotateLeft(){
		if (!(super.isBlock() && super.canRotateLeft())) {
			throw new Error("[BOARD]pre(1)(doRotateLeft) invalide");
		}
		checkInvariants();
		BlockContract getcurrentBlock_atPre = super.getcurrentBlock();
		GridContract getgrid_atPre = super.getgrid();
		int getNbLastCleaned_atPre = super.getNbLastCleaned();
		boolean isBlock_atPre = super.isBlock();
		int getXMinBlock_atPre = super.getXMinBlock();
		int getYMinBlock_atPre = super.getYMinBlock();
		
		char getType_atPre = getcurrentBlock().getType();
		int getSize_atPre = getcurrentBlock().getSize();
		int getNbPos_atPre = getcurrentBlock().getNbPos();
		
		super.doRotateLeft();
		checkInvariants();
		
		if(!(super.getcurrentBlock() == getcurrentBlock_atPre)) {
			throw new Error("[BOARD]post(1)(doRotateLeft) invalide");
		}
		if(!(super.getgrid() == getgrid_atPre)) {
			throw new Error("[BOARD]post(2)(doRotateLeft) invalide");
		}
		if(!(super.getNbLastCleaned() == getNbLastCleaned_atPre)) {
			throw new Error("[BOARD]post(3)(doRotateLeft) invalide");
		}
		if(!(super.isBlock() == isBlock_atPre)) {
			throw new Error("[BOARD]post(4)(doRotateLeft) invalide");
		}
		if (!(super.getXMinBlock() == getXMinBlock_atPre)) {
			throw new Error("[BOARD]post(5)(doRotateLeft) invalide");
		}
		if (!(super.getYMinBlock() == getYMinBlock_atPre)) {
			throw new Error("[BOARD]post(6)(doRotateLeft) invalide");
		}
		
		//block:rotateLeft
		BlockContract block = getcurrentBlock();
		if(!(block.getType() == getType_atPre)) {
			throw new Error("[BOARD]post(7.1)(doRotateLeft) invalide");
		}
		if(!(block.getSize() == getSize_atPre)) {
			throw new Error("[BOARD]post(7.2)(doRotateLeft) invalide");
		}
		if(!(block.getNbPos() == getNbPos_atPre)) {
			throw new Error("[BOARD]post(7.3)(doRotateLeft) invalide");
		}
	}

		
	public void doLeft(){
		if(!(super.isBlock() && super.cangoLeft())) {
			throw new Error("[BOARD]pre(1)(doLeft) invalide");
		}
		checkInvariants();
		BlockContract getcurrentBlock_atPre = super.getcurrentBlock();
		GridContract getgrid_atPre = super.getgrid();
		int getNbLastCleaned_atPre = super.getNbLastCleaned();
		boolean isBlock_atPre = super.isBlock();
		int getXMinBlock_atPre = super.getXMinBlock();
		int getYMinBlock_atPre = super.getYMinBlock();
		super.doLeft();
		checkInvariants();
		if(!(super.getcurrentBlock() == getcurrentBlock_atPre)) {
			throw new Error("[BOARD]post(1)(doLeft) invalide");
		}
		if(!(super.getgrid() == getgrid_atPre)) {
			throw new Error("[BOARD]post(2)(doLeft) invalide");
		}
		if(!(super.getNbLastCleaned() == getNbLastCleaned_atPre)) {
			throw new Error("[BOARD]post(3)(doLeft) invalide");
		}
		if(!(super.isBlock() == isBlock_atPre)) {
			throw new Error("[BOARD]post(4)(doLeft) invalide");
		}
		if (!(super.getXMinBlock() == getXMinBlock_atPre-1)) {
			throw new Error("[BOARD]post(5)(doLeft) invalide");
		}
		if (!(super.getYMinBlock() == getYMinBlock_atPre)) {
			throw new Error("[BOARD]post(6)(doLeft) invalide");
		}
	}
	
	
	public void doRotateRight(){
		if (!(super.isBlock() && super.canRotateRight())) {
			throw new Error("[BOARD]pre(1)(doRotateRight) invalide");
		}
		checkInvariants();
		BlockContract getcurrentBlock_atPre = super.getcurrentBlock();
		GridContract getgrid_atPre = super.getgrid();
		int getNbLastCleaned_atPre = super.getNbLastCleaned();
		boolean isBlock_atPre = super.isBlock();
		int getXMinBlock_atPre = super.getXMinBlock();
		int getYMinBlock_atPre = super.getYMinBlock();
		super.doRotateRight();
		checkInvariants();
		if(!(super.getcurrentBlock() == getcurrentBlock_atPre)) {
			throw new Error("[BOARD]post(1)(doRotateRight) invalide");
		}
		if(!(super.getgrid() == getgrid_atPre)) {
			throw new Error("[BOARD]post(2)(doRotateRight) invalide");
		}
		if(!(super.getNbLastCleaned() == getNbLastCleaned_atPre)) {
			throw new Error("[BOARD]post(3)(doRotateRight) invalide");
		}
		if(!(super.isBlock() == isBlock_atPre)) {
			throw new Error("[BOARD]post(4)(doRotateRight) invalide");
		}
		if (!(super.getXMinBlock() == getXMinBlock_atPre)) {
			throw new Error("[BOARD]post(5)(doRotateRight) invalide");
		}
		if (!(super.getYMinBlock() == getYMinBlock_atPre)) {
			throw new Error("[BOARD]post(6)(doRotateRight) invalide");
		}
	}
	
	public void doRight(){
		if(!(super.isBlock() && super.cangoRight())) {
			throw new Error("[BOARD]pre(1)(doRight) invalide");
		}
		checkInvariants();
		BlockContract getcurrentBlock_atPre = super.getcurrentBlock();
		GridContract getgrid_atPre = super.getgrid();
		int getNbLastCleaned_atPre = super.getNbLastCleaned();
		boolean isBlock_atPre = super.isBlock();
		int getXMinBlock_atPre = super.getXMinBlock();
		int getYMinBlock_atPre = super.getYMinBlock();
		super.doRight();
		checkInvariants();
		if(!(super.getcurrentBlock() == getcurrentBlock_atPre)) {
			throw new Error("[BOARD]post(1)(doRight) invalide");
		}
		if(!(super.getgrid() == getgrid_atPre)) {
			throw new Error("[BOARD]post(2)(doRight) invalide");
		}
		if(!(super.getNbLastCleaned() == getNbLastCleaned_atPre)) {
			throw new Error("[BOARD]post(3)(doRight) invalide");
		}
		if(!(super.isBlock() == isBlock_atPre)) {
			throw new Error("[BOARD]post(4)(doRight) invalide");
		}
		if (!( super.getXMinBlock() == getXMinBlock_atPre+1)) {
			throw new Error("[BOARD]post(5)(doRight) invalide");
		}
		if (!(super.getYMinBlock() == getYMinBlock_atPre)) {
			throw new Error("[BOARD]post(6)(doRight) invalide");
		}
	}
	
	
	public void doBottom(){
		if(!(super.isBlock())) {
			throw new Error("[BOARD]pre(1)(doBottom) invalide");
		}
		checkInvariants();
		BlockContract getcurrentBlock_atPre = super.getcurrentBlock();
		GridContract getgrid_atPre = super.getgrid();
		boolean isBlock_atPre = super.isBlock();
		int getXMinBlock_atPre = super.getXMinBlock();
		int getYMinBlock_atPre = super.getYMinBlock();
		int getBottomHeight_atPre = super.getBottomHeight();
		super.doBottom();
		checkInvariants();
		if(!(super.getcurrentBlock() == getcurrentBlock_atPre)) {
			throw new Error("[BOARD]post(1)(doBottom) invalide");
		}
		if(!(super.getgrid() == getgrid_atPre)) {
			throw new Error("[BOARD]post(2)(doBottom) invalide");
		}
		if(!(super.isBlock() == isBlock_atPre)) {
			throw new Error("[BOARD]post(3)(doBottom) invalide");
		}
		if (!(super.getXMinBlock() == getXMinBlock_atPre)) {
			throw new Error("[BOARD]post(4)(doBottom) invalide");
		}
		if (!(super.getYMinBlock() == getYMinBlock_atPre+getBottomHeight_atPre)) {
			throw new Error("[BOARD]post(5)(doBottom) invalide");
		}
		if(!(super.getBottomHeight() == 0 /*|| isBottom()*/)) {
			throw new Error("[BOARD]post(6)(doBottom) invalide");
		}
	}
	
	
	public void step(){
		if(!(super.isBlock())) {
			throw new Error("[BOARD]pre(1)(step) invalide");
		}
		checkInvariants();
		GridContract getgrid_atPre = super.getgrid();
		boolean isBlock_atPre = super.isBlock();
		int getXMinBlock_atPre = super.getXMinBlock();
		int getYMinBlock_atPre = super.getYMinBlock();
		int getBottomHeight_atPre = super.getBottomHeight();
		super.step();
		checkInvariants();
		if(!(super.getgrid() == getgrid_atPre)) {
			throw new Error("[BOARD]post(1)(step) invalide");
		}
		if(!(super.isBlock() == isBlock_atPre)) {
			throw new Error("[BOARD]post(2)(step) invalide");
		}
		if(!(super.getXMinBlock() == getXMinBlock_atPre)) {
			throw new Error("[BOARD]post(3)(step) invalide");
		}
		if (!(super.getYMinBlock() == getYMinBlock_atPre+1)) {
			throw new Error("[BOARD]post(4)(step) invalide");
		}
		if (!(super.getBottomHeight() == getBottomHeight_atPre-1)) {
			throw new Error("[BOARD]post(5)(step) invalide");
		}
	}
	
	
	public void insert(BlockContract block){
		if(!(super.isBlock() == false)) {
			throw new Error("[BOARD]pre(1)(insert) invalide");
		}
		checkInvariants();
		GridContract getgrid_atPre = super.getgrid();
		super.insert(block);
		checkInvariants();
		if(!(super.getcurrentBlock() == block)) {
			throw new Error("[BOARD]post(1)(insert) invalide");
		}
		if(!(super.getgrid() == getgrid_atPre)) {
			throw new Error("[BOARD]post(2)(insert) invalide");
		}
		if(!(super.isBlock())) {
			throw new Error("[BOARD]post(3)(insert) invalide");
		}
	}
	
	public void remove(){
		if(!(super.isBlock())) {
			throw new Error("[BOARD]pre(1)(remove) invalide");
		}
		checkInvariants();
		GridContract getgrid_atPre = super.getgrid();
		int getNbLastCleaned_atPre = super.getNbLastCleaned();
		super.remove();
		checkInvariants();
		if(!(super.getcurrentBlock() == null)) {
			throw new Error("[BOARD]post(1)(remove) invalide");
		}
		if(!(super.getgrid() == getgrid_atPre)) {
			throw new Error("[BOARD]post(2)(remove) invalide");
		}
		if(!(super.getNbLastCleaned() == getNbLastCleaned_atPre)) {
			throw new Error("[BOARD]post(3)(remove) invalide");
		}
		if(!(super.isBlock() == false)) {
			throw new Error("[BOARD]post(4)(remove) invalide");
		}
		if (!(super.getXMinBlock() == 0)) {
			throw new Error("[BOARD]post(5)(remove) invalide");
		}
		if (!(super.getYMinBlock() == 0)) {
			throw new Error("[BOARD]post(6)(remove) invalide");
		}
	}
	public void clean() {
		if(!(super.isBottom())) {
			throw new Error("[BOARD]pre(1)(clean) invalide");
		}
		checkInvariants();
		BlockContract getcurrentBlock_atPre = super.getcurrentBlock();
		GridContract getgrid_atPre = super.getgrid();
		super.clean();
		checkInvariants();
		if(!(super.getcurrentBlock() == getcurrentBlock_atPre)) {
			throw new Error("[BOARD]post(1)(clean) invalide");
		}
		if(!(super.getgrid() == getgrid_atPre)) {
			throw new Error("[BOARD]post(2)(clean) invalide");
		}
	}
	
}
