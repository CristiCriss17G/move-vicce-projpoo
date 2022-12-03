package com.vicce.move;

public class VehiculMElectric extends VehiculCuMotor {
int nrUsi;
int capacitateMotor;
int autonomie;
double greutate;
int  nrScaune;
int litriPortbagaj;
double kmReali;
int anFabricatie;
int nrPedale;
int cuplu;

public VehiculMElectric(float vitezaMax, float pret, int nrRoti, int nrLocuri,int nrUsi,int capacitateMotor,int autonomie,double greutate,boolean areTrapa,int litriPortbagaj,double kmReali,int anFabricatie,int nrPedale,int cuplu) {
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

public VehiculMElectric(VehiculMElectric a){ //tre sa vad ce are aici
  System.out.println("Constructor de copiere!");
  nrUsi=a.nrUsi;
  capacitateMotor=a.capacitateMotor;
  autonomie=a.autonomie;
  greutate=a.greutate;
  nrScaune=a.nrScaune;
  litriPortbagaj=a.litriPortbagaj;
  kmReali=a.kmReali;
  anFabricatie=a.anFabricatie;
  nrPedale=a.nrPedale;
  cuplu=a.cuplu;
  
}

@Override
public void afisare(){
  System.out.println("Acest vehicul are un nr de usi:"+nrUsi+" cu o capacitate cilindirca de "+capacitateMotor+" cu o autonomie de "+autonomie+" si cu o greutate de "+greutate+" si are un numar de scaune:"+nrScaune+" portbagajul este de:"+litriPortbagaj+
  " numarul de km reali este:"+kmReali+" din anul de fabricatie:"+anFabricatie+" cu un numar de pedale = "+nrPedale+" si in final cu un cuplu de : "+cuplu);
}

//mai trebuie sa fac setter si getter pentru fiecare data membra 

}
  

