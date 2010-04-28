package block;

import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.LinkedList;

import org.junit.Test;

public class BlockTest {
	
	public void checkInvariants(BlockContract block) {
		// inv1 : getType() == 'O' || 'L' || 'J' || 'T' || 'Z' || 'S' || 'I'
		if (!((block.getType() == 'O') || (block.getType() == 'L') || (block.getType() == 'J') || (block.getType() == 'T') || (block.getType() == 'Z') || (block.getType() == 'S') || (block.getType() == 'I'))) {
			throw new Error("Invariant (1) invalide");
		}
		// inv2 : getSize() == 2 || getSize() == 3 || getSize() == 4
		if (!((block.getSize() == 2) || (block.getSize() == 3) || (block.getSize() == 4))) {
			throw new Error("Invariant (2) invalide");
		}
		// inv3 : 0 <= getNbPos() && getNbPos <= 4
		if (!((0 <= block.getNbPos()) && (block.getNbPos() <= 4))) {
			throw new Error("Invariant (3) invalide");
		}
		Iterator<LinkedList<Integer>> it = block.getAllPos().iterator();
		int XMin = block.getSize()+1, XMax = 0, YMin = block.getSize()+1, YMax = 0;
		LinkedList<Integer> pos;
		while(it.hasNext()) {
			pos = it.next();
			if(pos.getFirst() < XMin) {
				XMin = pos.getFirst();
			}
			if (pos.getFirst() > XMax) {
				XMax = pos.getFirst();
			}
			if(pos.getLast() < YMin) {
				YMin = pos.getLast(); 
			}
			if (pos.getLast() > YMax) {
				YMax = pos.getLast();
			}
		}
		// inv4 : getXMin() == \findmin { first(p) \in getAllPos() }
		if (!(block.getXMin() == XMin)) {
			throw new Error("Invariant (4) invalide");
		}
		// inv5 : getXMax() == \findmax { first(p) \in getAllPos() }
		if (!(block.getXMax() == XMax)) {
			throw new Error("Invariant (5) invalide");
		}
		// inv6 : getYMin() == \findmin { second(p) \in getAllPos() }
		if (!(block.getYMin() == YMin)) {
			throw new Error("Invariant (6) invalide");
		}
		// inv7 : getYMax() == \findmax { second(p) \in getAllPos() }
		if (!(block.getYMax() == YMax)) {
			throw new Error("Invariant (7) invalide");
		}
		
		// inv8 : \forall x:int, y:int \in getHasPos((x,y)) { getAllPos().contains((x,y)) }
		for(int i=1; i<= block.getSize(); i++) {
			for (int j=1; j<=block.getSize(); j++) {
				if(block.hasPos(i, j)) {
					LinkedList<Integer> paire = new LinkedList<Integer>();
					paire.addFirst(i);
					paire.addLast(j);
					if(!block.getAllPos().contains(paire)) {
						throw new Error("Invariant (8) invalide");
					}
				}
			}
		}
		// inv9 : \forall x:int, y1:int, y2:int \in getHasPos((x,y1)) && getHasPos((x,y2)) { getLowPos().contains((x,max(y1,y2))) }
		for(int i=1; i<=block.getSize(); i++) {
			int max = 0;
			for(int j=1; j<=block.getSize(); j++) {
				if((block.hasPos(i, j)) && j > max) {
					max = j;					
				}
			}

			if(max >0) {
				LinkedList<Integer> paire = new LinkedList<Integer>();
				paire.addFirst(i);
				paire.addLast(max);
				if(!(block.getLowPos().contains(paire))) {
					throw new Error("Invariant (9) invalide");
				}
			}
		}
	}
	
