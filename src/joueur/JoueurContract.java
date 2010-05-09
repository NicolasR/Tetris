package joueur;

import tetris.TetrisContract;

public class JoueurContract extends JoueurDecorator {

	public JoueurContract(JoueurService joueur) {
		super(joueur);
	}
	
	public void checkInvariants() {
		// inv : getTetris() != null
		if(!(super.getTetris() != null)) {
			throw new Error("Invariant invalide");
		}
	}
	
	public TetrisContract getTetris() {
		checkInvariants();
		TetrisContract tetris = super.getTetris();
		checkInvariants();
		return tetris;
	}
	
	public void init() {
		super.init();
		checkInvariants();
	}
	
	public void goLeft() {
		checkInvariants();
		TetrisContract getTetris_atPre = super.getTetris();
		super.goLeft();
		checkInvariants();
		if(!(super.getTetris() == getTetris_atPre)) {
			throw new Error("post (goLeft) invalide");
		}
	}
	
	public void goRight() {
		checkInvariants();
		TetrisContract getTetris_atPre = super.getTetris();
		super.goRight();
		checkInvariants();
		if(!(super.getTetris() == getTetris_atPre)) {
			throw new Error("post (goRight) invalide");
		}
	}
	
	public void goDown() {
		checkInvariants();
		TetrisContract getTetris_atPre = super.getTetris();
		super.goDown();
		checkInvariants();
		if(!(super.getTetris() == getTetris_atPre)) {
			throw new Error("post (goDown) invalide");
		}
	}
	
	public void rotateLeft() {
		checkInvariants();
		TetrisContract getTetris_atPre = super.getTetris();
		super.rotateLeft();
		checkInvariants();
		if(!(super.getTetris() == getTetris_atPre)) {
			throw new Error("post (rotateLeft) invalide");
		}
	}
	
	public void rotateRight() {
		checkInvariants();
		TetrisContract getTetris_atPre = super.getTetris();
		super.rotateRight();
		checkInvariants();
		if(!(super.getTetris() == getTetris_atPre)) {
			throw new Error("post (rotateRight) invalide");
		}
	}

	@Override
	public boolean canPlay() {
		checkInvariants();
		boolean canPlay = super.canPlay();
		checkInvariants();
		return canPlay;
	}
	
}
