package com.vicce.move;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.UnaryOperator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.stage.FileChooser;
import javafx.util.converter.FloatStringConverter;

import com.vicce.move.seeder.*;

public class PrimaryController {

    @FXML
    private TableView<Mobilitate> tableView;

    @FXML
    private TextField textFieldPretMin;

    @FXML
    private TextField textFieldPretMax;

    @FXML
    private TextField textFieldVitezaMin;

    @FXML
    private TextField textFieldVitezaMax;

    @FXML
    private ComboBox<String> comboBoxTipVehicule;

    @FXML
    private TextField textFieldSearch;

    private ArrayList<Mobilitate> mobilitateListFull;

    public void initialize() {
        UnaryOperator<TextFormatter.Change> floatFilter = change -> {
            String newText = change.getControlNewText();
            if (newText.matches("-?([0-9]*([.][0-9]*)?)?")) {
                return change;
            }
            return null;
        };

        TextFormatter<Float> pretMinFormatter = new TextFormatter<>(new FloatStringConverter(), 0f, floatFilter);
        TextFormatter<Float> pretMaxFormatter = new TextFormatter<>(new FloatStringConverter(), 0f, floatFilter);
        TextFormatter<Float> vitezaMinFormatter = new TextFormatter<>(new FloatStringConverter(), 0f, floatFilter);
        TextFormatter<Float> vitezaMaxFormatter = new TextFormatter<>(new FloatStringConverter(), 0f, floatFilter);
        textFieldPretMin.setTextFormatter(pretMinFormatter);
        textFieldPretMin.setPromptText("Pretul minim");
        textFieldPretMax.setTextFormatter(pretMaxFormatter);
        textFieldPretMax.setPromptText("Pretul maxim");
        textFieldVitezaMin.setTextFormatter(vitezaMinFormatter);
        textFieldVitezaMin.setPromptText("Viteza minima");
        textFieldVitezaMax.setTextFormatter(vitezaMaxFormatter);
        textFieldVitezaMax.setPromptText("Viteza maxima");

        initializeComboBox();

        // showData();

        // function to be triggered when the textFieldSearch is changed
        textFieldSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            searchTable(newValue);
        });

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

    private void resetTable() {
        tableView.getItems().clear();
        tableView.getColumns().clear();
    }

    private void searchTable(String text) {
        ObservableList<Mobilitate> mobilitateListSearch = FXCollections.observableArrayList();
        for (Mobilitate mobilitate : mobilitateListFull) {
            if (mobilitate.getMarca().toLowerCase().contains(text.toLowerCase())
                    || mobilitate.getModel().toLowerCase().contains(text.toLowerCase())
                    || mobilitate.getTip().toLowerCase().contains(text.toLowerCase()) || text.isEmpty()) {
                mobilitateListSearch.add(mobilitate);
            }
        }
        tableView.getItems().setAll(mobilitateListSearch);
    }

    @FXML
    private void showData() {
        // clear the table first
        resetTable();

        ObservableList<Mobilitate> mobilitateList = FXCollections.observableArrayList();
        mobilitateListFull = new ArrayList<Mobilitate>();

        float pretMin;
        float pretMax;
        float vitezaMin;
        float vitezaMax;

        try {
            pretMin = Float.parseFloat(textFieldPretMin.getText());
        } catch (NumberFormatException e) {
            pretMin = 0;
        }

        try {
            pretMax = Float.parseFloat(textFieldPretMax.getText());
        } catch (NumberFormatException e) {
            pretMax = 0;
        }

        try {
            vitezaMin = Float.parseFloat(textFieldVitezaMin.getText());
        } catch (NumberFormatException e) {
            vitezaMin = 0;
        }

        try {
            vitezaMax = Float.parseFloat(textFieldVitezaMax.getText());
        } catch (NumberFormatException e) {
            vitezaMax = 0;
        }

        switch (comboBoxTipVehicule.getValue()) {
            case "Toate":
                tableView.getColumns().setAll(VehiculMMotorina.getTableColumns());
                tableView.getColumns().addAll(VehiculFMSport.getTableColumns());
                break;
            case "VehiculFMSport":
                tableView.getColumns().setAll(VehiculFMSport.getTableColumns());
                break;
            case "VehiculMMotorina":
                tableView.getColumns().setAll(VehiculMMotorina.getTableColumns());
                break;
            case "VehiculMBenzina":
                tableView.getColumns().setAll(VehiculMBenzina.getTableColumns());
                break;
            case "VehiculMElectric":
                tableView.getColumns().setAll(VehiculMElectric.getTableColumns());
                break;
            case "VehiculFMAgrement":
                tableView.getColumns().setAll(VehiculFMAgrement.getTableColumns());
                break;
        }

        mobilitateList
                .addAll(Seeder.getVehicule(comboBoxTipVehicule.getValue(), pretMin, pretMax, vitezaMin, vitezaMax));
        mobilitateListFull.addAll(mobilitateList);

        tableView.setItems(mobilitateList);

    }

    // @FXML
    // private void reverseNames() {
    // ObservableList<Mobilitate> mobilitateListReverse =
    // FXCollections.observableArrayList();
    // for (Mobilitate mobilitate : tableView.getItems()) {
    // mobilitate.setProprietar(new
    // StringBuilder(mobilitate.getProprietar()).reverse().toString());
    // mobilitateListReverse.add(mobilitate);
    // }
    // tableView.getItems().clear();
    // tableView.setItems(mobilitateListReverse);
    // }

    @FXML
    private void addData() throws IOException {
        Move.setRoot("addVehicule");
    }

    @FXML
    private void resetData() throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Resetare date");
        alert.setHeaderText("Esti sigur ca vrei sa resetezi datele?");
        alert.setContentText("Datele vor fi sterse permanent! Si va trebui sa adugi date noi");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            Seeder.resetVehicule(comboBoxTipVehicule.getValue());
            Move.setRoot("addVehicule");
        }
    }

    @FXML
    private void switchToSecondary() throws IOException {
        Move.setRoot("addVehicule");
    }

    @FXML
    private void exportData() {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Save TXT");
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("TXT", "*.txt"));
            File file = fileChooser.showSaveDialog(null);
            if (file != null) {
                FileWriter fileWriter = new FileWriter(file);

                // for (TableColumn<Mobilitate, ?> column : tableView.getColumns()) {
                // fileWriter.append(column.getText());
                // fileWriter.append(",");
                // }
                // fileWriter.append("\n");
                for (Mobilitate mobilitate : tableView.getItems()) {
                    switch (comboBoxTipVehicule.getValue()) {
                        // case "Toate":
                        // fileWriter.append("VehiculFMSport");
                        // fileWriter.append(",");
                        // fileWriter.append("VehiculMMotorina");
                        // fileWriter.append(",");
                        // break;
                        case "VehiculFMSport":
                            fileWriter.append("VehiculFMSport");
                            fileWriter.append(";");
                            break;
                        case "VehiculMMotorina":
                            fileWriter.append("VehiculMMotorina");
                            fileWriter.append(";");
                            break;
                        case "VehiculMBenzina":
                            fileWriter.append("VehiculMBenzina");
                            fileWriter.append(";");
                            break;
                        case "VehiculMElectric":
                            fileWriter.append("VehiculMElectric");
                            fileWriter.append(";");
                            break;
                        case "VehiculFMAgrement":
                            fileWriter.append("VehiculFMAgrement");
                            fileWriter.append(";");
                            break;
                    }
                    for (TableColumn<Mobilitate, ?> column : tableView.getColumns()) {
                        // if column is Raport pret viteza then skip it
                        if (column.getText().equals("Raport pret viteza")) {
                            continue;
                        }

                        fileWriter.append(column.getCellObservableValue(mobilitate).getValue().toString());
                        fileWriter.append(";");
                    }
                    fileWriter.append("\n");
                }
                fileWriter.flush();
                fileWriter.close();
            }
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
        }
    }
}
