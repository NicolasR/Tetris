package board;

import grid.GridContract;
import grid.GridImpl;

import java.util.LinkedList;

import block.BlockContract;

public class BoardImpl implements BoardService {

	private int XMinBlock;
	private int YMinBlock;
	private int NbLastCleaned;
	private boolean Conflict;
	private BlockContract bloc;
	private GridContract grid;
	
	@Override
	public boolean canRotateLeft() {
		boolean canRotate = true;
		for(LinkedList<Integer> p: bloc.getAllPos()) {
			int x = getXblock(p.getFirst());
			int y = getYblock(p.getLast());
			grid.remove(x, y);
		}		
		bloc.rotateLeft();
		for(LinkedList<Integer> p: bloc.getAllPos()) {
			int x = getXblock(p.getFirst());
			int y = getYblock(p.getLast());
			if(this.grid.isOccupied(x, y)) {
				canRotate = false;
				break;
			}
		}		
		bloc.rotateRight();
		for(LinkedList<Integer> p: bloc.getAllPos()) {
			int x = getXblock(p.getFirst());
			int y = getYblock(p.getLast());
			grid.put(x, y);
		}
		return canRotate;
	}

	@Override
	public boolean canRotateRight() {
		boolean canRotate = true;
		for(LinkedList<Integer> p: bloc.getAllPos()) {
			int x = getXblock(p.getFirst());
			int y = getYblock(p.getLast());
			grid.remove(x, y);
		}		
		bloc.rotateRight();
		for(LinkedList<Integer> p: bloc.getAllPos()) {
			int x = getXblock(p.getFirst());
			int y = getYblock(p.getLast());
			if(this.grid.isOccupied(x, y)) {
				canRotate = false;
				break;
			}
		}		
		bloc.rotateLeft();
		for(LinkedList<Integer> p: bloc.getAllPos()) {
			int x = getXblock(p.getFirst());
			int y = getYblock(p.getLast());
			grid.put(x, y);
		}
		return canRotate;
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
		}
		for(LinkedList<Integer> p: bloc.getAllPos()){
			int x = getXblock(p.getFirst());
			int y = getYblock(p.getLast());
			grid.put(x, y+length);
		}
		this.YMinBlock += length;
		clean();
	}

	@Override
	public void doLeft() {
		for(LinkedList<Integer> p: bloc.getAllPos()){
			int x = getXblock(p.getFirst());
			int y = getYblock(p.getLast());
			grid.remove(x, y);
		}
		for(LinkedList<Integer> p: bloc.getAllPos()){
			int x = getXblock(p.getFirst());
			int y = getYblock(p.getLast());
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
		}
		for(LinkedList<Integer> p: bloc.getAllPos()){
			int x = getXblock(p.getFirst());
			int y = getYblock(p.getLast());
			grid.put(x+1, y);
		}
		this.XMinBlock += 1;
	}

	@Override
	public void doRotateLeft() {
		for(LinkedList<Integer> p: bloc.getAllPos()){
			int x = getXblock(p.getFirst());
			int y = getYblock(p.getLast());
			grid.remove(x, y);
		}
		bloc.rotateLeft();
		for(LinkedList<Integer> p: bloc.getAllPos()){
			int x = getXblock(p.getFirst());
			int y = getYblock(p.getLast());
			grid.put(x, y);
		}
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
		return this.bloc != null;
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
		}
		for(LinkedList<Integer> p: bloc.getAllPos()){
			int x = getXblock(p.getFirst());
			int y = getYblock(p.getLast());
			grid.put(x, y+1);
		}
		this.YMinBlock += 1;
		if(isBottom()) {
			clean();
		}
	}
	
	public void clean() {
		this.NbLastCleaned = 0;
		boolean full;
		for(int j=YMinBlock; j<=YMinBlock+bloc.getSize()-1; j++) {
			full = true;
			for(int i=1; i<=grid.getWidth(); i++) {
				if(!grid.isOccupied(i, j)) {
					full = false;
					break;
				}
			}
			if(full) {
				this.NbLastCleaned++;
				for(int i=1; i<=grid.getWidth(); i++) {
					grid.remove(i, j);
					for(int k=j-1; k>=1; k++) {
						if(grid.isOccupied(i, k)) {
							grid.remove(i, k);
							grid.put(i, k+1);
						}
					}
				}
				
			}
		}
	}

	@Override
	public BlockContract getcurrentBlock() {
		return this.bloc;
	}

	@Override
	public void insert(BlockContract bloc) {
		this.bloc = bloc;
		this.XMinBlock = grid.getWidth() - (3 + bloc.getSize());
		this.YMinBlock = 1;
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
	}

	@Override
	public int getBottomHeight() {
		int length = 1;
		while(true){
			for(LinkedList<Integer> p: bloc.getLowPos()){
				int x = getXblock(p.getFirst());
				int y = getYblock(p.getLast())+length;
				if (!grid.canPut(x, y))
					return length-1;
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
		for(LinkedList<Integer> p: bloc.getLowPos()){
			if((getYblock(p.getLast()) == grid.getHeight()) || (getgrid().isOccupied(getXblock(p.getFirst()), getYblock(p.getLast())+1)))
				return true;
		}
		return false;
	}
	
	public boolean isConflict(){
		return this.Conflict;
	}

}
