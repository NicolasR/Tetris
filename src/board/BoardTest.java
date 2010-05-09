package board;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import block.BlockContract;
import block.BlockImpl;

public class BoardTest{
	
	private static BoardImpl impl;
	private static BoardContract board;
	
	@BeforeClass
	public static void initialize(){
		impl = new BoardImpl();
	}
	
	@Test
	public void testinit(){
		board = new BoardContract(impl);
		try{
			board.init(10,9);
			assertTrue(false);
		}catch(Error e){
			assertTrue(true);
		}
		
		board = new BoardContract(new BoardImpl());
		try{
			board.init(10,22);
			assertTrue(true);
		}catch(Error e){
			assertTrue(false);
		}
		boolean oracle_post = (board.getgrid().getWidth() == 10) && (board.getgrid().getHeight() == 22);
		assertTrue(oracle_post);	
		
		assertFalse(board.isBlock());
		
	}
	
	@Test
	public void testinsert(){
		board = new BoardContract(impl);
		board.init(10, 22);
		
		boolean oracle_pre = (!board.isBlock());
		assertTrue(oracle_pre);
		BlockContract block = new BlockContract(new BlockImpl());
		
		try{
			block.init('O');
			board.insert(block);
			assertTrue(true);
		}catch(Error e){
			assertTrue(false);
		}
		boolean oracle_post = (board.isBlock() && board.getcurrentBlock() == block 
				&& board.getXMinBlock()>0 && board.getYMinBlock() == 1);
		assertTrue(oracle_post);
		
		try{
			block = new BlockContract(new BlockImpl());
			board.insert(block);
			assertTrue(false);
		}catch(Error e){
			assertTrue(true);
		}
	}
	
	@Test
	public void testdoRotateLeft(){
		board = new BoardContract(impl);
		board.init(10, 22);
		BlockContract block = new BlockContract(new BlockImpl());
		block.init('L');
		board.insert(block);
		
		boolean oracle_pre = board.canRotateLeft() && board.isBlock();
		assertTrue(oracle_pre);
		int getXMinBlock_atPre, getYMinBlock_atPre;
		getXMinBlock_atPre = board.getXMinBlock();
		getYMinBlock_atPre = board.getYMinBlock();
		try{
			board.doRotateLeft();
			board.doRotateLeft();
			board.doRotateLeft();
			board.doRotateLeft();
			assertTrue(true);
		}catch(Error e){
			assertTrue(false);
		}
		 
		boolean oracle_post = (board.getXMinBlock() == getXMinBlock_atPre)
			&& (board.getYMinBlock() == getYMinBlock_atPre);
		
		assertTrue(oracle_post);
	}
	
	@Test
	public void testdoLeft(){
		board = new BoardContract(impl);
		board.init(10, 22);
		BlockContract block = new BlockContract(new BlockImpl());
		block.init('O');
		board.insert(block);
		
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
		try{
			board.doLeft();
			board.doLeft();
			board.doLeft();
			assertTrue(false);
		}catch(Error e){
			assertTrue(true);
		}
		 
		boolean oracle_post = (board.getXMinBlock() == (getXMinBlock_atPre-5))
			&& (board.getYMinBlock() == getYMinBlock_atPre);
		assertTrue(oracle_post);
	}
	
	@Test
	public void testdoRotateRight(){
		board = new BoardContract(impl);
		board.init(10, 22);
		BlockContract block = new BlockContract(new BlockImpl());
		block.init('L');
		board.insert(block);
		
		boolean oracle_pre = board.canRotateRight() && board.isBlock();
		assertTrue(oracle_pre);
		int getXMinBlock_atPre, getYMinBlock_atPre;
		getXMinBlock_atPre = board.getXMinBlock();
		getYMinBlock_atPre = board.getYMinBlock();
		try{
			board.doRotateRight();
			board.doRotateRight();
			board.doRotateRight();
			board.doRotateRight();
			assertTrue(true);
		}catch(Error e){
			assertTrue(false);
		}
		 
		boolean oracle_post = (board.getXMinBlock() == getXMinBlock_atPre)
			&& (board.getYMinBlock() == getYMinBlock_atPre);
		
		assertTrue(oracle_post);
	}
	
