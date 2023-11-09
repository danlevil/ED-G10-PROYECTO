module g10 {
    requires javafx.controls;
    requires javafx.fxml;

    opens g10 to javafx.fxml;
    exports g10;
}
