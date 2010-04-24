package board;

import grid.GridService;

public class BoardImpl implements BoardService {

	private int XBlockMin;
	private int YBlockMin;
	
	@Override
	public boolean canRotateLeft() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean canRotateRight() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cangoLeft() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean cangoRight() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getXblock(int x) {
		return this.XBlockMin+(x-1);
	}

	@Override
	public int getYblock(int y) {
		return this.YBlockMin+(y-1);
	}
	
	@Override
	public void doBottom() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doLeft() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doRight() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doRotateLeft() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doRotateRight() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getNbLastCleaned() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public GridService getgrid() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init(int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isBlock() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub

	}

	@Override
	public void step() {
		// TODO Auto-generated method stub

	}

	@Override
	public BlockContract getcurrentBlock() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(BlockContract bloc) {
		// TODO Auto-generated method stub
		
	}

}
