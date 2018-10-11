package test;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.BoardPanel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GuiTest  extends Application {

    BoardPanel b1 = new BoardPanel();

    @BeforeEach
    public void test(){


        launch();

    }

    @Test
    public void test1(){




    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setScene(new Scene(b1));
        primaryStage.show();

    }
}
