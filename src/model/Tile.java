package model;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class Tile {

	private int i;
	private int j;
	private ArrayList<Piece> piecesOnThisTile = new ArrayList<>();
	private int NumsOfMergedPiece;
	private boolean hasMergedPiece = false;
	private Piece OnlyPiece = null;
	private Piece MergedPiece = null;
	private boolean isEmpty = true;

	public Tile(int a, int b) {

		i = a;
		j = b;
		piecesOnThisTile = new ArrayList<>();

	}

	public int getNumsOfMergedPiece() {
		int k = piecesOnThisTile.size();

		return k;
	}

	public void AddMergePiece(Piece P) {

		P.setROW(i);
		P.setCOL(j);
		piecesOnThisTile.add(P);
		hasMergedPiece = true;
	}

	private void setMergedStatus() {
		if (piecesOnThisTile == null || piecesOnThisTile.size() < 1) {
			hasMergedPiece = false;
		} else {
			hasMergedPiece = true;
		}
	}

	public Piece getFirstPiece() {

		if (piecesOnThisTile != null && piecesOnThisTile.size() > 0) {

			return piecesOnThisTile.get(0);
		} else {
			return null;
		}
	}

	public boolean isEmpty() {

		boolean k = false;
		if (piecesOnThisTile == null || piecesOnThisTile.size() == 0) {
			k = true;
		}
		return k;
	}

	public void clearPiece() {

		OnlyPiece = null;
		// MergedPiece = null;
		piecesOnThisTile.clear();
		hasMergedPiece = false;
		isEmpty = true;

	}

	public void MergePiece(Piece P) {
		piecesOnThisTile.add(P);
		if (piecesOnThisTile.size() > 1) {
			hasMergedPiece = true;
		}
	}

	public Piece getPiece() {

		if (hasMergedPiece == false && piecesOnThisTile.size() == 1) {
			return piecesOnThisTile.get(0);
		}
		return MergedPiece;
	}

	//
	// public void setRook(Rook R) {
	//
	// boolean capture = false;
	//
	// if (isEmpty && !hasMergedPiece) {
	//
	//
	// OnlyPiece = R;
	//
	//
	// } else {
	//
	// if (R.isWhitePiece() == OnlyPiece.isWhitePiece()) {
	//
	// // Piece temp = OnlyPiece.clone();
	//
	//// int x = OnlyPiece.getROW();
	//// int y = OnlyPiece.getCOL();
	// boolean isWhite = OnlyPiece.isWhitePiece();
	//
	// piecesOnThisTile.add(R);
	//
	// OnlyPiece = new MergedPiece(i, j, isWhite);
	//
	// hasMergedPiece = true;
	// } else {
	//
	// R.setROW(i);
	// R.setCOL(j);
	// OnlyPiece = R;
	// piecesOnThisTile.clear();
	// capture = true;
	//
	// }
	// }
	//
	// }
	//
	// public void setKnight(Knight K) {
	//
	// if (hasMergedPiece == false) {
	// OnlyPiece = K;
	// // MergedPiece = null;
	// }
	//
	// }
	//
	// public void setBishop(Bishop B) {
	//
	// if (hasMergedPiece == false) {
	// OnlyPiece = B;
	// // MergedPiece = null;
	// }
	//
	// }
	//
	// public void setMergedPiece(MergedPiece M) {
	//
	//
	// }
	//
	// public void setPiece(Piece P) {
	//
	//
	//
	// if (P instanceof Rook) {
	// setRook((Rook) P);
	// } else if (P instanceof Knight) {
	// setKnight((Knight) P);
	// } else if (P instanceof Bishop) {
	// setBishop((Bishop) P);
	// } else if (P instanceof MergedPiece) {
	// setMergedPiece((MergedPiece) P);
	// }
	//
	//
	// }

	public void setPiece(Piece P) {

		if (this.OnlyPiece == null && this.piecesOnThisTile.size() == 0) {

			piecesOnThisTile.add(P);
			OnlyPiece = piecesOnThisTile.get(0);
			this.isEmpty = false;
		} else if (piecesOnThisTile != null && piecesOnThisTile.size() == 1) {

			if (piecesOnThisTile.get(0).isWhitePiece() == P.isWhitePiece()) {
				AddMergePiece(P);
			}

			else {
				this.clearPiece();
				this.setPiece(P);
			}
		}
	}

	public String toString() {
		String s = " . ";
		// if(this.OnlyPiece!=null) {
		// s = this.OnlyPiece.toString();
		// }

		if (this.piecesOnThisTile != null && this.piecesOnThisTile.size() == 1) {
			s = piecesOnThisTile.get(0).toString();
		}

		return s;

	}

	public boolean CanMove(int x, int y, Board board) {
		boolean k = false;
		for (int i = 0; i < piecesOnThisTile.size(); i++) {
			if (piecesOnThisTile.get(i).canMove(x, y, board)) {
				k = true;
			}
		}
		return k;
	}

	public Image getIcon() {
		if (piecesOnThisTile.size() == 1 && piecesOnThisTile.get(0) != null) {
			return piecesOnThisTile.get(0).getIcon();
		} else if (piecesOnThisTile.size() > 1) {
			return new MergedPiece(piecesOnThisTile.get(0).isWhitePiece()).getIcon();
		}
		return null;
	}

	public Piece getPieceByIndex(int i) {

		if (piecesOnThisTile != null && i >= 0 && i < piecesOnThisTile.size()) {

			return piecesOnThisTile.get(i);
		}

		return null;
	}

	public ArrayList getPiecesOnTheTile() {
		return piecesOnThisTile;
	}

}
