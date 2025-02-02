module ostro.veda.ui {
    requires javafx.controls;
    requires javafx.fxml;
    requires ostro.veda.logger;

    opens ostro.veda.ui to javafx.fxml;
    exports ostro.veda.ui;
}