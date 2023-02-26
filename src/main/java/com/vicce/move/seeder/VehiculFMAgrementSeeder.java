package com.vicce.move.seeder;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.nio.file.NoSuchFileException;

import com.vicce.move.AddVehiculController;
import com.vicce.move.VehiculFMAgrement;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.json.JSONObject;
import org.json.JSONArray;

public class VehiculFMAgrementSeeder {
    private static Random random = new Random();
    private static final String fileName = "vehiculeFMAgrement.test.json";

    private static final int MAX = 100;
    private static final int MIN = 0;
    private static final int MAX_VITEZA = 300;
    private static final int MIN_VITEZA = 100;
    private static final int MAX_PRET = 10000;
    private static final int MIN_PRET = 500;
    private static final String[] manufacturers = { "ALAN", "Cilo", "Alien Bikes", "Alexander Leutner & Co.",
            "American Classic", "Apache Bicycles", "Axle Release", "Bicycle Research", "Bike-Aid", "Bikeverywhere",
            "Black Diamond", "Steelman Cycles", "Supercycle", "Rivendell", "Bicycle Works", "Roadmaster","Roberts Cycles","Robin Hood","Rock Lobster","RockShox", "Pegasus" };
    private static final String[] models = { "Road Bike", "Mountain Bike", "Hybrid Bike", "Touring Bike",
            "Fixed Gear Bike", "BMX Bike", "Cruiser Bike", "Tandem Bike", "Folding Bike", "Recumbent Bike", "Roller Skates", "Scooter", "Unicycle", "Kick Scooter" };
    private static final String[] types = { "Road", "Mountain", "Hybrid", "Touring", "Fixed Gear", "BMX", "Cruiser" };
    private static final String[] proprietari = { "Andrea Ortiz", "Kadence Carney", "Hunter Heath", "Elianna Diaz",
            "Marina Barajas", "Ayanna Daniel", "Skylar Jensen", "Laura Hudson", "Oswaldo Rosario", "Marvin Clayton",
            "Nora Avila", "Tony Yang", "Jesus Beck", "Cayden Hurst", "Brayden Young", "Esteban Larsen",
            "Scarlett Horne", "Logan Estes", "Kyra Berger", "Charlize Wang", "Kael Gomez", "Vivian Levy",
            "Isabella Grant", "Spencer Hooper", "Danica Kane", "Emelia Hernandez", "Armani Hammond", "Raquel Burke",
            "Ruth Christian", "Prince Kim", "Ellis Wright", "Penelope Bean", "Raul Waller", "Kaylynn Hayden",
            "Sean Crawford", "Kaya Roth", "Ally Cross", "Sage King", "Payten Bentley", "Gianni Woodward",
            "Yandel Marshall", "Kailey Kramer", "Dax Bolton", "Makenna Parks", "Dangelo Vang", "Sandra Schmidt",
            "Jon Carson", "Haiden Newton", "Rachel Stanton", "Jaylon Cobb" };
    private static final int MAX_AN = 2020;
    private static final int MIN_AN = 1990;
    private static final int MAX_NRROTI = 4;
    private static final int MIN_NRROTI = 1;
    private static final int MAX_GREUTATE = 40;
    private static final int MIN_GREUTATE = 1;
    private static final int MAX_NRPEDALE = 4;
    private static final int MIN_NRPEDALE = 2;
    private static final int MAX_ACCELERATIE = 20;
    private static final int MIN_ACCELERATIE = 1;
    private static final VehiculFMAgrement.TipTeren[] tipuriTeren = VehiculFMAgrement.TipTeren.values();
    private static final VehiculFMAgrement.CategVarsta[] categoriiVarsta = VehiculFMAgrement.CategVarsta.values();
    private static final VehiculFMAgrement.EchipamentProtectie[] echipamenteProtectie = VehiculFMAgrement.EchipamentProtectie
            .values();

