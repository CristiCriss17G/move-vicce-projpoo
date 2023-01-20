package com.vicce.move;


//aici
public class VehiculCuMotor extends Mobilitate {
    protected int nrRoti;
    protected int nrLocuri;

    public VehiculCuMotor() {
        super();
        this.nrRoti = 4;
        this.nrLocuri = 5;
    }

    public VehiculCuMotor(VehiculCuMotor v) {
        super(v);
        this.nrRoti = v.nrRoti;
        this.nrLocuri = v.nrLocuri;

    }

    public VehiculCuMotor(float vitezaMax, float pret, int nrRoti, int nrLocuri) {
        super(vitezaMax, pret);
        this.nrRoti = nrRoti;
        this.nrLocuri = nrLocuri;
    }

    public int getNrRoti() {
        return this.nrRoti;
    }

    public void setNrRoti(int nrRoti) {
        this.nrRoti = nrRoti;
    }

    public int getNrLocuri() {
        return this.nrLocuri;
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

    @Override
    public String toString() {
        return "VehiculCuMotor [nrLocuri=" + nrLocuri + ", nrRoti=" + nrRoti + ", pret=" + pret + ", vitezaMax="
                + vitezaMax + "]";
    }
}
