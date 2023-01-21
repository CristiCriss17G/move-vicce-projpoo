package com.vicce.move.seeder;

import java.util.ArrayList;

import org.json.JSONArray;

import com.vicce.move.Mobilitate;

public class Seeder {

    public static boolean JSONSeed(JSONArray jsonArray) {
        return false;
    }

    public static ArrayList<Mobilitate> getVehicule(String categorie, float pretMin, float pretMax, float vitezaMin,
            float vitezaMax) {
        ArrayList<Mobilitate> vehicule = new ArrayList<Mobilitate>();
        switch (categorie) {
            case "Toate":
                vehicule.addAll(getVehicule("VehiculFMSport", pretMin, pretMax, vitezaMin, vitezaMax));
                break;
            case "VehiculFMSport":
                vehicule.addAll(VehiculFMSportSeeder.getVehicule(pretMin, pretMax, vitezaMin, vitezaMax));
                break;
            default:
                vehicule = new ArrayList<Mobilitate>();
                break;
        }
        return vehicule;
    }

    public static void resetVehicule(String tipVehicul) {
        switch (tipVehicul) {
            case "Toate":
            case "VehiculFMSport":
                VehiculFMSportSeeder.resetVehicule();
                break;
            default:
                break;
        }
    }

}