    public static ArrayList<VehiculFMAgrement> seed(int nr) {
        if (nr > MAX || nr < MIN) {
            throw new IllegalArgumentException("Numarul de vehicule trebuie sa fie intre " + MIN + " si " + MAX);
        }
        ArrayList<VehiculFMAgrement> vehicule = new ArrayList<VehiculFMAgrement>();
        for (int i = 0; i < nr; i++) {
            float vitezaMax = random.nextFloat() * (MAX_VITEZA - MIN_VITEZA) + MIN_VITEZA;
            float pret = random.nextFloat() * (MAX_PRET - MIN_PRET) + MIN_PRET;
            String marca = manufacturers[random.nextInt(manufacturers.length)];
            String model = models[random.nextInt(models.length)];
            String tip = types[random.nextInt(types.length)];
            String proprietar = proprietari[random.nextInt(proprietari.length)];
            int nrRoti = random.nextInt(MAX_NRROTI - MIN_NRROTI) + MIN_NRROTI;
            float greutate = random.nextFloat() * (MAX_GREUTATE - MIN_GREUTATE) + MIN_GREUTATE;
            int an = random.nextInt(MAX_AN - MIN_AN) + MIN_AN;
            int nrPedale = random.nextInt(MAX_NRPEDALE - MIN_NRPEDALE) + MIN_NRPEDALE;
            int acceleratie = random.nextInt(MAX_ACCELERATIE - MIN_ACCELERATIE) + MIN_ACCELERATIE;
            VehiculFMAgrement.TipTeren tipTeren = tipuriTeren[random.nextInt(tipuriTeren.length)];
            ArrayList<VehiculFMAgrement.EchipamentProtectie> echipamente = new ArrayList<VehiculFMAgrement.EchipamentProtectie>();
            VehiculFMAgrement.CategVarsta categVarsta = categoriiVarsta[random.nextInt(categoriiVarsta.length)];
            int nrEchipamente = random.nextInt(echipamenteProtectie.length);
            for (int j = 0; j < nrEchipamente; j++) {
                echipamente.add(echipamenteProtectie[random.nextInt(echipamenteProtectie.length)]);
            }
            VehiculFMAgrement vfma = new VehiculFMAgrement(vitezaMax, pret, marca, model, tip, proprietar, nrRoti,
                    greutate, an, nrPedale, acceleratie, tipTeren,
                    echipamente, categVarsta);
            vehicule.add(vfma);
        }
        return vehicule;
    }

    public static JSONArray JSONseed(int nr) {
        if (nr > MAX || nr < MIN) {
            throw new IllegalArgumentException("Numarul de vehicule trebuie sa fie intre " + MIN + " si " + MAX);
        }
        ArrayList<VehiculFMAgrement> vehicule = seed(nr);
        return JSONseed(vehicule);
    }

    public static JSONArray JSONseed(ArrayList<VehiculFMAgrement> vehicule) {
        return JSONseed(vehicule, fileName);
    }

    public static JSONArray JSONseed(boolean canBeNull, ArrayList<VehiculFMAgrement> vehicule) {
        return JSONseed(canBeNull, vehicule, fileName);
    }

    public static JSONArray JSONseed(ArrayList<VehiculFMAgrement> vehicule, String path) {
        return JSONseed(false, vehicule, path);
    }

