package com.vicce.move.seeder;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.nio.file.NoSuchFileException;

import com.vicce.move.VehiculMMotorina;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class VehiculMMotorinaSeeder {
    private static Random random = new Random();
    // private static final String fileName = "vehicule.test.json";
    private static final int MAX = 100;
    private static final int MIN = 1;
    private static final int MAX_VITEZA = 300;
    private static final int MIN_VITEZA = 100;
    private static final int MAX_PRET = 10000;
    private static final int MIN_PRET = 500;
    private static final int MAX_AN = 2020;
    private static final int MIN_AN = 1990;
    private static final int MAX_NRROTI = 8;
    private static final int MIN_NRROTI = 1;
    private static final int MIN_NRLOCURI = 2;
    private static final int MAX_NRLOCURI = 8;
    private static final int MIN_CILINDRII = 2;
    private static final int MAX_CILINDRII = 12;
    private static final int MIN_PUTERE = 50;
    private static final int MAX_PUTERE = 500;
    private static final float MIN_CUPLU = 500;
    private static final float MAX_CUPLU = 900;
    private static final String[] MARCA = { "BMW", "Porche", "Audi", "Volkwagen", "Ford", "Opel" };
    private static final String[] MODEL = { "GOLF 5", "Seria1", "Focus", "A4", "Astra" };

    public static ArrayList<VehiculMMotorina> seed(int nr) {
        if (nr > MAX || nr < MIN) {
            throw new IllegalArgumentException("Numarul de vehicule trebuie sa fie intre " + MIN + " si " + MAX);
        }
        ArrayList<VehiculMMotorina> vehicule = new ArrayList<VehiculMMotorina>();
        for (int i = 0; i < nr; i++) {
            float vitezaMax = random.nextFloat() * (MAX_VITEZA - MIN_VITEZA) + MIN_VITEZA;
            float pret = random.nextFloat() * (MAX_PRET - MIN_PRET) + MIN_PRET;
            String marca = MARCA[random.nextInt(MARCA.length)];
            String model = MODEL[random.nextInt(MODEL.length)];
            int nrRoti = random.nextInt(MAX_NRROTI - MIN_NRROTI) + MIN_NRROTI;
            int anFabricatie = random.nextInt(MAX_AN - MIN_AN) + MIN_AN;
            int putere = random.nextInt(MAX_PUTERE - MIN_PUTERE) + MIN_PUTERE;
            int numarCilindri = random.nextInt(MAX_CILINDRII - MIN_CILINDRII) + MIN_CILINDRII;
            int nrLocuri = random.nextInt(MAX_NRLOCURI - MIN_NRLOCURI) + MIN_NRLOCURI;
            float cuplu = random.nextFloat(MAX_CUPLU - MIN_CUPLU) + MIN_CUPLU;
            VehiculMMotorina vmm = new VehiculMMotorina(vitezaMax, pret, nrRoti, nrLocuri, marca, model, numarCilindri,
                    anFabricatie, putere, cuplu);
            // vfm.afisare();
            // System.out.println(vfm.raportVitezaPret());
            vehicule.add(vmm);
        }
        return vehicule;
    }

    public static void JSONseed(int nr) {
        if (nr > MAX || nr < MIN) {
            throw new IllegalArgumentException("Numarul de vehicule trebuie sa fie intre " + MIN + " si " + MAX);
        }
        ArrayList<VehiculMMotorina> vehicule = seed(nr);
        JSONseed(vehicule);
    }

    public static void JSONseed(ArrayList<VehiculMMotorina> vehicule) {
        JSONseed(vehicule, "vehicule.test.json");
    }

    public static void JSONseed(boolean canBeNull, ArrayList<VehiculMMotorina> vehicule) {
        JSONseed(canBeNull, vehicule, "vehicule.test.json");
    }

    public static void JSONseed(ArrayList<VehiculMMotorina> vehicule, String path) {
        JSONseed(false, vehicule, path);
    }

    public static void JSONseed(boolean canBeNull, ArrayList<VehiculMMotorina> vehicule, String path)
            throws IllegalArgumentException {
        if ((vehicule == null || vehicule.size() == 0) && !canBeNull) {
            throw new IllegalArgumentException("Lista de vehicule nu poate fi nula sau goala");
        }
        JSONArray vehiculeJSON = new JSONArray();
        for (int i = 0; i < vehicule.size(); i++) {
            VehiculMMotorina vmm = vehicule.get(i);
            JSONObject vehicul = new JSONObject();
            vehicul.put("id", vmm.getId());
            vehicul.put("vitezaMax", vmm.getVitezaMax());
            vehicul.put("pret", vmm.getPret());
            vehicul.put("marca", vmm.getMarca());
            vehicul.put("model", vmm.getModel());
            vehicul.put("nrRoti", vmm.getNrRoti());
            vehicul.put("an", vmm.getAnFabricatie());
            vehicul.put("putere", vmm.getPutere());
            vehicul.put("Cilindrii", vmm.getNumarCilindri());
            vehicul.put("nrLocuri", vmm.getNrLocuri());
            vehicul.put("cuplu", vmm.getCuplu());
            vehiculeJSON.put(vehicul);
        }
        try {
            FileWriter file = new FileWriter(path);
            file.write(vehiculeJSON.toString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<VehiculMMotorina> JSONReadSeed(String path) {
        if (path == null || path.isEmpty()) {
            throw new IllegalArgumentException("Path-ul nu poate fi nul sau gol");
        }
        ArrayList<VehiculMMotorina> vehicule = new ArrayList<VehiculMMotorina>();
        try {
            Scanner scanner = new Scanner(Paths.get(path), StandardCharsets.UTF_8.name());
            String content = scanner.useDelimiter("\\A").next();
            scanner.close();
            JSONArray vehiculeJSON = new JSONArray(content);
            for (int i = 0; i < vehiculeJSON.length(); i++) {
                JSONObject vehicul = vehiculeJSON.getJSONObject(i);
                long id = vehicul.getLong("id");
                float vitezaMax = (float) vehicul.getDouble("vitezaMax");
                float pret = (float) vehicul.getDouble("pret");
                String marca = vehicul.getString("marca");
                String model = vehicul.getString("model");
                int nrRoti = vehicul.getInt("nrRoti");
                int anFabricatie = vehicul.getInt("an");
                int numarCilindri = vehicul.getInt("Cilindrii");
                int nrLocuri = vehicul.getInt("nrLocuri");
                int putere = vehicul.getInt("putere");
                float cuplu = vehicul.getFloat("cuplu");

                VehiculMMotorina vmm = new VehiculMMotorina(vitezaMax, pret, nrRoti,
                        nrLocuri, marca, model, numarCilindri, anFabricatie, putere, cuplu, id);
                vehicule.add(vmm);
            }
        } catch (NoSuchFileException e) {
            // e.printStackTrace();
            throw new IllegalArgumentException("Fisierul nu exista; eroare de I/O: " + e.getMessage());
        } catch (IOException e) {
            // e.printStackTrace();
            throw new IllegalArgumentException("Fisierul nu poate fi citit; eroare de I/O: " + e.getMessage());
        }

        return vehicule;
    }

    // public static ArrayList<VehiculMMotorina> getVehicule() {
    //     ArrayList<VehiculMMotorina> vehicule;
    //     try {
    //         vehicule = JSONReadSeed(fileName);
    //     } catch (IllegalArgumentException e) {
    //         vehicule = new ArrayList<VehiculMMotorina>();
    //     }
    //     return vehicule;
    // }

    // public static ArrayList<VehiculMMotorina> getVehicule(float pretMin, float pretMax, float vitezaMin,
    //         float vitezaMax) {
    //     ArrayList<VehiculMMotorina> vehicule;
    //     try {
    //         vehicule = JSONReadSeed(fileName);
    //     } catch (IllegalArgumentException e) {
    //         vehicule = new ArrayList<VehiculMMotorina>();
    //     }
    //     if (pretMin > 0 || pretMax > 0)
    //         vehicule = VehiculMMotorina.filtrarePret(vehicule, pretMax, pretMin);
    //     if (vitezaMin > 0 || vitezaMax > 0)
    //         vehicule = VehiculMMotorina.filtrareViteza(vehicule, vitezaMax, vitezaMin);
    //     return vehicule;
    // }

    // public static boolean addVehicle(int nr) {
    //     ArrayList<VehiculMMotorina> vehiculeOld;
    //     try {
    //         vehiculeOld = JSONReadSeed(fileName);
    //     } catch (IllegalArgumentException e) {
    //         vehiculeOld = new ArrayList<VehiculMMotorina>();
    //     }
    //     ArrayList<VehiculMMotorina> vehiculeNew = seed(nr);
    //     ArrayList<VehiculMMotorina> vehicule = new ArrayList<VehiculMMotorina>();
    //     vehicule.addAll(vehiculeOld);
    //     vehicule.addAll(vehiculeNew);
    //     JSONseed(vehicule);
    //     return true;
    // }

    // public static boolean resetData() {
    //     ArrayList<VehiculMMotorina> vehicule = new ArrayList<VehiculMMotorina>();
    //     VehiculMMotorinaSeeder.JSONseed(true, vehicule);
    //     VehiculMMotorina.resetIdPool();
    //     return true;
    // }
}
