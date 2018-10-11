import controller.Controller;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class ChessMain extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		Controller c1 = new Controller();
		// c1.setMinHeight(480);
		// c1.setMaxHeight(480);

		Scene s1 = new Scene(new Controller().getFrame2(), 1000, 620);
		primaryStage.setScene(s1);
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.show();

	}
}
