package com.vicce.move.seeder;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.nio.file.NoSuchFileException;

import com.vicce.move.VehiculFMAgrement;
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
  private static final int MAX_PRET = 10000;
  private static final int MIN_CAPACITATEMOTOR= 1500;
  private static final int MAX_CAPACITATEMOTOR= 5500;
  private static final int MIN_AUTONOMIE= 350;
  private static final int MAX_AUTONOMIE= 600;
  private static final double MIN_GREUTATE= 800;
  private static final double MAX_GREUTATE= 2000;
  private static final double MIN_KMREALI= 1000;
  private static final double MAX_KMREALI= 15000;
  private static final int MIN_ANFABRICATIE= 2000;
  private static final int MAX_ANFABRICATIE= 2023;
  private static final int MIN_NRSCAUNE= 4;
  private static final int MAX_NRSCAUNE= 7;
  private static final int MIN_LITRIPORTBAGAJ= 500;
  private static final int MAX_LITRIPORTBAGAJ= 1000;
  private static final int MIN_NRPEDALE= 2;
  private static final int MAX_NRPEDALE= 3;
  private static final int MIN_CUPLU= 400;
  private static final int MAX_CUPLU= 800;
  private static final int MIN_NRUSI= 2;
  private static final int MAX_NRUSI= 5;


