package view;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.LightBase;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SetTurns extends Stage {

	private Button OkButton = new Button("Set");
	private Button clearButton = new Button("Clear");
	private Button cancelButton = new Button("Cancel");
	private Label intruct = new Label("Please set game turns:");
	private NumField inputTurns = new NumField();
	private String text;

	public SetTurns() {

		HBox topFit = new HBox();
		VBox frame = new VBox();
		HBox input = new HBox();
		input.getChildren().addAll(intruct, inputTurns);
		HBox buttonContainer = new HBox();
		HBox bottomFit = new HBox();
		buttonContainer.getChildren().addAll(OkButton, clearButton, cancelButton);

		buttonContainer.setSpacing(20);
		frame.getChildren().addAll(topFit, intruct, inputTurns, buttonContainer, bottomFit);
		this.setScene(new Scene(frame));

		OkButton.setStyle(
				"-fx-border-color:#e2e2e2; -fx-border-width:2; -fx-background-radius:0;-fx-background-color:#1d1d1d;-fx-font-size:11pt;-fx-text-fill:#d8d8d8;");
		clearButton.setStyle(
				"-fx-border-color:#e2e2e2; -fx-border-width:2; -fx-background-radius:0;-fx-background-color:#1d1d1d;-fx-font-size:11pt;-fx-text-fill:#d8d8d8;");
		OkButton.setPrefWidth(100);
		cancelButton.setStyle(
				"-fx-border-color:#e2e2e2; -fx-border-width:2; -fx-background-radius:0;-fx-background-color:#1d1d1d;-fx-font-size:11pt;-fx-text-fill:#d8d8d8;");
		cancelButton.setPrefWidth(100);
		clearButton.setPrefWidth(100);

		intruct.setStyle(
				"-fx-border-color:#e2e2e2; -fx-border-width:2; -fx-background-radius:0;-fx-background-color:#1d1d1d;-fx-font-size:11pt;-fx-text-fill:#d8d8d8;");

		this.clearButton.setOnAction((eee) -> {
			this.getInputTurns().clear();
		});
		
		this.cancelButton.setOnAction(event -> {
			this.close();
		});
		
		frame.setSpacing(30);
		frame.setStyle(
				"-fx-border-color:#e2e2e2; -fx-border-width:2; -fx-background-radius:0;-fx-background-color:#1d1d1d;-fx-font-size:11pt;-fx-text-fill:#d8d8d8;");

		this.setMinHeight(260);
		this.setMinWidth(400);
		
		this.initModality(Modality.APPLICATION_MODAL);
		this.show();
		
	}

	public Button getOkButton() {
		return OkButton;
	}

	public Button getClearButton() {
		return clearButton;
	}

	public Button getCancelButton() {
		return cancelButton;
	}

	public Label getIntruct() {
		return intruct;
	}

	public TextField getInputTurns() {
		return inputTurns;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getText() {
		return text;
	}

}
