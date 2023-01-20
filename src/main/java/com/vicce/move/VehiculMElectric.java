package com.vicce.move;

import java.util.ArrayList;
import java.util.Vector;

public class VehiculMElectric extends VehiculCuMotor { // folosesc doar 5 de aici pentru set si get
  protected int capacitateMotor;
  protected int autonomie;
  protected double greutate;
  protected double kmReali;
  protected int anFabricatie;

  protected int nrScaune;
  protected int litriPortbagaj;
  protected int nrPedale;
  protected int cuplu;
  protected int nrUsi;
  
  //aici am adaugat
  public static enum Electric{
    fastCharge,pilotAutomat,display,alcantara,range,suportPahare,incalzireScaune,trapa,automana,hybrid
  };
  protected ArrayList<Electric> electrics;

  public VehiculMElectric() {
    super();
    this.capacitateMotor = 10;
    this.autonomie = 400;
    this.greutate = 1500.99d;
    this.kmReali = 20000.99d;
    this.anFabricatie = 2019;
  }

  public VehiculMElectric(VehiculMElectric a) { // tre sa vad ce are aici
    System.out.println("Constructor de copiere!");
    this.nrUsi = a.nrUsi;
    this.capacitateMotor = a.capacitateMotor;
    this.autonomie = a.autonomie;
    this.greutate = a.greutate;
    this.nrScaune = a.nrScaune;
    this.litriPortbagaj = a.litriPortbagaj;
    this.kmReali = a.kmReali;
    this.anFabricatie = a.anFabricatie;
    this.nrPedale = a.nrPedale;
    this.cuplu = a.cuplu;

  }

  public VehiculMElectric(float vitezaMax, float pret, int nrRoti, int nrLocuri, int nrUsi, int capacitateMotor,
      int autonomie, double greutate,int nrScaune, int litriPortbagaj, double kmReali, int anFabricatie,
      int nrPedale, int cuplu) {
    super(vitezaMax, pret, nrRoti, nrLocuri);

    this.nrUsi = nrUsi;
    this.capacitateMotor = capacitateMotor;
    this.autonomie = autonomie;
    this.greutate = greutate;
    this.nrScaune = nrScaune;
    this.litriPortbagaj = litriPortbagaj;
    this.kmReali = kmReali;
    this.anFabricatie = anFabricatie;
    this.nrPedale = nrPedale;
    this.cuplu = cuplu;
  }

  public int getCapacitateMotor() {
    return this.capacitateMotor;
  }

  public void setCapacitateMotor(int capacitateMotor) {
    this.capacitateMotor = capacitateMotor;
  }

  public int getAutonomie() {
    return this.autonomie;
  }

  public void setAutonomie(int autonomie) {
    this.autonomie = autonomie;
  }

  public double getGreutate() {
    return this.greutate;
  }

  public void setGreutate(double greutate) {
    this.greutate = greutate;
  }

  public double getKmReali() {
    return this.kmReali;
  }

  public void setKmReali(double kmreali) {
    this.kmReali = kmreali;
  }

  public int getAnFabricatie() {
    return this.anFabricatie;
  }

  public void setAnFabricatie(int anFabricatie) {
    this.anFabricatie = anFabricatie;
  }

  // cred ca tre sa mai adaug ceva

  @Override
  public void afisare() {
    System.out.println("Acest vehicul are un nr de usi:" + nrUsi + " cu o capacitate cilindirca de " + capacitateMotor
        + " cu o autonomie de " + autonomie + " si cu o greutate de " + greutate + " si are un numar de scaune:"
        + nrScaune + " portbagajul este de:" + litriPortbagaj +
        " numarul de km reali este:" + kmReali + " din anul de fabricatie:" + anFabricatie + " cu un numar de pedale = "
        + nrPedale + " si in final cu un cuplu de : " + cuplu);
  }

  @Override
  public String toString(){
    return "Vehicul cu motor electric: numarul de usi= "+nrUsi+" capacitateMotor= "+capacitateMotor+" autonomie= "+autonomie+
    " greutate= "+greutate+" numarScaune= "+nrScaune+" portBagaj= "+litriPortbagaj+" nrKmReali= "+kmReali+" anFabricatie= "+anFabricatie+
    " numarPedale= "+nrPedale+" cuplu= "+cuplu+".";
  }
}
