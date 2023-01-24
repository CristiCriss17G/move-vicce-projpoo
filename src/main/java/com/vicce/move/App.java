package com.vicce.move;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


// import java.beans.Transient;

/**
 * Hello world!
 *
 */
public class App extends Application{

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 960, 640);
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





    
    //Testez constructorul cu parametri
    // public static void main(String[] args) {
    //     VehiculCuMotor vcm = new VehiculCuMotor(100, 1000, 4, 5);
    //     vcm.afisare();
    //     System.out.println(vcm.raportVitezaPret());

        //cele 10 campuri :
        // VehiculMElectric e1 = new VehiculMElectric(150, 9000, 5, 4, 4, 2500, 890, 800, 5, 600, 1000, 2018, 3, 450);
        // VehiculMElectric e2 = new VehiculMElectric(240, 7000, 4, 2, 2, 3000, 250, 1000,4, 300, 700, 2020, 2, 500);
        // VehiculMElectric e3 = new VehiculMElectric(250, 3000, 5, 7, 4, 2700, 230, 900, 5, 800, 9000, 2019, 3, 350);
        // VehiculMElectric e4 = new VehiculMElectric(220, 5000, 5, 7, 4, 2400, 190, 2000, 5, 700, 13000, 2012, 3, 250);
        // VehiculMElectric e5 = new VehiculMElectric(240, 8000, 5, 7, 4, 1500, 620, 1000, 4, 100, 11000, 2010, 2, 550);
        // VehiculMElectric e6 = new VehiculMElectric(240, 2000, 5, 2, 2, 1700, 850, 900, 2, 200, 12000, 2008, 2, 150);
        // VehiculMElectric e7 = new VehiculMElectric(250, 12000, 5, 7, 4, 1900, 700, 900, 2, 300, 10000, 2022, 3, 550);
        // VehiculMElectric e8 = new VehiculMElectric(190, 22000, 5, 7, 4, 2300, 350, 1000, 4, 500, 4000, 2012, 2, 410);
        // VehiculMElectric e9 = new VehiculMElectric(170, 10000, 5, 2, 2, 3200, 600, 1000, 5, 1200, 6000, 2018, 2, 422);
        // VehiculMElectric e10 = new VehiculMElectric(200, 5000, 5, 2, 2, 2000, 700, 1200, 4, 900, 7000, 2016, 3, 560);

        // //vectorul
        // VehiculMElectric[] vme = {e1,e2,e3,e4,e5,e6,e7,e8,e9,e10};

        // //afisarea vectorului :
        // for(int i=0;i<vme.length;i++){
        //     vme[i].afisare();
        // }
    
    }
}
