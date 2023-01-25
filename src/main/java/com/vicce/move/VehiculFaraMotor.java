package com.vicce.move;

import java.util.ArrayList;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class VehiculFaraMotor extends Mobilitate {
    protected int nrRoti;
    protected double greutate;
    protected int anFabricatie;
    protected int nrPedale;
    protected int acceleratie;

    public VehiculFaraMotor() {
        super();
        this.nrRoti = 0;
        this.greutate = 0;
        this.anFabricatie = 0;
        this.nrPedale = 0;
        this.acceleratie = 0;
    }

    public VehiculFaraMotor(VehiculFaraMotor a) {
        super(a);
        this.nrRoti = a.nrRoti;
        this.greutate = a.greutate;
        this.anFabricatie = a.anFabricatie;
        this.nrPedale = a.nrPedale;
        this.acceleratie = a.acceleratie;
    }

    public VehiculFaraMotor(float vitezaMax, float pret, int nrRoti, double greutate, int anFabricatie, int nrPedale,
            int acceleratie) {
        super(vitezaMax, pret);
        this.nrRoti = nrRoti;
        this.greutate = greutate;
        this.anFabricatie = anFabricatie;
        this.nrPedale = nrPedale;
        this.acceleratie = acceleratie;
    }

    public VehiculFaraMotor(float vitezaMax, float pret, int nrRoti, double greutate, int anFabricatie, int nrPedale,
            int acceleratie, long id) {
        super(vitezaMax, pret, id);
        this.nrRoti = nrRoti;
        this.greutate = greutate;
        this.anFabricatie = anFabricatie;
        this.nrPedale = nrPedale;
        this.acceleratie = acceleratie;
    }

    public VehiculFaraMotor(float vitezaMax, float pret, String marca, String model, String tip, String proprietar,
            int nrRoti, double greutate, int anFabricatie, int nrPedale, int acceleratie) {
        super(vitezaMax, pret, marca, model, tip, proprietar);
        this.nrRoti = nrRoti;
        this.greutate = greutate;
        this.anFabricatie = anFabricatie;
        this.nrPedale = nrPedale;
        this.acceleratie = acceleratie;
    }

    // adaugat macara, model, tip, proprietar, id
    public VehiculFaraMotor(float vitezaMax, float pret, String marca, String model, String tip, String proprietar,
            int nrRoti, double greutate, int anFabricatie, int nrPedale, int acceleratie, long id) {
        super(vitezaMax, pret, marca, model, tip, proprietar, id);
        this.nrRoti = nrRoti;
        this.greutate = greutate;
        this.anFabricatie = anFabricatie;
        this.nrPedale = nrPedale;
        this.acceleratie = acceleratie;
    }

    public int getNrRoti() {
        return this.nrRoti;
    }

    public void setNrRoti(int nrRoti) {
        this.nrRoti = nrRoti;
    }

    public double getGreutate() {
        return this.greutate;
    }

    public void setGreutate(double greutate) {
        this.greutate = greutate;
    }

    public int getAnFabricatie() {
        return this.anFabricatie;
    }

    public void setAnFabricatie(int anFabricatie) {
        this.anFabricatie = anFabricatie;
    }

    public int getNrPedale() {
        return this.nrPedale;
    }

    public void setNrPedale(int nrPedale) {
        this.nrPedale = nrPedale;
    }

    public int getAcceleratie() {
        return this.acceleratie;
    }

    public void setAcceleratie(int acceleratie) {
        this.acceleratie = acceleratie;
    }

    @Override
    public float raportVitezaPret() {
        return vitezaMax / pret;
    }

    @Override
    public void afisare() {
        System.out.println("Vehicul cu motor cu viteza maxima " + vitezaMax + " si pretul " + pret);
    }

    // adugat penntru generare tabel, sunt campurile clasei + campurile din clasa
    // parinte, de implementat in clasa copil
    public static ArrayList<TableColumn<Mobilitate, ?>> getTableColumns() {
        ArrayList<TableColumn<Mobilitate, ?>> columns = Mobilitate.getTableColumns();

        TableColumn<Mobilitate, Integer> nrRotiColumn = new TableColumn<>("Nr roti");
        nrRotiColumn.setCellValueFactory(new PropertyValueFactory<>("nrRoti"));
        columns.add(nrRotiColumn);

        TableColumn<Mobilitate, Double> greutateColumn = new TableColumn<>("Greutate");
        greutateColumn.setCellValueFactory(new PropertyValueFactory<>("greutate"));
        columns.add(greutateColumn);

        TableColumn<Mobilitate, Integer> anFabricatieColumn = new TableColumn<>("An fabricatie");
        anFabricatieColumn.setCellValueFactory(new PropertyValueFactory<>("anFabricatie"));
        columns.add(anFabricatieColumn);

        TableColumn<Mobilitate, Integer> nrPedaleColumn = new TableColumn<>("Nr pedale");
        nrPedaleColumn.setCellValueFactory(new PropertyValueFactory<>("nrPedale"));
        columns.add(nrPedaleColumn);

        TableColumn<Mobilitate, Integer> acceleratieColumn = new TableColumn<>("Acceleratie");
        acceleratieColumn.setCellValueFactory(new PropertyValueFactory<>("acceleratie"));
        columns.add(acceleratieColumn);
        return columns;
    }

    @Override
    public String toString() {
        return "VehiculCuMotor [nrPedale=" + nrPedale + ", nrRoti=" + nrRoti + ", pret=" + pret + ", vitezaMax="
                + vitezaMax + "]";
    }
}
