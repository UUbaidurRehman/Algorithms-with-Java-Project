module com.algorithms {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.algorithms to javafx.fxml;
    exports com.algorithms;
}
