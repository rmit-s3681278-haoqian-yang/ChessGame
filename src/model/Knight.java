package model;

import javafx.scene.image.Image;

public class Knight extends Piece {

	public Knight(int a, int b, boolean isWhitePiece) {
		super(a, b, isWhitePiece);
		if (isWhitePiece) {
			this.icon = new Image(getClass().getResourceAsStream("/pic/icon/w_knight.png"));
			name = " k ";
		} else {
			this.icon = new Image(getClass().getResourceAsStream("/pic/icon/b_knight.png"));
			name = " K ";
		}
	}

	@Override
	public boolean canMove(int row, int col, Board board) {

		boolean k = false;

		int DeltaI = this.ROW - row;
		int DeltaJ = this.COL - col;

		if (Math.abs(DeltaI) == 2 && Math.abs(DeltaJ) == 1) {
			k = true;
		} else if (Math.abs(DeltaI) == 1 && Math.abs(DeltaJ) == 2) {
			k = true;
		}

		return k;

	}
}