	@Test
	public void testGetType() {
		BlockImpl blockI = new BlockImpl();
		BlockContract blockC = new BlockContract(blockI);
		char Type;
		
		Type = 'O';
		blockC.init(Type);
		assertTrue(blockC.getType() == Type);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'L';
		blockC.init(Type);
		assertTrue(blockC.getType() == Type);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}		
		
		
		Type = 'J';
		blockC.init(Type);
		assertTrue(blockC.getType() == Type);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'T';
		blockC.init(Type);
		assertTrue(blockC.getType() == Type);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'Z';
		blockC.init(Type);
		assertTrue(blockC.getType() == Type);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'S';
		blockC.init(Type);
		assertTrue(blockC.getType() == Type);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'I';
		blockC.init(Type);
		assertTrue(blockC.getType() == Type);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
	}
	
	@Test
	public void testGetSize() {
		BlockImpl blockI = new BlockImpl();
		BlockContract blockC = new BlockContract(blockI);
		char Type;
		
		Type = 'O';
		blockC.init(Type);
		assertTrue(blockC.getSize() == 2);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'L';
		blockC.init(Type);
		assertTrue(blockC.getSize() == 3);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}		
		
		
		Type = 'J';
		blockC.init(Type);
		assertTrue(blockC.getSize() == 3);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'T';
		blockC.init(Type);
		assertTrue(blockC.getSize() == 3);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'Z';
		blockC.init(Type);
		assertTrue(blockC.getSize() == 3);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'S';
		blockC.init(Type);
		assertTrue(blockC.getSize() == 3);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'I';
		blockC.init(Type);
		assertTrue(blockC.getSize() == 4);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}		
	}
	
	@Test
	public void testGetNbPos() {
		BlockImpl blockI = new BlockImpl();
		BlockContract blockC = new BlockContract(blockI);
		char Type;
		
		Type = 'O';
		blockC.init(Type);
		assertTrue(blockC.getNbPos() == 4);
	
		blockC.removeAllPos();
		assertTrue(blockC.getNbPos() == 0);
		
		blockC.addPos(2, 2);
		assertTrue(blockC.getNbPos() == 1);
		
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'L';
		blockC.init(Type);
		assertTrue(blockC.getNbPos() == 4);
	
		blockC.removeAllPos();
		assertTrue(blockC.getNbPos() == 0);
		
		blockC.addPos(2, 2);
		assertTrue(blockC.getNbPos() == 1);
		
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}		
		
		
		Type = 'J';
		blockC.init(Type);
		assertTrue(blockC.getNbPos() == 4);
	
		blockC.removeAllPos();
		assertTrue(blockC.getNbPos() == 0);
		
		blockC.addPos(2, 2);
		assertTrue(blockC.getNbPos() == 1);
		
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'T';
		blockC.init(Type);
		assertTrue(blockC.getNbPos() == 4);
	
		blockC.removeAllPos();
		assertTrue(blockC.getNbPos() == 0);
		
		blockC.addPos(2, 2);
		assertTrue(blockC.getNbPos() == 1);
		
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'Z';
		blockC.init(Type);
		assertTrue(blockC.getNbPos() == 4);
	
		blockC.removeAllPos();
		assertTrue(blockC.getNbPos() == 0);
		
		blockC.addPos(2, 2);
		assertTrue(blockC.getNbPos() == 1);
		
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'S';
		blockC.init(Type);
		assertTrue(blockC.getNbPos() == 4);
	
		blockC.removeAllPos();
		assertTrue(blockC.getNbPos() == 0);
		
		blockC.addPos(2, 2);
		assertTrue(blockC.getNbPos() == 1);
		
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'I';
		blockC.init(Type);
		assertTrue(blockC.getNbPos() == 4);
		
		blockC.removeAllPos();
		assertTrue(blockC.getNbPos() == 0);
		
		blockC.addPos(2, 2);
		assertTrue(blockC.getNbPos() == 1);
		
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
	}
	
	@Test
	public void testGetXMin() {
		BlockImpl blockI = new BlockImpl();
		BlockContract blockC = new BlockContract(blockI);
		char Type;
		
		Type = 'O';
		blockC.init(Type);
		assertTrue(blockC.getXMin() == 1);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'L';
		blockC.init(Type);
		assertTrue(blockC.getXMin() == 2);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}		
		
		
		Type = 'J';
		blockC.init(Type);
		assertTrue(blockC.getXMin() == 1);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'T';
		blockC.init(Type);
		assertTrue(blockC.getXMin() == 1);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'Z';
		blockC.init(Type);
		assertTrue(blockC.getXMin() == 1);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'S';
		blockC.init(Type);
		assertTrue(blockC.getXMin() == 1);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'I';
		blockC.init(Type);
		assertTrue(blockC.getXMin() == 2);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}		
	}
	
	@Test
	public void testGetXMax() {
		BlockImpl blockI = new BlockImpl();
		BlockContract blockC = new BlockContract(blockI);
		char Type;
		
		Type = 'O';
		blockC.init(Type);
		assertTrue(blockC.getXMax() == 2);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'L';
		blockC.init(Type);
		assertTrue(blockC.getXMax() == 3);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}		
		
		
		Type = 'J';
		blockC.init(Type);
		assertTrue(blockC.getXMax() == 2);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'T';
		blockC.init(Type);
		assertTrue(blockC.getXMax() == 3);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'Z';
		blockC.init(Type);
		assertTrue(blockC.getXMax() == 3);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'S';
		blockC.init(Type);
		assertTrue(blockC.getXMax() == 3);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'I';
		blockC.init(Type);
		assertTrue(blockC.getXMax() == 2);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}		
	}
	
	@Test
	public void testGetYMin() {
		BlockImpl blockI = new BlockImpl();
		BlockContract blockC = new BlockContract(blockI);
		char Type;
		
		Type = 'O';
		blockC.init(Type);
		assertTrue(blockC.getYMin() == 1);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'L';
		blockC.init(Type);
		assertTrue(blockC.getYMin() == 1);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}		
		
		
		Type = 'J';
		blockC.init(Type);
		assertTrue(blockC.getYMin() == 1);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'T';
		blockC.init(Type);
		assertTrue(blockC.getYMin() == 2);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'Z';
		blockC.init(Type);
		assertTrue(blockC.getYMin() == 2);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'S';
		blockC.init(Type);
		assertTrue(blockC.getYMin() == 2);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'I';
		blockC.init(Type);
		assertTrue(blockC.getYMin() == 1);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
	}
	
	@Test
	public void testGetYMax() {
		BlockImpl blockI = new BlockImpl();
		BlockContract blockC = new BlockContract(blockI);
		char Type;
		
		Type = 'O';
		blockC.init(Type);
		assertTrue(blockC.getYMax() == 2);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'L';
		blockC.init(Type);
		assertTrue(blockC.getYMax() == 3);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}		
		
		
		Type = 'J';
		blockC.init(Type);
		assertTrue(blockC.getYMax() == 3);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'T';
		blockC.init(Type);
		assertTrue(blockC.getYMax() == 3);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'Z';
		blockC.init(Type);
		assertTrue(blockC.getYMax() == 3);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'S';
		blockC.init(Type);
		assertTrue(blockC.getYMax() == 3);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'I';
		blockC.init(Type);
		assertTrue(blockC.getYMax() == 4);
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}	
	}
	
	@Test
	public void testHasPos() {
		BlockImpl blockI = new BlockImpl();
		BlockContract blockC = new BlockContract(blockI);
		char Type;
		
		Type = 'O';
		blockC.init(Type);
		
		/* Précondition non vérifiée */
		try {
			blockC.hasPos(0, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(1, 0);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(5, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(3, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(0, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition vérifiée */
		try {
			blockC.hasPos(2, 2);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'L';
		blockC.init(Type);
		
		/* Précondition non vérifiée */
		try {
			blockC.hasPos(0, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(1, 0);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(5, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(3, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(0, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition vérifiée */
		try {
			blockC.hasPos(2, 2);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}		
		
		
		Type = 'J';
		blockC.init(Type);

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(0, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(1, 0);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(5, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(3, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(0, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition vérifiée */
		try {
			blockC.hasPos(2, 2);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'T';
		blockC.init(Type);

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(0, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(1, 0);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(5, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(3, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(0, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition vérifiée */
		try {
			blockC.hasPos(2, 2);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
				
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'Z';
		blockC.init(Type);

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(0, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(1, 0);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(5, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(3, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(0, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition vérifiée */
		try {
			blockC.hasPos(2, 2);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
			
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'S';
		blockC.init(Type);

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(0, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(1, 0);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(5, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(3, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(0, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition vérifiée */
		try {
			blockC.hasPos(2, 2);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
			
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'I';
		blockC.init(Type);

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(0, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(1, 0);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(5, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(3, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.hasPos(0, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition vérifiée */
		try {
			blockC.hasPos(2, 2);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
	}
	
	@Test
	public void testGetAllPos() {
		BlockImpl blockI = new BlockImpl();
		BlockContract blockC = new BlockContract(blockI);
		char Type;
		LinkedList<Integer> paire = new LinkedList<Integer>();
		
		Type = 'O';
		blockC.init(Type);
		
		paire.addFirst(1); paire.addLast(1);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
		
		paire.addFirst(1); paire.addLast(2);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
	
		paire.addFirst(2); paire.addLast(1);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
		
		paire.addFirst(2); paire.addLast(2);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
		
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'L';
		blockC.init(Type);

		paire.addFirst(2); paire.addLast(1);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
		
		paire.addFirst(2); paire.addLast(2);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
	
		paire.addFirst(2); paire.addLast(3);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
		
		paire.addFirst(3); paire.addLast(3);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
		
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}		
		
		
		Type = 'J';
		blockC.init(Type);

		paire.addFirst(1); paire.addLast(3);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
		
		paire.addFirst(2); paire.addLast(1);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
	
		paire.addFirst(2); paire.addLast(2);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
		
		paire.addFirst(2); paire.addLast(3);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
			
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'T';
		blockC.init(Type);

		paire.addFirst(1); paire.addLast(2);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
		
		paire.addFirst(2); paire.addLast(2);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
	
		paire.addFirst(2); paire.addLast(3);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
		
		paire.addFirst(3); paire.addLast(2);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'Z';
		blockC.init(Type);

		paire.addFirst(1); paire.addLast(2);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
		
		paire.addFirst(2); paire.addLast(2);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
	
		paire.addFirst(2); paire.addLast(3);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
		
		paire.addFirst(3); paire.addLast(3);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'S';
		blockC.init(Type);

		paire.addFirst(1); paire.addLast(3);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
		
		paire.addFirst(2); paire.addLast(2);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
	
		paire.addFirst(2); paire.addLast(3);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
		
		paire.addFirst(3); paire.addLast(2);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'I';
		blockC.init(Type);

		paire.addFirst(2); paire.addLast(1);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
		
		paire.addFirst(2); paire.addLast(2);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
	
		paire.addFirst(2); paire.addLast(3);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
		
		paire.addFirst(2); paire.addLast(4);
		assertTrue(blockC.getAllPos().contains(paire));
		paire.clear();
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
	}
	
	@Test
	public void testGetLowPos() {
		BlockImpl blockI = new BlockImpl();
		BlockContract blockC = new BlockContract(blockI);
		char Type;
		LinkedList<Integer> paire = new LinkedList<Integer>();
		
		Type = 'O';
		blockC.init(Type);

		paire.addFirst(1); paire.addLast(2);
		assertTrue(blockC.getLowPos().contains(paire));
		paire.clear();
		
		paire.addFirst(2); paire.addLast(2);
		assertTrue(blockC.getLowPos().contains(paire));
		paire.clear();
		
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'L';
		blockC.init(Type);

		paire.addFirst(2); paire.addLast(3);
		assertTrue(blockC.getLowPos().contains(paire));
		paire.clear();
		
		paire.addFirst(3); paire.addLast(3);
		assertTrue(blockC.getLowPos().contains(paire));
		paire.clear();
		
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}		
		
		
		Type = 'J';
		blockC.init(Type);

		paire.addFirst(1); paire.addLast(3);
		assertTrue(blockC.getLowPos().contains(paire));
		paire.clear();
		
		paire.addFirst(2); paire.addLast(3);
		assertTrue(blockC.getLowPos().contains(paire));
		paire.clear();
			
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'T';
		blockC.init(Type);

		paire.addFirst(1); paire.addLast(2);
		assertTrue(blockC.getLowPos().contains(paire));
		paire.clear();
		
		paire.addFirst(2); paire.addLast(3);
		assertTrue(blockC.getLowPos().contains(paire));
		paire.clear();
		
		paire.addFirst(3); paire.addLast(2);
		assertTrue(blockC.getLowPos().contains(paire));
		paire.clear();
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'Z';
		blockC.init(Type);

		paire.addFirst(1); paire.addLast(2);
		assertTrue(blockC.getLowPos().contains(paire));
		paire.clear();

		paire.addFirst(2); paire.addLast(3);
		assertTrue(blockC.getLowPos().contains(paire));
		paire.clear();
		
		paire.addFirst(3); paire.addLast(3);
		assertTrue(blockC.getLowPos().contains(paire));
		paire.clear();
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'S';
		blockC.init(Type);

		paire.addFirst(1); paire.addLast(3);
		assertTrue(blockC.getLowPos().contains(paire));
		paire.clear();
		
		paire.addFirst(2); paire.addLast(3);
		assertTrue(blockC.getLowPos().contains(paire));
		paire.clear();
		
		paire.addFirst(3); paire.addLast(2);
		assertTrue(blockC.getLowPos().contains(paire));
		paire.clear();
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		
		Type = 'I';
		blockC.init(Type);

		paire.addFirst(2); paire.addLast(4);
		assertTrue(blockC.getLowPos().contains(paire));
		paire.clear();
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
	}
	
	@Test
	public void testInit() {
		BlockImpl blockI = new BlockImpl();
		BlockContract blockC = new BlockContract(blockI);
		char Type;
		
		/* Précondition non vérifiée */
		try {
			blockC.init('A');
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		Type = 'O';
		/* Précondition vérifiée */
		try {
			blockC.init(Type);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == Type);
		
		/* PostCondition 2 */
		assertTrue(blockC.getNbPos() == 4);
		
		
		Type = 'L';
		/* Précondition vérifiée */
		try {
			blockC.init(Type);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}		
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == Type);
		
		/* PostCondition 2 */
		assertTrue(blockC.getNbPos() == 4);
		
		
		Type = 'J';
		/* Précondition vérifiée */
		try {
			blockC.init(Type);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == Type);
		
		/* PostCondition 2 */
		assertTrue(blockC.getNbPos() == 4);
		
				
		Type = 'T';
		/* Précondition vérifiée */
		try {
			blockC.init(Type);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == Type);
		
		/* PostCondition 2 */
		assertTrue(blockC.getNbPos() == 4);
		
		
		Type = 'Z';
		/* Précondition vérifiée */
		try {
			blockC.init(Type);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == Type);
		
		/* PostCondition 2 */
		assertTrue(blockC.getNbPos() == 4);
		
		
		Type = 'S';
		/* Précondition vérifiée */
		try {
			blockC.init(Type);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == Type);
		
		/* PostCondition 2 */
		assertTrue(blockC.getNbPos() == 4);
		
		
		Type = 'I';
		/* Précondition vérifiée */
		try {
			blockC.init(Type);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == Type);
		
		/* PostCondition 2 */
		assertTrue(blockC.getNbPos() == 4);
	}

	@Test
	public void testAddPos() {
		BlockImpl blockI = new BlockImpl();
		BlockContract blockC = new BlockContract(blockI);
		char Type;
		int getType_atPre;
		int getSize_atPre;
		int getNbPos_atPre;
		boolean[][] hasPos_atPre;
		int x;
		int y;

		Type = 'O';
		blockC.init(Type);
		blockC.removeAllPos();
		blockC.addPos(2, 2);
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(0, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(1, 0);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(5, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(3, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(0, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(2, 2);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		hasPos_atPre = new boolean[blockC.getSize()][blockC.getSize()];
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				hasPos_atPre[i-1][j-1] = blockC.hasPos(i, j);
			}
		}
		x = 1;
		y = 1;
		
		/* Précondition vérifiée */
		try {
			blockC.addPos(x, y);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
			
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre+1);
		
		/* PostCondition 4 */
		assertTrue(blockC.hasPos(x, y));
		
		/* PostCondition 5 */
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				if((i!=x) && (j!=y)) {
					assertTrue(blockC.hasPos(i, j) == hasPos_atPre[i-1][j-1]);
				}
			}
		}
		
		
		Type = 'L';
		blockC.init(Type);
		blockC.removeAllPos();
		blockC.addPos(2, 2);
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(0, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(1, 0);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(5, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(3, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(0, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(2, 2);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		hasPos_atPre = new boolean[blockC.getSize()][blockC.getSize()];
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				hasPos_atPre[i-1][j-1] = blockC.hasPos(i, j);
			}
		}
		x = 2;
		y = 1;
		
		/* Précondition vérifiée */
		try {
			blockC.addPos(x, y);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}		
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre+1);
		
		/* PostCondition 4 */
		assertTrue(blockC.hasPos(x, y));
		
		/* PostCondition 5 */
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				if((i!=x) && (j!=y)) {
					assertTrue(blockC.hasPos(i, j) == hasPos_atPre[i-1][j-1]);
				}
			}
		}
		
		
		Type = 'J';
		blockC.init(Type);
		blockC.removeAllPos();
		blockC.addPos(2, 2);
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(0, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(1, 0);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(5, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(3, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(0, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(2, 2);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		hasPos_atPre = new boolean[blockC.getSize()][blockC.getSize()];
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				hasPos_atPre[i-1][j-1] = blockC.hasPos(i, j);
			}
		}
		x = 2;
		y = 1;
		
		/* Précondition vérifiée */
		try {
			blockC.addPos(x, y);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre+1);
		
		/* PostCondition 4 */
		assertTrue(blockC.hasPos(x, y));
		
		/* PostCondition 5 */
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				if((i!=x) && (j!=y)) {
					assertTrue(blockC.hasPos(i, j) == hasPos_atPre[i-1][j-1]);
				}
			}
		}
		
				
		Type = 'T';
		blockC.init(Type);
		blockC.removeAllPos();
		blockC.addPos(2, 2);
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(0, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(1, 0);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(5, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(3, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(0, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(2, 2);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		hasPos_atPre = new boolean[blockC.getSize()][blockC.getSize()];
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				hasPos_atPre[i-1][j-1] = blockC.hasPos(i, j);
			}
		}
		x = 1;
		y = 2;
		
		/* Précondition vérifiée */
		try {
			blockC.addPos(x, y);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre+1);
		
		/* PostCondition 4 */
		assertTrue(blockC.hasPos(x, y));
		
		/* PostCondition 5 */
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				if((i!=x) && (j!=y)) {
					assertTrue(blockC.hasPos(i, j) == hasPos_atPre[i-1][j-1]);
				}
			}
		}
		
		
		Type = 'Z';
		blockC.init(Type);
		blockC.removeAllPos();
		blockC.addPos(2, 2);
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(0, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(1, 0);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(5, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(3, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(0, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(2, 2);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		hasPos_atPre = new boolean[blockC.getSize()][blockC.getSize()];
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				hasPos_atPre[i-1][j-1] = blockC.hasPos(i, j);
			}
		}
		x = 1;
		y = 2;
		
		/* Précondition vérifiée */
		try {
			blockC.addPos(x, y);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre+1);
		
		/* PostCondition 4 */
		assertTrue(blockC.hasPos(x, y));
		
		/* PostCondition 5 */
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				if((i!=x) && (j!=y)) {
					assertTrue(blockC.hasPos(i, j) == hasPos_atPre[i-1][j-1]);
				}
			}
		}
		
		
		Type = 'S';
		blockC.init(Type);
		blockC.removeAllPos();
		blockC.addPos(2, 2);
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(0, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(1, 0);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(5, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(3, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(0, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(2, 2);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		hasPos_atPre = new boolean[blockC.getSize()][blockC.getSize()];
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				hasPos_atPre[i-1][j-1] = blockC.hasPos(i, j);
			}
		}
		x = 1;
		y = 3;
		
		/* Précondition vérifiée */
		try {
			blockC.addPos(x, y);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre+1);
		
		/* PostCondition 4 */
		assertTrue(blockC.hasPos(x, y));
		
		/* PostCondition 5 */
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				if((i!=x) && (j!=y)) {
					assertTrue(blockC.hasPos(i, j) == hasPos_atPre[i-1][j-1]);
				}
			}
		}
		
		
		Type = 'I';
		blockC.init(Type);
		blockC.removeAllPos();
		blockC.addPos(2, 2);
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(0, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(1, 0);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(5, 3);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(3, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}

		/* Précondition non vérifiée */
		try {
			blockC.addPos(0, 5);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Précondition non vérifiée */
		try {
			blockC.addPos(2, 2);
			assertTrue(false);
		} catch(Error err) {
			assertTrue(true);
		}
		
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		hasPos_atPre = new boolean[blockC.getSize()][blockC.getSize()];
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				hasPos_atPre[i-1][j-1] = blockC.hasPos(i, j);
			}
		}
		x = 2;
		y = 1;
		
		/* Précondition vérifiée */
		try {
			blockC.addPos(x, y);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
	
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre+1);
		
		/* PostCondition 4 */
		assertTrue(blockC.hasPos(x, y));
		
		/* PostCondition 5 */
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				if((i!=x) && (j!=y)) {
					assertTrue(blockC.hasPos(i, j) == hasPos_atPre[i-1][j-1]);
				}
			}
		}
	}
	
	@Test
	public void testRemoveAllPos() {
		BlockImpl blockI = new BlockImpl();
		BlockContract blockC = new BlockContract(blockI);
		char Type;
		int getType_atPre;
		int getSize_atPre;

		Type = 'O';
		blockC.init(Type);
				
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		
		blockC.removeAllPos();
			
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == 0);
		
		/* PostCondition 4 */
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				assertTrue(!blockC.hasPos(i, j));
			}
		}
		
		
		Type = 'L';
		blockC.init(Type);
				
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		
		blockC.removeAllPos();
			
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == 0);
		
		/* PostCondition 4 */
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				assertTrue(!blockC.hasPos(i, j));
			}
		}
				
		
		Type = 'J';
		blockC.init(Type);
						
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		
		blockC.removeAllPos();
			
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == 0);
		
		/* PostCondition 4 */
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				assertTrue(!blockC.hasPos(i, j));
			}
		}
		
				
		Type = 'T';
		blockC.init(Type);
				
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		
		blockC.removeAllPos();
			
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == 0);
		
		/* PostCondition 4 */
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				assertTrue(!blockC.hasPos(i, j));
			}
		}
		
		
		Type = 'Z';
		blockC.init(Type);
					
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		
		blockC.removeAllPos();
			
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == 0);
		
		/* PostCondition 4 */
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				assertTrue(!blockC.hasPos(i, j));
			}
		}
		
		
		Type = 'S';
		blockC.init(Type);
				
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		
		blockC.removeAllPos();
			
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == 0);
		
		/* PostCondition 4 */
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				assertTrue(!blockC.hasPos(i, j));
			}
		}
		
		
		Type = 'I';
		blockC.init(Type);
				
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		
		blockC.removeAllPos();
			
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == 0);
		
		/* PostCondition 4 */
		for(int i=1; i<=blockC.getSize(); i++) {
			for(int j=1; j<=blockC.getSize(); j++) {
				assertTrue(!blockC.hasPos(i, j));
			}
		}		
	}

	@Test
	public void testRotateLeft() {
		BlockImpl blockI = new BlockImpl();
		BlockContract blockC = new BlockContract(blockI);
		char Type;
		int getType_atPre;
		int getSize_atPre;
		int getNbPos_atPre;

		Type = 'O';
		blockC.init(Type);
				
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		
		blockC.rotateLeft();
			
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre);
		
		Type = 'L';
		blockC.init(Type);
				
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		
		blockC.rotateLeft();
			
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre);
				
		
		Type = 'J';
		blockC.init(Type);
						
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		
		blockC.rotateLeft();
			
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre);
		
				
		Type = 'T';
		blockC.init(Type);
				
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		
		blockC.rotateLeft();
			
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre);
		
		
		Type = 'Z';
		blockC.init(Type);
					
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		
		blockC.rotateLeft();
			
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre);
		
		
		Type = 'S';
		blockC.init(Type);
				
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		
		blockC.rotateLeft();
			
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre);
		
		
		Type = 'I';
		blockC.init(Type);
				
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		
		blockC.rotateLeft();
			
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre);		
	}
	
	@Test
	public void testRotateRight() {
		BlockImpl blockI = new BlockImpl();
		BlockContract blockC = new BlockContract(blockI);
		char Type;
		int getType_atPre;
		int getSize_atPre;
		int getNbPos_atPre;

		Type = 'O';
		blockC.init(Type);
				
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		
		blockC.rotateRight();
			
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre);
		
		Type = 'L';
		blockC.init(Type);
				
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		
		blockC.rotateRight();
			
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre);
				
		
		Type = 'J';
		blockC.init(Type);
						
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		
		blockC.rotateRight();
			
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre);
		
				
		Type = 'T';
		blockC.init(Type);
				
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		
		blockC.rotateRight();
			
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre);
		
		
		Type = 'Z';
		blockC.init(Type);
					
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		
		blockC.rotateRight();
			
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre);
		
		
		Type = 'S';
		blockC.init(Type);
				
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		
		blockC.rotateRight();
			
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre);
		
		
		Type = 'I';
		blockC.init(Type);
				
		/* Captures */
		getType_atPre = blockC.getType();
		getSize_atPre = blockC.getSize();
		getNbPos_atPre = blockC.getNbPos();
		
		blockC.rotateRight();
			
		/* Invariants */
		try {
			checkInvariants(blockC);
			assertTrue(true);
		} catch(Error err) {
			assertTrue(false);
		}
		
		/* PostCondition 1 */
		assertTrue(blockC.getType() == getType_atPre);
		
		/* PostCondition 2 */
		assertTrue(blockC.getSize() == getSize_atPre);
		
		/* PostCondition 3 */
		assertTrue(blockC.getNbPos() == getNbPos_atPre);		
	}
}
