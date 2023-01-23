package com.vicce.move;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.UnaryOperator;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TextFormatter;
import javafx.util.converter.FloatStringConverter;

import com.vicce.move.seeder.VehiculMMotorinaSeeder;

public class PrimaryController {

    @FXML
    private TableView<VehiculMMotorina> tableView;

    @FXML
    private TextField textFieldPretMin;

    @FXML
    private TextField textFieldPretMax;

    @FXML
    private TextField textFieldVitezaMin;

    @FXML
    private TextField textFieldVitezaMax;

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
        showData();
    }

    @FXML
    private void showData() {
        // clear the table first
        tableView.getItems().clear();
        tableView.getColumns().clear();

        TableColumn<VehiculMMotorina, Long> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableView.getColumns().add(idColumn);

        TableColumn<VehiculMMotorina, Float> vitezaMaxColumn = new TableColumn<>("Viteza maxima");
        vitezaMaxColumn.setCellValueFactory(new PropertyValueFactory<>("vitezaMax"));
        tableView.getColumns().add(vitezaMaxColumn);

        TableColumn<VehiculMMotorina, Float> pretColumn = new TableColumn<>("Pret");
        pretColumn.setCellValueFactory(new PropertyValueFactory<>("pret"));
        tableView.getColumns().add(pretColumn);

        TableColumn<VehiculMMotorina, Integer> nrRotiColumn = new TableColumn<>("Numar roti");
        nrRotiColumn.setCellValueFactory(new PropertyValueFactory<>("nrRoti"));
        tableView.getColumns().add(nrRotiColumn);


        TableColumn<VehiculMMotorina, Integer> anFabricatieColumn = new TableColumn<>("An fabricatie");
        anFabricatieColumn.setCellValueFactory(new PropertyValueFactory<>("anFabricatie"));
        tableView.getColumns().add(anFabricatieColumn);

        TableColumn<VehiculMMotorina, Integer> numarCilindriColumn = new TableColumn<>("Numar Cilindri ");
        numarCilindriColumn.setCellValueFactory(new PropertyValueFactory<>("numarCilindri"));
        tableView.getColumns().add(numarCilindriColumn);

        TableColumn<VehiculMMotorina, Integer> marcaColumn = new TableColumn<>("Marca");
        marcaColumn.setCellValueFactory(new PropertyValueFactory<>("marca"));
        tableView.getColumns().add(marcaColumn);

        TableColumn<VehiculMMotorina, Integer> modelColumn = new TableColumn<>("Model");
        modelColumn.setCellValueFactory(new PropertyValueFactory<>("model"));
        tableView.getColumns().add(modelColumn);

        TableColumn<VehiculMMotorina, Integer> putereColumn = new TableColumn<>("Putere");
        putereColumn.setCellValueFactory(new PropertyValueFactory<>("putere"));
        tableView.getColumns().add(putereColumn);

        TableColumn<VehiculMMotorina, Integer> cupluColumn = new TableColumn<>("Cuplu");
        cupluColumn.setCellValueFactory(new PropertyValueFactory<>("cuplu"));
        tableView.getColumns().add(cupluColumn);

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

        tableView.getItems().addAll(App.getVehicule(pretMin, pretMax, vitezaMin, vitezaMax));

    }

    @FXML
    private void resetData() throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Resetare date");
        alert.setHeaderText("Esti sigur ca vrei sa resetezi datele?");
        alert.setContentText("Datele vor fi sterse permanent! Si va trebui sa adugi date noi");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            App.resetData();
            showData();
            // App.setRoot("secondary");
        }
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

}