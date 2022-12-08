package com.vicce.move;

public class VehiculMMotorina extends VehiculCuMotor{
    
    String marca;
    String model;
    int numarCilindri;
    int anFabricatie;
    int putere;
    float cuplu;

    VehiculMMotorina() {
        super();
        model="Seria 1";
        marca="BMW";
        numarCilindri=4;
        anFabricatie=2000;
        putere=200;
        cuplu=350;
    }

    VehiculMMotorina(float vitezaMax, float pret, int nrRoti, int nrLocuri,String marca,String model,int numarCilindri,int anFabricatie,int putere,int cuplu){
        super(vitezaMax,pret,nrRoti,nrLocuri);
        this.marca=marca;
        this.model=model;
        this.numarCilindri=numarCilindri;
        this.anFabricatie=anFabricatie;
        this.putere=putere;
        this.cuplu=cuplu;
    }

    VehiculMMotorina(VehiculMMotorina x){
        super(x);
        this.marca=x.marca;
        this.model=x.model;
        this.numarCilindri=x.numarCilindri;
        this.anFabricatie=x.anFabricatie;
        this.putere=x.putere;
        this.cuplu=x.cuplu;
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

    public void afisare(){
        System.out.println("Vehicul cu motor pe motorina "+marca+" "+ model+" fabricat in anul "+anFabricatie+" cu "+putere+"cai putere"+" si cu "+numarCilindri+ " cilindri si un cuplu de "+cuplu+" Nm.");
    }
}
