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


public static ArrayList<VehiculFMAgrement> seed(int nr) {
        if (nr > MAX || nr < MIN) {
            throw new IllegalArgumentException("Numarul de vehicule trebuie sa fie intre " + MIN + " si " + MAX);
        }

















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


  public static ArrayList<VehiculMElectric> genereazaRandomMasini(int n){
    ArrayList<VehiculMElectric> listaMasini = new ArrayList<>();
    VehiculMElectric primaMasina;
    for(int i=0;i<n;i++){
  //     int capacitateMotor =new Random().nextInt(2000);
  //     int autonomie = new Random().nextInt(300);
  //     double greutate= new Random().nextDouble(1000);
  //     double kmreali = new Random().nextDouble(10000);
  //     int anFabricatie = new Random().nextInt(2050);
  //     primaMasina=new VehiculMElectric(capacitateMotor,autonomie,anFabricatie, anFabricatie, anFabricatie, anFabricatie, anFabricatie, greutate,anFabricatie, anFabricatie, kmreali,anFabricatie, anFabricatie, anFabricatie);
  //     listaMasini.add(primaMasina); 
    }

    return listaMasini; 
  }
}
