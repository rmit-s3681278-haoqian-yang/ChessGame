package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;

public class RightPanel extends HBox {

	Button split = new Button("Split Piece");
	Label ScoreOfWhite = new Label();
	Label ScoreOfBlack = new Label();
	Label RemainingTurns = new Label();

	public RightPanel() {

		split.setStyle(
				"-fx-border-color:#e2e2e2; -fx-border-width:2; -fx-background-radius:0;-fx-background-color:#1d1d1d;-fx-font-size:11pt;-fx-text-fill:#d8d8d8;");

		int width = 160;

		Label Title1 = new Label("Score White");

		Label Title2 = new Label("Score Black");

		Label Title3 = new Label("Turns Remaining");
		Title1.setStyle(
				"-fx-border-color:#e2e2e2; -fx-border-width:2; -fx-background-radius:0;-fx-background-color:#1d1d1d;-fx-font-size:11pt;-fx-text-fill:#d8d8d8;");
		Title2.setStyle(
				"-fx-border-color:#e2e2e2; -fx-border-width:2; -fx-background-radius:0;-fx-background-color:#1d1d1d;-fx-font-size:11pt;-fx-text-fill:#d8d8d8;");
		Title3.setStyle(
				"-fx-border-color:#e2e2e2; -fx-border-width:2; -fx-background-radius:0;-fx-background-color:#1d1d1d;-fx-font-size:11pt;-fx-text-fill:#d8d8d8;");

		Title1.setTextAlignment(TextAlignment.CENTER);
		Title1.setAlignment(Pos.CENTER);
		Title2.setAlignment(Pos.CENTER);
		Title3.setAlignment(Pos.CENTER);

		HBox leftFit = new HBox();
		HBox rightFit = new HBox();
		HBox topFit = new HBox();
		HBox bottomFit = new HBox();

		VBox pane1 = new VBox();
		pane1.getChildren().addAll(topFit, split, Title1, ScoreOfWhite, Title2, ScoreOfBlack, Title3, RemainingTurns,
				bottomFit);
		ScoreOfWhite.setPrefWidth(160);
		ScoreOfBlack.setStyle(
				"-fx-border-color:#e2e2e2; -fx-border-width:2; -fx-background-radius:0;-fx-background-color:#1d1d1d;-fx-font-size:11pt;-fx-text-fill:#d8d8d8;");
		ScoreOfWhite.setStyle(
				"-fx-border-color:#e2e2e2; -fx-border-width:2; -fx-background-radius:0;-fx-background-color:#1d1d1d;-fx-font-size:11pt;-fx-text-fill:#d8d8d8;");
		RemainingTurns.setStyle(
				"-fx-border-color:#e2e2e2; -fx-border-width:2; -fx-background-radius:0;-fx-background-color:#1d1d1d;-fx-font-size:11pt;-fx-text-fill:#d8d8d8;");
		ScoreOfBlack.setPrefWidth(160);
		RemainingTurns.setPrefWidth(160);
		ScoreOfBlack.setAlignment(Pos.CENTER);
		ScoreOfBlack.setTextAlignment(TextAlignment.CENTER);
		ScoreOfWhite.setAlignment(Pos.CENTER);
		RemainingTurns.setAlignment(Pos.CENTER);
		pane1.setAlignment(Pos.CENTER_LEFT);
		split.setPrefWidth(width);

		Title1.setPrefWidth(width);

		Title2.setPrefWidth(width);

		Title3.setPrefWidth(width);

		pane1.setSpacing(20);

		this.getChildren().addAll(leftFit, pane1, rightFit);

		rightFit.setPrefWidth(60);

	}

	public Label getScoreOfWhite() {
		return ScoreOfWhite;
	}

	public Label getScoreOfBlack() {
		return ScoreOfBlack;
	}

	public Label getRemainingTurns() {
		return RemainingTurns;
	}

	public Button getSplit() {
		return split;
	}
}
