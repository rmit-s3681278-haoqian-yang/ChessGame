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
	public void ValidCells(Board B, int fromRow, int fromCol) {
		// Check upwards.
		for (int toRow = fromRow - 1; toRow >= fromRow - 2 && toRow >= 0; toRow--) {
			if (B.getCell(toRow, fromCol).getPiece() == null) {
				B.getCell(toRow, fromCol).setValidCell();
			} else {
				if (B.getCell(toRow, fromCol).getPiece().isWhite() != B.getCell(fromRow, fromCol).getPiece().isWhite()) {
					B.getCell(toRow, fromCol).setValidCell();
					break;
				} else {
					break;
				}
			}
		}
		// Check downwards.
		for (int toRow = fromRow + 1; toRow <= fromRow + 2 && toRow <= 5; toRow++) {
			if (B.getCell(toRow, fromCol).getPiece() == null) {
				B.getCell(toRow, fromCol).setValidCell();
			} else {
				if (B.getCell(toRow, fromCol).getPiece().isWhite() != B.getCell(fromRow, fromCol).getPiece().isWhite()) {
					B.getCell(toRow, fromCol).setValidCell();
					break;
				} else {
					break;
				}
			}
		}
		// Check left.
		for (int toCol = fromCol - 1; toCol >= fromCol - 2 && toCol >= 0; toCol--) {
			if (B.getCell(fromRow, toCol).getPiece() == null) {
				B.getCell(fromRow, toCol).setValidCell();
			} else {
				if (B.getCell(fromRow, toCol).getPiece().isWhite() != B.getCell(fromRow, fromCol).getPiece().isWhite()) {
					B.getCell(fromRow, toCol).setValidCell();
					break;
				} else {
					break;
				}
			}
		}
		// Check right.
		for (int toCol = fromCol + 1; toCol <= fromCol + 2 && toCol <= 5; toCol++) {
			if (B.getCell(fromRow, toCol).getPiece() == null) {
				B.getCell(fromRow, toCol).setValidCell();
			} else {
				if (B.getCell(fromRow, toCol).getPiece().isWhite() != B.getCell(fromRow, fromCol).getPiece().isWhite()) {
					B.getCell(fromRow, toCol).setValidCell();
					break;
				} else {
					break;
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
