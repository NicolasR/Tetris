package tetris;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;

public class TetrisTest{
	
	private static TetrisContract tetris;
	
	@BeforeClass
	public static void initialize(){
		TetrisImpl impl = new TetrisImpl();
		tetris = new TetrisContract(impl);
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
