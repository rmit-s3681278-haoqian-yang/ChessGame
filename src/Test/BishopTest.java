package Test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import org.junit.jupiter.api.Test;

import Pieces.Bishop;
import Tables.Board;
import Tables.Cell;

class BishopTest {

	Board Bl = new Board();

	Bishop bp1 = new Bishop(Bl);

	Cell c1 = Bl.getCell(4, 4);// A valid cell
	Cell c2 = Bl.getCell(3, 2);// an invalid cell
	Cell temp = Bl.getCell(2, 2);// Location of the piece-Bishop

	@Test
	void test() {
		
		Bl.putPieceTo(temp, bp1);
		Bl.ShowBoard();
		boolean move1 = bp1.CanMove(Bl.getCell(4, 4));
		boolean move2 = bp1.CanMove(Bl.getCell(3, 2));
		// bp1.MoveTo(c1);
		Bl.MovePieceTo(Bl.getCell(4, 4), bp1);

		assertEquals(move1, false);
		assertEquals(move2, false);
		assertEquals(Bl.getCell(2,2).isEmpty(),false);

		Bl.ShowBoard();
//		
//		Bl.MovePieceTo(Bl.getCell(5, 4), bp1);
//		Bl.ShowBoard();
//
//		
//		Bl.MovePieceTo(Bl.getCell(3, 4), bp1);
//		Bl.ShowBoard();
//
//		
//		Bl.MovePieceTo(Bl.getCell(0, 0), bp1);
//		Bl.ShowBoard();

	}

}
