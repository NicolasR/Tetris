package joueur;

import tetris.TetrisContract;
import tetris.TetrisImpl;

public class JoueurImpl implements JoueurService {

	private TetrisContract tetris;
	
	public TetrisContract getTetris() {
		return this.tetris;
	}
	
	public boolean canPlay(){
		return tetris.isRunning() && !tetris.isFinished();
	}
	
	public void init() {
		this.tetris = new TetrisContract(new TetrisImpl());
	}
	
	public void goLeft() {
		if (canPlay())
			this.tetris.goLeft();
	}
	
	public void goRight() {
		if (canPlay())
			this.tetris.goRight();
	}
	
	public void goDown() {
		if (canPlay())
			this.tetris.goDown();
	}
	
	public void rotateLeft() {
		if (canPlay())
			this.tetris.rotateLeft();
	}
	
	public void rotateRight() {
		if (canPlay())
			this.tetris.rotateRight();
	}
	
}
