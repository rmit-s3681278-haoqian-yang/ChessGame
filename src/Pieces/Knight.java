package Pieces;

import java.awt.*;

import Tables.Board;
import Tables.Cell;

public class Knight extends Piece {

	public Knight(Board board) {
		super(board);
		NameOfPiece = " k ";
	}

	@Override
	public void Move(int x, int y) {

	}

	public boolean MoveTo(Cell c) {

		return false;
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
		int[][] offset = { { -2, -1 }, { -2, 1 }, { -1, 2 }, { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 }, { -1, -2 } };
		for (int i = 0; i < offset.length; i++) {
			int toRow = fromRow + offset[i][0];
			int toCol = fromCol + offset[i][1];
			if ((toRow >= 0 && toRow <= 5) && (toCol >= 0 && toCol <= 5)) {
				if (B.getCell(toRow, toCol).getPiece() == null) {
					B.getCell(toRow, toCol).setValidCell();
				} else if (!B.getCell(toRow, toCol).getPiece().getColor()
						.equals(B.getCell(fromRow, fromCol).getPiece().getColor())) {
					B.getCell(toRow, toCol).setValidCell();
				} else {
					continue;
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
