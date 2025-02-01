module ostro.veda.ui {
    requires javafx.controls;
    requires javafx.fxml;

    opens ostro.veda.ui to javafx.fxml;
    exports ostro.veda.ui;
}