public static ArrayList<VehiculMElectric> seed(int nr) {
        if (nr > MAX || nr < MIN) {
            throw new IllegalArgumentException("Numarul de vehicule trebuie sa fie intre " + MIN + " si " + MAX);
        }
        ArrayList<VehiculMElectric> vehicule = new ArrayList<VehiculMElectric>();
        for(int i =0;i<n;i++){
          float vitezaMax = random.nextFloat() * (MAX_VITEZA - MIN_VITEZA) + MIN_VITEZA;
          float pret = random.nextFloat() * (MAX_PRET - MIN_PRET) + MIN_PRET;
          int capacitateMotor = random.nextInt() * (MAX_CAPACITATEMOTOR-MIN_CAPACITATEMOTOR)+MIN_CAPACITATEMOTOR;
          int autonomie = random.nextInt()*(MAX_AUTONOMIE-MIN_AUTONOMIE)+MIN_AUTONOMIE;
          double greutate = random.nextDouble()*(MAX_GREUTATE-MIN_GREUTATE)+MIN_GREUTATE;
          double kmReali = random.nextDouble()*(MAX_KMREALI-MIN_KMREALI)+MIN_KMREALI;
          int anFabricatie = random.nextInt()*(MAX_ANFABRICATIE-MIN_ANFABRICATIE)+MIN_ANFABRICATIE;
          // int nrScaune = random.nextInt()*(MAX_NRSCAUNE-MIN_NRSCAUNE)+MIN_NRSCAUNE;
          // int litriPortbagaj = random.nextInt()*(MAX_LITRIPORTBAGAJ-MIN_LITRIPORTBAGAJ)+MIN_LITRIPORTBAGAJ;
          // int nrPedale = random.nextInt()*(MAX_NRPEDALE-MIN_NRPEDALE)+MIN_NRPEDALE;
          // int cuplu = random.nextInt()*(MAX_CUPLU-MIN_CUPLU)+MIN_CUPLU;
          // int nrUsi= random.nextInt()*(MAX_NRUSI-MIN_NRUSI)+MIN_NRUSI;

          VehiculMElectric vme = new VehiculMElectric(vitezaMax, pret,capacitateM,autonomie,greutate,kmReali,anFabricatie,nrScaune,litriPortbagaj,nrPedale,cuplu,nrUsi);
          //System.out.println(vme.raportVitezaPret());
          vehicule.add(vme);

        }
        return vehicule;
      }

      public static void JSONseed(int nr){
        if(nr > MAX || nr > MIN){
          throw new IllegalArgumentException("Numarul de vehicule trebuie sa fie intre " + MIN + " si " + MAX);

        }
        ArrayList<VehiculMElectric> vehicule = seed(nr);
        JSONseed(vehicule);
      }

      public static void JSONseed(ArrayList<VehiculMElectric> vehicule) {
        JSONseed(vehicule, "vehicule.test.json");
    }

    public static void JSONseed(boolean canBeNull, ArrayList<VehiculMElectric> vehicule) {
      JSONseed(canBeNull, vehicule, "vehicule.test.json");
    }

    
    public static void JSONseed(ArrayList<VehiculMElectric> vehicule, String path) {
      JSONseed(false, vehicule, path);
    }

    public static void JSONseed(boolean canBeNull, ArrayList<VehiculFMAgrement> vehicule, String path)
    throws IllegalArgumentException {
      if ((vehicule == null || vehicule.size() == 0) && !canBeNull) {
        throw new IllegalArgumentException("Lista de vehicule nu poate fi nula sau goala");

    }
    JSONArray vehiculeJSON = new JSONArray();
    for (int i = 0; i < vehicule.size(); i++) {
      VehiculMElectric vfm = vehicule.get(i);

      JSONObject vehicul = new JSONObject();
      vehicul.put("vitezaMax", vme.getVitezaMax());
      vehicul.put("pret", vme.getPret());
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

  }
  public static ArrayList<VehiculMElectric> JSONReadSeed(String path){
    if (path == null || path.isEmpty()) {
        throw new IllegalArgumentException("Path-ul nu poate fi nul sau gol");
    }
    ArrayList<VehiculeMElectric> vehicule = new ArrayList<VehiculMElectric>();
    try {
      Scanner scanner = new Scanner(Paths.get(path), StandardCharsets.UTF_8.name());
      String content = scanner.useDelimiter("\\A").next();
      scanner.close();
      JSONArray vehiculeJSON = new JSONArray(content);
      for (int i = 0; i < vehiculeJSON.length(); i++) {
        JSONObject vehicul = vehiculeJSON.getJSONObject(i);
        float vitezaMax = (float) vehicul.getDouble("vitezaMax");
        float pret = (float) vehicul.getDouble("pret");
        int capacitateMotor = vehicul.getInt("capacitateMotor");
        int autonomie = vehicul.getInt("autonomie");
        double greutate = vehicul.getDouble("greutate");
        double kmReali = vehicul.getDouble("kmReali");
        int anFabricatie = vehicul.getInt("anFabricatie");
        VehiculMElectric vme = new VehiculMElectric(float vitezaMax, float pret, int nrRoti, int nrLocuri, int nrUsi, int capacitateMotor,
        int autonomie, double greutate,int nrScaune, int litriPortbagaj, double kmReali, int anFabricatie,int nrPedale, int cuplu);
                vehicule.add(vme);
  }
}
catch (NoSuchFileException e) {
  // e.printStackTrace();
  throw new IllegalArgumentException("Fisierul nu exista; eroare de I/O: " + e.getMessage());
} catch (IOException e) {
  // e.printStackTrace();
  throw new IllegalArgumentException("Fisierul nu poate fi citit; eroare de I/O: " + e.getMessage());
}


return vehicule;
}

public static ArrayList<VehiculMElectric> getVehicule() {
  ArrayList<VehiculMElectric> vehicule;
  try {
      vehicule = JSONReadSeed(fileName);
  } catch (IllegalArgumentException e) {
      vehicule = new ArrayList<VehiculMElectric>();
  }
  return vehicule;
}


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



public static boolean addVehicle(int nr) {
  ArrayList<VehiculMElectric> vehiculeOld;
  try {
      vehiculeOld = JSONReadSeed(fileName);
  } catch (IllegalArgumentException e) {
      vehiculeOld = new ArrayList<VehiculMElectric>();
  }
  ArrayList<VehiculMElecrtic> vehiculeNew = seed(nr);
  ArrayList<VehiculMElectric> vehicule = new ArrayList<VehiculMElectric>();
  vehicule.addAll(vehiculeOld);
  vehicule.addAll(vehiculeNew);
  JSONseed(vehicule);
  return true;
}

public static boolean resetData() {
  ArrayList<VehiculMElectric> vehicule = new ArrayList<VehiculMElectric>();
  VehiculFMSportSeeder.JSONseed(true, vehicule);
  VehiculFMSport.resetIdPool();
  return true;
}


}