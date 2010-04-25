package board;

import block.BlockContract;
import grid.GridContract;
import grid.GridImpl;
import java.util.LinkedList;

public class BoardImpl implements BoardService {

	private int XMinBlock;
	private int YMinBlock;
	private int NbLastCleaned;
	private boolean Conflict;
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
		int x = getXblock(bloc.getXMin());
		for(int y=1;y<=bloc.getSize();y++){
			if (bloc.hasPos(bloc.getXMin(), y) && !grid.canPut(x-1, y))
				return false;
		}
		return true;
	}

	@Override
	public boolean cangoRight() {
		int x = getXblock(bloc.getXMax());
		for(int y=1;y<=bloc.getSize();y++){
			if (bloc.hasPos(bloc.getXMax(), y) && !grid.canPut(x+1, y))
				return false;
		}
		return true;
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
		int length = getBottomHeight();
		for(LinkedList<Integer> p: bloc.getAllPos()){
			int x = getXblock(p.getFirst());
			int y = getYblock(p.getLast());
			grid.remove(x, y);
			grid.put(x, y+length);
		}
		this.YMinBlock += length;
	}

	@Override
	public void doLeft() {
		for(LinkedList<Integer> p: bloc.getAllPos()){
			int x = getXblock(p.getFirst());
			int y = getYblock(p.getLast());
			grid.remove(x, y);
			grid.put(x-1, y);
		}
		this.XMinBlock -= 1;
	}

	@Override
	public void doRight() {
		for(LinkedList<Integer> p: bloc.getAllPos()){
			int x = getXblock(p.getFirst());
			int y = getYblock(p.getLast());
			grid.remove(x, y);
			grid.put(x+1, y);
		}
		this.XMinBlock += 1;
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
		for(LinkedList<Integer> p: bloc.getAllPos()){
			int x = getXblock(p.getFirst());
			int y = getYblock(p.getLast());
			grid.remove(x, y);
			grid.put(x, y+1);
		}
		this.XMinBlock -= 1;
	}

	@Override
	public BlockContract getcurrentBlock() {
		return this.bloc;
	}

	@Override
	public void insert(BlockContract bloc) {
		this.bloc = bloc;
		for(LinkedList<Integer> p: bloc.getAllPos())
		{
			int x = getXblock(p.getFirst());
			int y = getYblock(p.getLast());
			if (!this.grid.isOccupied(x, y))
				this.grid.put(x, y);
			else{
				this.Conflict = true;
				break;
			}
		}
		this.XMinBlock = grid.getWidth() - (3 + bloc.getSize());
		this.YMinBlock = 1;
	}

	@Override
	public int getBottomHeight() {
		// TODO A vérifier
		int length = 1;
		//boolean found = false;
		while(true){
			for(LinkedList<Integer> p: bloc.getLowPos()){
				int x = getXblock(p.getFirst());
				int y = getYblock(p.getLast())+length;
				if (!grid.canPut(x, y))
					return length;
			}
			length += 1;
		}
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
			if (getgrid().isOccupied(getXblock(p.getFirst()), getYblock(p.getLast())+1))
				return true;
		}
		return false;
	}
	
	public boolean isConflict(){
		return this.Conflict;
	}

}
