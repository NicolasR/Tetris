package board;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import block.BlockContract;
import block.BlockImpl;

public class BoardTest{
	
	private static BoardContract board;
	
	@BeforeClass
	public static void initialize(){
		BoardImpl impl = new BoardImpl();
		board = new BoardContract(impl);
	}
	
	@Test
	public void testinit(){
		try{
			board.init(10,9);
			assertTrue(false);
		}catch(Error e){
			assertTrue(true);
		}
		
		board = new BoardContract(new BoardImpl());
		board.init(10,22);
		boolean oracle_post = (board.getgrid().getWidth() == 10) && (board.getgrid().getHeight() == 22);
		assertTrue(oracle_post);	
		
		assertFalse(board.isBlock());
		
	}
	
	@Test
	public void testinsert(){
		boolean oracle_pre = (!board.isBlock());
		assertTrue(oracle_pre);
		BlockContract bloc = new BlockContract(new BlockImpl());
		
		try{
			bloc.init(2);
			board.insert(bloc);
			assertTrue(true);
		}catch(Error e){
			assertTrue(false);
		}
		boolean oracle_post = (board.isBlock() && board.getcurrentBlock() == bloc 
				&& board.getXMinBlock()>0 && board.getYMinBlock() == 1);
		assertTrue(oracle_post);
		
		try{
			bloc = new BlockContract(new BlockImpl());
			board.insert(bloc);
			assertTrue(false);
		}catch(Error e){
			assertTrue(true);
		}
	}
	
	@Test
	public void testdoLeft(){
		boolean oracle_pre = board.cangoLeft() && board.isBlock();
		assertTrue(oracle_pre);
		int getXMinBlock_atPre, getYMinBlock_atPre;
		getXMinBlock_atPre = board.getXMinBlock();
		getYMinBlock_atPre = board.getYMinBlock();
		try{
			board.doLeft();
			board.doLeft();
			board.doLeft();
			assertTrue(true);
		}catch(Error e){
			assertTrue(false);
		}
		 
		boolean oracle_post = board.getXMinBlock()-3 == getXMinBlock_atPre
			&& board.getYMinBlock() == getYMinBlock_atPre;
		
		assertTrue(oracle_post);
	}
	
	@Test
	public void testdoRight(){
		boolean oracle_pre = board.cangoRight() && board.isBlock();
		assertTrue(oracle_pre);
		int getXMinBlock_atPre, getYMinBlock_atPre;
		getXMinBlock_atPre = board.getXMinBlock();
		getYMinBlock_atPre = board.getYMinBlock();
		try{
			board.doRight();
			board.doRight();
			board.doRight();
			assertTrue(true);
		}catch(Error e){
			assertTrue(false);
		}
		 
		boolean oracle_post = board.getXMinBlock()+3 == getXMinBlock_atPre
			&& board.getYMinBlock() == getYMinBlock_atPre;
		
		assertTrue(oracle_post);
	}
	
	@Test
	public void testremove(){
		boolean oracle_pre = board.isBlock();
		assertTrue(oracle_pre);
		
		try{
			board.remove();
			assertTrue(true);
		}catch(Error e){
			assertTrue(false);
		}
		
		boolean oracle_post = !board.isBlock();
		assertTrue(oracle_post);
		
		try{
			board.remove();
			assertTrue(false);
		}catch(Error e){
			assertTrue(true);
		}
	}
}
