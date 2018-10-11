package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PlayerLogin extends Stage {
	
	public Button getOkButton() {
		return okButton;
	}

	public Button getCancelButton() {
		return cancelButton;
	}

	public Button getClearButton() {
		return clearButton;
	}

	public Label getInstruct1() {
		return instruct1;
	}

	public TextField getInputUsername() {
		return inputUsername;
	}

	public Label getInstruct2() {
		return instruct2;
	}

	public TextField getInputPassword() {
		return inputPassword;
	}

	Button okButton = new Button("Ok");
	Button cancelButton = new Button("Cancel");
	Button clearButton = new Button("Clear");
	Label instruct1 = new Label("USERNAME:") {
		{
			setPrefWidth(85);
		}
	};
	TextField inputUsername = new TextField();
	Label instruct2 = new Label("PASSWORD:"){
		{
			setPrefWidth(85);
		}
	};
	PasswordField inputPassword = new PasswordField();

	public PlayerLogin() {

		HBox root = new HBox(10);
		VBox panel1 = new VBox(5);

		HBox topFit = new HBox(5);

		HBox namepart = new HBox(5);
		namepart.getChildren().addAll(instruct1, inputUsername);
		namepart.setAlignment(Pos.CENTER);

		HBox passpart = new HBox(5);
		passpart.getChildren().addAll(instruct2, inputPassword);
		passpart.setAlignment(Pos.CENTER);
		HBox bottonContainer = new HBox(5);
		bottonContainer.getChildren().addAll(okButton, clearButton, cancelButton);
		okButton.setPrefWidth(70);
		clearButton.setPrefWidth(70);
		cancelButton.setPrefWidth(70);
		bottonContainer.setAlignment(Pos.CENTER);
		bottonContainer.setSpacing(5);

		HBox bottomFit = new HBox(5);

		HBox leftFit = new HBox(5);
		HBox rightFit = new HBox(5);

		panel1.getChildren().addAll(topFit, namepart, passpart, bottonContainer, bottomFit);
		topFit.setPrefHeight(10);
		panel1.setSpacing(10);
		panel1.setAlignment(Pos.CENTER);

		root.getChildren().addAll(leftFit, panel1, rightFit);
		root.setAlignment(Pos.CENTER);
		root.setStyle(
				"-fx-border-color:#e2e2e2; -fx-border-width:2; -fx-background-radius:0;-fx-background-color:#1d1d1d;-fx-font-size:11pt;-fx-text-fill:#d8d8d8;");

		this.setScene(new Scene(root));

		this.inputUsername.setPromptText("Enter name here");

		this.inputPassword.setPromptText("Enter password here");

		this.cancelButton.setOnAction((ff) -> {
			this.close();
		});

		this.clearButton.setOnAction((fff) -> {
			this.inputUsername.clear();
			this.inputPassword.clear();
		});
		
		this.initModality(Modality.APPLICATION_MODAL);
		this.setTitle("Login");
		this.show();

	}
}