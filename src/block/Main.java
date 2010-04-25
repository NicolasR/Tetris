package block;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class Main {

	public static void main(String[] args) {

		BlockImpl impl = new BlockImpl();
		BlockContract contract = new BlockContract(impl);
		
		contract.init('L');
		System.out.println("NbPos = "+contract.getNbPos());
		System.out.println("Size = "+contract.getSize());
		
		System.out.println("XMin = "+contract.getXMin());
		System.out.println("XMax = "+contract.getXMax());
		System.out.println("YMin = "+contract.getYMin());
		System.out.println("YMax = "+contract.getYMax());
		
		System.out.println ("LowPos");
		Set<LinkedList<Integer>> getLowPos = contract.getLowPos();
		Iterator<LinkedList<Integer>> it = getLowPos.iterator();
		LinkedList<Integer> paire;
		while(it.hasNext()) {
			paire = it.next();
			System.out.println("x = "+paire.getFirst()+" y = "+paire.getLast());
		}
		
		System.out.println("AllPos");
		Set<LinkedList<Integer>> getAllPos = contract.getAllPos();
		 it = getAllPos.iterator();
		while(it.hasNext()) {
			paire = it.next();
			System.out.println("x = "+paire.getFirst()+" y = "+paire.getLast());
		}
		
		contract.rotateRight();
		
		System.out.println ("\n\nLowPos");
		getLowPos = contract.getLowPos();
		it = getLowPos.iterator();
		while(it.hasNext()) {
			paire = it.next();
			System.out.println("x = "+paire.getFirst()+" y = "+paire.getLast());
		}
		
		System.out.println("AllPos");
		getAllPos = contract.getAllPos();
		 it = getAllPos.iterator();
		while(it.hasNext()) {
			paire = it.next();
			System.out.println("x = "+paire.getFirst()+" y = "+paire.getLast());
		}

	}

}
