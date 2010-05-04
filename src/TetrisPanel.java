import grid.GridContract;

import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JPanel;

import board.BoardContract;


public class TetrisPanel extends JPanel {

	private GridContract grid;
	
	public TetrisPanel (GridContract grid){
		this.grid = grid;
		setDoubleBuffered(true);
		GridLayout layout = new GridLayout();
		this.setLayout(layout);
		
	}
	
	public void paintComponent(Graphics g){
        for(int i=1;i<=10;i++){
        	for(int j=1;j<=22;j++){
        		if (this.grid.isOccupied(i, j))
        			g.fillRect(10+(20*(i-1)), 10+(20*(j-1)), 20, 20);
        	}
        }
		
	}      
}
