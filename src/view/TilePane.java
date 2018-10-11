package view;

import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.image.ImageView;

public class TilePane extends Button {

	int RowGrid;
	int ColGrid;

	public TilePane(int i, int j) {

		this.RowGrid = i;
		this.ColGrid = j;

	}

	public void setSizeInTheBoard(double k) {
		this.setPrefHeight(k);
		this.setPrefWidth(k);
		this.setStyle("-fx-opacity:0.75 ;-fx-background-radius:0");

	}

	public void drawPiece(ImageView view) {
		this.setGraphic(view);
		this.setContentDisplay(ContentDisplay.CENTER);

	}

	public int getRowGrid() {
		return RowGrid;
	}

	public int getColGrid() {
		return ColGrid;
	}

}
