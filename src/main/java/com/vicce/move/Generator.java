package com.vicce.move;

import java.util.ArrayList;
import java.util.Random;

public class Generator {

    static private String[] modele = new String[]{"VW Golf 5","Audi A3","Ford Focus","BMW Seria 3","Hyundai Elantra","Citroen C3","Skoda Superb"};


    public static ArrayList<VehiculMBenzina> genereazaRandomMasini(int n){
        ArrayList<VehiculMBenzina> listaVehicule = new ArrayList<>();
        VehiculMBenzina masina;
        for(int i=0;i<n;i++){
            int vitezaMax=new Random().nextInt(130,350);
            int pret=new Random().nextInt(4000,90000);
            int nrRoti=new Random().nextInt(4,6);
            int nrLocuri=new Random().nextInt(2,7);
            int caiPutere=new Random().nextInt(70,500);
            int capacitateMotor=new Random().nextInt(1200,3000);
            String model = modele[new Random().nextInt(modele.length)];
            int anFabricatie=new Random().nextInt(1995,2022);
            double consumUrban=new Random().nextInt(5,14);

            masina=new VehiculMBenzina(vitezaMax,pret,nrRoti,nrLocuri,caiPutere,capacitateMotor,model,anFabricatie,consumUrban);
            listaVehicule.add(masina);
        }
        return listaVehicule;
    }







}
