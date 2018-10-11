package model;

import javafx.beans.property.adapter.ReadOnlyJavaBeanBooleanProperty;
import javafx.scene.image.Image;

public abstract class Piece implements Cloneable {

	int ROW;
	int COL;
	Image icon;
	String name;

	boolean isWhitePiece;

	public Piece() {

	}

	public Piece(int a, int b, boolean isWhitePiece) {

		ROW = a;
		COL = b;

		this.isWhitePiece = isWhitePiece;

	}

	public abstract boolean canMove(int row, int col, Board board);

	public int getROW() {
		return ROW;
	}

	public int getCOL() {
		return COL;
	}

	public boolean isWhitePiece() {
		return isWhitePiece;
	}

	public void setROW(int ROW) {
		this.ROW = ROW;
	}

	public void setCOL(int COL) {
		this.COL = COL;
	}

	public void setROWandCOL(int row, int col) {
		ROW = row;
		COL = col;
	}

	public Image getIcon() {
		return icon;
	}

	public void setWhitePiece() {
		isWhitePiece = true;
	}

	public void setBlackPiece() {
		isWhitePiece = false;
	}

	public String toString() {
		return name;
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();

	}
}
