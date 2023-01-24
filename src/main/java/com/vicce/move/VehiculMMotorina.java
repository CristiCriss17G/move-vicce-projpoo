package com.vicce.move;

import java.util.ArrayList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class VehiculMMotorina extends VehiculCuMotor {

    protected int numarCilindri;
    protected int anFabricatie;
    protected int putere;
    protected float cuplu;

    public VehiculMMotorina() {
        super();
        this.numarCilindri = 4;
        this.anFabricatie = 2000;
        this.putere = 200;
        this.cuplu = 350;
    }

    public VehiculMMotorina(VehiculMMotorina x) {
        super(x);
        this.numarCilindri = x.numarCilindri;
        this.anFabricatie = x.anFabricatie;
        this.putere = x.putere;
        this.cuplu = x.cuplu;
    }

    public VehiculMMotorina(float vitezaMax, float pret, int nrRoti, int nrLocuri,
            int numarCilindri, int anFabricatie, int putere, float cuplu) {
        super(vitezaMax, pret, nrRoti, nrLocuri);
        this.numarCilindri = numarCilindri;
        this.anFabricatie = anFabricatie;
        this.putere = putere;
        this.cuplu = cuplu;
    }

    public VehiculMMotorina(float vitezaMax, float pret, int nrRoti, int nrLocuri,
            int numarCilindri, int anFabricatie, int putere, float cuplu, long id) {
        super(vitezaMax, pret, nrRoti, nrLocuri, id);
        this.numarCilindri = numarCilindri;
        this.anFabricatie = anFabricatie;
        this.putere = putere;
        this.cuplu = cuplu;
    }

    public VehiculMMotorina(float vitezaMax, float pret, String marca, String model, String tip, String proprietar,
            int nrRoti, int nrLocuri, int numarCilindri,
            int anFabricatie, int putere, float cuplu) {
        super(vitezaMax, pret, marca, model, tip, proprietar, nrRoti, nrLocuri);
        this.numarCilindri = numarCilindri;
        this.anFabricatie = anFabricatie;
        this.putere = putere;
        this.cuplu = cuplu;
    }

    public VehiculMMotorina(float vitezaMax, float pret, String marca, String model, String tip, String proprietar,
            int nrRoti, int nrLocuri, int numarCilindri,
            int anFabricatie, int putere, float cuplu, long id) {
        super(vitezaMax, pret, marca, model, tip, proprietar, nrRoti, nrLocuri, id);
        this.numarCilindri = numarCilindri;
        this.anFabricatie = anFabricatie;
        this.putere = putere;
        this.cuplu = cuplu;
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

    public static ArrayList<VehiculMMotorina> filtrareViteza(ArrayList<VehiculMMotorina> vehicule, float vitezaMaxim,
            float vitezaMinima) {
        ArrayList<VehiculMMotorina> vehiculeFiltrate = new ArrayList<VehiculMMotorina>();
        for (VehiculMMotorina vehicul : vehicule) {
            if ((vitezaMaxim == 0 || vehicul.getVitezaMax() <= vitezaMaxim)
                    && (vitezaMinima == 0 || vehicul.getVitezaMax() >= vitezaMinima)) {
                vehiculeFiltrate.add(vehicul);
            }
        }
        return vehiculeFiltrate;
    }

    public static ArrayList<VehiculMMotorina> filtrarePret(ArrayList<VehiculMMotorina> vehicule, float pretMaxim,
            float pretMinim) {
        ArrayList<VehiculMMotorina> vehiculeFiltrate = new ArrayList<VehiculMMotorina>();
        for (VehiculMMotorina vehicul : vehicule) {
            if ((pretMaxim == 0 || vehicul.getPret() <= pretMaxim)
                    && (pretMinim == 0 || vehicul.getPret() >= pretMinim)) {
                vehiculeFiltrate.add(vehicul);
            }
        }
        return vehiculeFiltrate;
    }

    public static ArrayList<TableColumn<Mobilitate, ?>> getTableColumns() {
        ArrayList<TableColumn<Mobilitate, ?>> columns = VehiculCuMotor.getTableColumns();

        TableColumn<Mobilitate, Integer> numarCilindriColumn = new TableColumn<>("Numar Cilindri");
        numarCilindriColumn.setCellValueFactory(new PropertyValueFactory<>("numarCilindri"));
        columns.add(numarCilindriColumn);

        TableColumn<Mobilitate, Integer> anFabricatieColumn = new TableColumn<>(
                "An Fabricatie");
        anFabricatieColumn.setCellValueFactory(
                new PropertyValueFactory<>("anFabricatie"));
        columns.add(anFabricatieColumn);

        TableColumn<Mobilitate, Integer> putereColumn = new TableColumn<>(
                "Putere");
        putereColumn.setCellValueFactory(
                new PropertyValueFactory<>("putere"));
        columns.add(putereColumn);

        TableColumn<Mobilitate, Float> cupluColumn = new TableColumn<>(
                "Cuplu");
        cupluColumn.setCellValueFactory(
                new PropertyValueFactory<>("cuplu"));
        columns.add(cupluColumn);

        return columns;
    }

}