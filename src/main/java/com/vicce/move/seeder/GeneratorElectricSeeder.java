package com.vicce.move.seeder;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.nio.file.NoSuchFileException;

import com.vicce.move.Mobilitate;
import com.vicce.move.VehiculFMAgrement;
import com.vicce.move.VehiculMElectric;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.json.JSONObject;
import org.json.JSONArray;

public class GeneratorElectricSeeder {
  private static Random random = new Random();
  private static final String fileName = "vehicule.test.json";
  private static final int MAX = 100;
  private static final int MIN = 1;
  private static final int MAX_VITEZA = 300;
  private static final int MIN_VITEZA = 100;
  private static final int MAX_PRET = 10000;
  private static final int MIN_PRET = 100;
  private static final int MIN_CAPACITATEMOTOR = 1500;
  private static final int MAX_CAPACITATEMOTOR = 5500;
  private static final int MIN_AUTONOMIE = 350;
  private static final int MAX_AUTONOMIE = 600;
  private static final double MIN_GREUTATE = 800;
  private static final double MAX_GREUTATE = 2000;
  private static final double MIN_KMREALI = 1000;
  private static final double MAX_KMREALI = 15000;
  private static final int MIN_ANFABRICATIE = 2000;
  private static final int MAX_ANFABRICATIE = 2023;
  private static final int MIN_NRSCAUNE = 4;
  private static final int MAX_NRSCAUNE = 7;
  private static final int MIN_LITRIPORTBAGAJ = 500;
  private static final int MAX_LITRIPORTBAGAJ = 1000;
  private static final int MIN_NRPEDALE = 2;
  private static final int MAX_NRPEDALE = 3;
  private static final int MIN_CUPLU = 400;
  private static final int MAX_CUPLU = 800;
  private static final int MIN_NRUSI = 2;
  private static final int MAX_NRUSI = 5;

  private static final String[] manufacturers = { "Mazda", "Porche", "Fiat", "Bentley", "Hammer", "Renault",
      "Dodge", "Toyota", "VW", "Dacia", "Koenigsegg", "Lada" };

  private static final String[] models = { "CX-7", "Tycan", "Punto", "Bentayga", "H2", " Talisman", "Charger", "Supra",
      "Lupo", "Logan", "One1", "Granta" };

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

  public static ArrayList<VehiculMElectric> seed(int nr) {
    if (nr > MAX || nr < MIN) {
      throw new IllegalArgumentException("Numarul de vehicule trebuie sa fie intre " + MIN + " si " + MAX);
    }
    ArrayList<VehiculMElectric> vehicule = new ArrayList<VehiculMElectric>();
    for (int i = 0; i < nr; i++) {
      float vitezaMax = random.nextFloat() * (MAX_VITEZA - MIN_VITEZA) + MIN_VITEZA;
      float pret = random.nextFloat() * (MAX_PRET - MIN_PRET) + MIN_PRET;
      int capacitateMotor = random.nextInt() * (MAX_CAPACITATEMOTOR - MIN_CAPACITATEMOTOR) + MIN_CAPACITATEMOTOR;
      int autonomie = random.nextInt() * (MAX_AUTONOMIE - MIN_AUTONOMIE) + MIN_AUTONOMIE;
      double greutate = random.nextDouble() * (MAX_GREUTATE - MIN_GREUTATE) + MIN_GREUTATE;
      double kmReali = random.nextDouble() * (MAX_KMREALI - MIN_KMREALI) + MIN_KMREALI;
      int anFabricatie = random.nextInt() * (MAX_ANFABRICATIE - MIN_ANFABRICATIE) + MIN_ANFABRICATIE;
      int nrScaune = random.nextInt() * (MAX_NRSCAUNE - MIN_NRSCAUNE) + MIN_NRSCAUNE;
      int litriPortbagaj = random.nextInt() * (MAX_LITRIPORTBAGAJ - MIN_LITRIPORTBAGAJ) + MIN_LITRIPORTBAGAJ;
      int nrPedale = random.nextInt() * (MAX_NRPEDALE - MIN_NRPEDALE) + MIN_NRPEDALE;
      int cuplu = random.nextInt() * (MAX_CUPLU - MIN_CUPLU) + MIN_CUPLU;
      int nrUsi = random.nextInt() * (MAX_NRUSI - MIN_NRUSI) + MIN_NRUSI;
      String marca = manufacturers[random.nextInt(manufacturers.length)];
      String model = models[random.nextInt(models.length)];

      VehiculMElectric vme = new VehiculMElectric(pret, pret, nrUsi, nrUsi, nrUsi, nrUsi, nrUsi, kmReali, nrUsi, nrUsi,
          kmReali, nrUsi, nrUsi, nrUsi);
      vehicule.add(vme);

    }
    return vehicule;
  }

