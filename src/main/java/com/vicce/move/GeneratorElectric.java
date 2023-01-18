package com.vicce.move;

import java.util.ArrayList;
import java.util.Random;

public class GeneratorElectric {
  
  public static ArrayList<VehiculMElectric> genereazaRandomMasini(int n){
    ArrayList<VehiculMElectric> listaMasini = new ArrayList<>();
    
    VehiculMElectric primaMasina;
    for(int i=0;i<n;i++){
      int capacitateMotor =new Random().nextInt(2000);
      int autonomie = new Random().nextInt(300);
      double greutate= new Random().nextDouble(1000);
      double kmreali = new Random().nextDouble(10000);
      int anFabricatie = new Random().nextInt(2050);
      primaMasina=new VehiculMElectric(capacitateMotor,autonomie,anFabricatie, anFabricatie, anFabricatie, anFabricatie, anFabricatie, greutate,anFabricatie, anFabricatie, kmreali,anFabricatie, anFabricatie, anFabricatie);
      listaMasini.add(primaMasina); 
    }

    return listaMasini; 
  }

  public static VehiculMElectric[] genereazaNisteMasini(int n){
    VehiculMElectric[] listaMasini=new VehiculMElectric[n];
    for(int i=0;i<n;i++){
      int capacitateMotor =new Random().nextInt(2000);
      int autonomie = new Random().nextInt(300);
      double greutate= new Random().nextDouble(1000);
      double kmreali = new Random().nextDouble(10000);
      int anFabricatie = new Random().nextInt(2050);
      VehiculMElectric oMasina=new VehiculMElectric(capacitateMotor,autonomie,anFabricatie, anFabricatie, anFabricatie, anFabricatie, anFabricatie, greutate,anFabricatie, anFabricatie, kmreali,anFabricatie, anFabricatie, anFabricatie);
      listaMasini[i]=oMasina;
    }
    return listaMasini;
  }



}
