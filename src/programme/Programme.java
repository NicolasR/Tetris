package programme;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import joueur.JoueurContract;
import joueur.JoueurImpl;

public class Programme extends JPanel implements KeyListener {

	private static final long serialVersionUID = 2104825133643372892L;

	private final Fenetre fenetre;
	private final JoueurContract joueur;
	
	public Programme(){
		setDoubleBuffered(true);
		addKeyListener(this);
		this.joueur = new JoueurContract(new JoueurImpl());
		this.joueur.init();
		this.joueur.getTetris().init();
		this.fenetre = new Fenetre(joueur);
	}
	
	public void init(){
		fenetre.setVisible(true);
		fenetre.setSize(800, 600);
	}
	
	public void paintComponent(Graphics g){
	    super.paintComponent(g);
	  }
	
	@Override
	public void keyPressed(KeyEvent e) {

	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * @param args
	 */
	
}
