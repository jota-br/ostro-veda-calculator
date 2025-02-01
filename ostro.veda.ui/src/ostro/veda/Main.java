package ostro.veda;

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
        Scene scene = new Scene(loader.load());

        ControllerMain controller = loader.getController();

        var calcController = controller.createController("CalculatorSimple.fxml");
        controller.updateCenter("CalculatorSimple.fxml", calcController);

        stage.setMaximized(true);

        stage.show();
    }

    @Override
    public void init() throws Exception {

    }

    @Override
    public void stop() throws Exception {

    }
}
