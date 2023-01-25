package com.vicce.move;

import java.util.ArrayList;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

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

    
    public VehiculCuMotor(float vitezaMax, float pret, int nrRoti, int nrLocuri, long id) {
        super(vitezaMax, pret, id);
        this.nrRoti = nrRoti;
        this.nrLocuri = nrLocuri;
    }

    public VehiculCuMotor(float vitezaMax, float pret, String marca, String model, String tip, String proprietar,
            int nrRoti, int nrLocuri) {
        super(vitezaMax, pret, marca, model, tip, proprietar);
        this.nrRoti = nrRoti;
        this.nrLocuri = nrLocuri;
    }

    public VehiculCuMotor(float vitezaMax, float pret, String marca, String model, String tip, String proprietar,
            int nrRoti, int nrLocuri, long id) {
        super(vitezaMax, pret, marca, model, tip, proprietar, id);
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

    // pentru generare tabel
    public static ArrayList<TableColumn<Mobilitate, ?>> getTableColumns() {
        ArrayList<TableColumn<Mobilitate, ?>> columns = Mobilitate.getTableColumns();

        TableColumn<Mobilitate, Integer> nrRotiColumn = new TableColumn<>("Nr roti");
        nrRotiColumn.setCellValueFactory(new PropertyValueFactory<>("nrRoti"));
        columns.add(nrRotiColumn);

        TableColumn<Mobilitate, Integer> nrLocuriColumn = new TableColumn<>("Nr locuri");
        nrLocuriColumn.setCellValueFactory(new PropertyValueFactory<>("nrLocuri"));
        columns.add(nrLocuriColumn);

        return columns;
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
