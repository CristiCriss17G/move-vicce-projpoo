package com.vicce.move;

import java.util.ArrayList;

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
            }};

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
        this.echipamentProtectie = echipamentProtectie;
        this.tipTeren = tipTeren;
        this.categVarsta = categVarsta;
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

    @Override
    public void afisare() {
        super.afisare();
        System.out.println("Echipament protectie: " + this.echipamentProtectie);
        System.out.println("Tip teren: " + this.tipTeren);
        System.out.println("Categorie varsta: " + this.categVarsta);
    }

    @Override
    public String toString() {
        return "VehiculFMAgrement [echipamentProtectie=" + echipamentProtectie + ", tipTeren= " + tipTeren
                + ", CategVarsta" + categVarsta + ", acceleratie=" + acceleratie
                + ", anFabricatie=" + anFabricatie + ", nrPedale=" + nrPedale + ", greutate=" + greutate + ", nrRoti="
                + nrRoti + ", pret=" + pret + ", vitezaMax=" + vitezaMax + "]";
    }
}
