module com.vicce.move {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.vicce.move to javafx.fxml;

    exports com.vicce.move;
}