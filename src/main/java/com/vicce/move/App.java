package com.vicce.move;

import java.util.ArrayList;
import java.util.Scanner;
import com.vicce.move.seeder.VehiculFMAgrementSeeder;

/**
 * Testeaza clasa VehiculFMAgrement
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
                try {
                    ArrayList<VehiculFMAgrement> vehicule2 = VehiculFMAgrementSeeder.JSONReadSeed("vehicule.test.json");
                    for (VehiculFMAgrement vehicul : vehicule2) {
                        vehicul.afisare();
                        System.out.println(vehicul.raportVitezaPret());
                    }
                    System.out.println("Doriti sa filtrati dupa pret? (y/n)");
                    VehiculFMAgrement filtru = new VehiculFMAgrement();
                    String raspuns = scanner.next();
                    if (raspuns.equals("y")) {
                        System.out.println("Introduceti pretul maxim: ");
                        float pretMaxim = scanner.nextFloat();
                        System.out.println("Vehiculele minim: ");
                        float pretMinim = scanner.nextFloat();
                        ArrayList<VehiculFMAgrement> vehiculeFiltrate = filtru.filtrarePret(vehicule2, pretMaxim,
                                pretMinim);
                        for (VehiculFMAgrement vehicul : vehiculeFiltrate) {
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
                        ArrayList<VehiculFMAgrement> vehiculeFiltrate = filtru.filtrareViteza(vehicule2, vitezaMaxima,
                                vitezaMinima);
                        for (VehiculFMAgrement vehicul : vehiculeFiltrate) {
                            vehicul.afisare();
                            System.out.println(vehicul.raportVitezaPret());
                        }
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    System.out.println("Nu exista vehicule in baza de date");
                }
                break;
            case 2:
                System.out.println("Introduceti numarul de vehicule de tipul VehiculFMAgrement: ");
                int nr = scanner.nextInt();
                ArrayList<VehiculFMAgrement> vehiculeOld;
                try {
                    vehiculeOld = VehiculFMAgrementSeeder.JSONReadSeed("vehicule.test.json");
                } catch (IllegalArgumentException e) {
                    vehiculeOld = new ArrayList<VehiculFMAgrement>();
                }
                ArrayList<VehiculFMAgrement> vehiculeNew = VehiculFMAgrementSeeder.seed(nr);
                ArrayList<VehiculFMAgrement> vehicule = new ArrayList<VehiculFMAgrement>();
                vehicule.addAll(vehiculeOld);
                vehicule.addAll(vehiculeNew);
                VehiculFMAgrementSeeder.JSONseed(vehicule);
                break;
            case 3:
                System.out.println("Introduceti numarul de vehicule de tipul VehiculFMAgrement: ");
                nr = scanner.nextInt();
                ArrayList<VehiculFMAgrement> vehicule3 = VehiculFMAgrementSeeder.seed(nr);
                VehiculFMAgrementSeeder.JSONseed(vehicule3);
                break;
            default:
                System.out.println("Optiune invalida");
                break;
        }

        scanner.close();
    }
}