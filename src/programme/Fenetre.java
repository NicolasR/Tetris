package programme;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import joueur.JoueurService;


public class Fenetre extends JFrame implements KeyListener{

	private static final long serialVersionUID = 8164118974463460991L;
	
	static final int GOLEFT = 1;
	static final int GORIGHT = 2;
	static final int GODOWN = 3;
	static final int ROTATELEFT = 4;
	static final int ROTATERIGHT = 5;
	static final int STEP = 6;
	
	/**
	 * Menu
	 */
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menuJeu = new JMenu("Jeu");
	private JMenuItem JeuDemarrer = new JMenuItem("D�marrer");
	private JMenuItem JeuQuitter = new JMenuItem("Quitter");
	private TetrisPanel panel;
	private Runner runner;
	private JoueurService joueur;
	private Fenetre fenetre = this;
	
	public Fenetre(JoueurService joueur2){
		this.joueur = joueur2;
		JeuQuitter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		this.panel = new TetrisPanel(joueur2,this);
		this.setContentPane(panel);
		this.runner = new Runner(joueur2, this);
		JeuDemarrer.addActionListener(new DemarrerListener(joueur2,runner));
		
		this.menuJeu.add(JeuDemarrer);
		this.menuJeu.add(JeuQuitter);
		this.menuBar.add(menuJeu);
		this.setJMenuBar(menuBar);
		this.setTitle("Tetris");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		addKeyListener(this);
	}
	
	public class DemarrerListener implements ActionListener{
		private JoueurService joueur;
		private Runner runner;
		
		public DemarrerListener(JoueurService joueur, Runner runner){
			this.joueur = joueur;
			this.runner = runner;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			joueur.getTetris().next();
			this.runner.start();
		}
	}
	
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode();
		switch(code){
			//CRTL gauche
			case KeyEvent.VK_C:
				doAction(ROTATELEFT);
				break;
			//ALT gauche
			case KeyEvent.VK_V:
				doAction(ROTATERIGHT);
				break;
			case KeyEvent.VK_LEFT:
				doAction(GOLEFT);
				break;
			case KeyEvent.VK_RIGHT:
				doAction(GORIGHT);
				break;
			case KeyEvent.VK_DOWN:
				doAction(GODOWN);
				break;
			default:
				//System.out.println("Touche: "+e.getKeyCode());
		}
	}
	
	public synchronized void doAction(int action){
		switch(action){
			case GOLEFT:
				goLeft();
				break;
			case GORIGHT:
				goRight();
				break;
			case GODOWN:
				goDown();
				break;
			case ROTATELEFT:
				rotateLeft();
				break;
			case ROTATERIGHT:
				rotateRight();
				break;
			case STEP:
				step();
				break;
			default:
				System.out.println("Erreur");
				System.exit(1);
		}
		this.panel.setScore(joueur.getTetris().getScore());
		this.paint(this.fenetre.getGraphics());
		//this.repaint();
	}
	
	public synchronized void goLeft(){
			this.joueur.goLeft();
	}
	
	public synchronized void goRight(){
			this.joueur.goRight();
	}
	
	public synchronized void goDown(){
			this.joueur.goDown();
	}
	
	public synchronized void step(){
		this.joueur.getTetris().step();
	}
	
	public synchronized void rotateLeft(){
			this.joueur.rotateLeft();
	}
	
	public synchronized void rotateRight(){
			this.joueur.rotateRight();
	}
	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
