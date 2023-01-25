package com.vicce.move.seeder;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.nio.file.NoSuchFileException;

import com.vicce.move.VehiculMBenzina;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.json.JSONObject;
import org.json.JSONArray;



public class VehiculMBenzinaSeeder {

    private static Random random = new Random();
    private static final String fileName = "vehiculeMBenzina.test.json";
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
    private static final int MAX_NRLOCURI = 8;
    private static final int MIN_NRLOCURI = 2;
    private static final int MAX_CAI=600;
    private static final int MIN_CAI=60;
    private static final int MAX_CAPACITATE=3500;
    private static final int MIN_CAPACITATE=1400;
    private static final double MAX_CONSUM=12.5;
    private static final double MIN_CONSUM=3.4;
    

    //static private String[] modele = new String[]{"VW ","Audi","Ford","BMW ","Hyundai Elantra","Citroen","Skoda"};
    //static private String[] marci = new String[]{"Golf 5","A3","Focus","Seria 3","Elantra"," C3","Superb"};

    private static final String[] manufacturers = { "VW", "Audi", "Ford", "BMW", "Hyundai", "Citroen",
            "Skoda", "Mercedes-Benz", "Renault","Dacia", "Opel", "Toyota"};

    private static final String[] models = { "Golf 5","Passat","A3","A6","Focus","Fiesta","Seria 3","X3","Elantra","Tucson"," C3","C5","Superb",
    "Octavia", "C","S","Clio","Megane", "Logan","Duster", "Astra","Corsa", "Corolla","Yaris"};

    private static final String[] types = {"Sport", "Road", "Mountain", "Hybrid", "Touring", "SUV", "LUX"  };

    private static final String[] proprietari = { "Andrea Ortiz", "Kadence Carney", "Hunter Heath", "Elianna Diaz",
    "Marina Barajas", "Ayanna Daniel", "Skylar Jensen", "Laura Hudson", "Oswaldo Rosario", "Marvin Clayton",
    "Nora Avila", "Tony Yang", "Jesus Beck", "Cayden Hurst", "Brayden Young", "Esteban Larsen",
    "Scarlett Horne", "Logan Estes", "Kyra Berger", "Charlize Wang", "Kael Gomez", "Vivian Levy",
    "Isabella Grant", "Spencer Hooper", "Danica Kane", "Emelia Hernandez", "Armani Hammond", "Raquel Burke",
    "Ruth Christian", "Prince Kim", "Ellis Wright", "Penelope Bean", "Raul Waller", "Kaylynn Hayden",
    "Sean Crawford", "Kaya Roth", "Ally Cross", "Sage King", "Payten Bentley", "Gianni Woodward",
    "Yandel Marshall", "Kailey Kramer", "Dax Bolton", "Makenna Parks", "Dangelo Vang", "Sandra Schmidt",
    "Jon Carson", "Haiden Newton", "Rachel Stanton", "Jaylon Cobb" };



    public static ArrayList<VehiculMBenzina> seed (int nr){
        if (nr > MAX || nr < MIN) {
            throw new IllegalArgumentException("Numarul de vehicule trebuie sa fie intre " + MIN + " si " + MAX);
        }
        ArrayList<VehiculMBenzina> vehicule = new ArrayList<VehiculMBenzina>();
        
        for(int i=0;i<nr;i++){
            //int vitezaMax=new Random().nextInt(130,350);
            //int pret=new Random().nextInt(4000,90000);
            //int nrRoti=new Random().nextInt(4,6);
            //int nrLocuri=new Random().nextInt(2,7);
            //int caiPutere=new Random().nextInt(70,500);
            //int capacitateMotor=new Random().nextInt(1200,3000);
            //String marca = marci[new Random().nextInt(marci.length)];
            //String model = modele[new Random().nextInt(modele.length)];
            //int anFabricatie=new Random().nextInt(1995,2022);
            //double consumUrban=new Random().nextInt(5,14);

            float vitezaMax = random.nextFloat() * (MAX_VITEZA - MIN_VITEZA) + MIN_VITEZA;
            float pret = random.nextFloat() * (MAX_PRET - MIN_PRET) + MIN_PRET; 
            String tip = types[random.nextInt(types.length)];
            String proprietar = proprietari[random.nextInt(proprietari.length)];
            int anFabricatie = random.nextInt(MAX_AN - MIN_AN) + MIN_AN;
            int nrRoti = random.nextInt(MAX_NRROTI - MIN_NRROTI) + MIN_NRROTI;
            int nrLocuri = random.nextInt(MAX_NRLOCURI - MIN_NRLOCURI) + MIN_NRLOCURI;
            int caiPutere = random.nextInt(MAX_CAI - MIN_CAI) + MIN_CAI;
            int capacitateMotor=random.nextInt(MAX_CAPACITATE - MIN_CAPACITATE) + MIN_CAI;
            double consumUrban=random.nextDouble(MAX_CONSUM - MIN_CONSUM) + MIN_CONSUM;
            String marca = manufacturers[random.nextInt(manufacturers.length)];
            String model = models[random.nextInt(models.length)];
            

            VehiculMBenzina masina=new VehiculMBenzina(vitezaMax,pret,marca,model,tip,proprietar,nrRoti,nrLocuri,caiPutere,capacitateMotor,anFabricatie,consumUrban);
            vehicule.add(masina);
        }
        return vehicule;
    }

