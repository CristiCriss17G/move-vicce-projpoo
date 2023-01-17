package com.vicce.move;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import com.vicce.move.seeder.VehiculFMSportSeeder;

/**
 * Base class for the app with javaFX
 * Testeaza clasa VehiculFMSport
 *
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 640, 480);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        stage.setScene(scene);
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

    static String showVehicule(boolean returnVal) {
        Scanner scanner = new Scanner(System.in);
        try {
            ArrayList<VehiculFMSport> vehicule2 = VehiculFMSportSeeder.JSONReadSeed("vehicule.test.json");
            StringBuilder sb = new StringBuilder();
            for (VehiculFMSport vehicul : vehicule2) {
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
            VehiculFMSport filtru = new VehiculFMSport();
            String raspuns = scanner.next();
            if (raspuns.equals("y")) {
                System.out.println("Introduceti pretul maxim: ");
                float pretMaxim = scanner.nextFloat();
                System.out.println("Vehiculele minim: ");
                float pretMinim = scanner.nextFloat();
                ArrayList<VehiculFMSport> vehiculeFiltrate = filtru.filtrarePret(vehicule2, pretMaxim,
                        pretMinim);
                for (VehiculFMSport vehicul : vehiculeFiltrate) {
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
                ArrayList<VehiculFMSport> vehiculeFiltrate = filtru.filtrareViteza(vehicule2, vitezaMaxima,
                        vitezaMinima);
                for (VehiculFMSport vehicul : vehiculeFiltrate) {
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

    static void addVehicle() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti numarul de vehicule de tipul VehiculFMSport: ");
        int nr = scanner.nextInt();
        ArrayList<VehiculFMSport> vehiculeOld;
        try {
            vehiculeOld = VehiculFMSportSeeder.JSONReadSeed("vehicule.test.json");
        } catch (IllegalArgumentException e) {
            vehiculeOld = new ArrayList<VehiculFMSport>();
        }
        ArrayList<VehiculFMSport> vehiculeNew = VehiculFMSportSeeder.seed(nr);
        ArrayList<VehiculFMSport> vehicule = new ArrayList<VehiculFMSport>();
        vehicule.addAll(vehiculeOld);
        vehicule.addAll(vehiculeNew);
        VehiculFMSportSeeder.JSONseed(vehicule);
        scanner.close();
    }

    static void resetVehicule() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<VehiculFMSport> vehicule = new ArrayList<VehiculFMSport>();
        VehiculFMSportSeeder.JSONseed(vehicule);
        System.out.println("Introduceti numarul de vehicule de tipul VehiculFMSport: ");
        int nr = scanner.nextInt();
        ArrayList<VehiculFMSport> vehicule3 = VehiculFMSportSeeder.seed(nr);
        VehiculFMSportSeeder.JSONseed(vehicule3);
        scanner.close();
    }

    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // System.out.println("Optiuni: ");
        // System.out.println("1. Vizualizare vehicule din baza de date");
        // System.out.println("2. Adaugare vehicule in baza de date");
        // System.out.println("3. Stergere vehicule din baza de date si refacere baza de
        // date");

        // System.out.println("Introduceti numarul optiunii: ");
        // int optiune = scanner.nextInt();
        // switch (optiune) {
        // case 1:
        // try {
        // ArrayList<VehiculFMSport> vehicule2 =
        // VehiculFMSportSeeder.JSONReadSeed("vehicule.test.json");
        // for (VehiculFMSport vehicul : vehicule2) {
        // vehicul.afisare();
        // System.out.println(vehicul.raportVitezaPret());
        // }
        // System.out.println("Doriti sa filtrati dupa pret? (y/n)");
        // VehiculFMSport filtru = new VehiculFMSport();
        // String raspuns = scanner.next();
        // if (raspuns.equals("y")) {
        // System.out.println("Introduceti pretul maxim: ");
        // float pretMaxim = scanner.nextFloat();
        // System.out.println("Vehiculele minim: ");
        // float pretMinim = scanner.nextFloat();
        // ArrayList<VehiculFMSport> vehiculeFiltrate = filtru.filtrarePret(vehicule2,
        // pretMaxim,
        // pretMinim);
        // for (VehiculFMSport vehicul : vehiculeFiltrate) {
        // vehicul.afisare();
        // System.out.println(vehicul.raportVitezaPret());
        // }
        // }
        // System.out.println("Doriti sa filtrati dupa viteza? (y/n)");
        // raspuns = scanner.next();
        // if (raspuns.equals("y")) {
        // System.out.println("Introduceti viteza maxima: ");
        // float vitezaMaxima = scanner.nextFloat();
        // System.out.println("Introduceti viteza minima: ");
        // float vitezaMinima = scanner.nextFloat();
        // ArrayList<VehiculFMSport> vehiculeFiltrate = filtru.filtrareViteza(vehicule2,
        // vitezaMaxima,
        // vitezaMinima);
        // for (VehiculFMSport vehicul : vehiculeFiltrate) {
        // vehicul.afisare();
        // System.out.println(vehicul.raportVitezaPret());
        // }
        // }
        // } catch (IllegalArgumentException e) {
        // System.out.println(e.getMessage());
        // System.out.println("Nu exista vehicule in baza de date");
        // }
        // break;
        // case 2:
        // System.out.println("Introduceti numarul de vehicule de tipul VehiculFMSport:
        // ");
        // int nr = scanner.nextInt();
        // ArrayList<VehiculFMSport> vehiculeOld;
        // try {
        // vehiculeOld = VehiculFMSportSeeder.JSONReadSeed("vehicule.test.json");
        // } catch (IllegalArgumentException e) {
        // vehiculeOld = new ArrayList<VehiculFMSport>();
        // }
        // ArrayList<VehiculFMSport> vehiculeNew = VehiculFMSportSeeder.seed(nr);
        // ArrayList<VehiculFMSport> vehicule = new ArrayList<VehiculFMSport>();
        // vehicule.addAll(vehiculeOld);
        // vehicule.addAll(vehiculeNew);
        // VehiculFMSportSeeder.JSONseed(vehicule);
        // break;
        // case 3:
        // System.out.println("Introduceti numarul de vehicule de tipul VehiculFMSport:
        // ");
        // nr = scanner.nextInt();
        // ArrayList<VehiculFMSport> vehicule3 = VehiculFMSportSeeder.seed(nr);
        // VehiculFMSportSeeder.JSONseed(vehicule3);
        // break;
        // default:
        // System.out.println("Optiune invalida");
        // break;
        // }

        // scanner.close();

        launch();
    }
}
