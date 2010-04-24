package tetris;

import java.util.Random;

import board.*;

public class TetrisImpl implements TetrisService {

	private int score;
	private boolean isFinished;
	private boolean isRunning;
	private boolean needNext;
	private BoardContract board;
	
	@Override
	public BoardContract getBoard() {
		return this.board;
	}

	@Override
	public int getScore() {
		return this.score;
	}

	@Override
	public void goDown() {
		this.board.doBottom();
		this.score += 20 + 50*this.board.getNbLastCleaned();
		this.needNext = true;
	}

	@Override
	public void goLeft() {
		this.board.doLeft();
	}

	@Override
	public void goRight() {
		this.board.doRight();
	}

	@Override
	public void init() {
		this.score = 0;
		this.isFinished = false;
		this.isRunning = true;
		this.needNext = true;
		this.board = new BoardContract(new BoardImpl());
		this.board.init(10, 22);
	}

	@Override
	public boolean isFinished() {
		return this.isFinished;
	}

	@Override
	public boolean isRunning() {
		return this.isRunning;
	}

	@Override
	public boolean needNext() {
		return this.needNext;
	}

	@Override
	public void next() {
		Random r = new Random();
		int size;
		switch(r.nextInt(3)){
			case 0: 
				size = 2;
				break;
			case 1:
				size = 3;
				break;
			default:
				size = 4;
		}
		BlockContract bloc = new BlockContract(new BlockImpl());
		bloc.init(size);
		this.board.insert(bloc);
		this.needNext = false;
	}

	@Override
	public void rotateLeft() {
		this.board.doRotateLeft();
	}

	@Override
	public void rotateRight() {
		this.board.doRotateRight();
	}

	@Override
	public void step() {
		this.board.step(); //Vérifier si en bas?
	}

}
