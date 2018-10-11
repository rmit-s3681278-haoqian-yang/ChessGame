package view;

import javafx.scene.layout.GridPane;

public class BoardPanel extends GridPane {

	TilePane[][] tilePanes = new TilePane[6][6];

	public BoardPanel() {

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {

				tilePanes[i][j] = new TilePane(i, j);
				tilePanes[i][j].setSizeInTheBoard(80);
				this.add(tilePanes[i][j], i, j);

			}
		}
		RepaintBoard();

		this.setHgap(5);
		this.setVgap(5);

	}

	public TilePane getTilePaneAt(int i, int j) {
		return tilePanes[i][j];
	}

	public void RepaintBoard() {
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {

				if ((i + j) % 2 == 0) {
					tilePanes[i][j].setStyle("-fx-background-color:rgb(127,127,127)");

				} else {
					tilePanes[i][j].setStyle("-fx-background-color:rgb(242,234,193)");
				}
			}
		}
	}

	public void FitGreenToTileAt(int i, int j) {
		tilePanes[i][j].setStyle("-fx-background-color:GREEN");

	}

}
