module g10 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens g10 to javafx.fxml;
    exports g10;
}
