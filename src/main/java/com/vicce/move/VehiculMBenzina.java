package com.vicce.move;

import java.util.ArrayList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class VehiculMBenzina extends VehiculCuMotor {
    protected int caiPutere;
    protected int capacitateMotor;
    protected int anFabricatie;
    protected double consumUrban;

    public VehiculMBenzina() {
        super();
        caiPutere = 100;
        capacitateMotor = 1600;
        anFabricatie = 2000;
        consumUrban = 5.6;
    }

    // public VehiculMBenzina(float vitezaMax, float pret, int nrRoti, int nrLocuri,
    // int putere, int capacitate, int an,
    // double consum) {
    // super(vitezaMax, pret, nrRoti, nrLocuri);
    // this.caiPutere = putere;
    // this.capacitateMotor = capacitate;
    // this.anFabricatie = an;
    // this.consumUrban = consum;
    // }

    // public VehiculMBenzina(float vitezaMax, float pret, int nrRoti, int nrLocuri,
    // int putere, int capacitate, int an,
    // double consum, long id) {
    // super(vitezaMax, pret, nrRoti, nrLocuri, id);
    // this.caiPutere = putere;
    // this.capacitateMotor = capacitate;
    // this.anFabricatie = an;
    // this.consumUrban = consum;
    // }

    public VehiculMBenzina(float vitezaMax, float pret, String marca, String model, String tip, String proprietar,
            int stock,
            int nrRoti, int nrLocuri, int putere, int capacitate, int an, double consum) {
        super(vitezaMax, pret, marca, model, tip, proprietar, stock, nrRoti, nrLocuri);
        this.caiPutere = putere;
        this.capacitateMotor = capacitate;
        this.anFabricatie = an;
        this.consumUrban = consum;
    }

    public VehiculMBenzina(float vitezaMax, float pret, String marca, String model, String tip, String proprietar,
            int stock,
            int nrRoti, int nrLocuri, int putere, int capacitate, int an, double consum, long id) {
        super(vitezaMax, pret, marca, model, tip, proprietar, stock, nrRoti, nrLocuri, id);
        this.caiPutere = putere;
        this.capacitateMotor = capacitate;
        this.anFabricatie = an;
        this.consumUrban = consum;
    }

    public VehiculMBenzina(VehiculMBenzina m) {
        super(m);
        this.caiPutere = m.caiPutere;
        this.capacitateMotor = m.capacitateMotor;
        this.anFabricatie = m.anFabricatie;
        this.consumUrban = m.consumUrban;
    }

    public int getCaiPutere() {
        return caiPutere;
    }

    public void setCaiPutere(int putere) {
        this.caiPutere = putere;
    }

    public int getCapacitateMotor() {
        return capacitateMotor;
    }

    public void setCapacitateMotor(int capacitate) {
        this.capacitateMotor = capacitate;
    }

    public int getAnFabricatie() {
        return anFabricatie;
    }

    public void setAnFabricatie(int an) {
        this.anFabricatie = an;
    }

    public double getConsumUrban() {
        return consumUrban;
    }

    public void setConsumUrban(double consum) {
        this.consumUrban = consum;
    }

    public static ArrayList<VehiculMBenzina> filtrareViteza(ArrayList<VehiculMBenzina> vehicule, float vitezaMaxim,
            float vitezaMinima) {
        ArrayList<VehiculMBenzina> vehiculeFiltrate = new ArrayList<VehiculMBenzina>();
        for (VehiculMBenzina vehicul : vehicule) {
            if ((vitezaMaxim == 0 || vehicul.getVitezaMax() <= vitezaMaxim)
                    && (vitezaMinima == 0 || vehicul.getVitezaMax() >= vitezaMinima)) {
                vehiculeFiltrate.add(vehicul);
            }
        }
        return vehiculeFiltrate;
    }

    public static ArrayList<VehiculMBenzina> filtrarePret(ArrayList<VehiculMBenzina> vehicule, float pretMaxim,
            float pretMinim) {
        ArrayList<VehiculMBenzina> vehiculeFiltrate = new ArrayList<VehiculMBenzina>();
        for (VehiculMBenzina vehicul : vehicule) {
            if ((pretMaxim == 0 || vehicul.getPret() <= pretMaxim)
                    && (pretMinim == 0 || vehicul.getPret() >= pretMinim)) {
                vehiculeFiltrate.add(vehicul);
            }
        }
        return vehiculeFiltrate;
    }

    @Override
    public String toString() {
        return "Vehicul cu motor pe benzina fabricat in anul " + anFabricatie + " cu " + caiPutere + " cai putere"
                + " si o capacitate de " + capacitateMotor + " si un consum urban de " + consumUrban + "l/100km";

    }

    @Override
    public void afisare() {
        System.out.println("Vehicul cu motor pe benzina fabricat in anul " + anFabricatie + " cu " + caiPutere
                + "cai putere" + " si o capacitate de " + capacitateMotor + " si un consum urban de " + consumUrban
                + "l/100km");
    }

    public static ArrayList<TableColumn<Mobilitate, ?>> getTableColumns() {
        ArrayList<TableColumn<Mobilitate, ?>> columns = VehiculCuMotor.getTableColumns();

        TableColumn<Mobilitate, Integer> putereColumn = new TableColumn<>("Cai putere");
        putereColumn.setCellValueFactory(new PropertyValueFactory<>("caiPutere"));
        columns.add(putereColumn);

        TableColumn<Mobilitate, Integer> capacitateMotorColumn = new TableColumn<>("Capacitate motor");
        capacitateMotorColumn.setCellValueFactory(new PropertyValueFactory<>("capacitateMotor"));
        columns.add(capacitateMotorColumn);

        TableColumn<Mobilitate, Integer> anFabricatieColumn = new TableColumn<>("An Fabricatie");
        anFabricatieColumn.setCellValueFactory(new PropertyValueFactory<>("anFabricatie"));
        columns.add(anFabricatieColumn);

        TableColumn<Mobilitate, Double> consumUrbanColumn = new TableColumn<>("Consum urban");
        consumUrbanColumn.setCellValueFactory(new PropertyValueFactory<>("consumUrban"));
        columns.add(consumUrbanColumn);

        return columns;
    }

}
