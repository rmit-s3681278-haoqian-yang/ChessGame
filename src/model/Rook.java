package model;

import javafx.scene.image.Image;

public class Rook extends Piece {

	public Rook(int a, int b, boolean isWhitePiece) {
		super(a, b, isWhitePiece);
		if (isWhitePiece) {
			this.icon = new Image(getClass().getResourceAsStream("/pic/icon/w_rook.png"));
			name = " r ";
		} else {
			this.icon = new Image(getClass().getResourceAsStream("/pic/icon/b_rook.png"));
			name = " R ";
		}
	}

	@Override
	public boolean canMove(int row, int col, Board board) {

		boolean k = false;

		int DeltaI = this.ROW - row;
		int DeltaJ = this.COL - col;

		int mI = (this.ROW + row) / 2;
		int mJ = (this.COL + col) / 2;

		boolean s = board.getTileAt(mI, mJ).getPiece() != null;

		if (Math.abs(DeltaI) == 2 && DeltaJ == 0) {
			if (!s) {
				k = true;
			}
		} else if (Math.abs(DeltaJ) == 2 && DeltaI == 0) {
			if (!s)

				k = true;
		} else if (Math.abs(DeltaI) == 1 && DeltaJ == 0) {
			k = true;
		} else if (Math.abs(DeltaJ) == 1 && DeltaI == 0) {
			k = true;
		}

		return k;
	}

}
