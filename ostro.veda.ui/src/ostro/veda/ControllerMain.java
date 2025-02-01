package ostro.veda;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ControllerMain {



    @FXML
    private VBox topVbox;

    @FXML
    private VBox rightVbox;

    @FXML
    private VBox centerVbox;

    @FXML
    private VBox bottomVbox;

    @FXML
    private VBox leftVbox;

    public <T> T createController (String fxml) {

        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        return loader.getController();
    }

    @FXML
    public <T> void updateCenter(String fxml, T controller) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            loader.setController(controller);

            Node newContent = loader.load();
            centerVbox.getChildren().clear();
            centerVbox.getChildren().add(newContent);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
