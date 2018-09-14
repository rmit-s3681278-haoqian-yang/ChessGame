package Pieces;

import java.awt.*;
import java.util.ArrayList;

import Tables.Board;
import Tables.Cell;

public class Rook extends Piece {

	public Rook(Board board) {
		super(board);
		NameOfPiece = " r ";
	}

	@Override
	public void Move(int x, int y) {
		// int[] Xs = {x+2,x+1,x-1,x-2};
		// int[] Ys = {y+2,y+1,y-1,y-2};
		int DeltaX = ROW - x;
		int DeltaY = COL - y;

		// x+1,y ; x+2 ,y; x-1,y; x-2,y;
		// x,y+1;x,y+2;x,y-1;x,y-2;
		if (Math.abs(DeltaX) == 2 && COL == y) {

		} else if (Math.abs(DeltaX) == 1 && COL == y) {

		} else if (ROW == x && Math.abs(DeltaY) == 1) {

		} else if (ROW == x && Math.abs(DeltaY) == 2) {

		}

		ArrayList<Cell> Moves = new ArrayList<>();

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

	@Override
	public boolean CanMove(Cell cell) {
		// TODO Auto-generated method stub
		return false;
	}
}
