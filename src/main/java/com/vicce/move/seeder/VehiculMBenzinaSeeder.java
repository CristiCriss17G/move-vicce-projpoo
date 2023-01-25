package com.vicce.move.seeder;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.nio.file.NoSuchFileException;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.json.JSONObject;
import org.json.JSONArray;

import com.vicce.move.VehiculMBenzina;

public class VehiculMBenzinaSeeder {

    private static Random random = new Random();
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
    private static final int MIN_CAI=60;
    private static final int MAX_CAI=600;
    private static final int MIN_CAPACITATE=1400;
    private static final int MAX_CAPACITATE=3500;
    private static final double MIN_CONSUM=3.4;
    private static final double MAX_CONSUM=12.5;
    static private String[] modele = new String[]{"VW ","Audi","Ford","BMW ","Hyundai Elantra","Citroen","Skoda"};
    static private String[] marci = new String[]{"Golf 5","A3","Focus","Seria 3","Elantra"," C3","Superb"};



    public static ArrayList<VehiculMBenzina> genereazaRandomMasini(int n){
        ArrayList<VehiculMBenzina> listaVehicule = new ArrayList<>();
        VehiculMBenzina masina;
        for(int i=0;i<n;i++){
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
            int anFabricatie = random.nextInt(MAX_AN - MIN_AN) + MIN_AN;
            int nrRoti = random.nextInt(MAX_NRROTI - MIN_NRROTI) + MIN_NRROTI;
            int nrLocuri = random.nextInt(MAX_NRLOCURI - MIN_NRLOCURI) + MIN_NRLOCURI;
            int caiPutere = random.nextInt(MAX_CAI - MIN_CAI) + MIN_CAI;
            int capacitateMotor=random.nextInt(MAX_CAPACITATE - MIN_CAPACITATE) + MIN_CAI;
            double consumUrban=random.nextDouble(MAX_CONSUM - MIN_CONSUM) + MIN_CONSUM;
            String marca=marci[random.nextInt(marci.length)];
            String model=modele[random.nextInt(modele.length)];
            

            masina=new VehiculMBenzina(vitezaMax,pret,nrRoti,nrLocuri,caiPutere,capacitateMotor,marca,model,anFabricatie,consumUrban);
            listaVehicule.add(masina);
        }
        return listaVehicule;
    }







}