    public static JSONArray JSONseed(int nr) {
        if (nr > MAX || nr < MIN) {
            throw new IllegalArgumentException("Numarul de vehicule trebuie sa fie intre " + MIN + " si " + MAX);
        }
        ArrayList<VehiculMBenzina> vehicule = seed(nr);
        return JSONseed(vehicule);
    }

    public static JSONArray JSONseed(ArrayList<VehiculMBenzina> vehicule) {
        return JSONseed(vehicule, fileName);
    }

    public static JSONArray JSONseed(boolean canBeNull, ArrayList<VehiculMBenzina> vehicule) {
        return JSONseed(canBeNull, vehicule, fileName);
    }

    public static JSONArray JSONseed(ArrayList<VehiculMBenzina> vehicule, String path) {
        return JSONseed(false, vehicule, path);
    }

    public static JSONArray JSONseed(boolean canBeNull, ArrayList<VehiculMBenzina> vehicule, String path)
            throws IllegalArgumentException {
        if ((vehicule == null || vehicule.size() == 0) && !canBeNull) {
            throw new IllegalArgumentException("Lista de vehicule nu poate fi nula sau goala");
        }
        JSONArray vehiculeJSON = new JSONArray();
        for (int i = 0; i < vehicule.size(); i++) {
            VehiculMBenzina vmb = vehicule.get(i);

            JSONObject vehicul = new JSONObject();
            vehicul.put("id", vmb.getId());
            vehicul.put("vitezaMax", vmb.getVitezaMax());
            vehicul.put("pret", vmb.getPret());
            vehicul.put("anFabricatie", vmb.getAnFabricatie());
            vehicul.put("nrRoti", vmb.getNrRoti());
            vehicul.put("nrLocuri",vmb.getNrLocuri());
            vehicul.put("caiPutere",vmb.getCaiPutere());
            vehicul.put("capacitateMotor",vmb.getCapacitateMotor());
            vehicul.put("consumUrban",vmb.getConsumUrban());
            vehicul.put("model",vmb.getModel());
            vehicul.put("marca",vmb.getMarca());
            vehicul.put("tip",vmb.getTip());
            vehicul.put("proprietar",vmb.getProprietar());
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

    public static ArrayList<VehiculMBenzina> JSONReadSeed(JSONArray vehiculeJSON) throws IllegalArgumentException {
        if (vehiculeJSON == null || vehiculeJSON.length() == 0) {
            throw new IllegalArgumentException("Lista de vehicule nu poate fi nula sau goala");
        }
        ArrayList<VehiculMBenzina> vehicule = new ArrayList<VehiculMBenzina>();
        for (int i = 0; i < vehiculeJSON.length(); i++) {
            JSONObject vehicul = vehiculeJSON.getJSONObject(i);
            long id = vehicul.getLong("id");
            float vitezaMax = (float) vehicul.getDouble("vitezaMax");
            float pret = (float) vehicul.getDouble("pret");
            int anFabricatie = vehicul.getInt("anFabricatie");
            int nrRoti = vehicul.getInt("nrRoti");
            int nrLocuri=vehicul.getInt("nrLocuri");
            int caiPutere=vehicul.getInt("caiPutere");
            int capacitateMotor=vehicul.getInt("capacitateMotor");
            double consumUrban=vehicul.getDouble("consumUrban");
            String model=vehicul.getString("model");
            String marca=vehicul.getString("marca");
            String tip = vehicul.getString("tip");
            String proprietar = vehicul.getString("proprietar");
           
           
            VehiculMBenzina vmb = new VehiculMBenzina(vitezaMax, pret,marca,model,tip ,proprietar, nrRoti, nrLocuri, caiPutere, capacitateMotor,anFabricatie,consumUrban,id);
            vehicule.add(vmb);
        }
        return vehicule;
    }


    public static ArrayList<VehiculMBenzina> JSONReadSeed(String path) throws IllegalArgumentException {
        if (path == null || path.isEmpty()) {
            throw new IllegalArgumentException("Path-ul nu poate fi nul sau gol");
        }
        ArrayList<VehiculMBenzina> vehicule = new ArrayList<VehiculMBenzina>();
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
                int anFabricatie = vehicul.getInt("anFabricatie");
                int nrRoti = vehicul.getInt("nrRoti");
                int nrLocuri=vehicul.getInt("nrLocuri");
                int caiPutere=vehicul.getInt("caiPutere");
                int capacitateMotor=vehicul.getInt("capacitateMotor");
                double consumUrban=vehicul.getDouble("consumUrban");
                String model=vehicul.getString("model");
                String marca=vehicul.getString("marca");
                String tip = vehicul.getString("tip");
                String proprietar = vehicul.getString("proprietar");

                VehiculMBenzina vmb = new VehiculMBenzina(vitezaMax, pret,marca,model,tip ,proprietar, nrRoti, nrLocuri, caiPutere, capacitateMotor,anFabricatie,consumUrban,id);
                vehicule.add(vmb);
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
    
    // pt citirea din fisier si returnare pt interfata grafica
    public static ArrayList<VehiculMBenzina> getVehicule() {
        ArrayList<VehiculMBenzina> vehicule;
        try {
            vehicule = JSONReadSeed(fileName);
        } catch (IllegalArgumentException e) {
            vehicule = new ArrayList<VehiculMBenzina>();
        }
        return vehicule;
    }

    // pt filtrare si returnare pt interfata grafica
    public static ArrayList<VehiculMBenzina> getVehicule(float pretMin, float pretMax, float vitezaMin,
            float vitezaMax) {
        ArrayList<VehiculMBenzina> vehicule;
        try {
            vehicule = JSONReadSeed(fileName);
        } catch (IllegalArgumentException e) {
            vehicule = new ArrayList<VehiculMBenzina>();
        }
        if (pretMin > 0 || pretMax > 0)
            vehicule = VehiculMBenzina.filtrarePret(vehicule, pretMax, pretMin);
        if (vitezaMin > 0 || vitezaMax > 0)
            vehicule = VehiculMBenzina.filtrareViteza(vehicule, vitezaMax, vitezaMin);
        return vehicule;
    }

    // pt adaugarea unui vehicul in fisier

    public static boolean addVehicle(int nr) {
        ArrayList<VehiculMBenzina> vehiculeOld;
        try {
            vehiculeOld = JSONReadSeed(fileName);
        } catch (IllegalArgumentException e) {
            vehiculeOld = new ArrayList<VehiculMBenzina>();
        }
        ArrayList<VehiculMBenzina> vehiculeNew = seed(nr);
        ArrayList<VehiculMBenzina> vehicule = new ArrayList<VehiculMBenzina>();
        vehicule.addAll(vehiculeOld);
        vehicule.addAll(vehiculeNew);
        JSONseed(vehicule);
        return true;
    }

    //  pt adaugarea unui vehicul in fisier
    public static JSONArray addVehicule(int nr) {
        ArrayList<VehiculMBenzina> vehiculeOld;
        try {
            vehiculeOld = JSONReadSeed(fileName);
        } catch (IllegalArgumentException e) {
            vehiculeOld = new ArrayList<VehiculMBenzina>();
        }
        ArrayList<VehiculMBenzina> vehiculeNew = seed(nr);
        ArrayList<VehiculMBenzina> vehicule = new ArrayList<VehiculMBenzina>();
        vehicule.addAll(vehiculeOld);
        vehicule.addAll(vehiculeNew);
        return JSONseed(vehicule);
    }

    public static boolean resetData() {
        ArrayList<VehiculMBenzina> vehicule = new ArrayList<VehiculMBenzina>();
        VehiculMBenzinaSeeder.JSONseed(true, vehicule);
        VehiculMBenzina.resetIdPool();
        return true;
    }

     // adaugat pt resetarea fisierului
     public static JSONArray resetVehicule() {
        ArrayList<VehiculMBenzina> vehicule = new ArrayList<VehiculMBenzina>();
        VehiculMBenzina.resetIdPool();
        return JSONseed(true, vehicule);
    }

}