  public static JSONArray JSONseed(int nr) {
    if (nr > MAX || nr > MIN) {
      throw new IllegalArgumentException("Numarul de vehicule trebuie sa fie intre " + MIN + " si " + MAX);

    }
    ArrayList<VehiculMElectric> vehicule = seed(nr);
    return JSONseed(vehicule);
  }

  public static JSONArray JSONseed(ArrayList<VehiculMElectric> vehicule) {
    return JSONseed(vehicule, fileName);
  }

  public static JSONArray JSONseed(boolean canBeNull, ArrayList<VehiculMElectric> vehicule) {
    return JSONseed(vehicule, fileName);
  }

  public static JSONArray JSONseed(ArrayList<VehiculMElectric> vehicule, String path) {
    return JSONseed(false, vehicule, path);
  }

  public static JSONArray JSONseed(boolean canBeNull, ArrayList<VehiculMElectric> vehicule, String path)
      throws IllegalArgumentException {
    if ((vehicule == null || vehicule.size() == 0) && !canBeNull) {
      throw new IllegalArgumentException("Lista de vehicule nu poate fi nula sau goala");
    }
    JSONArray vehiculeJSON = new JSONArray();
    for (int i = 0; i < vehicule.size(); i++) {
      VehiculMElectric vme = vehicule.get(i);
      JSONObject vehicul = new JSONObject();
      vehicul.put("id", vme.getId());
      vehicul.put("vitezaMax", vme.getVitezaMax());
      vehicul.put("pret", vme.getPret());
      vehicul.put("marca", vme.getMarca());
      vehicul.put("model", vme.getModel());
      vehicul.put("tip", vme.getTip());
      vehicul.put("proprietar", vme.getProprietar());
      vehicul.put("capacitateMotor", vme.getCapacitateMotor());
      vehicul.put("autonomie", vme.getAutonomie());
      vehicul.put("greutate", vme.getGreutate());
      vehicul.put("kmReali", vme.getKmReali());
      vehicul.put("anFabricatie", vme.getAnFabricatie());
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

  // modificat pt JSON
  public static ArrayList<VehiculMElectric> JSONReadSeed(JSONArray vehiculeJSON) throws IllegalArgumentException {
    if (vehiculeJSON == null || vehiculeJSON.length() == 0) {
      throw new IllegalArgumentException("Lista de vehicule nu poate fi nula sau goala");
    }
    ArrayList<VehiculMElectric> vehicule = new ArrayList<VehiculMElectric>();
    for (int i = 0; i < vehiculeJSON.length(); i++) {
      JSONObject vehicul = vehiculeJSON.getJSONObject(i);
      long id = vehicul.getLong("id");
      float vitezaMax = (float) vehicul.getDouble("vitezaMax");
      float pret = (float) vehicul.getDouble("pret");
      int capacitateMotor = vehicul.getInt("capacitateMotor");
      String marca = vehicul.getString("marca");
      String model = vehicul.getString("model");
      String tip = vehicul.getString("tip");
      String proprietar = vehicul.getString("proprietar");
      int autonomie = vehicul.getInt("autonomie");
      double greutate = vehicul.getDouble("greutate");
      double kmReali = vehicul.getDouble("kmReali");
      int anFabricatie = vehicul.getInt("anFabricatie");

      VehiculMElectric vme = new VehiculMElectric(vitezaMax, pret, capacitateMotor, marca, model, tip, proprietar,
          autonomie, greutate, kmReali, anFabricatie, id);
      vehicule.add(vme);
    }
    return vehicule;
  }

  public static ArrayList<VehiculMElectric> JSONReadSeed(String path) {
    if (path == null || path.isEmpty()) {
      throw new IllegalArgumentException("Path-ul nu poate fi nul sau gol");
    }
    ArrayList<VehiculMElectric> vehicule = new ArrayList<VehiculMElectric>();
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
        int capacitateMotor = vehicul.getInt("capacitateMotor");
        String marca = vehicul.getString("marca");
        String model = vehicul.getString("model");
        String tip = vehicul.getString("tip");
        String proprietar = vehicul.getString("proprietar");
        int autonomie = vehicul.getInt("autonomie");
        double greutate = vehicul.getDouble("greutate");
        double kmReali = vehicul.getDouble("kmReali");
        int anFabricatie = vehicul.getInt("anFabricatie");

        VehiculMElectric vme = new VehiculMElectric(vitezaMax, pret, capacitateMotor, marca, model, tip, proprietar,
            autonomie, greutate, kmReali, anFabricatie, id);
        vehicule.add(vme);
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

  // catch (NoSuchFileException e) {
  // // e.printStackTrace();
  // throw new IllegalArgumentException("Fisierul nu exista; eroare de I/O: " +
  // e.getMessage());
  // } catch (IOException e) {
  // // e.printStackTrace();
  // throw new IllegalArgumentException("Fisierul nu poate fi citit; eroare de
  // I/O: " + e.getMessage());
  // }

  public static ArrayList<VehiculMElectric> getVehicule() {
    ArrayList<VehiculMElectric> vehicule;
    try {
      vehicule = JSONReadSeed(fileName);
    } catch (IllegalArgumentException e) {
      vehicule = new ArrayList<VehiculMElectric>();
    }
    return vehicule;
  }

  // pt filtrare si returnare pt interfata grafica
  public static ArrayList<VehiculMElectric> getVehicule(float pretMin, float pretMax, float vitezaMin,
      float vitezaMax) {
    ArrayList<VehiculMElectric> vehicule;
    try {
      vehicule = JSONReadSeed(fileName);
    } catch (IllegalArgumentException e) {
      vehicule = new ArrayList<VehiculMElectric>();
    }
    if (pretMin > 0 || pretMax > 0)
      vehicule = VehiculMElectric.filtrarePret(vehicule, pretMax, pretMin);
    if (vitezaMin > 0 || vitezaMax > 0)
      vehicule = VehiculMElectric.filtrareViteza(vehicule, vitezaMax, vitezaMin);
    return vehicule;
  }

  // pt adaugarea unui vehicul in fisier
  public static boolean addVehicle(int nr) {
    ArrayList<VehiculMElectric> vehiculeOld;
    try {
      vehiculeOld = JSONReadSeed(fileName);
    } catch (IllegalArgumentException e) {
      vehiculeOld = new ArrayList<VehiculMElectric>();
    }
    ArrayList<VehiculMElectric> vehiculeNew = seed(nr);
    ArrayList<VehiculMElectric> vehicule = new ArrayList<VehiculMElectric>();
    vehicule.addAll(vehiculeOld);
    vehicule.addAll(vehiculeNew);
    JSONseed(vehicule);
    return true;
  }

  public static JSONArray addVehicule(int nr) {
    ArrayList<VehiculMElectric> vehiculeOld;
    try {
      vehiculeOld = JSONReadSeed(fileName);
    } catch (IllegalArgumentException e) {
      vehiculeOld = new ArrayList<VehiculMElectric>();
    }
    ArrayList<VehiculMElectric> vehiculeNew = seed(nr);
    ArrayList<VehiculMElectric> vehicule = new ArrayList<VehiculMElectric>();
    vehicule.addAll(vehiculeOld);
    vehicule.addAll(vehiculeNew);
    return JSONseed(vehicule);
  }

  public static JSONArray addVehicule(VehiculMElectric vfm) {
    ArrayList<VehiculMElectric> vehiculeOld;
    try {
      vehiculeOld = JSONReadSeed(fileName);
    } catch (IllegalArgumentException e) {
      vehiculeOld = new ArrayList<VehiculMElectric>();
    }
    ArrayList<VehiculMElectric> vehicule = new ArrayList<VehiculMElectric>();
    vehicule.addAll(vehiculeOld);
    vehicule.add(vfm);
    return JSONseed(vehicule);
  }

  public static boolean resetData() {
    ArrayList<VehiculMElectric> vehicule = new ArrayList<VehiculMElectric>();
    GeneratorElectricSeeder.JSONseed(true, vehicule);
    VehiculMElectric.resetIdPool();
    return true;
  }

  // pentru resetarea fisierului
  public static JSONArray resetVehicule() {
    ArrayList<VehiculMElectric> vehicule = new ArrayList<VehiculMElectric>();
    VehiculMElectric.resetIdPool();
    return JSONseed(true, vehicule);
  }

}