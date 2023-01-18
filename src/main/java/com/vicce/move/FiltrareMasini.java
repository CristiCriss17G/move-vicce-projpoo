package com.vicce.move;
import java.util.ArrayList;

public class FiltrareMasini {

    public static ArrayList<VehiculMMotorina> filtreazaDupaPutere(ArrayList<VehiculMMotorina> listaInitvehicule, int putere) {

        ArrayList<VehiculMMotorina> listaVehicule = new ArrayList<VehiculMMotorina>();

        for (VehiculMMotorina vehicule : listaInitvehicule)

            if (vehicule.getPutere() <= putere)

                listaVehicule.add(vehicule);

        return listaVehicule;

    }



    public static ArrayList<VehiculMMotorina> filtreazaDupaPret(ArrayList<VehiculMMotorina> listaVehicule2, float pret) {

        ArrayList<VehiculMMotorina> listaVehicule = new ArrayList<VehiculMMotorina>();

        for (VehiculMMotorina vehicule : listaVehicule2)

        if (vehicule.getPret() <= pret)

        listaVehicule.add(vehicule);

        return listaVehicule;

    }

}