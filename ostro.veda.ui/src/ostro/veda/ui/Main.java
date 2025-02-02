package ostro.veda.ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
        Scene scene = new Scene(loader.load(), 600, 500);

        ControllerMain controller = loader.getController();

        controller.updateCenter("CalculatorSimple.fxml");
        controller.setButtonAction();
        stage.setMaximized(false);

        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void init() throws Exception {

    }

    @Override
    public void stop() throws Exception {

    }
}
