package com.vicce.move;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import com.vicce.move.seeder.VehiculMMotorinaSeeder;

/**
 * Base class for the app with javaFX
 * Testeaza clasa VehiculFMSport
 *
 */
public class App extends Application {

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

    static void showVehicule() {
        showVehicule(false);
    }

    static ArrayList<VehiculMMotorina> getVehicule() {
        ArrayList<VehiculMMotorina> vehicule = VehiculMMotorinaSeeder.JSONReadSeed("vehicule.test.json");
        return vehicule;
    }

    static ArrayList<VehiculMMotorina> getVehicule(float pretMin, float pretMax, float vitezaMin, float vitezaMax) {
        ArrayList<VehiculMMotorina> vehicule = VehiculMMotorinaSeeder.JSONReadSeed("vehicule.test.json");
        VehiculMMotorina filtru = new VehiculMMotorina();
        if (pretMin > 0 || pretMax > 0)
            vehicule = filtru.filtrarePret(vehicule, pretMax, pretMin);
        if (vitezaMin > 0 || vitezaMax > 0)
            vehicule = filtru.filtrareViteza(vehicule, vitezaMax, vitezaMin);
        return vehicule;
    }

    static String showVehicule(boolean returnVal) {
        Scanner scanner = new Scanner(System.in);
        try {
            ArrayList<VehiculMMotorina> vehicule2 = VehiculMMotorinaSeeder.JSONReadSeed("vehicule.test.json");
            StringBuilder sb = new StringBuilder();
            for (VehiculMMotorina vehicul : vehicule2) {
                if (returnVal) {
                    sb.append(vehicul.toString());
                    sb.append(vehicul.raportVitezaPret());
                } else {
                    vehicul.afisare();
                    System.out.println(vehicul.raportVitezaPret());
                }
            }
            if (returnVal) {
                scanner.close();
                return sb.toString();
            }
            System.out.println("Doriti sa filtrati dupa pret? (y/n)");
            VehiculMMotorina filtru = new VehiculMMotorina();
            String raspuns = scanner.next();
            if (raspuns.equals("y")) {
                System.out.println("Introduceti pretul maxim: ");
                float pretMaxim = scanner.nextFloat();
                System.out.println("Vehiculele minim: ");
                float pretMinim = scanner.nextFloat();
                ArrayList<VehiculMMotorina> vehiculeFiltrate = filtru.filtrarePret(vehicule2, pretMaxim,
                        pretMinim);
                for (VehiculMMotorina vehicul : vehiculeFiltrate) {
                    vehicul.afisare();
                    System.out.println(vehicul.raportVitezaPret());
                }
            }
            System.out.println("Doriti sa filtrati dupa viteza? (y/n)");
            raspuns = scanner.next();
            if (raspuns.equals("y")) {
                System.out.println("Introduceti viteza maxima: ");
                float vitezaMaxima = scanner.nextFloat();
                System.out.println("Introduceti viteza minima: ");
                float vitezaMinima = scanner.nextFloat();
                ArrayList<VehiculMMotorina> vehiculeFiltrate = filtru.filtrareViteza(vehicule2, vitezaMaxima,
                        vitezaMinima);
                for (VehiculMMotorina vehicul : vehiculeFiltrate) {
                    vehicul.afisare();
                    System.out.println(vehicul.raportVitezaPret());
                }
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("Nu exista vehicule in baza de date");
        }
        scanner.close();
        return "";
    }

    static boolean addVehicle(int nr) {
        ArrayList<VehiculMMotorina> vehiculeOld;
        try {
            vehiculeOld = VehiculMMotorinaSeeder.JSONReadSeed("vehicule.test.json");
        } catch (IllegalArgumentException e) {
            vehiculeOld = new ArrayList<VehiculMMotorina>();
        }
        ArrayList<VehiculMMotorina> vehiculeNew = VehiculMMotorinaSeeder.seed(nr);
        ArrayList<VehiculMMotorina> vehicule = new ArrayList<VehiculMMotorina>();
        vehicule.addAll(vehiculeOld);
        vehicule.addAll(vehiculeNew);
        VehiculMMotorinaSeeder.JSONseed(vehicule);
        return true;
    }

    static void addVehicle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti numarul de vehicule de tipul VehiculMMotorina: ");
        int nr = scanner.nextInt();
        ArrayList<VehiculMMotorina> vehiculeOld;
        try {
            vehiculeOld = VehiculMMotorinaSeeder.JSONReadSeed("vehicule.test.json");
        } catch (IllegalArgumentException e) {
            vehiculeOld = new ArrayList<VehiculMMotorina>();
        }
        ArrayList<VehiculMMotorina> vehiculeNew = VehiculMMotorinaSeeder.seed(nr);
        ArrayList<VehiculMMotorina> vehicule = new ArrayList<VehiculMMotorina>();
        vehicule.addAll(vehiculeOld);
        vehicule.addAll(vehiculeNew);
        VehiculMMotorinaSeeder.JSONseed(vehicule);
        scanner.close();
    }

    static boolean resetData() {
        ArrayList<VehiculMMotorina> vehicule = new ArrayList<VehiculMMotorina>();
        VehiculMMotorinaSeeder.JSONseed(true, vehicule);
        VehiculMMotorina.resetIdPool();
        return true;
    }

    static void resetVehicule() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<VehiculMMotorina> vehicule = new ArrayList<VehiculMMotorina>();
        VehiculMMotorinaSeeder.JSONseed(vehicule);
        System.out.println("Introduceti numarul de vehicule de tipul VehiculMMotorina: ");
        int nr = scanner.nextInt();
        ArrayList<VehiculMMotorina> vehicule3 = VehiculMMotorinaSeeder.seed(nr);
        VehiculMMotorinaSeeder.JSONseed(vehicule3);
        scanner.close();
    }

    public static void main(String[] args) {
        launch();
    }
}