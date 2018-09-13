package Tables;

import Pieces.Piece;

public class Cell {

	final private int ROW;// the x axis
	final private int COL;// the y axis
	private Piece PieceOnThisCell;
	private boolean EmptyCell = true;
	private boolean Highlighted = false;

	public Cell(int x, int y) {
		ROW = x;
		COL = y;
	}

	public void setPieceOnThisCell(Piece p) {

		PieceOnThisCell = p;
	}
	
	public Piece getPiece() {
		return PieceOnThisCell;
	}

	public String ToString() {
		
		if (PieceOnThisCell == null) {
			return " - ";
		}
		return PieceOnThisCell.PieceName();
	}

	public int getXofCell() {
		return ROW;
	}

	public int getYofCell() {
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
