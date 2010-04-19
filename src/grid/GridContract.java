package grid;

public class GridContract extends GridDecorator {

	public GridContract(GridService f) {
		super(f);
	}
	
	public void checkInvariants(){
		for(int i=1;i<=super.getWidth();i++){
			for(int j=1;j<=super.getHeight();j++){
				if (super.isOccupied(i, j) == super.canPut(i, j))
					throw new Error("Invariant invalide(1)");
			}
		}
			
	}
	
	
	public boolean isOccupied(int x, int y){
		checkInvariants();
		if (x < 1 || x > getWidth() || y < 1 || y > getHeight())
			throw new Error("post(1)(isOccupied) invalide");
		boolean temp = super.isOccupied(x, y);
		checkInvariants();
		return temp;
	}
	
	public boolean canPut(int x, int y){
		checkInvariants();
		boolean temp = super.canPut(x, y);
		checkInvariants();
		return temp;
	}
	
	public void init(int x, int y){
		if (x <= 0 || y <= 0 || y < x )
			throw new Error("pre(1)(init) invalide");
		
		super.init(x, y);
		
		if (super.getWidth() != x || super.getHeight() != y)
			throw new Error("post(1)(init) invalide");
		
		int xtemp = 1, ytemp = 1;
		while (xtemp <= super.getWidth()){
			while (ytemp <= super.getHeight()){
				if (super.isOccupied(xtemp,ytemp) || !super.canPut(xtemp, ytemp))
					throw new Error("post(2)(init) invalide");
				ytemp++;
			}
			xtemp++;
		}
		checkInvariants();
	}
	
	public void put(int x, int y){
		checkInvariants();
		if (!super.canPut(x, y))
			throw new Error("pre(1)(put) invalide");
		
		boolean grid_atPre[][] = new boolean[super.getWidth()][super.getHeight()];
		int xtemp=1, ytemp=1;
		while(xtemp<=super.getWidth())
		{
			while(ytemp<=super.getHeight()){
				grid_atPre[xtemp][ytemp] = super.isOccupied(xtemp,ytemp);
				ytemp++;
			}
			xtemp++;
		}
		/*int getWidth_atPre = super.getWidth();
		int getHeight_atPre = super.getHeight();*/
		
		super.put(x, y);
		
		if (grid_atPre[x][y] == super.isOccupied(x, y))
			throw new Error("post(1)(put) invalide");
		
		if (super.canPut(x,y))
			throw new Error("post(2)(put) invalide");
		
		xtemp = 1;
		ytemp = 1;
		while (xtemp<=super.getWidth()){
			while(ytemp<=super.getHeight()){
				if (xtemp != x || ytemp != y)
				{
					if (grid_atPre[xtemp][ytemp] != super.isOccupied(xtemp, ytemp))
						throw new Error("post(3)(put) invalide");
					
					if (!super.canPut(xtemp, ytemp))
						throw new Error("post(4)(put) invalide");
				}
				
			}
		}
		/*if (getWidth_atPre != super.getWidth())
			throw new Error("post(5)(put) invalide");
		if (getHeight_atPre != super.getHeight())
			throw new Error("post(6)(put) invalide");*/
		
		checkInvariants();
	}
	
	public void remove(int x, int y){
		checkInvariants();
		if (!super.isOccupied(x, y))
			throw new Error("pre(1)(put) invalide");
		
		boolean grid_atPre[][] = new boolean[super.getWidth()][super.getHeight()];
		int xtemp=1, ytemp=1;
		while(xtemp<=super.getWidth())
		{
			while(ytemp<=super.getHeight()){
				grid_atPre[xtemp][ytemp] = super.isOccupied(xtemp,ytemp);
				ytemp++;
			}
			xtemp++;
		}
		/*int getWidth_atPre = super.getWidth();
		int getHeight_atPre = super.getHeight();*/
		
		super.put(x, y);
		
		if (grid_atPre[x][y] == super.isOccupied(x, y))
			throw new Error("post(1)(put) invalide");
		
		if (!super.canPut(x,y))
			throw new Error("post(2)(put) invalide");
		
		xtemp = 1;
		ytemp = 1;
		while (xtemp<=super.getWidth()){
			while(ytemp<=super.getHeight()){
				if (xtemp != x || ytemp != y)
				{
					if (grid_atPre[xtemp][ytemp] == super.isOccupied(xtemp, ytemp))
						throw new Error("post(3)(put) invalide");
					
					if (!super.canPut(xtemp, ytemp))
						throw new Error("post(4)(put) invalide");
				}
				
			}
		}
		/*if (getWidth_atPre != super.getWidth())
			throw new Error("post(5)(put) invalide");
		if (getHeight_atPre != super.getHeight())
			throw new Error("post(6)(put) invalide");*/
		checkInvariants();
	}

}
