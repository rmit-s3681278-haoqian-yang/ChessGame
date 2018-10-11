package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class LeftPanel extends HBox {

	Button LoginPlayerWhiteButton = new Button("Login Player White");
	Button LoginPlayerBlackButton = new Button("Login Player Black");
	Button AddNewPlayerButton = new Button("Add New Player");

	Button setGameTurnsButton = new Button("Set Game Turns");
	Button startButton = new Button("START");
	Button quitButton = new Button("QUIT");

	public LeftPanel() {

		HBox leftBorder = new HBox();
		HBox rightBorder = new HBox();
		HBox topBorder = new HBox();
		HBox bottomBorder = new HBox();

		VBox GamePanel = new VBox();

		int width = 160;

		GamePanel.getChildren().addAll(topBorder, AddNewPlayerButton, LoginPlayerWhiteButton, LoginPlayerBlackButton,
				setGameTurnsButton, startButton, quitButton, bottomBorder);
		AddNewPlayerButton.setPrefWidth(width);
		AddNewPlayerButton.setStyle(
				"-fx-border-color:#e2e2e2; -fx-border-width:2; -fx-background-radius:0;-fx-background-color:#1d1d1d;-fx-font-size:11pt;-fx-text-fill:#d8d8d8;");

		LoginPlayerBlackButton.setPrefWidth(width);
		LoginPlayerWhiteButton.setStyle(
				"-fx-border-color:#e2e2e2; -fx-border-width:2; -fx-background-radius:0;-fx-background-color:#1d1d1d;-fx-font-size:11pt;-fx-text-fill:#d8d8d8;");

		LoginPlayerWhiteButton.setPrefWidth(width);
		LoginPlayerBlackButton.setStyle(
				"-fx-border-color:#e2e2e2; -fx-border-width:2; -fx-background-radius:0;-fx-background-color:#1d1d1d;-fx-font-size:11pt;-fx-text-fill:#d8d8d8;");

		setGameTurnsButton.setPrefWidth(width);
		setGameTurnsButton.setStyle(
				"-fx-border-color:#e2e2e2; -fx-border-width:2; -fx-background-radius:0;-fx-background-color:#1d1d1d;-fx-font-size:11pt;-fx-text-fill:#d8d8d8;");

		startButton.setPrefWidth(width);
		startButton.setStyle(
				"-fx-border-color:#e2e2e2; -fx-border-width:2; -fx-background-radius:0;-fx-background-color:#1d1d1d;-fx-font-size:11pt;-fx-text-fill:#d8d8d8;");

		quitButton.setPrefWidth(width);
		quitButton.setStyle(
				"-fx-border-color:#e2e2e2; -fx-border-width:2; -fx-background-radius:0;-fx-background-color:#1d1d1d;-fx-font-size:11pt;-fx-text-fill:#d8d8d8;");

		this.getChildren().addAll(leftBorder, GamePanel);

		leftBorder.setPrefWidth(60);

		GamePanel.setAlignment(Pos.CENTER_RIGHT);

		GamePanel.setSpacing(20);

	}

	public Button getLoginPlayerWhiteButton() {
		return LoginPlayerWhiteButton;
	}

	public Button getLoginPlayerBlackButton() {
		return LoginPlayerBlackButton;
	}

	public Button getAddNewPlayerButton() {
		return AddNewPlayerButton;
	}

	public Button getSetGameTurnsButton() {
		return setGameTurnsButton;
	}

	public Button getStartButton() {
		return startButton;
	}

	public Button getQuitButton() {
		return quitButton;
	}

}
