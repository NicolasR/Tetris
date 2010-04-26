package joueur;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import tetris.TetrisContract;

public class JoueurTest {
	
	public void checkInvariants(JoueurContract joueur) {
		// inv : getTetris() != null
		if(!(joueur.getTetris() != null)) {
			throw new Error("Invariant invalide");
		}
	}
	
	@Test
	public void testGetTetris() {
		JoueurContract joueur = new JoueurContract(new JoueurImpl());
		joueur.init();
		try {
			joueur.getTetris();
			assertTrue(true);
		}  catch(Error err) {
			assertTrue(true);
		}
		
		/* Invariants */
		try {
			checkInvariants(joueur);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
	}
	
	@Test
	public void testInit() {
		JoueurContract joueur = new JoueurContract(new JoueurImpl());
		try {
			joueur.init();
			assertTrue(true);
		}  catch(Error err) {
			assertTrue(true);
		}
		
		/* Invariants */
		try {
			checkInvariants(joueur);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
	}
	
	@Test
	public void testGoLeft() {
		JoueurContract joueur = new JoueurContract(new JoueurImpl());
		joueur.init();
		
		/* Captures */
		TetrisContract getTetris_atPre = joueur.getTetris();
		
		try {
			joueur.goLeft();
			assertTrue(true);
		}  catch(Error err) {
			assertTrue(true);
		}
		
		/* Invariants */
		try {
			checkInvariants(joueur);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition */
		assertTrue(joueur.getTetris() == getTetris_atPre);
	}
	
	@Test
	public void testGoRight() {
		JoueurContract joueur = new JoueurContract(new JoueurImpl());
		joueur.init();
		
		/* Captures */
		TetrisContract getTetris_atPre = joueur.getTetris();
		
		try {
			joueur.goRight();
			assertTrue(true);
		}  catch(Error err) {
			assertTrue(true);
		}
		
		/* Invariants */
		try {
			checkInvariants(joueur);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition */
		assertTrue(joueur.getTetris() == getTetris_atPre);
	}
	
	@Test
	public void testGoDown() {
		JoueurContract joueur = new JoueurContract(new JoueurImpl());
		joueur.init();
		
		/* Captures */
		TetrisContract getTetris_atPre = joueur.getTetris();
		
		try {
			joueur.goDown();
			assertTrue(true);
		}  catch(Error err) {
			assertTrue(true);
		}
		
		/* Invariants */
		try {
			checkInvariants(joueur);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition */
		assertTrue(joueur.getTetris() == getTetris_atPre);
	}
	
	@Test
	public void testRotateLeft() {
		JoueurContract joueur = new JoueurContract(new JoueurImpl());
		joueur.init();
		
		/* Captures */
		TetrisContract getTetris_atPre = joueur.getTetris();
		
		try {
			joueur.rotateLeft();
			assertTrue(true);
		}  catch(Error err) {
			assertTrue(true);
		}
		
		/* Invariants */
		try {
			checkInvariants(joueur);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition */
		assertTrue(joueur.getTetris() == getTetris_atPre);
	}
	
	@Test
	public void testRotateRight() {
		JoueurContract joueur = new JoueurContract(new JoueurImpl());
		joueur.init();
		
		/* Captures */
		TetrisContract getTetris_atPre = joueur.getTetris();
		
		try {
			joueur.rotateRight();
			assertTrue(true);
		}  catch(Error err) {
			assertTrue(true);
		}
		
		/* Invariants */
		try {
			checkInvariants(joueur);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition */
		assertTrue(joueur.getTetris() == getTetris_atPre);
	}
	
}
