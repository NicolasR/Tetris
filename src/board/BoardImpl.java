package board;

import block.BlockContract;
import grid.GridContract;
import grid.GridImpl;
import java.util.LinkedList;

public class BoardImpl implements BoardService {

	private int XMinBlock;
	private int YMinBlock;
	private int NbLastCleaned;
	private BlockContract bloc;
	private GridContract grid;
	
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
		return this.XMinBlock+(x-1);
	}

	@Override
	public int getYblock(int y) {
		return this.YMinBlock+(y-1);
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
		bloc.rotateLeft();
	}

	@Override
	public void doRotateRight() {
		bloc.rotateRight();
	}

	@Override
	public int getNbLastCleaned() {
		return this.NbLastCleaned;
	}

	@Override
	public GridContract getgrid() {
		return this.grid;
	}

	@Override
	public void init(int x, int y) {
		bloc = null;
		grid = new GridContract(new GridImpl());
		grid.init(x, y);
		NbLastCleaned = 0;
		XMinBlock = 0;
		YMinBlock = 0;
	}

	@Override
	public boolean isBlock() {
		return this.bloc == null;
	}

	@Override
	public void remove() {
		this.bloc = null;
		XMinBlock = 0;
		YMinBlock = 0;
	}

	@Override
	public void step() {
		// TODO Auto-generated method stub

	}

	@Override
	public BlockContract getcurrentBlock() {
		return this.bloc;
	}

	@Override
	public void insert(BlockContract bloc) {
		this.bloc = bloc;
	}

	@Override
	public int getBottomHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getXMinBlock() {
		return this.XMinBlock;
	}

	@Override
	public int getYMinBlock() {
		return this.YMinBlock;
	}

	@Override
	public boolean isBottom() {
		for(LinkedList<Integer> p: bloc.getAllPos()){
			if (getgrid().isOccupied(p.getFirst()+1, p.getLast()+1))
				return true;
		}
		return false;
	}

}
