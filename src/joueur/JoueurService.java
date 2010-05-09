package joueur;

import tetris.TetrisContract;

public interface JoueurService {

	/* INVARIANTS */
	// inv : getTetris() != null
	
	/* OBSERVATORS */	
	public TetrisContract getTetris();
	public boolean canPlay();
	
	/* CONSTRUCTORS */
	public void init();
	
	/* OPERATORS */	
	//Pre: canPlay() == true
	// Post : getTetris() == getTetris@pre
	public void goLeft();
	
	//Pre: canPlay() == true
	// Post : getTetris() == getTetris@pre
	public void goRight();
	
	//Pre: canPlay() == true
	// Post : getTetris() == getTetris@pre
	public void goDown();
	
	//Pre: canPlay() == true
	// Post : getTetris() == getTetris@pre
	public void rotateLeft();
	
	//Pre: canPlay() == true
	// Post : getTetris() == getTetris@pre
	public void rotateRight();
		
}
