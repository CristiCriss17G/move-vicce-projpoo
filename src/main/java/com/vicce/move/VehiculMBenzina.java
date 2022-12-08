package com.vicce.move;

public class VehiculMBenzina extends VehiculCuMotor {
    protected int caiPutere;
    protected int capacitateMotor;
    protected String marca;
    protected String model;
    protected int anFabricatie;
    protected double consumUrban;

    VehiculMBenzina() {
        super();
        this.caiPutere = 0;
        this.capacitateMotor = 0;
        this.marca = "";
        this.model = "";
        this.anFabricatie = 2000;
        this.consumUrban = 0;
    }

    VehiculMBenzina(float vitezaMax, float pret, int nrRoti, int nrLocuri, int putere, int capacitate, String marca,
            String model, int an, double consum) {
        super(vitezaMax, pret, nrRoti, nrLocuri);
        this.caiPutere = putere;
        this.capacitateMotor = capacitate;
        this.marca = marca;
        this.model = model;
        this.anFabricatie = an;
        this.consumUrban = consum;
    }

    VehiculMBenzina(VehiculMBenzina m) {
        super(m);
        this.caiPutere = m.caiPutere;
        this.capacitateMotor = m.capacitateMotor;
        this.marca = m.marca;
        this.model = m.model;
        this.anFabricatie = m.anFabricatie;
        this.consumUrban = m.consumUrban;
    }

    public int getCaiPutere() {
        return this.caiPutere;
    }

    public void setCaiPutere(int putere) {
        this.caiPutere = putere;
    }

    public int getCapacitateMotor() {
        return this.capacitateMotor;
    }

    public void setCapacitateMotor(int capacitate) {
        this.capacitateMotor = capacitate;
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

    public int getAnFabricatie() {
        return this.anFabricatie;
    }

    public void setAnFabricatie(int an) {
        this.anFabricatie = an;
    }

    public double getConsumUrban() {
        return this.consumUrban;
    }

    public void setConsumUrban(double consum) {
        this.consumUrban = consum;
    }

    @Override
    public void afisare() {
        System.out.println("Vehicul cu motor pe benzina " + marca + " " + model + " fabricat in anul " + anFabricatie
                + " cu " + caiPutere + "cai putere" + " si o capacitate de " + capacitateMotor
                + " si un consum urban de " + consumUrban + "l/100km");
    }
}
