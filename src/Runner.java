import javax.swing.JFrame;

import tetris.TetrisContract;


public class Runner extends Thread implements Runnable {
	private TetrisContract tetris;
	private JFrame fenetre;
	private TetrisPanel pane;
	
	public Runner(TetrisContract tetris, JFrame Fenetre, TetrisPanel pane){
		this.tetris = tetris;
		this.fenetre = Fenetre;
		this.pane = pane;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(true){
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//tetris.rotateRight();
		pane.doAction(TetrisPanel.STEP);
		//fenetre.repaint();
		//System.out.println("OK");
		}
	}
}
