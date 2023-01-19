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

import com.vicce.move.seeder.VehiculFMAgrementSeeder;

public class PrimaryController {

    @FXML
    private TableView<VehiculFMAgrement> tableView;

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

        TableColumn<VehiculFMAgrement, Long> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableView.getColumns().add(idColumn);

        TableColumn<VehiculFMAgrement, Float> vitezaMaxColumn = new TableColumn<>("Viteza maxima");
        vitezaMaxColumn.setCellValueFactory(new PropertyValueFactory<>("vitezaMax"));
        tableView.getColumns().add(vitezaMaxColumn);

        TableColumn<VehiculFMAgrement, Float> pretColumn = new TableColumn<>("Pret");
        pretColumn.setCellValueFactory(new PropertyValueFactory<>("pret"));
        tableView.getColumns().add(pretColumn);

        TableColumn<VehiculFMAgrement, Integer> nrRotiColumn = new TableColumn<>("Numar roti");
        nrRotiColumn.setCellValueFactory(new PropertyValueFactory<>("nrRoti"));
        tableView.getColumns().add(nrRotiColumn);

        TableColumn<VehiculFMAgrement, Double> greutateColumn = new TableColumn<>("Greutate");
        greutateColumn.setCellValueFactory(new PropertyValueFactory<>("greutate"));
        tableView.getColumns().add(greutateColumn);

        TableColumn<VehiculFMAgrement, Integer> anFabricatieColumn = new TableColumn<>("An fabricatie");
        anFabricatieColumn.setCellValueFactory(new PropertyValueFactory<>("anFabricatie"));
        tableView.getColumns().add(anFabricatieColumn);

        TableColumn<VehiculFMAgrement, Integer> nrPedaleColumn = new TableColumn<>("Numar pedale");
        nrPedaleColumn.setCellValueFactory(new PropertyValueFactory<>("nrPedale"));
        tableView.getColumns().add(nrPedaleColumn);

        TableColumn<VehiculFMAgrement, Integer> acceleratieColumn = new TableColumn<>("Acceleratie");
        acceleratieColumn.setCellValueFactory(new PropertyValueFactory<>("acceleratie"));
        tableView.getColumns().add(acceleratieColumn);

        TableColumn<VehiculFMAgrement, VehiculFMAgrement.TipTeren> tipTerenColumn = new TableColumn<>("Tip teren");
        tipTerenColumn.setCellValueFactory(new PropertyValueFactory<>("tipTeren"));
        tableView.getColumns().add(tipTerenColumn);

        TableColumn<VehiculFMAgrement, ArrayList<VehiculFMAgrement.EchipamentProtectie>> echipamentProtectieColumn = new TableColumn<>(
                "Echipament protectie");
        echipamentProtectieColumn.setCellValueFactory(new PropertyValueFactory<>("echipamentProtectie"));
        tableView.getColumns().add(echipamentProtectieColumn);

        TableColumn<VehiculFMAgrement, ArrayList<VehiculFMAgrement.CategVarsta>> categVarstaColumn = new TableColumn<>(
                "Categorie varsta");
        categVarstaColumn.setCellValueFactory(new PropertyValueFactory<>("categVarsta"));
        tableView.getColumns().add(categVarstaColumn);

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