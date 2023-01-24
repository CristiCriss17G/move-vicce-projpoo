package com.vicce.move;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * Base class for the app with javaFX
 * Testeaza clasa VehiculFMSport
 *
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primaryMMotorina"), 960, 640);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Vehicule");
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }


    public static void main(String[] args) {
        launch();
    }
}