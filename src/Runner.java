import javax.swing.JFrame;

import joueur.JoueurService;


public class Runner extends Thread implements Runnable {
	private JoueurService joueur;
	private TetrisPanel pane;
	
	public Runner(JoueurService joueur, JFrame Fenetre, TetrisPanel pane){
		this.joueur = joueur;
		this.pane = pane;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		while(!joueur.getTetris().isFinished()){
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
		System.out.println("Fini: "+joueur.getTetris().getScore());
	}
}
