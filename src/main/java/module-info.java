module com.vicce.move {
  requires javafx.controls;
  requires javafx.fxml;
  requires org.json;

  opens com.vicce.move to javafx.fxml;

  exports com.vicce.move;
}
