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
    private ComboBox<String> comboBoxTipVehicule;

    @FXML
    private TextField textFieldFilePath;

    @FXML
    private Label labelStatus;

    private String filePath;

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

        // function to be triggered when the textFieldFilePath is changed
        textFieldFilePath.textProperty().addListener((observable, oldValue, newValue) -> {
            filePath = newValue;
        });

        initializeComboBox();

    }

    private void initializeComboBox() {
        ObservableList<String> tipVehiculeList = FXCollections.observableArrayList();
        // tipVehiculeList.add("Toate");
        tipVehiculeList.add("VehiculFMSport");
        tipVehiculeList.add("VehiculMMotorina");
        tipVehiculeList.add("VehiculMBenzina");
        tipVehiculeList.add("VehiculMElectric");
        tipVehiculeList.add("VehiculFMAgrement");
        comboBoxTipVehicule.setItems(tipVehiculeList);
        comboBoxTipVehicule.getSelectionModel().selectFirst();
    }

    @FXML
    private void showData() throws IOException {
        App.setRoot("primaryFMAgrement");
    }

    @FXML
    private void addData() {
        int numarVehicule;

        try {
            numarVehicule = Integer.parseInt(textFieldAddVehicule.getText());
        } catch (NumberFormatException e) {
            numarVehicule = 0;
        }

        if (Seeder.addVehicule(comboBoxTipVehicule.getValue(), numarVehicule))
            labelStatus.setText("Vehicule adaugate cu succes!");
        else
            labelStatus.setText("Nu s-au putut adauga vehiculele!");
    }

    @FXML
    private void chooseFile() {
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilterTXT = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        FileChooser.ExtensionFilter extFilterJSON = new FileChooser.ExtensionFilter("JSON files (*.json)", "*.json");
        FileChooser.ExtensionFilter extFilterCSV = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().addAll(extFilterTXT, extFilterJSON, extFilterCSV);
        fileChooser.setTitle("Open Resource File");
        filePath = fileChooser.showOpenDialog(null).getAbsolutePath();
        textFieldFilePath.setText(filePath);
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
                    case "VehiculFMSport":
                        long id = Long.parseLong(lineArray[1]);
                        float vitezaMax = Float.parseFloat(lineArray[2]);
                        float pret = Float.parseFloat(lineArray[3]);
                        String marca = lineArray[4];
                        String model = lineArray[5];
                        String tip = lineArray[6];
                        String proprietar = lineArray[7];
                        int nrRoti = Integer.parseInt(lineArray[8]);
                        double greutate = Double.parseDouble(lineArray[9]);
                        int an = Integer.parseInt(lineArray[10]);
                        int nrPedale = Integer.parseInt(lineArray[11]);
                        int acceleratie = Integer.parseInt(lineArray[12]);
                        VehiculFMSport.TipTeren tipTeren = VehiculFMSport.TipTeren.valueOf(lineArray[13]);
                        // trim [ ] from the string
                        String[] echipamenteArray = lineArray[14].substring(1, lineArray[14].length() - 1).split(", ");
                        ArrayList<VehiculFMSport.EchipamentProtectie> echipamente = new ArrayList<>();
                        for (String echipament : echipamenteArray) {
                            echipamente.add(VehiculFMSport.EchipamentProtectie.valueOf(echipament));
                        }
                        mobilitate = new VehiculFMSport(vitezaMax, pret, marca, model, tip, proprietar, nrRoti,
                                greutate, an, nrPedale, acceleratie, tipTeren, echipamente, id);
                        break;
                    case "VehiculFMAgrement":
                        id = Long.parseLong(lineArray[1]);
                        vitezaMax = Float.parseFloat(lineArray[2]);
                        pret = Float.parseFloat(lineArray[3]);
                        marca = lineArray[4];
                        model = lineArray[5];
                        tip = lineArray[6];
                        proprietar = lineArray[7];
                        nrRoti = Integer.parseInt(lineArray[8]);
                        greutate = Double.parseDouble(lineArray[9]);
                        an = Integer.parseInt(lineArray[10]);
                        nrPedale = Integer.parseInt(lineArray[11]);
                        acceleratie = Integer.parseInt(lineArray[12]);
                        // trim [ ] from the string
                        String[] echipamentProc = lineArray[13].substring(1, lineArray[13].length() - 1).split(", ");
                        ArrayList<VehiculFMAgrement.EchipamentProtectie> echipamentProtectie = new ArrayList<>();
                        for (String echipament : echipamentProc) {
                            echipamentProtectie.add(VehiculFMAgrement.EchipamentProtectie.valueOf(echipament));
                        }
                        VehiculFMAgrement.TipTeren tipTerenAg = VehiculFMAgrement.TipTeren.valueOf(lineArray[14]);
                        VehiculFMAgrement.CategVarsta categVarsta = VehiculFMAgrement.CategVarsta
                                .valueOf(lineArray[15]);
                        mobilitate = new VehiculFMAgrement(vitezaMax, pret, marca, model, tip, proprietar, nrRoti,
                                greutate, an, nrPedale, acceleratie, tipTerenAg, echipamentProtectie, categVarsta, id);
                        break;
                    case "VehiculMMotorina":
                        id = Long.parseLong(lineArray[1]);
                        vitezaMax = Float.parseFloat(lineArray[2]);
                        pret = Float.parseFloat(lineArray[3]);
                        marca = lineArray[4];
                        model = lineArray[5];
                        tip = lineArray[6];
                        proprietar = lineArray[7];
                        nrRoti = Integer.parseInt(lineArray[8]);
                        int nrLocuri = Integer.parseInt(lineArray[9]);
                        int nrCilindri = Integer.parseInt(lineArray[10]);
                        an = Integer.parseInt(lineArray[11]);
                        int putere = Integer.parseInt(lineArray[12]);
                        int cuplu = Integer.parseInt(lineArray[13]);

                        mobilitate = new VehiculMMotorina(vitezaMax, pret, marca, model, tip, proprietar, nrRoti,
                                nrLocuri, nrCilindri, an, putere, cuplu, id);
                        break;
                    case "VehiculMBenzina":
                        id = Long.parseLong(lineArray[1]);
                        vitezaMax = Float.parseFloat(lineArray[2]);
                        pret = Float.parseFloat(lineArray[3]);
                        marca = lineArray[4];
                        model = lineArray[5];
                        tip = lineArray[6];
                        proprietar = lineArray[7];
                        nrRoti = Integer.parseInt(lineArray[8]);
                        nrLocuri = Integer.parseInt(lineArray[9]);
                        int caiPutere = Integer.parseInt(lineArray[10]);
                        int capacitateMotor = Integer.parseInt(lineArray[11]);
                        an = Integer.parseInt(lineArray[12]);
                        double consumUrban = Double.parseDouble(lineArray[13]);
                        mobilitate = new VehiculMBenzina(vitezaMax, pret, marca, model, tip, proprietar, nrRoti,
                                nrLocuri, caiPutere, capacitateMotor, an, consumUrban, id);
                        break;
                    case "VehiculMElectric":
                        id = Long.parseLong(lineArray[1]);
                        vitezaMax = Float.parseFloat(lineArray[2]);
                        pret = Float.parseFloat(lineArray[3]);
                        marca = lineArray[4];
                        model = lineArray[5];
                        tip = lineArray[6];
                        proprietar = lineArray[7];
                        nrRoti = Integer.parseInt(lineArray[8]);
                        nrLocuri = Integer.parseInt(lineArray[9]);
                        capacitateMotor = Integer.parseInt(lineArray[10]);
                        int autonomie = Integer.parseInt(lineArray[11]);
                        greutate = Double.parseDouble(lineArray[12]);
                        double kmReali = Double.parseDouble(lineArray[13]);
                        an = Integer.parseInt(lineArray[14]);
                        int nrScaune = Integer.parseInt(lineArray[15]);
                        int litriPortbagaj = Integer.parseInt(lineArray[16]);
                        nrPedale = Integer.parseInt(lineArray[17]);
                        cuplu = Integer.parseInt(lineArray[18]);
                        int nrUsi = Integer.parseInt(lineArray[19]);
                        VehiculMElectric.Electric motor = VehiculMElectric.Electric.valueOf(lineArray[20]);
                        mobilitate = new VehiculMElectric(vitezaMax, pret, marca, model, tip, proprietar, nrRoti,
                                nrLocuri, nrUsi, capacitateMotor, autonomie, greutate, nrScaune, litriPortbagaj,
                                kmReali, an, nrPedale, cuplu, motor, id);
                        break;
                    default:
                        System.out.println("Invalid class name");
                }
                if (mobilitate != null)
                    Seeder.addVehicule(mobilitate);
            }
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + filePath + "'");
        } catch (IOException ex) {
            System.out.println("Error reading file '" + filePath + "'");
        }
    }
}
