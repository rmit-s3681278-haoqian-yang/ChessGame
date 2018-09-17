package Tables;

import Pieces.Piece;

public class Cell {

	private int ROW;
	private int COL;
	private Piece PieceOnThisCell;
	private boolean EmptyCell;
	private boolean Highlighted;

	public Cell(int row, int col) {
		this.ROW = row;
		this.COL = col;
		this.PieceOnThisCell = null;
		this.EmptyCell = true;
		this.Highlighted = false;
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
