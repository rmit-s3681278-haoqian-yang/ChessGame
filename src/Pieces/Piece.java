package Pieces;

import java.awt.*;
import java.util.ArrayList;

import Tables.Board;
import Tables.Cell;

public abstract class Piece {

	protected int ROW;
	protected int COL;

	protected Board board;

	protected String NameOfPiece;

	protected ArrayList<Cell> ValidCells = new ArrayList<>();

	protected Cell OnWhichCell;

	private Color color;

	public Piece(Board board) {
		this.board = board;
	}

	public void setROW(int i) {
		ROW = i;
	}

	public void setCOL(int i) {
		COL = i;
	}

	public int getROW() {
		return ROW;
	}

	public int getCOL() {
		return COL;
	}

	public Color getColor() {
		return color;
	}

	public abstract void Move(int x, int y);

	public abstract String PieceName();

	public abstract void NameUpper();

	public abstract void ValidCells(Board B, int fromRow, int fromCol);

	public abstract boolean CanMove(Cell cell);
}
