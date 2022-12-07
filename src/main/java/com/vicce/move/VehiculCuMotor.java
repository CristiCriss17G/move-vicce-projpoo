package com.vicce.move;

public class VehiculCuMotor extends Mobilitate {
    int nrRoti;
    int nrLocuri;

    public VehiculCuMotor(){
        super();
        nrRoti=4;
        nrLocuri=5;
    }

    public VehiculCuMotor(float vitezaMax, float pret, int nrRoti, int nrLocuri) {
        super(vitezaMax, pret);
        this.nrRoti = nrRoti;
        this.nrLocuri = nrLocuri;
    }

    public VehiculCuMotor(VehiculCuMotor v){
        super(v);
        this.nrRoti=v.nrRoti;
        this.nrLocuri=v.nrLocuri;

    }
    public int getNrRoti() {
        return nrRoti;
    }

    public void setNrRoti(int nrRoti) {
        this.nrRoti = nrRoti;
    }

    public int getNrLocuri() {
        return nrLocuri;
    }

    public void setNrLocuri(int nrLocuri) {
        this.nrLocuri = nrLocuri;
    }

    @Override
    public float raportVitezaPret() {
        return vitezaMax / pret;
    }

    @Override
    public void afisare() {
        System.out.println("Vehicul cu motor cu viteza maxima " + vitezaMax + " si pretul " + pret);
    }
}
