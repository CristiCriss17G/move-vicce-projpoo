package com.vicce.move.seeder;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.nio.file.NoSuchFileException;

import com.vicce.move.VehiculFMSport;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.json.JSONObject;
import org.json.JSONArray;

public class VehiculFMSportSeeder {
    private static Random random = new Random();
    private static final String fileName = "vehiculeFMSport.test.json"; // modifica numele fisierului pentru fiecare
                                                                        // clasa
    private static final int MAX = 100;
    private static final int MIN = 1;
    private static final int MAX_VITEZA = 300;
    private static final int MIN_VITEZA = 100;
    private static final int MAX_PRET = 10000;
    private static final int MIN_PRET = 500;
    private static final String[] manufacturers = { "Nike", "Adidas", "Under Armour", "Puma", "Reebok", "Asics",
            "New Balance", "Jordan", "Wilson", "Columbia" };
    private static final String[] models = { "Road Bike", "Mountain Bike", "Hybrid Bike", "Touring Bike",
            "Fixed Gear Bike", "BMX Bike", "Cruiser Bike", "Tandem Bike", "Folding Bike", "Recumbent Bike",
            "Skateboard", "Longboard", "Inline Skates", "Roller Skates", "Scooter", "Unicycle" };
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
    private static final int MAX_NRROTI = 8;
    private static final int MIN_NRROTI = 1;
    private static final int MAX_GREUTATE = 10;
    private static final int MIN_GREUTATE = 1;
    private static final int MAX_NRPEDALE = 10;
    private static final int MIN_NRPEDALE = 1;
    private static final int MAX_ACCELERATIE = 20;
    private static final int MIN_ACCELERATIE = 1;
    private static final VehiculFMSport.TipTeren[] tipuriTeren = VehiculFMSport.TipTeren.values();
    private static final VehiculFMSport.EchipamentProtectie[] echipamenteProtectie = VehiculFMSport.EchipamentProtectie
            .values();

