package com.vicce.move;

import java.util.ArrayList;
import java.util.Scanner;
import com.vicce.move.seeder.VehiculFMSportSeeder;

/**
 * Testeaza clasa VehiculFMSport
 *
 */
public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Optiuni: ");
        System.out.println("1. Vizualizare vehicule din baza de date");
        System.out.println("2. Adaugare vehicule in baza de date");
        System.out.println("3. Stergere vehicule din baza de date si refacere baza de date");

        System.out.println("Introduceti numarul optiunii: ");
        int optiune = scanner.nextInt();
        switch (optiune) {
            case 1:
                ArrayList<VehiculFMSport> vehicule2 = VehiculFMSportSeeder.JSONReadSeed("vehicule.test.json");
                for (VehiculFMSport vehicul : vehicule2) {
                    vehicul.afisare();
                    System.out.println(vehicul.raportVitezaPret());
                }
                break;
            case 2:
                System.out.println("Introduceti numarul de vehicule de tipul VehiculFMSport: ");
                int nr = scanner.nextInt();
                ArrayList<VehiculFMSport> vehiculeOld = VehiculFMSportSeeder.JSONReadSeed("vehicule.test.json");
                ArrayList<VehiculFMSport> vehiculeNew = VehiculFMSportSeeder.seed(nr);
                ArrayList<VehiculFMSport> vehicule = new ArrayList<VehiculFMSport>();
                vehicule.addAll(vehiculeOld);
                vehicule.addAll(vehiculeNew);
                VehiculFMSportSeeder.JSONseed(vehicule);
                break;
            case 3:
                System.out.println("Introduceti numarul de vehicule de tipul VehiculFMSport: ");
                nr = scanner.nextInt();
                ArrayList<VehiculFMSport> vehicule3 = VehiculFMSportSeeder.seed(nr);
                VehiculFMSportSeeder.JSONseed(vehicule3);
                break;
            default:
                System.out.println("Optiune invalida");
                break;
        }

        scanner.close();
    }
}
