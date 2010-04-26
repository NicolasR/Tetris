package joueur;

import tetris.TetrisContract;

public interface JoueurService {

	/* INVARIANTS */
	// inv : getTetris() != null
	
	/* OBSERVATORS */	
	public TetrisContract getTetris();
	
	/* CONSTRUCTORS */
	public void init();
	
	/* OPERATORS */	
	// Post : getTetris() == getTetris@pre
	public void goLeft();
	
	// Post : getTetris() == getTetris@pre
	public void goRight();
	
	// Post : getTetris() == getTetris@pre
	public void goDown();
	
	// Post : getTetris() == getTetris@pre
	public void rotateLeft();
	
	// Post : getTetris() == getTetris@pre
	public void rotateRight();
		
}
