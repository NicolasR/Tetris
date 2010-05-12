import grid.GridContract;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import joueur.JoueurContract;


public class TetrisPanel extends JPanel implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8545642574194371642L;
	private GridContract grid;
	private JoueurContract joueur;
	private JFrame fenetre;
	private JLabel score;
	static final int GOLEFT = 1;
	static final int GORIGHT = 2;
	static final int GODOWN = 3;
	static final int ROTATELEFT = 4;
	static final int ROTATERIGHT = 5;
	static final int STEP = 6;
	
	public TetrisPanel (GridContract grid, JoueurContract joueur, JFrame fenetre){
		this.grid = grid;
		this.joueur = joueur;
		this.fenetre = fenetre;
		this.score = new JLabel("Score: ");
		setDoubleBuffered(true);
		GridLayout layout = new GridLayout();
		this.setLayout(layout);
		addKeyListener(this);
		this.add(score);
	}
	
	public void paintComponent(Graphics g){
        for(int i=1;i<=10;i++){
        	for(int j=1;j<=22;j++){
        		if (this.grid.isOccupied(i, j))
        			g.fillRect(10+(20*(i-1)), 10+(20*(j-1)), 20, 20);
        	}
        }
        g.drawRect(10, 10, 200, 440);
		
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
		score.setText("Score: "+joueur.getTetris().getScore());
		this.fenetre.paint(this.fenetre.getGraphics());
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
