package grid;

public interface GridService {
	/** Observators */
	public int getWidth();
	public int getHeight();
	public boolean isOccupied(int x, int y);
	  //pre: x >= 1 && x <= getWidth() && y >= 1 && y <= getHeight()
	public boolean canPut(int x, int y);
	
	/** Invariants
	 * \forall x in (1<= x && x < getWidth){
	 * 			\forall y in (1<= y && y < getHeight){
	 * 				isOccupied(x,y) == not(canPut(x,y));
	 *  		}
	 * }
	 * getWidth@pre = getWidth
	 * getHeight@pre = getHeight
	 * 
	 */
	
	/** Constructors
	 * Initialise
	 * pre: x > 0 && y > 0 && y >= x
	 * post: getWidth == x && getHeight == y
	 * post: \forall x in (1<= x && x < getWidth){
	 * 			\forall y in (1<= y && y < getHeight){
	 * 				not(isOccupied(x,y)) && canPut(x,y);
	 *  		}
	 *  	 }
	 */
	 public void init(int x, int y);
	 
	 /** Operators */
	 /** pre: canPut(x,y)
	  * post: not(isOccupied(x,y)@pre) == isOccupied(x,y)
	  * post: not(canPut(x,y))
	  * post: forall i in (1<= i && x != i && i < getWidth){
	  * 		  forall j in (1<= j && j<y && j < getHeight){
	  * 		  	isOccupied(i,j)@pre == isOccupied(i,j);
	  * 		  }
	  * 	  }
	  * post: forall i in (1<= i && x != i && i < getWidth){
	  * 		  forall j in (1<= j && j<y && j < getHeight){
	  * 		  	canPut(i,j);
	  * 		  }
	  * 	  }
	  * getWidth@pre = getWidth
	  * getHeight@pre = getHeight
	  */
	 public void put(int x, int y);
	 
	 /**
	  * pre: isOccupied(x,y);
	  * post: isOccupied(x,y)@pre == not(isOccupied(x,y))
	  * post: canPut(x,y)
	  * post: forall i in (1<= i && x != i && i < getWidth){
	  * 		  forall j in (1<= j && j<y && j < getHeight){
	  * 		  	isOccupied(i,j)@pre == not(isOccupied(i,j));
	  * 		  }
	  * 	  }
	  * post: forall i in (1<= i && x != i && i < getWidth){
	  * 		  forall j in (1<= j && j<y && j < getHeight){
	  * 		  	canPut(i,j);
	  * 		  }
	  * 	  }
	  * getWidth@pre = getWidth
	  * getHeight@pre = getHeight
	  */
	 public void remove(int x, int y);
	 
	 
	 
	
	
	
}