    public static ArrayList<VehiculFMSport> seed(int nr) {
        if (nr > MAX || nr < MIN) {
            throw new IllegalArgumentException("Numarul de vehicule trebuie sa fie intre " + MIN + " si " + MAX);
        }
        ArrayList<VehiculFMSport> vehicule = new ArrayList<VehiculFMSport>();
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
            VehiculFMSport.TipTeren tipTeren = tipuriTeren[random.nextInt(tipuriTeren.length)];
            ArrayList<VehiculFMSport.EchipamentProtectie> echipamente = new ArrayList<VehiculFMSport.EchipamentProtectie>();
            int nrEchipamente = random.nextInt(echipamenteProtectie.length);
            for (int j = 0; j < nrEchipamente; j++) {
                echipamente.add(echipamenteProtectie[random.nextInt(echipamenteProtectie.length)]);
            }
            VehiculFMSport vfm = new VehiculFMSport(vitezaMax, pret, marca, model, tip, proprietar, nrRoti,
                    greutate, an, nrPedale, acceleratie,
                    tipTeren,
                    echipamente);
            vehicule.add(vfm);
        }
        return vehicule;
    }

    // modificat pt returnare JSON
    public static JSONArray JSONseed(int nr) {
        if (nr > MAX || nr < MIN) {
            throw new IllegalArgumentException("Numarul de vehicule trebuie sa fie intre " + MIN + " si " + MAX);
        }
        ArrayList<VehiculFMSport> vehicule = seed(nr);
        return JSONseed(vehicule);
    }

    // modificat pt returnare JSON
    public static JSONArray JSONseed(ArrayList<VehiculFMSport> vehicule) {
        return JSONseed(vehicule, fileName);
    }

    // modificat pt returnare JSON
    public static JSONArray JSONseed(boolean canBeNull, ArrayList<VehiculFMSport> vehicule) {
        return JSONseed(canBeNull, vehicule, fileName);
    }

    // modificat pt returnare JSON
    public static JSONArray JSONseed(ArrayList<VehiculFMSport> vehicule, String path) {
        return JSONseed(false, vehicule, path);
    }

    // modificat pt returnare JSON
    public static JSONArray JSONseed(boolean canBeNull, ArrayList<VehiculFMSport> vehicule, String path)
            throws IllegalArgumentException {
        if ((vehicule == null || vehicule.size() == 0) && !canBeNull) {
            throw new IllegalArgumentException("Lista de vehicule nu poate fi nula sau goala");
        }
        JSONArray vehiculeJSON = new JSONArray();
        for (int i = 0; i < vehicule.size(); i++) {
            VehiculFMSport vfm = vehicule.get(i);

            JSONObject vehicul = new JSONObject();
            vehicul.put("id", vfm.getId());
            vehicul.put("vitezaMax", vfm.getVitezaMax());
            vehicul.put("pret", vfm.getPret());
            vehicul.put("marca", vfm.getMarca());
            vehicul.put("model", vfm.getModel());
            vehicul.put("tip", vfm.getTip());
            vehicul.put("proprietar", vfm.getProprietar());
            vehicul.put("nrRoti", vfm.getNrRoti());
            vehicul.put("greutate", vfm.getGreutate());
            vehicul.put("an", vfm.getAnFabricatie());
            vehicul.put("nrPedale", vfm.getNrPedale());
            vehicul.put("acceleratie", vfm.getAcceleratie());
            vehicul.put("tipTeren", vfm.getTipTeren());
            vehicul.put("echipamente", vfm.getEchipamentProtectie());
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
    public static ArrayList<VehiculFMSport> JSONReadSeed(JSONArray vehiculeJSON) throws IllegalArgumentException {
        if (vehiculeJSON == null || vehiculeJSON.length() == 0) {
            throw new IllegalArgumentException("Lista de vehicule nu poate fi nula sau goala");
        }
        ArrayList<VehiculFMSport> vehicule = new ArrayList<VehiculFMSport>();
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
            VehiculFMSport.TipTeren tipTeren = VehiculFMSport.TipTeren.valueOf(vehicul.getString("tipTeren"));
            ArrayList<VehiculFMSport.EchipamentProtectie> echipamente = new ArrayList<VehiculFMSport.EchipamentProtectie>();
            JSONArray echipamenteJSON = vehicul.getJSONArray("echipamente");
            for (int j = 0; j < echipamenteJSON.length(); j++) {
                echipamente.add(VehiculFMSport.EchipamentProtectie.valueOf(echipamenteJSON.getString(j)));
            }
            VehiculFMSport vfm = new VehiculFMSport(vitezaMax, pret, marca, model, tip, proprietar, nrRoti,
                    greutate, an, nrPedale, acceleratie,
                    tipTeren,
                    echipamente, id);
            vehicule.add(vfm);
        }
        return vehicule;
    }

    /**
     * Va fi stearsa la urmatoarea versiune
     * 
     * @deprecated
     * 
     */
    public static ArrayList<VehiculFMSport> JSONReadSeed(String path) throws IllegalArgumentException {
        if (path == null || path.isEmpty()) {
            throw new IllegalArgumentException("Path-ul nu poate fi nul sau gol");
        }
        ArrayList<VehiculFMSport> vehicule = new ArrayList<VehiculFMSport>();
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
                VehiculFMSport.TipTeren tipTeren = VehiculFMSport.TipTeren.valueOf(vehicul.getString("tipTeren"));
                JSONArray echipamenteJSON = vehicul.getJSONArray("echipamente");
                ArrayList<VehiculFMSport.EchipamentProtectie> echipamente = new ArrayList<VehiculFMSport.EchipamentProtectie>();
                for (int j = 0; j < echipamenteJSON.length(); j++) {
                    echipamente.add(VehiculFMSport.EchipamentProtectie.valueOf(echipamenteJSON.getString(j)));
                }
                VehiculFMSport vfm = new VehiculFMSport(vitezaMax, pret, marca, model, tip, proprietar, nrRoti,
                        greutate, an, nrPedale,
                        acceleratie,
                        tipTeren,
                        echipamente, id);
                vehicule.add(vfm);
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
    public static ArrayList<VehiculFMSport> getVehicule() {
        ArrayList<VehiculFMSport> vehicule;
        try {
            vehicule = JSONReadSeed(fileName);
        } catch (IllegalArgumentException e) {
            vehicule = new ArrayList<VehiculFMSport>();
        }
        return vehicule;
    }

    // adaugat pt filtrare si returnare pt interfata grafica
    public static ArrayList<VehiculFMSport> getVehicule(float pretMin, float pretMax, float vitezaMin,
            float vitezaMax) {
        ArrayList<VehiculFMSport> vehicule;
        try {
            vehicule = JSONReadSeed(fileName);
        } catch (IllegalArgumentException e) {
            vehicule = new ArrayList<VehiculFMSport>();
        }
        if (pretMin > 0 || pretMax > 0)
            vehicule = VehiculFMSport.filtrarePret(vehicule, pretMax, pretMin);
        if (vitezaMin > 0 || vitezaMax > 0)
            vehicule = VehiculFMSport.filtrareViteza(vehicule, vitezaMax, vitezaMin);
        return vehicule;
    }

    /**
     * adaugat pt adaugarea unui vehicul in fisier
     * Va fi stearsa la urmatoarea versiune
     * 
     * @deprecated
     */
    public static boolean addVehicle(int nr) {
        ArrayList<VehiculFMSport> vehiculeOld;
        try {
            vehiculeOld = JSONReadSeed(fileName);
        } catch (IllegalArgumentException e) {
            vehiculeOld = new ArrayList<VehiculFMSport>();
        }
        ArrayList<VehiculFMSport> vehiculeNew = seed(nr);
        ArrayList<VehiculFMSport> vehicule = new ArrayList<VehiculFMSport>();
        vehicule.addAll(vehiculeOld);
        vehicule.addAll(vehiculeNew);
        JSONseed(vehicule);
        return true;
    }

    // adaugat pt adaugarea unui vehicul in fisier
    public static JSONArray addVehicule(int nr) {
        ArrayList<VehiculFMSport> vehiculeOld;
        try {
            vehiculeOld = JSONReadSeed(fileName);
        } catch (IllegalArgumentException e) {
            vehiculeOld = new ArrayList<VehiculFMSport>();
        }
        ArrayList<VehiculFMSport> vehiculeNew = seed(nr);
        ArrayList<VehiculFMSport> vehicule = new ArrayList<VehiculFMSport>();
        vehicule.addAll(vehiculeOld);
        vehicule.addAll(vehiculeNew);
        return JSONseed(vehicule);
    }

    /**
     * adaugat pt resetarea fisierului
     * Va fi stearsa la urmatoarea versiune
     * 
     * @deprecated
     */
    public static boolean resetData() {
        ArrayList<VehiculFMSport> vehicule = new ArrayList<VehiculFMSport>();
        VehiculFMSportSeeder.JSONseed(true, vehicule);
        VehiculFMSport.resetIdPool();
        return true;
    }

    // adaugat pt resetarea fisierului
    public static JSONArray resetVehicule() {
        ArrayList<VehiculFMSport> vehicule = new ArrayList<VehiculFMSport>();
        VehiculFMSport.resetIdPool();
        return JSONseed(true, vehicule);
    }

}
