package com.vicce.move;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.FileChooser;
import javafx.util.converter.IntegerStringConverter;

import java.util.ArrayList;
import java.util.function.UnaryOperator;

import com.vicce.move.seeder.*;

public class AddVehiculController {
    @FXML
    private TextField textFieldAddVehicule;

    @FXML
    private TextField textFieldFilePath;

    private String filePath;

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
        App.setRoot("primary");
    }

    @FXML
    private void addData() {
        int numarVehicule;
        try {
            numarVehicule = Integer.parseInt(textFieldAddVehicule.getText());
        } catch (NumberFormatException e) {
            numarVehicule = 0;
        }

        if (VehiculFMSportSeeder.addVehicle(numarVehicule))
            labelStatus.setText("Vehicule adaugate cu succes!");
        else
            labelStatus.setText("Nu s-au putut adauga vehiculele!");
    }

    @FXML
    private void importData() {
        if (filePath == null || filePath.isEmpty()) {
            labelStatus.setText("Nu ati selectat un fisier!");
            return;
        }
        try {
            // open file and print contents
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
                // split line by \/ and based on the first element of the array as the class
                // name, call the appropriate constructor
                // and add the object to the list
                String[] lineArray = line.split(";");
                Mobilitate mobilitate = null;
                switch (lineArray[0]) {

                    case "VehiculMMotorina":
                        long id = Long.parseLong(lineArray[1]);
                        float vitezaMax = Float.parseFloat(lineArray[2]);
                        float pret = Float.parseFloat(lineArray[3]);
                        String marca = lineArray[4];
                        String model = lineArray[5];
                        String tip = lineArray[6];
                        String proprietar = "";
                        int stock = Integer.parseInt(lineArray[7]);
                        int nrRoti = Integer.parseInt(lineArray[8]);
                        int nrLocuri = Integer.parseInt(lineArray[9]);
                        int nrCilindri = Integer.parseInt(lineArray[10]);
                        int an = Integer.parseInt(lineArray[11]);
                        int putere = Integer.parseInt(lineArray[12]);
                        float cupluMot = Float.parseFloat(lineArray[13]);

                        mobilitate = new VehiculMMotorina(vitezaMax, pret, marca, model, tip, proprietar, stock, nrRoti,
                                nrLocuri, nrCilindri, an, putere, cupluMot, id);
                        break;
                    default:
                        System.out.println("Invalid class name");
                }
                if (mobilitate != null)
                    Seeder.addVehicule(mobilitate);
            }
            bufferedReader.close();
            App.setRoot("primaryFMAgrement");
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + filePath + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + filePath + "'");
        }
    }
}
