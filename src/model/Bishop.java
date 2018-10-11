package model;

import javafx.scene.image.Image;

public class Bishop extends Piece {

	public Bishop(int a, int b, boolean isWhitePiece) {
		super(a, b, isWhitePiece);

		if (isWhitePiece) {
			this.icon = new Image(getClass().getResourceAsStream("/pic/icon/w_bishop.png"));
			name = " b ";
		} else {
			this.icon = new Image(getClass().getResourceAsStream("/pic/icon/b_bishop.png"));
			name = " B ";

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

		if (Math.abs(DeltaI) == 2 && Math.abs(DeltaJ) == 2) {
			if (!s) {
				k = true;
			}
		} else if (Math.abs(DeltaJ) == 1 && Math.abs(DeltaI) == 1) {

			k = true;
		}

		return k;
	}
}
