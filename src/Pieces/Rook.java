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
		// Check upwards.
		for (int toRow = fromRow - 1; toRow >= fromRow - 2 && toRow >= 0; toRow--) {
			if (C[toRow][fromCol].getPiece() == null) {
				C[toRow][fromCol].setValidCell();
			} else {
				if (C[toRow][fromCol].getPiece().getColor().equals(C[fromRow][fromCol].getPiece().getColor())) {
					C[toRow][fromCol].setValidCell();
				}
			}
		}
		// Check downwards.
		for (int toRow = fromRow + 1; toRow <= fromRow + 2 && toRow <= 5; toRow++) {
			if (C[toRow][fromCol].getPiece() == null) {
				C[toRow][fromCol].setValidCell();
			} else {
				if (C[toRow][fromCol].getPiece().getColor().equals(C[fromRow][fromCol].getPiece().getColor())) {
					C[toRow][fromCol].setValidCell();
				}
			}
		}
		// Check left.
		for (int toCol = fromCol - 1; toCol >= fromCol - 2 && toCol >= 0; toCol--) {
			if (C[fromRow][toCol].getPiece() == null) {
				C[fromRow][toCol].setValidCell();
			} else {
				if (C[fromRow][toCol].getPiece().getColor().equals(C[fromRow][fromCol].getPiece().getColor())) {
					C[fromRow][toCol].setValidCell();
				}
			}
		}
		// Check right.
		for (int toCol = fromCol + 1; toCol <= fromCol + 2 && toCol <= 5; toCol++) {
			if (C[fromRow][toCol].getPiece() == null) {
				C[fromRow][toCol].setValidCell();
			} else {
				if (C[fromRow][toCol].getPiece().getColor().equals(C[fromRow][fromCol].getPiece().getColor())) {
					C[fromRow][toCol].setValidCell();
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
