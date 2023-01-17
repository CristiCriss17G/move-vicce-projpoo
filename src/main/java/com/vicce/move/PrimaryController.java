package com.vicce.move;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import com.vicce.move.seeder.*;

public class PrimaryController {

    @FXML
    private TextField textField;

    @FXML
    private void showData() {
        String data = App.showVehicule(true);
        // put the output in the field with id textField
        textField.setText(data);
    }

    @FXML
    private void addData() {
        App.addVehicle();
    }

    @FXML
    private void resetData() {
        App.resetVehicule();
    }
}
