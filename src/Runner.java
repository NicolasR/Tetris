import javax.swing.JFrame;

import tetris.TetrisContract;


public class Runner extends Thread implements Runnable {
	private TetrisContract tetris;
	private JFrame fenetre;
	
	public Runner(TetrisContract tetris, JFrame Fenetre){
		this.tetris = tetris;
		this.fenetre = Fenetre;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tetris.rotateRight();
		fenetre.repaint();
		System.out.println("OK");
		}
	}
}
