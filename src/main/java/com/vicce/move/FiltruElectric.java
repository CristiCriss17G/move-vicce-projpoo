package com.vicce.move;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.lang.String;



public class FiltruElectric {
  public static ArrayList<VehiculMElectric> filtreazaDupaCapCilin(ArrayList<VehiculMElectric> listaInitialaMasini,int capacitateMotor){

  
  ArrayList<VehiculMElectric> listaMasini = new ArrayList<>();
  for(VehiculMElectric vehicle : listaInitialaMasini)
    if(vehicle.getCapacitateMotor()<=capacitateMotor)
        listaMasini.add(vehicle);
  
  return listaMasini;
  }

  public static ArrayList<VehiculMElectric> filtreazaDupaAutonomie(ArrayList<VehiculMElectric> listaInitialaMasini,int autonomie){
    
    ArrayList<VehiculMElectric> listaMasini = new ArrayList<>();
    for(VehiculMElectric vehicle : listaInitialaMasini)
      //if(vehicle.getAutonomie().equals(autonomie))
          listaMasini.add(vehicle);
  return listaMasini;
  }





}
