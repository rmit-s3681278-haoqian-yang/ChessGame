package Tables;

import Pieces.Piece;

public class Cell {

	final private int ROW;// the x axis
	final private int COL;// the y axis
	private Piece PieceOnThisCell;
	private boolean EmptyCell = true;
	private boolean Highlighted = false;
	private Board board;

	public Cell(int x, int y) {
		ROW = x;
		COL = y;
	}

	public void setPieceOnThisCell(Piece p) {

		if (p != null) {
			PieceOnThisCell = p;
			EmptyCell = false;
		}
	}

	public Piece getPiece() {
		return PieceOnThisCell;
	}

	public void setPieceNull() {
		PieceOnThisCell = null;
		EmptyCell = true;
	}

	public String ToString() {
		if (PieceOnThisCell != null) {
			return PieceOnThisCell.PieceName();
		} if (PieceOnThisCell == null) {
			return " - ";
		} else {
			return " - ";
		}
	}

	public int getROWofCell() {
		return ROW;
	}

	public int getCOLofCell() {
		return COL;
	}

	public boolean isEmpty() {
		return EmptyCell;
	}

	public boolean isValidCell() {
		return Highlighted;
	}

	public void setValidCell() {
		if (Highlighted == false) {
			Highlighted = true;
		}
	}

	public void setInvalidCell() {
		if (Highlighted == true) {
			Highlighted = false;
		}
	}

}
