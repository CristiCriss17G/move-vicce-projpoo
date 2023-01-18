package com.vicce.move;


public class VehiculMMotorina extends VehiculCuMotor {

    protected String marca;
    protected String model;
    protected int numarCilindri;
    protected int anFabricatie;
    protected int putere;
    protected float cuplu;


    VehiculMMotorina() {
        super();
        this.model = "Seria 1";
        this.marca = "BMW";
        this.numarCilindri = 4;
        this.anFabricatie = 2000;
        this.putere = 200;
        this.cuplu = 350;
    }

    VehiculMMotorina(VehiculMMotorina x) {
        super(x);
        this.marca = x.marca;
        this.model = x.model;
        this.numarCilindri = x.numarCilindri;
        this.anFabricatie = x.anFabricatie;
        this.putere = x.putere;
        this.cuplu = x.cuplu;
    }

    VehiculMMotorina(float vitezaMax, float pret, int nrRoti, int nrLocuri, String marca, String model,
            int numarCilindri, int anFabricatie, int putere, int cuplu) {
        super(vitezaMax, pret, nrRoti, nrLocuri);
        this.marca = marca;
        this.model = model;
        this.numarCilindri = numarCilindri;
        this.anFabricatie = anFabricatie;
        this.putere = putere;
        this.cuplu = cuplu;
    }

    public String getMarca() {
        return this.marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getNumarCilindri() {
        return this.numarCilindri;
    }

    public void setNumarCilindri(int numarCilindri) {
        this.numarCilindri = numarCilindri;
    }

    public int getAnFabricatie() {
        return this.anFabricatie;
    }

    public void setAnFabricatie(int anFabricatie) {
        this.anFabricatie = anFabricatie;
    }

    public int getPutere() {
        return this.putere;
    }

    public void setPutere(int putere) {
        this.putere = putere;
    }

    public float getCuplu() {
        return this.cuplu;
    }

    public void setCuplu(float cuplu) {
        this.cuplu = cuplu;
    }

    @Override
    public String toString() {
        return "Vehicul cu motor pe motorina " + marca + " " + model + " fabricat in anul " + anFabricatie
        + " cu " + putere + "cai putere" + " si cu " + numarCilindri + " cilindri si un cuplu de " + cuplu
        + " Nm.\n";
    }

    @Override
    public void afisare() {
        System.out.println("Vehicul cu motor pe motorina " + marca + " " + model + " fabricat in anul " + anFabricatie
                + " cu " + putere + "cai putere" + " si cu " + numarCilindri + " cilindri si un cuplu de " + cuplu
                + " Nm.\n");
    }
}