package programme;

import joueur.JoueurContract;


public class Runner extends Thread implements Runnable {
	private JoueurContract joueur;
	private Fenetre fenetre;
	
	public Runner(JoueurContract joueur, Fenetre fenetre){
		this.joueur = joueur;
		this.fenetre = fenetre;
	}

	@Override
	public void run() {
		
		while(!joueur.getTetris().isFinished()){
		try {
			Thread.sleep(700);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		fenetre.doAction(Fenetre.STEP);
		}
		System.out.println("Fini: "+joueur.getTetris().getScore());
	}
}
