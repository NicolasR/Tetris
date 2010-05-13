package joueur;

import programme.Factory;
import tetris.TetrisService;

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
	
	public TetrisService getTetris() {
		checkInvariants();
		TetrisService tetris = Factory.createTetris();
		checkInvariants();
		return tetris;
	}
	
	public void init() {
		super.init();
		checkInvariants();
	}
	
	public void goLeft() {
		checkInvariants();
		TetrisService getTetris_atPre = super.getTetris();
		
		int getScore_atPre = getTetris().getScore();
		boolean isBottom_atPre = getTetris().getBoard().isBottom();
		super.goLeft();
		checkInvariants();
		
		if(!(super.getTetris() == getTetris_atPre)) {
			throw new Error("[JOUEUR]post(1)(goLeft) invalide");
		}
		
		//POST TETRIS:goLeft
		TetrisService tetris = getTetris();
		if (!(tetris.getScore() == getScore_atPre))
			throw new Error("[JOUEUR]post(2.1)(goLeft) invalide");
		
		if (!isBottom_atPre)
			if (!(tetris.needNext() == false))
				throw new Error("[JOUEUR]post(2.2)(goLeft) invalide");
	}
	
	public void goRight() {
		checkInvariants();
		TetrisService getTetris_atPre = super.getTetris();
		boolean isBottom_atPre = getTetris().getBoard().isBottom();
		
		int getScore_atPre = getTetris().getScore();
		
		super.goRight();
		checkInvariants();
		
		if(!(super.getTetris() == getTetris_atPre)) {
			throw new Error("[JOUEUR]post(1)(goRight) invalide");
		}
		
		//POST TETRIS:goRight
		TetrisService tetris = getTetris();
		if (!(tetris.getScore() == getScore_atPre))
			throw new Error("[JOUEUR]post(2.1)(goRight) invalide");
		if (!isBottom_atPre)
			if (!(tetris.needNext() == false))
				throw new Error("[JOUEUR]post(2.2)(goRight) invalide");
	}
	
	public void goDown() {
		checkInvariants();
		TetrisService getTetris_atPre = super.getTetris();
		
		boolean isBottom_atPre = getTetris().getBoard().isBottom();
		int getScore_atPre = getTetris().getScore();
		
		super.goDown();
		checkInvariants();
		
		if(!(super.getTetris() == getTetris_atPre)) {
			throw new Error("[JOUEUR]post(1)(goDown) invalide");
		}
		
		//POST TETRIS:goDown
		TetrisService tetris = getTetris();
		if (!isBottom_atPre){
			if (!(getScore_atPre+20+50*(tetris.getBoard().getNbLastCleaned()) == tetris.getScore()))
				throw new Error("[JOUEUR]post(2.1)(goDown) invalide");
			
			if (!(tetris.needNext() == true))
				throw new Error("[JOUEUR]post(2.2)(goDown) invalide");
		}
	}
	
	public void rotateLeft() {
		checkInvariants();
		TetrisService getTetris_atPre = super.getTetris();
		
		int getScore_atPre = getTetris().getScore();
		
		super.rotateLeft();
		checkInvariants();
		
		if(!(super.getTetris() == getTetris_atPre)) {
			throw new Error("[JOUEUR]post(1)(rotateLeft) invalide");
		}
		
		//POST TETRIS:rotateLeft
		TetrisService tetris = getTetris();
		if (!(tetris.getScore() == getScore_atPre))
			throw new Error("[JOUEUR]post(2.1)(rotateLeft) invalide");
		if (!(tetris.needNext() == false))
			throw new Error("[JOUEUR]post(2.2)(rotateLeft) invalide");
	}
	
	public void rotateRight() {
		checkInvariants();
		TetrisService getTetris_atPre = super.getTetris();
		
		int getScore_atPre = getTetris().getScore();
		
		super.rotateRight();
		checkInvariants();
		
		if(!(super.getTetris() == getTetris_atPre)) {
			throw new Error("[JOUEUR]post(1)(rotateRight) invalide");
		}
		
		//POST TETRIS:rotateRight
		TetrisService tetris = getTetris();
		if (!(tetris.getScore() == getScore_atPre))
			throw new Error("[JOUEUR]post(2.1)(rotateRight) invalide");
		if (!(tetris.needNext() == false))
			throw new Error("[JOUEUR]post(2.2)(rotateRight) invalide");
	}

	@Override
	public boolean canPlay() {
		checkInvariants();
		boolean canPlay = super.canPlay();
		checkInvariants();
		return canPlay;
	}
	
}
