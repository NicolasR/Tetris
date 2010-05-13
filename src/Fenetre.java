import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import joueur.JoueurContract;


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
	private JMenuItem JeuDemarrer = new JMenuItem("Démarrer");
	private JMenuItem JeuQuitter = new JMenuItem("Quitter");
	private TetrisPanel panel;
	private Runner runner;
	private JoueurContract joueur;
	private Fenetre fenetre = this;
	
	public Fenetre(JoueurContract joueur){
		this.joueur = joueur;
		JeuQuitter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		this.panel = new TetrisPanel(joueur,this);
		this.setContentPane(panel);
		this.runner = new Runner(joueur, this);
		JeuDemarrer.addActionListener(new DemarrerListener(joueur,runner));
		
		this.menuJeu.add(JeuDemarrer);
		this.menuJeu.add(JeuQuitter);
		this.menuBar.add(menuJeu);
		this.setJMenuBar(menuBar);
		this.setTitle("Tetris");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		addKeyListener(this);
	}
	
	public class DemarrerListener implements ActionListener{
		private JoueurContract joueur;
		private Runner runner;
		
		public DemarrerListener(JoueurContract joueur, Runner runner){
			this.joueur = joueur;
			this.runner = runner;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
				joueur.getTetris().next();
				this.runner.start();
				Thread t = new Thread() {
			        public void run() {
			          while(true){
			  				try {
								sleep(10);
								fenetre.repaint();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
			  				//System.out.println("Where we go we don't need roads");

			          }
			        }
				};
		}
	}
	
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode();
		switch(code){
			//CRTL gauche
			case KeyEvent.VK_CONTROL:
				doAction(ROTATELEFT);
				break;
			//ALT gauche
			case KeyEvent.VK_ALT:
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
				System.out.println("Touche: "+e.getKeyCode());
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
		//this.fenetre.paint(this.fenetre.getGraphics());
		this.repaint();
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
