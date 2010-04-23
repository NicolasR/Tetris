package block;

import java.util.LinkedList;
import java.util.Set;

public interface BlockService {
	
	/* INVARIANTS */
	// inv1 : getSize() == 2 || getSize() == 3 || getSize() == 4
	// inv2 : 0 <= NbPos()
	// inv3 : getXMin() == \findmin { first(p) \in getAllPos() }
	// inv4 : getXMax() == \findmax { first(p) \in getAllPos() }
	// inv5 : getYMin() ==\findmin { second(p) \in getAllPos() }
	// inv6 : getYMax() == \findmax { second(p) \in getAllPos() }
	// inv7 : \forall x:int, y:int \in getHasPos((x,y)) { getAllPos().contains((x,y)) }  
	// inv8 : \forall x:int, y1:int, y2:int \in getHasPos((x,y1)) && getHasPos((x,y2)) { getLowPos().contains((x,max(y1,y2))) }
	
	/* OBSERVATORS */
	public int getSize();
	
	public int getNbPos();
	
	public int getXMin();

	public int getXMax();
	
	public int getYMin();
	
	public int getYMax();
	
	// Pre : 1 <= x && x <= getSize() && 1 <= y && y <= getSize()
	public boolean hasPos(int x, int y);
	
	public Set<LinkedList<Integer>> getAllPos();
	
	public Set<LinkedList<Integer>> getLowPos();
	
	/* CONSTRUCTORS */
	// Pre : size == 2 || size == 3 || size == 4
	// Post1 : getSize() == size
	// Post2 : getNbPos() == 0
	// Post3 : \forall x:int in [1,size] { \forall y:int in [1,size] { !hasPos(x,y) } }
	public void init(int size);
	
	/* OPERATORS */
	// Pre : 1 <= x && x <= getSize() && 1 <= y && y <= getSize() && !hasPos(x,y)
	// Post1 : getSize() = getSize()@pre
	// Post2 : getNbPos() == getNbPos@pre + 1
	// Post3 : hasPos(x,y) == true
	// Post4 : \forall x1:int in [1,size], y1:int in [1,size] { x1 != x && y1 != y && hasPos(x1,y1) == hasPos(x1,y1)@pre } 
	public void addPos(int x, int y);
	
	// Post1 : getSize() == getSize()@pre;
	// Post2 : getNbPos() == getNbPos()@pre;
	public void rotateLeft();
	
	// Post1 : getSize() == getSize()@pre;
	// Post2 : getNbPos() == getNbPos()@pre;
	public void rotateRight();
	
	

}