    public static JSONArray JSONseed(boolean canBeNull, ArrayList<VehiculFMAgrement> vehicule, String path)
            throws IllegalArgumentException {
        // if ((vehicule == null || vehicule.size() == 0) && !canBeNull) {
        //     throw new IllegalArgumentException("Lista de vehicule nu poate fi nula sau goala");
        // }
        JSONArray vehiculeJSON = new JSONArray();
        for (int i = 0; i < vehicule.size(); i++) {
            VehiculFMAgrement vfma = vehicule.get(i);

            JSONObject vehicul = new JSONObject();
            vehicul.put("id", vfma.getId());
            vehicul.put("vitezaMax", vfma.getVitezaMax());
            vehicul.put("pret", vfma.getPret());
            vehicul.put("marca", vfma.getMarca());
            vehicul.put("model", vfma.getModel());
            vehicul.put("tip", vfma.getTip());
            vehicul.put("proprietar", vfma.getProprietar());
            vehicul.put("nrRoti", vfma.getNrRoti());
            vehicul.put("greutate", vfma.getGreutate());
            vehicul.put("an", vfma.getAnFabricatie());
            vehicul.put("nrPedale", vfma.getNrPedale());
            vehicul.put("acceleratie", vfma.getAcceleratie());
            vehicul.put("tipTeren", vfma.getTipTeren());
            vehicul.put("echipamente", vfma.getEchipamentProtectie());
            vehicul.put("categVarsta", vfma.getCategVarsta());
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

    public static ArrayList<VehiculFMAgrement> JSONReadSeed(JSONArray vehiculeJSON) throws IllegalArgumentException {
        if (vehiculeJSON == null || vehiculeJSON.length() == 0) {
            throw new IllegalArgumentException("Lista de vehicule nu poate fi nula sau goala");
        }
        ArrayList<VehiculFMAgrement> vehicule = new ArrayList<VehiculFMAgrement>();
        for (int i = 0; i < vehiculeJSON.length(); i++) {
            JSONObject vehicul = vehiculeJSON.getJSONObject(i);
            long id = vehicul.getLong("id");
            float vitezaMax = vehicul.getFloat("vitezaMax");
            float pret = vehicul.getFloat("pret");
            String marca = vehicul.getString("marca");
            String model = vehicul.getString("model");
            String tip = vehicul.getString("tip");
            String proprietar = vehicul.getString("proprietar");
            int nrRoti = vehicul.getInt("nrRoti");
            float greutate = vehicul.getFloat("greutate");
            int an = vehicul.getInt("an");
            int nrPedale = vehicul.getInt("nrPedale");
            int acceleratie = vehicul.getInt("acceleratie");
            VehiculFMAgrement.TipTeren tipTeren = VehiculFMAgrement.TipTeren.valueOf(vehicul.getString("tipTeren"));
            VehiculFMAgrement.CategVarsta categVarsta = VehiculFMAgrement.CategVarsta
                    .valueOf(vehicul.getString("categVarsta"));
            ArrayList<VehiculFMAgrement.EchipamentProtectie> echipamente = new ArrayList<VehiculFMAgrement.EchipamentProtectie>();
            JSONArray echipamenteJSON = vehicul.getJSONArray("echipamente");
            for (int j = 0; j < echipamenteJSON.length(); j++) {
                echipamente.add(VehiculFMAgrement.EchipamentProtectie.valueOf(echipamenteJSON.getString(j)));
            }
            VehiculFMAgrement vfma = new VehiculFMAgrement(vitezaMax, pret, marca, model, tip, proprietar, nrRoti,
                    greutate, an, nrPedale, acceleratie,
                    tipTeren,
                    echipamente, categVarsta, id);
            vehicule.add(vfma);
        }
        return vehicule;
    }

    /**
     * Va fi stearsa la urmatoarea versiune
     * 
     * @deprecated
     * 
     */
    public static ArrayList<VehiculFMAgrement> JSONReadSeed(String path) throws IllegalArgumentException {
        if (path == null || path.isEmpty()) {
            throw new IllegalArgumentException("Path-ul nu poate fi nul sau gol");
        }
        ArrayList<VehiculFMAgrement> vehicule = new ArrayList<VehiculFMAgrement>();
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
                String tip = vehicul.getString("tip");
                String proprietar = vehicul.getString("proprietar");
                int nrRoti = vehicul.getInt("nrRoti");
                float greutate = (float) vehicul.getDouble("greutate");
                int an = vehicul.getInt("an");
                int nrPedale = vehicul.getInt("nrPedale");
                int acceleratie = vehicul.getInt("acceleratie");
                VehiculFMAgrement.TipTeren tipTeren = VehiculFMAgrement.TipTeren.valueOf(vehicul.getString("tipTeren"));
                VehiculFMAgrement.CategVarsta categVarsta = VehiculFMAgrement.CategVarsta
                        .valueOf(vehicul.getString("categVarsta"));
                JSONArray echipamenteJSON = vehicul.getJSONArray("echipamente");
                ArrayList<VehiculFMAgrement.EchipamentProtectie> echipamente = new ArrayList<VehiculFMAgrement.EchipamentProtectie>();
                for (int j = 0; j < echipamenteJSON.length(); j++) {
                    echipamente.add(VehiculFMAgrement.EchipamentProtectie.valueOf(echipamenteJSON.getString(j)));
                }
                VehiculFMAgrement vfma = new VehiculFMAgrement(vitezaMax, pret, marca, model, tip, proprietar, nrRoti,
                        greutate, an, nrPedale,
                        acceleratie,
                        tipTeren, echipamente,
                        categVarsta, id);
                vehicule.add(vfma);
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

    // adaugat pt citirea din fisier si returnare pt interfata grafica
    public static ArrayList<VehiculFMAgrement> getVehicule() {
        ArrayList<VehiculFMAgrement> vehicule;
        try {
            vehicule = JSONReadSeed(fileName);
        } catch (IllegalArgumentException e) {
            vehicule = new ArrayList<VehiculFMAgrement>();
        }
        return vehicule;
    }

    // adaugat pt filtrare si returnare pt interfata grafica
    public static ArrayList<VehiculFMAgrement> getVehicule(float pretMin, float pretMax, float vitezaMin,
            float vitezaMax) {
        ArrayList<VehiculFMAgrement> vehicule;
        try {
            vehicule = JSONReadSeed(fileName);
        } catch (IllegalArgumentException e) {
            vehicule = new ArrayList<VehiculFMAgrement>();
        }
        if (pretMin > 0 || pretMax > 0)
            vehicule = VehiculFMAgrement.filtrarePret(vehicule, pretMax, pretMin);
        if (vitezaMin > 0 || vitezaMax > 0)
            vehicule = VehiculFMAgrement.filtrareViteza(vehicule, vitezaMax, vitezaMin);
        return vehicule;
    }

    public static boolean addVehicle(int nr) {
        ArrayList<VehiculFMAgrement> vehiculeOld;
        try {
            vehiculeOld = JSONReadSeed(fileName);
        } catch (IllegalArgumentException e) {
            vehiculeOld = new ArrayList<VehiculFMAgrement>();
        }
        ArrayList<VehiculFMAgrement> vehiculeNew = seed(nr);
        ArrayList<VehiculFMAgrement> vehicule = new ArrayList<VehiculFMAgrement>();
        vehicule.addAll(vehiculeOld);
        vehicule.addAll(vehiculeNew);
        JSONseed(vehicule);
        return true;
    }

    // adaugat pt adaugarea unui vehicul in fisier
    public static JSONArray addVehicule(int nr) {
        ArrayList<VehiculFMAgrement> vehiculeOld;
        try {
            vehiculeOld = JSONReadSeed(fileName);
        } catch (IllegalArgumentException e) {
            vehiculeOld = new ArrayList<VehiculFMAgrement>();
        }
        ArrayList<VehiculFMAgrement> vehiculeNew = seed(nr);
        ArrayList<VehiculFMAgrement> vehicule = new ArrayList<VehiculFMAgrement>();
        vehicule.addAll(vehiculeOld);
        vehicule.addAll(vehiculeNew);
        return JSONseed(vehicule);
    }

    public static JSONArray addVehicule(VehiculFMAgrement vfm) {
        ArrayList<VehiculFMAgrement> vehiculeOld;
        try {
            vehiculeOld = JSONReadSeed(fileName);
        } catch (IllegalArgumentException e) {
            vehiculeOld = new ArrayList<VehiculFMAgrement>();
        }
        ArrayList<VehiculFMAgrement> vehicule = new ArrayList<VehiculFMAgrement>();
        vehicule.addAll(vehiculeOld);
        vehicule.add(vfm);
        return JSONseed(vehicule);
    }

    /**
     * adaugat pt resetarea fisierului
     * Va fi stearsa la urmatoarea versiune
     * 
     * @deprecated
     */
    public static boolean resetData() {
        ArrayList<VehiculFMAgrement> vehicule = new ArrayList<VehiculFMAgrement>();
        VehiculFMAgrementSeeder.JSONseed(true, vehicule);
        VehiculFMAgrement.resetIdPool();
        return true;
    }

    // adaugat pt resetarea fisierului
    public static JSONArray resetVehicule() {
        ArrayList<VehiculFMAgrement> vehicule = new ArrayList<VehiculFMAgrement>();
        VehiculFMAgrement.resetIdPool();
        return JSONseed(true, vehicule);
    }

}