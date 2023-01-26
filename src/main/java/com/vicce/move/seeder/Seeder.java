package com.vicce.move.seeder;

import java.util.ArrayList;

import org.json.JSONArray;

import com.vicce.move.Mobilitate;
import com.vicce.move.VehiculFMAgrement;

public class Seeder {

    public static boolean JSONSeed(JSONArray jsonArray) {
        return false;
    }

    public static ArrayList<Mobilitate> getVehicule(String categorie, float pretMin, float pretMax, float vitezaMin,
            float vitezaMax) {
        ArrayList<Mobilitate> vehicule = new ArrayList<Mobilitate>();
        switch (categorie) {
            case "VehiculFMAgrement":
                vehicule.addAll(getVehicule("VehiculFMAgrement", pretMin, pretMax, vitezaMin, vitezaMax));
                break;
            default:
                vehicule = new ArrayList<Mobilitate>();
                break;
        }
        return vehicule;
    }

    public static void resetVehicule(String tipVehicul) {
        switch (tipVehicul) {
            case "VehiculAgrement":
                VehiculFMAgrementSeeder.resetVehicule();
                break;
            case "VehiculFMAgrement":
                VehiculFMAgrementSeeder.resetVehicule();
                break;
            default:
                break;
        }
    }

    public static boolean addVehicule(String tipVehicul, int nr) {
        return switch (tipVehicul) {
            case "VehiculAgrement" -> {
                VehiculFMAgrementSeeder.addVehicule(nr);
                yield true;
            }
            default -> false;
        };
    }

    public static boolean addVehicule(Mobilitate vehicul) {
        return switch (vehicul.getClass().getSimpleName()) {
            case "VehiculFMAgrement" -> {
                VehiculFMAgrementSeeder.addVehicule((VehiculFMAgrement) vehicul);
                yield true;
            }
            default -> false;
        };
    }

    public static boolean addVehicule(ArrayList<Mobilitate> vehicule) {
        boolean success = true;
        for (Mobilitate vehicul : vehicule) {
            success = success && addVehicule(vehicul);
        }
        return success;
    }

}