package view;

import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class QuitConfirm extends Stage {

	public QuitConfirm() {

		VBox vb = new VBox();

		vb.setMaxSize(400, 150);
		vb.setMinSize(400, 150);
		vb.setAlignment(Pos.CENTER);
		vb.setPadding(new Insets(10, 10, 10, 10));
		vb.setSpacing(20);

		Label label = new Label();
		Button button1 = new Button();
		Button button2 = new Button();

		HBox hb = new HBox();
		hb.setAlignment(Pos.CENTER);
		hb.setSpacing(20);

		label.setWrapText(true);
		label.setText("Sure To Quit?");
		label.setStyle(
				"-fx-border-color:#e2e2e2; -fx-border-width:2; -fx-background-radius:0;-fx-background-color:#1d1d1d;-fx-font-size:14pt;-fx-text-fill:#d8d8d8;");

		button1.setText("No");
		button1.setMinSize(100, 40);
		button1.setMaxSize(100, 40);
		button1.setOnAction(e -> this.close());

		button2.setText("Yes");
		button2.setMinSize(100, 40);
		button2.setMaxSize(100, 40);
		button2.setOnAction(e -> Platform.exit());

		button1.setStyle(
				"-fx-border-color:#e2e2e2; -fx-border-width:2; -fx-background-radius:0;-fx-background-color:#1d1d1d;-fx-font-size:13pt;-fx-text-fill:#d8d8d8;");

		button2.setStyle(
				"-fx-border-color:#e2e2e2; -fx-border-width:2; -fx-background-radius:0;-fx-background-color:#1d1d1d;-fx-font-size:13pt;-fx-text-fill:#d8d8d8;");

		hb.getChildren().addAll(button2, button1);
		vb.getChildren().addAll(label, hb);
		vb.setStyle(
				"-fx-border-color:#e2e2e2; -fx-border-width:2; -fx-background-radius:0;-fx-background-color:#1d1d1d;-fx-font-size:11pt;-fx-text-fill:#d8d8d8;");

		this.setTitle("Confirm Exit");
		this.setResizable(false);
		this.setScene(new Scene(vb, 300, 192));
		this.initStyle(StageStyle.TRANSPARENT);

		this.show();

	}

}
