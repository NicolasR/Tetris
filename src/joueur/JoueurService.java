package joueur;

import tetris.TetrisService;

public interface JoueurService {

	/* INVARIANTS */
	// inv : getTetris() != null
	
	/* OBSERVATORS */	
	public TetrisService getTetris();
	public boolean canPlay();
	
	/* CONSTRUCTORS */
	public void init();
	
	/* OPERATORS */	
	//Pre: canPlay() == true
	// Post : getTetris() == getTetris@pre
	//Post: getTetris() = Tetris:goLeft()
	public void goLeft();
	
	//Pre: canPlay() == true
	// Post : getTetris() == getTetris@pre
	//Post: getTetris() = Tetris:goRight()
	public void goRight();
	
	//Pre: canPlay() == true
	// Post : getTetris() == getTetris@pre
	//Post: getTetris() = Tetris:goDown()
	public void goDown();
	
	//Pre: canPlay() == true
	// Post : getTetris() == getTetris@pre
	//Post: getTetris() = Tetris:rotateLeft()
	public void rotateLeft();
	
	//Pre: canPlay() == true
	// Post : getTetris() == getTetris@pre
	//Post: getTetris() = Tetris:rotateRight()
	public void rotateRight();
		
}
