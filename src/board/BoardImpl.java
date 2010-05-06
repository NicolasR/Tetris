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
	
	public boolean canRotateLeft_old() {
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
			if(1 <= x && x <= grid.getWidth() && 1 <= y && y <= grid.getHeight()) {
				if(this.grid.isOccupied(x, y)) {
					canRotate = false;
					break;
				}
			} else {
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
	
	public boolean canRotateLeft() {
		int[][] newPos = new int[4][2];
		
		switch(bloc.getType()) {
			case 'O' : return true; 
			case 'L' : 
				if((bloc.getYMin() == 1) && (bloc.getYMax() == 3)) {
					if(bloc.hasPos(3, 3)) {
						newPos[0][0] = 1;
						newPos[0][1] = 2;
						newPos[1][0] = 2;
						newPos[1][1] = 2;
						newPos[2][0] = 3;
						newPos[2][1] = 1;
						newPos[3][0] = 3;
						newPos[3][1] = 2;
					} else { 
						newPos[0][0] = 1;
						newPos[0][1] = 2;
						newPos[1][0] = 1;
						newPos[1][1] = 3;
						newPos[2][0] = 2;
						newPos[2][1] = 2;
						newPos[3][0] = 3;
						newPos[3][1] = 2;
					}
				} else {
					if(bloc.hasPos(3, 1)) {
						newPos[0][0] = 1;
						newPos[0][1] = 1;
						newPos[1][0] = 2;
						newPos[1][1] = 1;
						newPos[2][0] = 2;
						newPos[2][1] = 2;
						newPos[3][0] = 2;
						newPos[3][1] = 3;
					} else { 
						newPos[0][0] = 2;
						newPos[0][1] = 1;
						newPos[1][0] = 2;
						newPos[1][1] = 2;
						newPos[2][0] = 2;
						newPos[2][1] = 3;
						newPos[3][0] = 3;
						newPos[3][1] = 3;
					}
				}
				break;
			case 'J' : 
				if((bloc.getYMin() == 1) && (bloc.getYMax() == 3)) {
					if(bloc.hasPos(1, 3)) {
						newPos[0][0] = 1;
						newPos[0][1] = 2;
						newPos[1][0] = 2;
						newPos[1][1] = 2;
						newPos[2][0] = 3;
						newPos[2][1] = 2;
						newPos[3][0] = 3;
						newPos[3][1] = 3;
					} else { 
						newPos[0][0] = 1;
						newPos[0][1] = 1;
						newPos[1][0] = 1;
						newPos[1][1] = 2;
						newPos[2][0] = 2;
						newPos[2][1] = 2;
						newPos[3][0] = 3;
						newPos[3][1] = 2;
					}
				} else {
					if(bloc.hasPos(1, 1)) {
						newPos[0][0] = 1;
						newPos[0][1] = 3;
						newPos[1][0] = 2;
						newPos[1][1] = 1;
						newPos[2][0] = 2;
						newPos[2][1] = 2;
						newPos[3][0] = 2;
						newPos[3][1] = 3;
					} else {
						newPos[0][0] = 2;
						newPos[0][1] = 1;
						newPos[1][0] = 2;
						newPos[1][1] = 2;
						newPos[2][0] = 2;
						newPos[2][1] = 3;
						newPos[3][0] = 3;
						newPos[3][1] = 1;
					}
				}
				break;
			case 'T' :
				if((bloc.getXMin() == 1) && (bloc.getXMax() == 3)) {
					if(bloc.hasPos(2, 3)) {
						newPos[0][0] = 2;
						newPos[0][1] = 1;
						newPos[1][0] = 2;
						newPos[1][1] = 2;
						newPos[2][0] = 2;
						newPos[2][1] = 3;
						newPos[3][0] = 3;
						newPos[3][1] = 2;
					} else { 
						newPos[0][0] = 1;
						newPos[0][1] = 2;
						newPos[1][0] = 2;
						newPos[1][1] = 1;
						newPos[2][0] = 2;
						newPos[2][1] = 2;
						newPos[3][0] = 2;
						newPos[3][1] = 3;						
					}
				} else {
					if(bloc.hasPos(1, 2)) {
						newPos[0][0] = 1;
						newPos[0][1] = 2;
						newPos[1][0] = 2;
						newPos[1][1] = 2;
						newPos[2][0] = 2;
						newPos[2][1] = 3;
						newPos[3][0] = 3;
						newPos[3][1] = 2;
					} else { 
						newPos[0][0] = 1;
						newPos[0][1] = 2;
						newPos[1][0] = 2;
						newPos[1][1] = 1;
						newPos[2][0] = 2;
						newPos[2][1] = 2;
						newPos[3][0] = 3;
						newPos[3][1] = 2;
					}
				}
				break;
			case 'Z' :
				if(bloc.getXMax() == 3) {
					newPos[0][0] = 1;
					newPos[0][1] = 2;
					newPos[1][0] = 1;
					newPos[1][1] = 3;
					newPos[2][0] = 2;
					newPos[2][1] = 1;
					newPos[3][0] = 2;
					newPos[3][1] = 2;
				} else {
					newPos[0][0] = 1;
					newPos[0][1] = 2;
					newPos[1][0] = 2;
					newPos[1][1] = 2;
					newPos[2][0] = 2;
					newPos[2][1] = 3;
					newPos[3][0] = 3;
					newPos[3][1] = 3;
				}
				break;
			case 'S' :
				if(bloc.getXMax() == 3) {
					newPos[0][0] = 1;
					newPos[0][1] = 1;
					newPos[1][0] = 1;
					newPos[1][1] = 2;
					newPos[2][0] = 2;
					newPos[2][1] = 2;
					newPos[3][0] = 2;
					newPos[3][1] = 3;
				} else {
					newPos[0][0] = 1;
					newPos[0][1] = 3;
					newPos[1][0] = 2;
					newPos[1][1] = 2;
					newPos[2][0] = 2;
					newPos[2][1] = 3;
					newPos[3][0] = 3;
					newPos[3][1] = 2;
				}
				break;
			case 'I' : 			
				if(bloc.getXMin() == bloc.getXMax()) {
					newPos[0][0] = 1;
					newPos[0][1] = 2;
					newPos[1][0] = 2;
					newPos[1][1] = 2;
					newPos[2][0] = 3;
					newPos[2][1] = 2;
					newPos[3][0] = 4;
					newPos[3][1] = 2;
				} else {
					newPos[0][0] = 2;
					newPos[0][1] = 1;
					newPos[1][0] = 2;
					newPos[1][1] = 2;
					newPos[2][0] = 2;
					newPos[2][1] = 3;
					newPos[3][0] = 2;
					newPos[3][1] = 4;
				}			
				break;
			default : return false;
		}
		
		int x, y;
		for(int i=0; i<4; i++) {
				x = newPos[i][0];
				y = newPos[i][1];
				if(1 <= getXblock(x) && getXblock(x) <= grid.getWidth() && 1 <= getYblock(y) && getYblock(y) <= grid.getHeight()) {
					if(!bloc.hasPos(x, y) && this.grid.isOccupied(getXblock(x), getYblock(y))) {
						return false;
					}
				} else {
					return false;
				}
			
		}		
		return true;
	}

	public boolean canRotateRight_old() {
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
			if(1 <= x && x <= grid.getWidth() && 1 <= y && y <= grid.getHeight()) {
				if(this.grid.isOccupied(x, y)) {
					canRotate = false;
					break;
				}
			} else {
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

	public boolean canRotateRight() {
		int[][] newPos = new int[4][2];
		
		switch(bloc.getType()) {
			case 'O' : return true; 
			case 'L' : 
				if((bloc.getYMin() == 1) && (bloc.getYMax() == 3)) {
					if(bloc.hasPos(3, 3)) {
						newPos[0][0] = 1;
						newPos[0][1] = 2;
						newPos[1][0] = 1;
						newPos[1][1] = 3;
						newPos[2][0] = 2;
						newPos[2][1] = 2;
						newPos[3][0] = 3;
						newPos[3][1] = 2;
					} else { 
						newPos[0][0] = 1;
						newPos[0][1] = 2;
						newPos[1][0] = 2;
						newPos[1][1] = 2;
						newPos[2][0] = 3;
						newPos[2][1] = 1;
						newPos[3][0] = 3;
						newPos[3][1] = 2;
					}
				} else {
					if(bloc.hasPos(3, 1)) {
						newPos[0][0] = 2;
						newPos[0][1] = 1;
						newPos[1][0] = 2;
						newPos[1][1] = 2;
						newPos[2][0] = 2;
						newPos[2][1] = 3;
						newPos[3][0] = 3;
						newPos[3][1] = 3;
					} else { 
						newPos[0][0] = 1;
						newPos[0][1] = 1;
						newPos[1][0] = 2;
						newPos[1][1] = 1;
						newPos[2][0] = 2;
						newPos[2][1] = 2;
						newPos[3][0] = 2;
						newPos[3][1] = 3;
					}
				}
				break;
			case 'J' : 
				if((bloc.getYMin() == 1) && (bloc.getYMax() == 3)) {
					if(bloc.hasPos(1, 3)) {
						newPos[0][0] = 1;
						newPos[0][1] = 1;
						newPos[1][0] = 1;
						newPos[1][1] = 2;
						newPos[2][0] = 2;
						newPos[2][1] = 2;
						newPos[3][0] = 3;
						newPos[3][1] = 2;
					} else { 
						newPos[0][0] = 1;
						newPos[0][1] = 2;
						newPos[1][0] = 2;
						newPos[1][1] = 2;
						newPos[2][0] = 3;
						newPos[2][1] = 2;
						newPos[3][0] = 3;
						newPos[3][1] = 3;
					}
				} else {
					if(bloc.hasPos(1, 1)) {
						newPos[0][0] = 2;
						newPos[0][1] = 1;
						newPos[1][0] = 2;
						newPos[1][1] = 2;
						newPos[2][0] = 2;
						newPos[2][1] = 3;
						newPos[3][0] = 3;
						newPos[3][1] = 1;
					} else {
						newPos[0][0] = 1;
						newPos[0][1] = 3;
						newPos[1][0] = 2;
						newPos[1][1] = 1;
						newPos[2][0] = 2;
						newPos[2][1] = 2;
						newPos[3][0] = 2;
						newPos[3][1] = 3;
					}
				}
				break;
			case 'T' :
				if((bloc.getXMin() == 1) && (bloc.getXMax() == 3)) {
					if(bloc.hasPos(2, 3)) {
						newPos[0][0] = 1;
						newPos[0][1] = 2;
						newPos[1][0] = 2;
						newPos[1][1] = 1;
						newPos[2][0] = 2;
						newPos[2][1] = 2;
						newPos[3][0] = 2;
						newPos[3][1] = 3;
					} else { 
						newPos[0][0] = 2;
						newPos[0][1] = 1;
						newPos[1][0] = 2;
						newPos[1][1] = 2;
						newPos[2][0] = 2;
						newPos[2][1] = 3;
						newPos[3][0] = 3;
						newPos[3][1] = 2;						
					}
				} else {
					if(bloc.hasPos(1, 2)) {
						newPos[0][0] = 1;
						newPos[0][1] = 2;
						newPos[1][0] = 2;
						newPos[1][1] = 1;
						newPos[2][0] = 2;
						newPos[2][1] = 2;
						newPos[3][0] = 3;
						newPos[3][1] = 2;
					} else { 
						newPos[0][0] = 1;
						newPos[0][1] = 2;
						newPos[1][0] = 2;
						newPos[1][1] = 2;
						newPos[2][0] = 2;
						newPos[2][1] = 3;
						newPos[3][0] = 3;
						newPos[3][1] = 2;
					}
				}
				break;
			case 'Z' :
				if(bloc.getXMax() == 3) {
					newPos[0][0] = 1;
					newPos[0][1] = 2;
					newPos[1][0] = 1;
					newPos[1][1] = 3;
					newPos[2][0] = 2;
					newPos[2][1] = 1;
					newPos[3][0] = 2;
					newPos[3][1] = 2;
				} else {
					newPos[0][0] = 1;
					newPos[0][1] = 2;
					newPos[1][0] = 2;
					newPos[1][1] = 2;
					newPos[2][0] = 2;
					newPos[2][1] = 3;
					newPos[3][0] = 3;
					newPos[3][1] = 3;
				}
				break;
			case 'S' :
				if(bloc.getXMax() == 3) {
					newPos[0][0] = 1;
					newPos[0][1] = 1;
					newPos[1][0] = 1;
					newPos[1][1] = 2;
					newPos[2][0] = 2;
					newPos[2][1] = 2;
					newPos[3][0] = 2;
					newPos[3][1] = 3;
				} else {
					newPos[0][0] = 1;
					newPos[0][1] = 3;
					newPos[1][0] = 2;
					newPos[1][1] = 2;
					newPos[2][0] = 2;
					newPos[2][1] = 3;
					newPos[3][0] = 3;
					newPos[3][1] = 2;
				}
				break;
			case 'I' : 			
				if(bloc.getXMin() == bloc.getXMax()) {
					newPos[0][0] = 1;
					newPos[0][1] = 2;
					newPos[1][0] = 2;
					newPos[1][1] = 2;
					newPos[2][0] = 3;
					newPos[2][1] = 2;
					newPos[3][0] = 4;
					newPos[3][1] = 2;
				} else {
					newPos[0][0] = 2;
					newPos[0][1] = 1;
					newPos[1][0] = 2;
					newPos[1][1] = 2;
					newPos[2][0] = 2;
					newPos[2][1] = 3;
					newPos[3][0] = 2;
					newPos[3][1] = 4;
				}			
				break;
			default : return false;
		}
		
		int x, y;
		for(int i=0; i<4; i++) {
				x = newPos[i][0];
				y = newPos[i][1];
				if(1 <= getXblock(x) && getXblock(x) <= grid.getWidth() && 1 <= getYblock(y) && getYblock(y) <= grid.getHeight()) {
					if(!bloc.hasPos(x, y) && this.grid.isOccupied(getXblock(x), getYblock(y))) {
						return false;
					}
				} else {
					return false;
				}
			
		}		
		return true;
	}

	
	@Override
	public boolean cangoLeft() {
		for(int x=2; x<=bloc.getSize(); x++) {
			for(int y=1;y<=bloc.getSize();y++){
				if(bloc.hasPos(x, y)) {
					if(!bloc.hasPos(x-1, y) && !grid.canPut(getXblock(x)-1, getYblock(y))) {
						return false;
					}
				}
			}
		}
		for(int y=1;y<=bloc.getSize();y++){
			if(bloc.hasPos(1, y)) {
				if(!grid.canPut(getXblock(1)-1, getYblock(y))) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public boolean cangoRight() {
		for(int x=1; x<=bloc.getSize()-1; x++) {
			for(int y=1;y<=bloc.getSize();y++){
				if(bloc.hasPos(x, y)) {
					if(!bloc.hasPos(x+1, y) && !grid.canPut(getXblock(x)+1, getYblock(y))) {
						return false;
					}
				}
			}
		}
		for(int y=1;y<=bloc.getSize();y++){
			if(bloc.hasPos(bloc.getSize(), y)) {
				if(!grid.canPut(getXblock(bloc.getSize())+1, getYblock(y))) {
					return false;
				}
			}
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
		for(LinkedList<Integer> p: bloc.getAllPos()){
			int x = getXblock(p.getFirst());
			int y = getYblock(p.getLast());
			grid.remove(x, y);
		}
		bloc.rotateRight();
		for(LinkedList<Integer> p: bloc.getAllPos()){
			int x = getXblock(p.getFirst());
			int y = getYblock(p.getLast());
			grid.put(x, y);
		}
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
		if(isBottom()) {
			clean();
		}
		else
		{
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
		}
	}
	
	public void clean() {
		this.NbLastCleaned = 0;
		boolean full;
		int min = getYblock(bloc.getYMin());
		int max = getYblock(bloc.getYMax());
		for(int j=min; j<=max; j++) {
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
					for(int k=j-1; k>1; k--) {
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
		this.XMinBlock = grid.getWidth() - (2 + bloc.getSize());
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
