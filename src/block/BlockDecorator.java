package block;

import java.util.LinkedList;
import java.util.Set;

public abstract class BlockDecorator implements BlockService {

	private BlockService delegate;
	
	public BlockDecorator (BlockService delegate) {
		this.delegate = delegate;
	}
	
	public int getSize() {
		return this.delegate.getSize();
	}
	
	
	public int getNbPos() {
		return this.delegate.getNbPos();
	}
	
	public int getXMin() {
		return this.delegate.getXMin();
	}
	
	public int getXMax() {
		return this.delegate.getXMax();
	}
	
	public int getYMin() {
		return this.delegate.getYMin();
	}
	
	public int getYMax() {
		return this.delegate.getYMax();
	}
	
	public boolean hasPos(int x, int y) {
		return this.delegate.hasPos(x, y);
	}
	
	public Set<LinkedList<Integer>> getAllPos() {
		return this.delegate.getAllPos();
	}
	
	public Set<LinkedList<Integer>> getLowPos() {
		return this.delegate.getLowPos();
	}
	
	public void init(int size) {
		this.delegate.init(size);
	}
	
	public void addPos(int x, int y) {
		this.delegate.addPos(x, y);
	}
	
	public void rotateLeft() {
		this.delegate.rotateLeft();
	}
	
	public void rotateRight() {
		this.delegate.rotateRight();
	}
}
