package com.vicce.move;

import java.util.ArrayList;

public class VehiculFMSport extends VehiculFaraMotor {
    public static enum TipTeren {
        asfalt, nisip, zapada, gheata, munte, panta, pietris
    };

    public static enum EchipamentProtectie {
        nimic, casca, manusi, pantaloni, bluza, botine, geci, ochelari
    };

    protected TipTeren tipTeren;

    protected ArrayList<EchipamentProtectie> echipamentProtectie;

    public VehiculFMSport() {
        super();
        this.tipTeren = TipTeren.asfalt;
        this.echipamentProtectie = new ArrayList<EchipamentProtectie>() {
            {
                add(EchipamentProtectie.nimic);
            }
        };
    }

    public VehiculFMSport(VehiculFMSport a) {
        super(a);
        this.tipTeren = a.tipTeren;
        this.echipamentProtectie = a.echipamentProtectie;
    }

    public VehiculFMSport(float vitezaMax, float pret, int nrRoti, double greutate, int anFabricatie, int nrPedale,
            int acceleratie, TipTeren tipTeren, ArrayList<EchipamentProtectie> echipamentProtectie) {
        super(vitezaMax, pret, nrRoti, greutate, anFabricatie, nrPedale, acceleratie);
        this.tipTeren = tipTeren;
        this.echipamentProtectie = echipamentProtectie == null || echipamentProtectie.size() == 0
                ? new ArrayList<EchipamentProtectie>() {
                    {
                        add(EchipamentProtectie.nimic);
                    }
                }
                : echipamentProtectie;
    }

    public TipTeren getTipTeren() {
        return this.tipTeren;
    }

    public void setTipTeren(TipTeren tipTeren) {
        this.tipTeren = tipTeren;
    }

    public ArrayList<EchipamentProtectie> getEchipamentProtectie() {
        return this.echipamentProtectie;
    }

    public void setEchipamentProtectie(ArrayList<EchipamentProtectie> echipamentProtectie) {
        this.echipamentProtectie = echipamentProtectie;
    }

    public ArrayList<VehiculFMSport> filtrareViteza(ArrayList<VehiculFMSport> vehicule, float vitezaMaxim,
            float vitezaMinima) {
        ArrayList<VehiculFMSport> vehiculeFiltrate = new ArrayList<VehiculFMSport>();
        for (VehiculFMSport vehicul : vehicule) {
            if (vehicul.getVitezaMax() <= vitezaMaxim
                    && vehicul.getVitezaMax() >= vitezaMinima) {
                vehiculeFiltrate.add(vehicul);
            }
        }
        return vehiculeFiltrate;
    }

    public ArrayList<VehiculFMSport> filtrarePret(ArrayList<VehiculFMSport> vehicule, float pretMaxim,
            float pretMinim) {
        ArrayList<VehiculFMSport> vehiculeFiltrate = new ArrayList<VehiculFMSport>();
        for (VehiculFMSport vehicul : vehicule) {
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
        System.out.println("Tip teren: " + this.tipTeren);
        System.out.println("Echipament protectie: " + this.echipamentProtectie);
    }

    @Override
    public String toString() {
        return "VehiculFMSport " + id + " [tipTeren=" + tipTeren + ", echipamentProtectie=" + echipamentProtectie
                + ", nrRoti="
                + nrRoti + ", greutate=" + greutate + ", anFabricatie=" + anFabricatie + ", nrPedale=" + nrPedale
                + ", acceleratie=" + acceleratie + ", vitezaMax=" + vitezaMax + ", pret=" + pret + "]";
    }
}
