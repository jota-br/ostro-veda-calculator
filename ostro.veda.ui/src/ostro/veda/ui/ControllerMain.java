package ostro.veda.ui;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import ostro.veda.service.Logger;
import ostro.veda.ui.helpers.CheckLastChar;

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

    // EXPRESSION TEXT FIELD
    @FXML
    private TextField expressionTextField;

    // NUMBERS
    @FXML
    private Button numZero;
    @FXML
    private Button numOne;
    @FXML
    private Button numTwo;
    @FXML
    private Button numThree;
    @FXML
    private Button numFour;
    @FXML
    private Button numFive;
    @FXML
    private Button numSix;
    @FXML
    private Button numSeven;
    @FXML
    private Button numEight;
    @FXML
    private Button numNine;

    // OPERATORS
    @FXML
    private Button operationMultiply;
    @FXML
    private Button operationDivision;
    @FXML
    private Button operationSubtraction;
    @FXML
    private Button operationSum;


    @FXML
    public void handleNum(long value) {

        StringBuilder sb = new StringBuilder(expressionTextField.getText());
        sb.append(value);
        expressionTextField.setText(String.valueOf(sb));
    }

    @FXML
    public void handleOperation(char value) {
        StringBuilder sb = new StringBuilder(expressionTextField.getText());

        if (CheckLastChar.hasChar(String.valueOf(sb))) {
            return;
        }

        sb.append(value);
        expressionTextField.setText(String.valueOf(sb));
    }

    @FXML
    public void handleNumZero() {
        handleNum(0);
    }

    @FXML
    public void handleNumOne() {
        handleNum(1);
    }

    @FXML
    public void handleNumTwo() {
        handleNum(2);
    }

    @FXML
    public void handleNumThree() {
        handleNum(3);
    }

    @FXML
    public void handleNumFour() {
        handleNum(4);
    }

    @FXML
    public void handleNumFive() {
        handleNum(5);
    }

    @FXML
    public void handleNumSix() {
        handleNum(6);
    }

    @FXML
    public void handleNumSeven() {
        handleNum(7);
    }

    @FXML
    public void handleNumEight() {
        handleNum(8);
    }

    @FXML
    public void handleNumNine() {
        handleNum(9);
    }

    @FXML
    public void handleMultiply() {
        handleOperation('*');
    }

    @FXML
    public void handleDivision() {
        handleOperation('*');
    }

    @FXML
    public void handleSubtraction() {
        handleOperation('-');
    }

    @FXML
    public void handleSum() {
        handleOperation('+');
    }

    public void setButtonAction() {
        this.numZero.setOnAction(e -> handleNumZero());
        this.numOne.setOnAction(e -> handleNumOne());
        this.numTwo.setOnAction(e -> handleNumTwo());
        this.numThree.setOnAction(e -> handleNumThree());
        this.numFour.setOnAction(e -> handleNumFour());
        this.numFive.setOnAction(e -> handleNumFive());
        this.numSix.setOnAction(e -> handleNumSix());
        this.numSeven.setOnAction(e -> handleNumSeven());
        this.numEight.setOnAction(e -> handleNumEight());
        this.numNine.setOnAction(e -> handleNumNine());

        this.operationMultiply.setOnAction(e -> handleMultiply());
        this.operationDivision.setOnAction(e -> handleDivision());
        this.operationSubtraction.setOnAction(e -> handleSubtraction());
        this.operationSum.setOnAction(e -> handleSum());
    }

    @FXML
    public <T> void updateCenter(String fxml) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            loader.setController(this);

            Node newContent = loader.load();
            centerVbox.getChildren().clear();
            centerVbox.getChildren().add(newContent);
        } catch (IOException e) {
            Logger.log(e);
        }
    }
}
