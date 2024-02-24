package com.vicce.move;

import java.util.ArrayList;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class VehiculMElectric extends VehiculCuMotor { // folosesc doar 5 de aici pentru set si get
  protected int capacitateMotor;
  protected int autonomie;
  protected double greutate;
  protected double kmReali;
  protected int anFabricatie;
  protected int nrScaune;
  protected int litriPortbagaj;
  protected int nrPedale;
  protected int cuplu;
  protected int nrUsi;

  // aici am adaugat
  public static enum Electric {
    fastCharge, pilotAutomat, display, alcantara, range, suportPahare, incalzireScaune, trapa, automana, hybrid
  };

  protected Electric electrics;

  public VehiculMElectric() {
    super();
    this.capacitateMotor = 0;
    this.autonomie = 0;
    this.greutate = 0;
    this.kmReali = 0;
    this.anFabricatie = 0;
    this.nrScaune = 0;
    this.litriPortbagaj = 0;
    this.nrPedale = 0;
    this.cuplu = 0;
    this.nrUsi = 0;
    this.electrics = Electric.range;
  }

  public VehiculMElectric(VehiculMElectric a) {
    super(a);
    this.nrUsi = a.nrUsi;
    this.capacitateMotor = a.capacitateMotor;
    this.autonomie = a.autonomie;
    this.greutate = a.greutate;
    this.nrScaune = a.nrScaune;
    this.litriPortbagaj = a.litriPortbagaj;
    this.kmReali = a.kmReali;
    this.anFabricatie = a.anFabricatie;
    this.nrPedale = a.nrPedale;
    this.cuplu = a.cuplu;
    this.electrics = a.electrics;
  }

  // public VehiculMElectric(float vitezaMax, float pret, int nrRoti, int
  // nrLocuri, int nrUsi, int capacitateMotor,
  // int autonomie, double greutate, int nrScaune, int litriPortbagaj, double
  // kmReali, int anFabricatie,
  // int nrPedale, int cuplu, Electric electrics) {

  // super(vitezaMax, pret, nrRoti, nrLocuri);
  // this.nrUsi = nrUsi;
  // this.capacitateMotor = capacitateMotor; //
  // this.autonomie = autonomie;//
  // this.greutate = greutate;//
  // this.nrScaune = nrScaune;
  // this.litriPortbagaj = litriPortbagaj;
  // this.kmReali = kmReali;//
  // this.anFabricatie = anFabricatie;//
  // this.nrPedale = nrPedale;
  // this.cuplu = cuplu;
  // this.electrics = electrics;
  // }

  // public VehiculMElectric(float vitezaMax, float pret, int nrRoti, int
  // nrLocuri, int nrUsi, int capacitateMotor,
  // int autonomie, double greutate, int nrScaune, int litriPortbagaj, double
  // kmReali, int anFabricatie,
  // int nrPedale, int cuplu, Electric electrics, long id) {

  // super(vitezaMax, pret, nrRoti, nrLocuri, id);
  // this.nrUsi = nrUsi;
  // this.capacitateMotor = capacitateMotor; //
  // this.autonomie = autonomie;//
  // this.greutate = greutate;//
  // this.nrScaune = nrScaune;
  // this.litriPortbagaj = litriPortbagaj;
  // this.kmReali = kmReali;//
  // this.anFabricatie = anFabricatie;//
  // this.nrPedale = nrPedale;
  // this.cuplu = cuplu;
  // this.electrics = electrics;
  // }

  public VehiculMElectric(float vitezaMax, float pret, String marca, String model, String tip, String proprietar,
      int stock,
      int nrRoti, int nrLocuri, int nrUsi, int capacitateMotor,
      int autonomie, double greutate, int nrScaune, int litriPortbagaj, double kmReali, int anFabricatie,
      int nrPedale, int cuplu, Electric electrics) {

    super(vitezaMax, pret, marca, model, tip, proprietar, stock, nrRoti, nrLocuri);
    this.nrUsi = nrUsi;
    this.capacitateMotor = capacitateMotor; //
    this.autonomie = autonomie;//
    this.greutate = greutate;//
    this.nrScaune = nrScaune;
    this.litriPortbagaj = litriPortbagaj;
    this.kmReali = kmReali;//
    this.anFabricatie = anFabricatie;//
    this.nrPedale = nrPedale;
    this.cuplu = cuplu;
    this.electrics = electrics;
  }

  public VehiculMElectric(float vitezaMax, float pret, String marca, String model, String tip, String proprietar,
      int stock,
      int nrRoti, int nrLocuri, int nrUsi, int capacitateMotor,
      int autonomie, double greutate, int nrScaune, int litriPortbagaj, double kmReali, int anFabricatie,
      int nrPedale, int cuplu, Electric electrics, long id) {

    super(vitezaMax, pret, marca, model, tip, proprietar, stock, nrRoti, nrLocuri, id);
    this.nrUsi = nrUsi;
    this.capacitateMotor = capacitateMotor; //
    this.autonomie = autonomie;//
    this.greutate = greutate;//
    this.nrScaune = nrScaune;
    this.litriPortbagaj = litriPortbagaj;
    this.kmReali = kmReali;//
    this.anFabricatie = anFabricatie;//
    this.nrPedale = nrPedale;
    this.cuplu = cuplu;
    this.electrics = electrics;
  }

  public int getCapacitateMotor() {
    return this.capacitateMotor;
  }

  public void setCapacitateMotor(int capacitateMotor) {
    this.capacitateMotor = capacitateMotor;
  }

  public int getAutonomie() {
    return this.autonomie;
  }

  public void setAutonomie(int autonomie) {
    this.autonomie = autonomie;
  }

  public double getGreutate() {
    return this.greutate;
  }

  public void setGreutate(double greutate) {
    this.greutate = greutate;
  }

  public double getKmReali() {
    return this.kmReali;
  }

  public void setKmReali(double kmreali) {
    this.kmReali = kmreali;
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

  public int getCuplu() {
    return this.cuplu;
  }

  public void setCuplu(int cuplu) {
    this.cuplu = cuplu;
  }

  public Electric getElectric() {
    return this.electrics;
  }

  public void setElectric(Electric electrics) {
    this.electrics = electrics;
  }

  public int getNrUsi() {
    return this.nrUsi;
  }

  public void setNrUsi(int nrUsi) {
    this.nrUsi = nrUsi;
  }

  public int getNrScaune() {
    return this.nrScaune;
  }

  public void setNrScaune(int nrScaune) {
    this.nrScaune = nrScaune;
  }

  public int getLitriPortbagaj() {
    return this.litriPortbagaj;
  }

  public void setLitriPortbagaj(int litriPortbagaj) {
    this.litriPortbagaj = litriPortbagaj;
  }

  public Electric getElectrics() {
    return this.electrics;
  }

  public void setElectrics(Electric electrics) {
    this.electrics = electrics;
  }

  public static ArrayList<VehiculMElectric> filtrareViteza(ArrayList<VehiculMElectric> vehicule, float vitezaMaxim,
      float vitezaMinima) {
    ArrayList<VehiculMElectric> vehiculeFiltrate = new ArrayList<VehiculMElectric>();
    for (VehiculMElectric vehicul : vehicule) {
      if ((vitezaMaxim == 0 || vehicul.getVitezaMax() <= vitezaMaxim)
          && (vitezaMinima == 0 || vehicul.getVitezaMax() >= vitezaMinima)) {
        vehiculeFiltrate.add(vehicul);
      }
    }
    return vehiculeFiltrate;
  }

  public static ArrayList<VehiculMElectric> filtrarePret(ArrayList<VehiculMElectric> vehicule, float pretMaxim,
      float pretMinim) {
    ArrayList<VehiculMElectric> vehiculeFiltrate = new ArrayList<VehiculMElectric>();
    for (VehiculMElectric vehicul : vehicule) {
      if ((pretMaxim == 0 || vehicul.getPret() <= pretMaxim)
          && (pretMinim == 0 || vehicul.getPret() >= pretMinim)) {
        vehiculeFiltrate.add(vehicul);
      }
    }
    return vehiculeFiltrate;
  }

  @Override
  public void afisare() {
    super.afisare();
    System.out.println("Capacitate Motor: " + this.capacitateMotor);
    System.out.println("Autonomie: " + this.autonomie);
    System.out.println("Greutate: " + this.greutate);
    System.out.println("Nr Scaune: " + this.nrScaune);
    System.out.println("Nr Usi: " + this.nrUsi);
    System.out.println("Nr Pedale: " + this.nrPedale);
    System.out.println("Cuplu: " + this.cuplu);
    System.out.println("Electric: " + this.electrics);
    System.out.println("Litri Portbagaj: " + this.litriPortbagaj);
    System.out.println("Km Reali: " + this.kmReali);
    System.out.println("An Fabricatie: " + this.anFabricatie);
    System.out.println("Electrics: " + this.electrics);
  }

  public static ArrayList<TableColumn<Mobilitate, ?>> getTableColumns() {
    ArrayList<TableColumn<Mobilitate, ?>> tableColumns = VehiculCuMotor.getTableColumns();

    TableColumn<Mobilitate, Integer> capacitateMotorColumn = new TableColumn<>("Capacitate Motor");
    capacitateMotorColumn.setCellValueFactory(new PropertyValueFactory<>("capacitateMotor"));
    tableColumns.add(capacitateMotorColumn);

    TableColumn<Mobilitate, Integer> autonomieColumn = new TableColumn<>("Autonomie");
    autonomieColumn.setCellValueFactory(new PropertyValueFactory<>("autonomie"));
    tableColumns.add(autonomieColumn);

    TableColumn<Mobilitate, Double> greutateColumn = new TableColumn<>("Greutate");
    greutateColumn.setCellValueFactory(new PropertyValueFactory<>("greutate"));
    tableColumns.add(greutateColumn);

    TableColumn<Mobilitate, Integer> kmRealiColumn = new TableColumn<>("KM  Reali");
    kmRealiColumn.setCellValueFactory(new PropertyValueFactory<>("kmReali"));
    tableColumns.add(kmRealiColumn);

    TableColumn<Mobilitate, Integer> anFabricatieColumn = new TableColumn<>("An Fabricatie");
    anFabricatieColumn.setCellValueFactory(new PropertyValueFactory<>("anFabricatie"));
    tableColumns.add(anFabricatieColumn);

    TableColumn<Mobilitate, Integer> nrScauneColumn = new TableColumn<>("Numar Scaune");
    nrScauneColumn.setCellValueFactory(new PropertyValueFactory<>("nrScaune"));
    tableColumns.add(nrScauneColumn);

    TableColumn<Mobilitate, Integer> litriPortbagajColumn = new TableColumn<>("Litri Portbagaj");
    litriPortbagajColumn.setCellValueFactory(new PropertyValueFactory<>("litriPortbagaj"));
    tableColumns.add(litriPortbagajColumn);

    TableColumn<Mobilitate, Integer> nrPedaleColumn = new TableColumn<>("Numar Pedale");
    nrPedaleColumn.setCellValueFactory(new PropertyValueFactory<>("nrPedale"));
    tableColumns.add(nrPedaleColumn);

    TableColumn<Mobilitate, Integer> cupluColumn = new TableColumn<>("Cuplu");
    cupluColumn.setCellValueFactory(new PropertyValueFactory<>("cuplu"));
    tableColumns.add(cupluColumn);

    TableColumn<Mobilitate, Integer> nrUsiColumn = new TableColumn<>("Numar Usi");
    nrUsiColumn.setCellValueFactory(new PropertyValueFactory<>("nrUsi"));
    tableColumns.add(nrUsiColumn);

    TableColumn<Mobilitate, Electric> electricsColumn = new TableColumn<>("Electrics");
    electricsColumn.setCellValueFactory(new PropertyValueFactory<>("electrics"));
    tableColumns.add(electricsColumn);

    return tableColumns;
  }

  @Override
  public String toString() {
    return "Vehicul cu motor electric: numarul de usi= " + nrUsi + " capacitateMotor= " + capacitateMotor
        + " autonomie= " + autonomie +
        " greutate= " + greutate + " numarScaune= " + nrScaune + " portBagaj= " + litriPortbagaj + " nrKmReali= "
        + kmReali + " anFabricatie= " + anFabricatie +
        " numarPedale= " + nrPedale + " cuplu= " + cuplu + ".";
  }
}