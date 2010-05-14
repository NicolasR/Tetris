package tetris;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

import programme.Factory;

public class TetrisTest{
	
	private static TetrisService tetris;
	
	@BeforeClass
	public static void initialize(){
		tetris = Factory.createTetris();
	}
	
	@Test
	public void testinit(){
		try{
			tetris.init();
			assertTrue(true);
		}catch(Error e){
			assertTrue(false);
		}
		boolean oracle = tetris.isRunning() && !tetris.isFinished() && tetris.needNext() && tetris.getScore() == 0;
		assertTrue(oracle);
		
	}
		
}
