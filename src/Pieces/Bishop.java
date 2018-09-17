package Pieces;

import java.awt.*;
import java.util.ArrayList;

import Tables.Board;
import Tables.Cell;

public class Bishop extends Piece {

	public Bishop(Board board) {
		super(board);
		NameOfPiece = " b ";
	}

	@Override
	public void Move(int x, int y) {

		// if(Xs-2==x&&COL+2==y) {//Left up 2 blocks
		//// if(x+1==Xs-1&&y-1==Ys+1) {//if one block is on the way
		////
		//// }
		//
		//
		//
		//
		// }
		//
		// else if(Xs+2==x&&COL+2==y) {//Right up 2 blocks
		//// if(x-1==Xs+1&&y-1==Ys+1) {//same as above
		////
		//// }
		//
		//
		//
		// }
		//
		// else if(Xs-2==x&&COL-2==y) {//Left down 2 blocks
		//// if(x+1==Xs-1&&y-1==Ys-1) {//same as above
		////
		//// }
		//
		//
		// }
		//
		// else if(Xs+2==x&&COL-2==y) {//Right down 2 blocks
		//// if(x-1==Xs+1&&y+1==Ys-1) {
		////
		//// }
		//
		//
		// }
		//
		// Cell leftup = new Cell(Xs-2,COL+2);
		//
		// Cell leftdown = new Cell(Xs-2,COL-2);
		//
		// Cell rightup = new Cell(Xs+2,COL+2);
		//
		// Cell rightdown = new Cell(Xs+2,COL-2);
		//
		//
	}

	public boolean CanMove(Cell c) {
		boolean k;
		int TARGET_ROW = c.getROWofCell();
		int TARGET_COL = c.getCOLofCell();
		int DR = TARGET_ROW - ROW;
		int DC = TARGET_COL - COL;

		if (Math.abs(DR) == 1 && Math.abs(DC) == 1) {
			k = true;
		} else if (Math.abs(DR) == 2 && Math.abs(DC) == 2 && isBlocked(TARGET_ROW, TARGET_COL) == false) {
			k = true;
		} else {
			k = false;
		}

		return k;

	}

	// if (DR == -1 && DC == -1) {
	// k = true;
	// } else if (DR == 1 && DC == -1) {
	// k = true;
	// } else if (DR == -1 && DC == 1) {
	// k = true;
	// } else if (DR == 1 && DC == -1) {
	// k = true;
	// }
	//

	// if(DR == -2&& DC ==-2) {
	// k = true;
	// }
	// else if(DR == -2&& DC == 2) {
	// k = true;
	// }

	private boolean isBlocked(int des_row, int des_col) {
		boolean k = false;
		int Rmid = (des_row + ROW) / 2;
		int Cmid = (des_col + COL) / 2;

		if (board.getCell(Rmid, Cmid).isEmpty()) {
			k = true;
		}

		return k;

	}

	public void MoveTo(Cell c) {
		// boolean k = false;
		// int TARGET_ROW = c.getROWofCell();
		// int TARGET_COL = c.getCOLofCell();

		// this.ROW = TARGET_ROW;
		// this.COL = TARGET_COL;

		if (CanMove(c)) {
			board.getCell(ROW, COL).setPieceOnThisCell(null);
			c.setPieceOnThisCell(this);
			this.ROW = c.getROWofCell();
			this.COL = c.getCOLofCell();

		}

		// Board B = new Board();
		// boolean k = false;
		// if(c.isValidCell()) {
		// c.setPieceOnThisCell(this);
		// this.ROW = c.getROWofCell();
		// this.COL = c.getCOLofCell();
		//
		// B.resetAllValidBooleans();
		// k= true;
		// }
		// return k;

	}

	@Override
	public String PieceName() {
		return NameOfPiece;
	}

	@Override
	public void NameUpper() {
		NameOfPiece = NameOfPiece.toUpperCase();
	}

	@Override
	public void ValidCells(Cell[][] C, int fromRow, int fromCol) {
		// Check top-left.
		for (int toRow = fromRow - 1; toRow >= fromRow - 2 && toRow >= 0; toRow--) {
			for (int toCol = fromCol - 1; toCol >= fromCol - 2 && toCol >= 0; toCol--) {
				if (C[toRow][toCol].getPiece() == null) {
					C[toRow][toCol].setValidCell();
				} else {
					if (C[toRow][toCol].getPiece().getColor().equals(C[fromRow][fromCol].getPiece().getColor())) {
						C[toRow][toCol].setValidCell();
					}
				}
			}
		}
		// Check top-right.
		for (int toRow = fromRow - 1; toRow >= fromRow - 2 && toRow >= 0; toRow--) {
			for (int toCol = fromCol + 1; toCol <= fromCol + 2 && toCol <= 5; toCol++) {
				if (C[toRow][toCol].getPiece() == null) {
					C[toRow][toCol].setValidCell();
				} else {
					if (C[toRow][toCol].getPiece().getColor().equals(C[fromRow][fromCol].getPiece().getColor())) {
						C[toRow][toCol].setValidCell();
					}
				}
			}
		}
		// Check bottom-left
		for (int toRow = fromRow + 1; toRow <= fromRow + 2 && toRow <= 5; toRow++) {
			for (int toCol = fromCol - 1; toCol >= fromCol - 2 && toCol >= 0; toCol--) {
				if (C[toRow][toCol].getPiece() == null) {
					C[toRow][toCol].setValidCell();
				} else {
					if (C[toRow][toCol].getPiece().getColor().equals(C[fromRow][fromCol].getPiece().getColor())) {
						C[toRow][toCol].setValidCell();
					}
				}
			}
		}
		// Check bottom-right.
		for (int toRow = fromRow + 1; toRow <= fromRow + 2 && toRow <= 5; toRow++) {
			for (int toCol = fromCol + 1; toCol <= fromCol + 2 && toCol <= 5; toCol++) {
				if (C[toRow][toCol].getPiece() == null) {
					C[toRow][toCol].setValidCell();
				} else {
					if (C[toRow][toCol].getPiece().getColor().equals(C[fromRow][fromCol].getPiece().getColor())) {
						C[toRow][toCol].setValidCell();
					}
				}
			}
		}
	}

}
