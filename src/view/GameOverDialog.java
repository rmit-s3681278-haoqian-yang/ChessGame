package view;

import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class GameOverDialog extends Alert {
    public GameOverDialog(AlertType alertType) {
        super(alertType);

        this.setTitle("Game ends");
    }

}
