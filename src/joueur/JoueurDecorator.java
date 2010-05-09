package joueur;

import tetris.TetrisContract;

public abstract class JoueurDecorator implements JoueurService {

	private JoueurService delegate;
	
	public JoueurDecorator(JoueurService delegate) {
		this.delegate = delegate;
	}
	
	public TetrisContract getTetris() {
		return this.delegate.getTetris();
	}
	
	public boolean canPlay(){
		return this.delegate.canPlay();
	}
	
	public void init() {
		this.delegate.init();
	}
	
	public void goLeft() {
		this.delegate.goLeft();
	}
	
	public void goRight() {
		this.delegate.goRight();
	}
		
	public void goDown() {
		this.delegate.goDown();
	}

	public void rotateLeft() {
		this.delegate.rotateLeft();
	}

	public void rotateRight() {
		this.delegate.rotateRight();
	}

}
