package com.vicce.move;

import java.io.IOException;
import java.util.Optional;
import java.util.function.UnaryOperator;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
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

    @FXML
    private void showData() {
        // clear the table first
        resetTable();

        ObservableList<Mobilitate> mobilitateList = FXCollections.observableArrayList();

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

        tableView.setItems(mobilitateList);

    }

    @FXML
    private void addData() throws IOException {
        App.setRoot("addVehicule");
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
            App.setRoot("addVehicule");
        }
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("addVehicule");
    }
}
