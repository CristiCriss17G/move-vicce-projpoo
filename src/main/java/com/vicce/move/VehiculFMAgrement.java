package com.vicce.move;

import java.util.ArrayList;

import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class VehiculFMAgrement extends VehiculFaraMotor {
    public static enum EchipamentProtectie {
        nimic, casca, manusi, pantaloni, bluza, botine, geci, ochelari
    };

    public static enum TipTeren {
        asfalt, pamant, zapada, gheata
    };

    public static enum CategVarsta {
        copii, adulti, seniori
    };

    protected ArrayList<EchipamentProtectie> echipamentProtectie;

    protected TipTeren tipTeren;

    protected CategVarsta categVarsta;

    public VehiculFMAgrement() {
        super();
        this.echipamentProtectie = new ArrayList<EchipamentProtectie>() {
            {
                add(EchipamentProtectie.nimic);
            }
        };

        this.tipTeren = TipTeren.asfalt;
        this.categVarsta = CategVarsta.adulti;
    }

    public VehiculFMAgrement(VehiculFMAgrement a) {
        super(a);
        this.echipamentProtectie = a.echipamentProtectie;
        this.tipTeren = a.tipTeren;
        this.categVarsta = a.categVarsta;
    }

    public VehiculFMAgrement(float vitezaMax, float pret, int nrRoti, double greutate, int anFabricatie, int nrPedale,
            int acceleratie, ArrayList<EchipamentProtectie> echipamentProtectie, TipTeren tipTeren,
            CategVarsta categVarsta) {
        super(vitezaMax, pret, nrRoti, greutate, anFabricatie, nrPedale, acceleratie);
        this.echipamentProtectie = echipamentProtectie == null || echipamentProtectie.size() == 0
                ? new ArrayList<EchipamentProtectie>() {
                    {
                        add(EchipamentProtectie.nimic);
                    }
                }
                : echipamentProtectie;
        this.tipTeren = tipTeren;
        this.categVarsta = categVarsta;
    }

    public VehiculFMAgrement(float vitezaMax, float pret, String marca, String model, String tip, String proprietar,
            int nrRoti, double greutate,
            int anFabricatie, int nrPedale,
            int acceleratie, TipTeren tipTeren, ArrayList<EchipamentProtectie> echipamentProtectie,
            CategVarsta categVarsta) {
        super(vitezaMax, pret, marca, model, tip, proprietar, nrRoti, greutate, anFabricatie, nrPedale, acceleratie);
        this.tipTeren = tipTeren;
        this.categVarsta = categVarsta;
        this.echipamentProtectie = echipamentProtectie == null || echipamentProtectie.size() == 0
                ? new ArrayList<EchipamentProtectie>() {
                    {
                        add(EchipamentProtectie.nimic);
                    }
                }
                : echipamentProtectie;
    }

    public VehiculFMAgrement(float vitezaMax, float pret, int nrRoti, double greutate, int anFabricatie, int nrPedale,
            int acceleratie, ArrayList<EchipamentProtectie> echipamentProtectie, TipTeren tipTeren,
            CategVarsta categVarsta, long id) {
        super(vitezaMax, pret, nrRoti, greutate, anFabricatie, nrPedale, acceleratie, id);
        this.echipamentProtectie = echipamentProtectie == null || echipamentProtectie.size() == 0
                ? new ArrayList<EchipamentProtectie>() {
                    {
                        add(EchipamentProtectie.nimic);
                    }
                }
                : echipamentProtectie;
        this.tipTeren = tipTeren;
        this.categVarsta = categVarsta;
    }

    public VehiculFMAgrement(float vitezaMax, float pret, String marca, String model, String tip, String proprietar,
            int nrRoti, double greutate,
            int anFabricatie, int nrPedale,
            int acceleratie, TipTeren tipTeren, ArrayList<EchipamentProtectie> echipamentProtectie,
            CategVarsta categVarsta, long id) {
        super(vitezaMax, pret, marca, model, tip, proprietar, nrRoti, greutate, anFabricatie, nrPedale, acceleratie,
                id);
        this.tipTeren = tipTeren;
        this.categVarsta = categVarsta;
        this.echipamentProtectie = echipamentProtectie == null || echipamentProtectie.size() == 0
                ? new ArrayList<EchipamentProtectie>() {
                    {
                        add(EchipamentProtectie.nimic);
                    }
                }
                : echipamentProtectie;
    }

    public ArrayList<EchipamentProtectie> getEchipamentProtectie() {
        return this.echipamentProtectie;
    }

    public void setEchipamentProtectie(ArrayList<EchipamentProtectie> echipamentProtectie) {
        this.echipamentProtectie = echipamentProtectie;
    }

    public TipTeren getTipTeren() {
        return this.tipTeren;
    }

    public void setTipTeren(TipTeren tipTeren) {
        this.tipTeren = tipTeren;
    }

    public CategVarsta getCategVarsta() {
        return this.categVarsta;
    }

    public void setCategVarsta(CategVarsta categVarsta) {
        this.categVarsta = categVarsta;
    }

    public static ArrayList<VehiculFMAgrement> filtrareViteza(ArrayList<VehiculFMAgrement> vehicule, float vitezaMaxim,
            float vitezaMinima) {
        ArrayList<VehiculFMAgrement> vehiculeFiltrate = new ArrayList<VehiculFMAgrement>();
        for (VehiculFMAgrement vehicul : vehicule) {
            if (vehicul.getVitezaMax() <= vitezaMaxim
                    && vehicul.getVitezaMax() >= vitezaMinima) {
                vehiculeFiltrate.add(vehicul);
            }
        }
        return vehiculeFiltrate;
    }

    public static ArrayList<VehiculFMAgrement> filtrarePret(ArrayList<VehiculFMAgrement> vehicule, float pretMaxim,
            float pretMinim) {
        ArrayList<VehiculFMAgrement> vehiculeFiltrate = new ArrayList<VehiculFMAgrement>();
        for (VehiculFMAgrement vehicul : vehicule) {
            if (vehicul.getPret() <= pretMaxim
                    && vehicul.getPret() >= pretMinim) {
                vehiculeFiltrate.add(vehicul);
            }
        }
        return vehiculeFiltrate;
    }

    @Override
    public void afisare() {
        super.afisare();
        System.out.println("Echipament protectie: " + this.echipamentProtectie);
        System.out.println("Tip teren: " + this.tipTeren);
        System.out.println("Categorie varsta: " + this.categVarsta);
    }

    public static ArrayList<TableColumn<Mobilitate, ?>> getTableColumns() {
        ArrayList<TableColumn<Mobilitate, ?>> columns = VehiculFaraMotor.getTableColumns();

        TableColumn<Mobilitate, TipTeren> tipTerenColumn = new TableColumn<>("Tip teren");
        tipTerenColumn.setCellValueFactory(new PropertyValueFactory<>("tipTeren"));
        columns.add(tipTerenColumn);

        TableColumn<Mobilitate, TipTeren> categVarstaColumn = new TableColumn<>("Categ. varsta");
        categVarstaColumn.setCellValueFactory(new PropertyValueFactory<>("categVarsta"));
        columns.add(categVarstaColumn);

        TableColumn<Mobilitate, ArrayList<EchipamentProtectie>> echipamentProtectieColumn = new TableColumn<>(
                "Echipament protectie");
        echipamentProtectieColumn.setCellValueFactory(
                new PropertyValueFactory<>("echipamentProtectie"));
        columns.add(echipamentProtectieColumn);

        return columns;
    }

    @Override
    public String toString() {
        return "VehiculFMAgrement [echipamentProtectie=" + echipamentProtectie + ", tipTeren= " + tipTeren
                + ", CategVarsta" + categVarsta + ", acceleratie=" + acceleratie
                + ", anFabricatie=" + anFabricatie + ", nrPedale=" + nrPedale + ", greutate=" + greutate + ", nrRoti="
                + nrRoti + ", pret=" + pret + ", vitezaMax=" + vitezaMax + "]";
    }
}