	@Test
	public void testdoRight(){	
		board = new BoardContract(impl);
		board.init(10, 22);
		BlockContract block = new BlockContract(new BlockImpl());
		block.init('O');
		board.insert(block);
		
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
		try{
			board.doRight();
			assertTrue(false);
		}catch(Error e){
			assertTrue(true);
		}
		 
		boolean oracle_post = (board.getXMinBlock() == (getXMinBlock_atPre+3))
			&& (board.getYMinBlock() == getYMinBlock_atPre);

		assertTrue(oracle_post);
	}
	
	@Test
	public void testdoBottom(){
		board = new BoardContract(impl);
		board.init(10, 22);
		BlockContract block = new BlockContract(new BlockImpl());
		block.init('O');
		board.insert(block);
		
		boolean oracle_pre = board.isBlock();
		assertTrue(oracle_pre);
		int getXMinBlock_atPre, getYMinBlock_atPre, getBottomHeight_atPre;
		getXMinBlock_atPre = board.getXMinBlock();
		getYMinBlock_atPre = board.getYMinBlock();	
		getBottomHeight_atPre = board.getBottomHeight();
		try{
			board.doBottom();
			assertTrue(true);
		}catch(Error e){
			e.printStackTrace();
			assertTrue(false);
		}
		 
		boolean oracle_post = (board.getXMinBlock() == (getXMinBlock_atPre))
			&& (board.getYMinBlock() == getYMinBlock_atPre + getBottomHeight_atPre);
		
		assertTrue(oracle_post);
	}
	
	@Test
	public void testStep(){
		board = new BoardContract(impl);
		board.init(10, 22);
		BlockContract block = new BlockContract(new BlockImpl());
		block.init('O');
		board.insert(block);
		
		boolean oracle_pre = board.isBlock();
		assertTrue(oracle_pre);
		int getXMinBlock_atPre, getYMinBlock_atPre;
		getXMinBlock_atPre = board.getXMinBlock();
		getYMinBlock_atPre = board.getYMinBlock();	
		try{
			board.step();
			assertTrue(true);
		}catch(Error e){
			assertTrue(false);
		}
		 
		boolean oracle_post = (board.getXMinBlock() == (getXMinBlock_atPre))
			&& (board.getYMinBlock() == getYMinBlock_atPre+1);
		
		assertTrue(oracle_post);
	}
		
	@Test
	public void testremove(){
		board = new BoardContract(impl);
		board.init(10, 22);
		BlockContract block = new BlockContract(new BlockImpl());
		block.init('O');
		board.insert(block);
		
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
	
	@Test
	public void testclean(){
		board = new BoardContract(impl);
		board.init(10, 22);
		BlockContract block = new BlockContract(new BlockImpl());
		block.init('O');
		board.insert(block);

		board.doBottom();

		boolean oracle_pre = board.isBottom();
		assertTrue(oracle_pre);
		int getNbLastCleaned_atPre = board.getNbLastCleaned();	
		try{
			board.clean();
			assertTrue(true);
		}catch(Error e){
			e.printStackTrace();
			assertTrue(false);
		}
		 
		boolean oracle_post = (board.getNbLastCleaned() >= getNbLastCleaned_atPre);
		assertTrue(oracle_post);
		
		
		board = new BoardContract(impl);
		board.init(10, 22);
		board.insert(block);
			
		board.step();
		board.step();
		board.step();
		board.step();
		board.step();
		board.step();
		board.step();
		board.step();
		board.step();
		board.step();
		board.step();
		board.step();
		board.step();
		board.step();
		board.step();
		board.step();
		board.step();
		board.step();
		board.step();
		board.step();
			
		oracle_pre = board.isBottom();
		assertTrue(oracle_pre);
		getNbLastCleaned_atPre = board.getNbLastCleaned();	
		try{
			board.clean();
			assertTrue(true);
		}catch(Error e){
			e.printStackTrace();
			assertTrue(false);
		}
		 
		oracle_post = (board.getNbLastCleaned() >= getNbLastCleaned_atPre);
		assertTrue(oracle_post);
	}
}
