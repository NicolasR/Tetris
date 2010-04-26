import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Programme extends JPanel implements KeyListener {

	public Programme(){
		addKeyListener(this);
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Touche: "+e.getKeyCode());

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

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
		fenetre.setContentPane(new Programme());
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
		fenetre.setSize(320, 240);
		Thread t = new Thread() {
	        public void run() {
	          // Instanciation et lancement du traitement
	          System.out.println("Salut");
	          while(true){
	  				try {
						sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	  				System.out.println("Were we go we don't need roads");
	  			
	          }
	        }
		};
		t.start();
	}

}
