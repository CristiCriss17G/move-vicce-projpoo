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
    private static final String fileName = "vehiculeMMotorina.test.json";
    private static final int MAX = 100;
    private static final int MIN = 1;
    private static final int MAX_VITEZA = 300;
    private static final int MIN_VITEZA = 100;
    private static final int MAX_PRET = 10000;
    private static final int MIN_PRET = 500;
    private static final String[] manufacturers = { "Audi", "BMW", "Ford", "Dacia", "Mercedes-Benz", "Skoda",
            "Volkswagen", "Renault", "Opel", "Toyota", "Volvo", "Peugeot", "Mazda", "Nissan" };
    private static final String[] models = { "A4", "A6", "Q5", "Seria 5",
            "Seria 7", "X3", "Focus", "Kuga", "Mondeo", "Duster",
            "Logan", "Sandero", "C", "GLE Coupe", "GLC", "Octavia", "Fabia", "Superb", "Megane", "Clio", "Laguna",
            "Astra", "Corsa", "Insignia", "Auris", "Corolla", "Land Cruiser", "XC 60", "V40", "S60", "508", "Partner",
            "407", "CX-7", "CX-5", "CX-3", "Qashqai", "Juke", "Navara" };
    private static final String[] types = { "Sport", "Road", "Mountain", "Hybrid", "Touring", "SUV", "LUX" };
    private static final String[] proprietari = { "Andrea Ortiz", "Kadence Carney", "Hunter Heath", "Elianna Diaz",
            "Marina Barajas", "Ayanna Daniel", "Skylar Jensen", "Laura Hudson", "Oswaldo Rosario", "Marvin Clayton",
            "Nora Avila", "Tony Yang", "Jesus Beck", "Cayden Hurst", "Brayden Young", "Esteban Larsen",
            "Scarlett Horne", "Logan Estes", "Kyra Berger", "Charlize Wang", "Kael Gomez", "Vivian Levy",
            "Isabella Grant", "Spencer Hooper", "Danica Kane", "Emelia Hernandez", "Armani Hammond", "Raquel Burke",
            "Ruth Christian", "Prince Kim", "Ellis Wright", "Penelope Bean", "Raul Waller", "Kaylynn Hayden",
            "Sean Crawford", "Kaya Roth", "Ally Cross", "Sage King", "Payten Bentley", "Gianni Woodward",
            "Yandel Marshall", "Kailey Kramer", "Dax Bolton", "Makenna Parks", "Dangelo Vang", "Sandra Schmidt",
            "Jon Carson", "Haiden Newton", "Rachel Stanton", "Jaylon Cobb" };
    private static final int MIN_STOCK = 0;
    private static final int MAX_STOCK = 20;
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

    public static ArrayList<VehiculMMotorina> seed(int nr) {
        if (nr > MAX || nr < MIN) {
            throw new IllegalArgumentException("Numarul de vehicule trebuie sa fie intre " + MIN + " si " + MAX);
        }
        ArrayList<VehiculMMotorina> vehicule = new ArrayList<VehiculMMotorina>();
        for (int i = 0; i < nr; i++) {
            float vitezaMax = random.nextFloat(MAX_VITEZA - MIN_VITEZA) + MIN_VITEZA;
            float pret = random.nextFloat(MAX_PRET - MIN_PRET) + MIN_PRET;
            String marca = manufacturers[random.nextInt(manufacturers.length)];
            String model = models[random.nextInt(models.length)];
            String tip = types[random.nextInt(types.length)];
            String proprietar = proprietari[random.nextInt(proprietari.length)];
            int stock = random.nextInt(MAX_STOCK - MIN_STOCK) + MIN_STOCK;
            int nrRoti = random.nextInt(MAX_NRROTI - MIN_NRROTI) + MIN_NRROTI;
            int anFabricatie = random.nextInt(MAX_AN - MIN_AN) + MIN_AN;
            int putere = random.nextInt(MAX_PUTERE - MIN_PUTERE) + MIN_PUTERE;
            int numarCilindri = random.nextInt(MAX_CILINDRII - MIN_CILINDRII) + MIN_CILINDRII;
            int nrLocuri = random.nextInt(MAX_NRLOCURI - MIN_NRLOCURI) + MIN_NRLOCURI;
            float cuplu = random.nextFloat(MAX_CUPLU - MIN_CUPLU) + MIN_CUPLU;
            VehiculMMotorina vmm = new VehiculMMotorina(vitezaMax, pret, marca, model, tip, proprietar, stock, nrRoti,
                    nrLocuri, numarCilindri, anFabricatie, putere, cuplu);
            vehicule.add(vmm);
        }
        return vehicule;
    }

    public static JSONArray JSONseed(int nr) {
        if (nr > MAX || nr < MIN) {
            throw new IllegalArgumentException("Numarul de vehicule trebuie sa fie intre " + MIN + " si " + MAX);
        }
        ArrayList<VehiculMMotorina> vehicule = seed(nr);
        return JSONseed(vehicule);
    }

    public static JSONArray JSONseed(ArrayList<VehiculMMotorina> vehicule) {
        return JSONseed(vehicule, fileName);
    }

    public static JSONArray JSONseed(boolean canBeNull, ArrayList<VehiculMMotorina> vehicule) {
        return JSONseed(canBeNull, vehicule, fileName);
    }

    public static JSONArray JSONseed(ArrayList<VehiculMMotorina> vehicule, String path) {
        return JSONseed(false, vehicule, path);
    }

    public static JSONArray JSONseed(boolean canBeNull, ArrayList<VehiculMMotorina> vehicule, String path)
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
            vehicul.put("tip", vmm.getTip());
            vehicul.put("proprietar", vmm.getProprietar());
            vehicul.put("stock", vmm.getStock());
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
        return vehiculeJSON;
    }

    // modificat pt acceptare JSON
    public static ArrayList<VehiculMMotorina> JSONReadSeed(JSONArray vehiculeJSON) throws IllegalArgumentException {
        if (vehiculeJSON == null || vehiculeJSON.length() == 0) {
            throw new IllegalArgumentException("Lista de vehicule nu poate fi nula sau goala");
        }
        ArrayList<VehiculMMotorina> vehicule = new ArrayList<VehiculMMotorina>();
        for (int i = 0; i < vehiculeJSON.length(); i++) {
            JSONObject vehicul = vehiculeJSON.getJSONObject(i);
            long id = vehicul.optLong("id");
            float vitezaMax = vehicul.optFloat("vitezaMax");
            float pret = vehicul.optFloat("pret");
            String marca = vehicul.optString("marca");
            String model = vehicul.optString("model");
            String tip = vehicul.optString("tip");
            String proprietar = vehicul.optString("proprietar");
            int stock = vehicul.optInt("stock");
            int nrRoti = vehicul.optInt("nrRoti");
            int anFabricatie = vehicul.optInt("an");
            int numarCilindri = vehicul.optInt("Cilindrii");
            int nrLocuri = vehicul.optInt("nrLocuri");
            int putere = vehicul.optInt("putere");
            float cuplu = vehicul.optFloat("cuplu");

            VehiculMMotorina vmm = new VehiculMMotorina(vitezaMax, pret, marca, model, tip, proprietar, stock, nrRoti,
                    nrLocuri, numarCilindri, anFabricatie, putere, cuplu, id);
            vehicule.add(vmm);
        }
        return vehicule;
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
            vehicule = JSONReadSeed(vehiculeJSON);
        } catch (NoSuchFileException e) {
            // e.printStackTrace();
            throw new IllegalArgumentException("Fisierul nu exista; eroare de I/O: " + e.getMessage());
        } catch (IOException e) {
            // e.printStackTrace();
            throw new IllegalArgumentException("Fisierul nu poate fi citit; eroare de I/O: " + e.getMessage());
        }

        return vehicule;
    }

    public static ArrayList<VehiculMMotorina> getVehicule() {
        ArrayList<VehiculMMotorina> vehicule;
        try {
            vehicule = JSONReadSeed(fileName);
        } catch (IllegalArgumentException e) {
            vehicule = new ArrayList<VehiculMMotorina>();
        }
        return vehicule;
    }

    public static ArrayList<VehiculMMotorina> getVehicule(float pretMin, float pretMax, float vitezaMin,
            float vitezaMax) {
        ArrayList<VehiculMMotorina> vehicule;
        try {
            vehicule = JSONReadSeed(fileName);
        } catch (IllegalArgumentException e) {
            vehicule = new ArrayList<VehiculMMotorina>();
        }
        if (pretMin > 0 || pretMax > 0)
            vehicule = VehiculMMotorina.filtrarePret(vehicule, pretMax, pretMin);
        if (vitezaMin > 0 || vitezaMax > 0)
            vehicule = VehiculMMotorina.filtrareViteza(vehicule, vitezaMax, vitezaMin);
        return vehicule;
    }

    public static boolean addVehicle(int nr) {
        ArrayList<VehiculMMotorina> vehiculeOld;
        try {
            vehiculeOld = JSONReadSeed(fileName);
        } catch (IllegalArgumentException e) {
            vehiculeOld = new ArrayList<VehiculMMotorina>();
        }
        ArrayList<VehiculMMotorina> vehiculeNew = seed(nr);
        ArrayList<VehiculMMotorina> vehicule = new ArrayList<VehiculMMotorina>();
        vehicule.addAll(vehiculeOld);
        vehicule.addAll(vehiculeNew);
        JSONseed(vehicule);
        return true;
    }

    public static JSONArray addVehicule(VehiculMMotorina vmm) {
        ArrayList<VehiculMMotorina> vehiculeOld;
        try {
            vehiculeOld = JSONReadSeed(fileName);
        } catch (IllegalArgumentException e) {
            vehiculeOld = new ArrayList<VehiculMMotorina>();
        }
        ArrayList<VehiculMMotorina> vehicule = new ArrayList<VehiculMMotorina>();
        vehicule.addAll(vehiculeOld);
        vehicule.add(vmm);
        return JSONseed(vehicule);
    }

    public static JSONArray addVehicule(int nr) {
        ArrayList<VehiculMMotorina> vehiculeOld;
        try {
            vehiculeOld = JSONReadSeed(fileName);
        } catch (IllegalArgumentException e) {
            vehiculeOld = new ArrayList<VehiculMMotorina>();
        }
        ArrayList<VehiculMMotorina> vehiculeNew = seed(nr);
        ArrayList<VehiculMMotorina> vehicule = new ArrayList<VehiculMMotorina>();
        vehicule.addAll(vehiculeOld);
        vehicule.addAll(vehiculeNew);
        return JSONseed(vehicule);
    }

    public static boolean resetData() {
        ArrayList<VehiculMMotorina> vehicule = new ArrayList<VehiculMMotorina>();
        VehiculMMotorinaSeeder.JSONseed(true, vehicule);
        VehiculMMotorina.resetIdPool();
        return true;
    }

    public static JSONArray resetVehicule() {
        ArrayList<VehiculMMotorina> vehicule = new ArrayList<VehiculMMotorina>();
        VehiculMMotorina.resetIdPool();
        return JSONseed(true, vehicule);
    }

}
