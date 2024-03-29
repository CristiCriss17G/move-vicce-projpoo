package com.vicce.move;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public abstract class Mobilitate implements Comparable<Mobilitate>, Serializable {
    private static long idPool = 1;

    public final static void resetIdPool() {
        idPool = 1;
    }

    protected final long id;
    protected float vitezaMax;
    protected float pret;
    protected String marca = ""; // adaugat + getter + setter
    protected String model = "";// adaugat + getter + setter
    protected String tip = "";// adaugat + getter + setter
    protected String proprietar = "";// adaugat + getter + setter
    protected int stock = 0;// adaugat + getter + setter

    public Mobilitate() {
        this.id = idPool++;
        this.vitezaMax = 0;
        this.pret = 0;
        this.marca = "";
        this.model = "";
        this.tip = "";
        this.proprietar = this.marca;
        this.stock = 0;
    }

    public Mobilitate(Mobilitate a) {
        this.id = a.id;
        this.vitezaMax = a.vitezaMax;
        this.pret = a.pret;
        this.marca = a.marca;
        this.model = a.model;
        this.tip = a.tip;
        this.proprietar = a.proprietar;
        this.stock = a.stock;
    }

    // public Mobilitate(float vitezaMax, float pret) {
    // this.id = idPool++;
    // this.vitezaMax = vitezaMax;
    // this.pret = pret;
    // this.marca = "";
    // this.model = "";
    // this.tip = "";
    // this.proprietar = this.marca;
    // this.stock = 0;
    // }

    // public Mobilitate(float vitezaMax, float pret, long id) {
    // this.id = id;
    // this.vitezaMax = vitezaMax;
    // this.pret = pret;
    // this.marca = "";
    // this.model = "";
    // this.tip = "";
    // this.proprietar = this.marca;
    // if (idPool <= id)
    // idPool = id + 1;
    // }

    public Mobilitate(float vitezaMax, float pret, String marca, String model, String tip, String proprietar,
            int stock) {
        this.id = idPool++;
        this.vitezaMax = vitezaMax;
        this.pret = pret;
        this.marca = marca;
        this.model = model;
        this.tip = tip;
        this.proprietar = proprietar;
        this.stock = stock;
    }

    public Mobilitate(float vitezaMax, float pret, String marca, String model, String tip, String proprietar, int stock,
            long id) {
        this.id = id;
        this.vitezaMax = vitezaMax;
        this.pret = pret;
        this.marca = marca;
        this.model = model;
        this.tip = tip;
        this.proprietar = proprietar;
        this.stock = stock;
        if (idPool <= id)
            idPool = id + 1;
    }

    public final long getId() {
        return this.id;
    }

    public float getVitezaMax() {
        return this.vitezaMax;
    }

    public void setVitezaMax(float vitezaMax) {
        this.vitezaMax = vitezaMax;
    }

    public float getPret() {
        return this.pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
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

    public String getTip() {
        return this.tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getProprietar() {
        return this.proprietar;
    }

    public void setProprietar(String proprietar) {
        this.proprietar = proprietar;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public int compareTo(Mobilitate o) {
        if (this.getRaportVitezaPret() > o.getRaportVitezaPret())
            return 1;
        if (this.getRaportVitezaPret() < o.getRaportVitezaPret())
            return -1;
        return 0;
    }

    public static ArrayList<TableColumn<Mobilitate, ?>> getTableColumns() { // adugat pt interfata
        ArrayList<TableColumn<Mobilitate, ?>> columns = new ArrayList<>();

        TableColumn<Mobilitate, Long> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        // idCol.setMinWidth(50);
        columns.add(idCol);

        TableColumn<Mobilitate, Float> vitezaMaxCol = new TableColumn<>("Viteza Maxima");
        vitezaMaxCol.setCellValueFactory(new PropertyValueFactory<>("vitezaMax"));
        // vitezaMaxCol.setMinWidth(100);
        columns.add(vitezaMaxCol);

        TableColumn<Mobilitate, Float> pretCol = new TableColumn<>("Pret");
        pretCol.setCellValueFactory(new PropertyValueFactory<>("pret"));
        // pretCol.setMinWidth(100);
        columns.add(pretCol);

        TableColumn<Mobilitate, Float> raportCol = new TableColumn<>("Raport pret viteza");
        raportCol.setCellValueFactory(new PropertyValueFactory<>("raportVitezaPret"));
        // raportCol.setMinWidth(100);
        columns.add(raportCol);

        TableColumn<Mobilitate, String> marcaCol = new TableColumn<>("Marca");
        marcaCol.setCellValueFactory(new PropertyValueFactory<>("marca"));
        // marcaCol.setMinWidth(100);
        columns.add(marcaCol);

        TableColumn<Mobilitate, String> modelCol = new TableColumn<>("Model");
        modelCol.setCellValueFactory(new PropertyValueFactory<>("model"));
        // modelCol.setMinWidth(100);
        columns.add(modelCol);

        // TableColumn<Mobilitate, String> tipCol = new TableColumn<>("Tip");
        // tipCol.setCellValueFactory(new PropertyValueFactory<>("tip"));
        // // tipCol.setMinWidth(100);
        // columns.add(tipCol);

        // TableColumn<Mobilitate, String> proprietarCol = new
        // TableColumn<>("Proprietar");
        // proprietarCol.setCellValueFactory(new PropertyValueFactory<>("proprietar"));
        // // proprietarCol.setMinWidth(100);
        // columns.add(proprietarCol);

        TableColumn<Mobilitate, Integer> stockCol = new TableColumn<>("Stock");
        stockCol.setCellValueFactory(new PropertyValueFactory<>("stock"));
        // stockCol.setMinWidth(100);
        columns.add(stockCol);

        return columns;
    }

    public abstract float getRaportVitezaPret();

    public abstract void afisare();

    @Override
    public abstract String toString();

}