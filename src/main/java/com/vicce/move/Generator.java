package com.vicce.move;
import java.util.Random;
import java.util.ArrayList;

public class Generator {
 
    
    static private String[] modele = new String[]{"A4","Focus","Seria4","Logan","Toyota"};
    static private String[] marci = new String[]{"BMW","Dacia","Audi","Ford","Corolla"};


    public static ArrayList<VehiculMMotorina> genereazaRandomMasini(int n){
        ArrayList<VehiculMMotorina> listaVehicule = new ArrayList<>();
        VehiculMMotorina Masina;
        for(int i=0;i<n;i++){
            float vitezaMax=new Random().nextInt(100,450);
            float pret=new Random().nextInt(3000,80000);
            int nrRoti=new Random().nextInt(4,8);
            int nrLocuri=new Random().nextInt(2,7);
            String marca=marci[new Random().nextInt(marci.length)];
            String model = modele[new Random().nextInt(modele.length)];
            int numarCilindri=new Random().nextInt(4,8);
            int anFabricatie=new Random().nextInt(2000,2021);
            int putere=new Random().nextInt(200,850);
            float cuplu=new Random().nextInt(100,500);
            

            Masina=new VehiculMMotorina(vitezaMax,pret,nrRoti,nrLocuri,marca,model,numarCilindri,anFabricatie,putere,cuplu);
            listaVehicule.add(Masina);
        }
        return listaVehicule;
    }




}
    



