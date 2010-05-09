import grid.GridContract;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import joueur.JoueurContract;
import joueur.JoueurImpl;

import tetris.TetrisContract;
import tetris.TetrisImpl;

public class Programme extends JPanel implements KeyListener {

	public Programme(){
		addKeyListener(this);
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final JFrame fenetre = new JFrame("Tetris");
		JoueurContract joueur = new JoueurContract(new JoueurImpl());
		joueur.init();
		joueur.getTetris().init();
		GridContract grid = joueur.getTetris().getBoard().getgrid();
		TetrisPanel pane = new TetrisPanel(grid,joueur,fenetre);
		fenetre.setContentPane(pane);
		joueur.getTetris().next();
		fenetre.repaint();
		Runner run = new Runner(joueur, fenetre, pane);
		
		//pane.paintComponent(pane.getGraphics());
		//fenetre.add(new JLabel("Score:"));
		//TetrisPanel tt = new TetrisPanel();
		//fenetre.add(tt);
		//fenetre.add(pane);
		//pane.paintComponent(pane.getGraphics());
		//pane.getGraphics().fillRect(1, 1, 1, 1);
		fenetre.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e)
		     { 
		       System.exit(0);  
		     }
		   public void windowActivated(WindowEvent e)
		     { 		       
		      fenetre.getContentPane().requestFocus();	
		     }
		});
		
		fenetre.setVisible(true);
		fenetre.setSize(800, 600);
		Thread t = new Thread() {
	        public void run() {
	          while(true){
	  				try {
						sleep(100);
						fenetre.repaint();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	  				//System.out.println("Where we go we don't need roads");
	  			
	          }
	        }
		};
		//t.start();
		run.start();
	}

}
