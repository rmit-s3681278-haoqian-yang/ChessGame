package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.*;

import java.util.ArrayList;

public class SelectSplitPiece extends Stage {

	ArrayList<Button> piecesList = new ArrayList<>();

	VBox frame = new VBox();

	public SelectSplitPiece(ArrayList<Piece> a) {

		for (int i = 0; i < a.size(); i++) {

			piecesList.add(i, new Button());

			if (a.get(i) instanceof Rook) {

				piecesList.get(i).setText("Rook");

			} else if (a.get(i) instanceof Knight) {

				piecesList.get(i).setText("Knight");
			}

			else if (a.get(i) instanceof Bishop) {

				piecesList.get(i).setText("Bishop");
			}

		}

		frame.getChildren().addAll(piecesList);

		FlowPane frame2 = new FlowPane();
		frame2.getChildren().addAll(piecesList);
		frame2.setAlignment(Pos.CENTER);
		this.setScene(new Scene(frame2));
		this.setMinHeight(360);
		this.setMinWidth(720);

	}

	public void addNewMergedPiece(String str) {

		piecesList.add(new Button(str));
		frame.getChildren().add(piecesList.get(piecesList.size() - 1));

	}
}
