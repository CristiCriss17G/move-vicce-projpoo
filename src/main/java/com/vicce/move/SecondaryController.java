package com.vicce.move;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.util.converter.IntegerStringConverter;
import java.util.function.UnaryOperator;

import com.vicce.move.seeder.VehiculMMotorinaSeeder;

public class SecondaryController {

    @FXML
    private TextField textFieldAddVehicule;

    @FXML
    private Label labelStatus;

    public void initialize() {
        UnaryOperator<TextFormatter.Change> intFilter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("([0-9]{1,4})?")) {
                return change;
            }
            return null;
        };

        TextFormatter<Integer> addVehiculFormatter = new TextFormatter<>(new IntegerStringConverter(), 0, intFilter);
        textFieldAddVehicule.setTextFormatter(addVehiculFormatter);
        textFieldAddVehicule.setPromptText("Numarul de vehicule de adaugat");

    }

    @FXML
    private void showData() throws IOException {
        App.setRoot("primaryMMotorina");
    }

    @FXML
    private void addData() {
        int numarVehicule;
        try {
            numarVehicule = Integer.parseInt(textFieldAddVehicule.getText());
        } catch (NumberFormatException e) {
            numarVehicule = 0;
        }

        if (VehiculMMotorinaSeeder.addVehicle(numarVehicule))
            labelStatus.setText("Vehicule adaugate cu succes!");
        else
            labelStatus.setText("Nu s-au putut adauga vehiculele!");
    }

}