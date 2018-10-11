package model;

import javafx.scene.layout.GridPane;

public class Board {

	private Player PlayerWhite;
	private Player PlayerBlack;

	private Tile[][] tiles = new Tile[6][6];

	public Board(Player W, Player B) {

		PlayerWhite = W;
		PlayerBlack = B;

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {

				tiles[i][j] = new Tile(i, j);

			}
		}

	}

	public Player getPlayerWhite() {
		return PlayerWhite;
	}

	public Player getPlayerBlack() {
		return PlayerBlack;
	}

	public Tile[][] getTiles() {
		return tiles;
	}

	public Tile getTileAt(int i, int j) {

		if (i >= 0 && i <= 5) {

			if (j >= 0 && j <= 5) {

				return tiles[i][j];
			}
		}
		return null;

	}

	public void Move(Tile startTile, Tile endTile) {

		Piece temp = startTile.getPiece();

		endTile.setPiece(temp);

		startTile.clearPiece();

	}

	public void PutPieceTo(Piece P, int i, int j) {
		tiles[i][j].setPiece(P);
	}

	public void setUpGame() {

		// set White Player's Piece
		tiles[0][0].setPiece(new Rook(0, 0, true));
		tiles[1][0].setPiece(new Bishop(1, 0, true));
		tiles[2][0].setPiece(new Knight(2, 0, true));
		tiles[3][0].setPiece(new Knight(3, 0, true));
		tiles[4][0].setPiece(new Bishop(4, 0, true));
		tiles[5][0].setPiece(new Rook(5, 0, true));

		// PutPieceTo(new Rook(0,0,true),0,0);

		tiles[0][5].setPiece(new Rook(0, 5, false));
		tiles[1][5].setPiece(new Bishop(1, 5, false));
		tiles[2][5].setPiece(new Knight(2, 5, false));
		tiles[3][5].setPiece(new Knight(3, 5, false));
		tiles[4][5].setPiece(new Bishop(4, 5, false));
		tiles[5][5].setPiece(new Rook(5, 5, false));

		// set Black Player's Piece

	}

	// //set White Player's Piece
	// table.getBoard().getTileAt(0, 0).AddMergePiece(new Rook(0, 0, true));
	// table.getBoard().getTileAt(1, 0).AddMergePiece(new Bishop(1, 0, true));
	// table.getBoard().getTileAt(2, 0).AddMergePiece(new Knight(2, 0, true));
	// table.getBoard().getTileAt(3, 0).AddMergePiece(new Knight(3, 0, true));
	// table.getBoard().getTileAt(4, 0).AddMergePiece(new Bishop(4, 0, true));
	// table.getBoard().getTileAt(5, 0).AddMergePiece(new Rook(5, 0, true));
	//
	//
	// //set Black Player's Piece
	// table.getBoard().getTileAt(0, 5).AddMergePiece(new Rook(0, 5, false));
	// table.getBoard().getTileAt(1, 5).AddMergePiece(new Bishop(1, 5, false));
	// table.getBoard().getTileAt(2, 5).AddMergePiece(new Knight(2, 5, false));
	// table.getBoard().getTileAt(3, 5).AddMergePiece(new Knight(3, 5, false));
	// table.getBoard().getTileAt(4, 5).AddMergePiece(new Bishop(4, 5, false));
	// table.getBoard().getTileAt(5, 5).AddMergePiece(new Rook(5, 5, false));

}
