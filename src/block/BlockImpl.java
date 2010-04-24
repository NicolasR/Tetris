package block;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class BlockImpl implements BlockService {

	private int Size;
	private int NbPos;
	private int XMin;
	private int XMax;
	private int YMin;
	private int YMax;
	private boolean[][] Pos;
	
	public int getSize() {
		return this.Size;
	}
	
	public int getNbPos() {
		return this.NbPos;
	}
	
	public int getXMin() {
		return this.XMin;
	}

	public int getXMax() {
		return this.XMax;
	}
	
	public int getYMin() {
		return this.YMin;
	}
	
	public int getYMax() {
		return this.YMax;
	}
	
	public boolean hasPos(int x, int y) {
		return Pos[x-1][y-1];
	}
	
	public Set<LinkedList<Integer>> getAllPos() {
		Set<LinkedList<Integer>> AllPos = new HashSet<LinkedList<Integer>>();
		LinkedList<Integer> paire;
		
		for(int i=0; i<getSize(); i++) {
			for(int j=0; j<getSize(); j++) {
				if(Pos[i][j]) {
					paire = new LinkedList<Integer>();
					paire.addFirst(i+1);
					paire.addLast(j+1);
					AllPos.add(paire);
				}
			}
		}
		return AllPos;		
	}
	
	public Set<LinkedList<Integer>> getLowPos() {
		Set<LinkedList<Integer>> LowPos = new HashSet<LinkedList<Integer>>();
		for(int i=1; i<=getSize(); i++) {
			int max = 0;
			for(int j=1; j<=getSize(); j++) {
				if(hasPos(i,j)) {
					max = j;
				}
			}
			if(max >0) {
				LinkedList<Integer> paire = new LinkedList<Integer>();
				paire.addFirst(i);
				paire.addLast(max);
				LowPos.add(paire);
			}
		}		
		return LowPos;		
	}
	
	public void init(int size) {
		this.Size = size;
		this.NbPos = 0;
		this.Pos = new boolean[size][size];
		for(int i=0; i<getSize(); i++) {
			for(int j=0; j<getSize(); j++) {
				Pos[i][j] = false;
			}
		}
		this.XMin = size+1;
		this.XMax = 0;
		this.YMin = size+1;
		this.YMax = 0;
	}
	
	public void addPos(int x, int y) {
		Pos[x-1][y-1] = true;
		NbPos++;
		if (x > XMax) {
			XMax = x;
		}
		if (x < XMin) {
			XMin = x;
		}
		if (y > YMax) {
			YMax = y;
		}
		if (y < YMin) {
			YMin = y;
		}
	}
	
	public void rotateLeft() {
		
	}
	
	public void rotateRight() {
		
	}

}