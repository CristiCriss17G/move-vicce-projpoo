package com.vicce.move;

import javafx.fxml.FXML;
import com.vicce.move.seeder.*;

public class PrimaryController {
    @FXML
    private void showData() {
        App.showVehicule();
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
