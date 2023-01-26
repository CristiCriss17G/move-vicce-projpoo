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

  protected ArrayList<Electric> electrics;

  public VehiculMElectric(float vitezaMax, float pret, int capacitateMotor2, String marca, String model, String tip,
      String proprietar, int autonomie2, double greutate2, double kmReali2, int anFabricatie2, long id) {
    super();
    this.capacitateMotor = 10;
    this.autonomie = 400;
    this.greutate = 1500.99d;
    this.kmReali = 20000.99d;
    this.anFabricatie = 2019;
  }

  public VehiculMElectric(VehiculMElectric a) { // tre sa vad ce are aici
    System.out.println("Constructor de copiere!");
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

  }

  public VehiculMElectric(float vitezaMax, float pret, int nrRoti, int nrLocuri, int nrUsi, int capacitateMotor,
      int autonomie, double greutate, int nrScaune, int litriPortbagaj, double kmReali, int anFabricatie,
      int nrPedale, int cuplu) {
    super(vitezaMax, pret, nrRoti, nrLocuri);

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

  // cred ca tre sa mai adaug ceva

  @Override
  public void afisare() {
    System.out.println("Acest vehicul are un nr de usi:" + nrUsi + " cu o capacitate cilindirca de " + capacitateMotor
        + " cu o autonomie de " + autonomie + " si cu o greutate de " + greutate + " si are un numar de scaune:"
        + nrScaune + " portbagajul este de:" + litriPortbagaj +
        " numarul de km reali este:" + kmReali + " din anul de fabricatie:" + anFabricatie + " cu un numar de pedale = "
        + nrPedale + " si in final cu un cuplu de : " + cuplu);
  }

  @Override
  public String toString() {
    return "Vehicul cu motor electric: numarul de usi= " + nrUsi + " capacitateMotor= " + capacitateMotor
        + " autonomie= " + autonomie +
        " greutate= " + greutate + " numarScaune= " + nrScaune + " portBagaj= " + litriPortbagaj + " nrKmReali= "
        + kmReali + " anFabricatie= " + anFabricatie +
        " numarPedale= " + nrPedale + " cuplu= " + cuplu + ".";
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

    return tableColumns;
  }

  // public static void resetIdPool() {
  // }

  public static boolean addVehicle(int numarVehicule) {
    return false;
  }

  // public Collection<?> getId() {
  // return null;
  // }

  // public Collection<?> getMarca() {
  // return null;
  // }

  // public Collection<?> getModel() {
  // return null;
  // }

  // public Collection<?> getTip() {
  // return null;
  // }

  // public Collection<?> getProprietar() {
  // return null;
  // }
}
