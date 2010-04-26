package joueur;

import tetris.TetrisContract;
import tetris.TetrisImpl;

public class JoueurImpl implements JoueurService {

	private TetrisContract tetris;
	
	public TetrisContract getTetris() {
		return this.tetris;
	}
	
	public void init() {
		this.tetris = new TetrisContract(new TetrisImpl());
	}
	
	public void goLeft() {
		this.tetris.goLeft();
	}
	
	public void goRight() {
		this.tetris.goRight();
	}
	
	public void goDown() {
		this.tetris.goDown();
	}
	
	public void rotateLeft() {
		this.tetris.rotateLeft();
	}
	
	public void rotateRight() {
		this.tetris.rotateRight();
	}
	
}
