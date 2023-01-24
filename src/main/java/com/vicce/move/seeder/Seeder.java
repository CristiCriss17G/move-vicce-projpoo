package com.vicce.move.seeder;

import java.util.ArrayList;

import org.json.JSONArray;

import com.vicce.move.Mobilitate;
import com.vicce.move.VehiculFMSport;
import com.vicce.move.VehiculMMotorina;

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
                vehicule.addAll(getVehicule("VehiculMMotorina", pretMin, pretMax, vitezaMin, vitezaMax));
                break;
            case "VehiculFMSport":
                vehicule.addAll(VehiculFMSportSeeder.getVehicule(pretMin, pretMax, vitezaMin, vitezaMax));
                break;
            case "VehiculMMotorina":
                vehicule.addAll(VehiculMMotorinaSeeder.getVehicule(pretMin, pretMax, vitezaMin, vitezaMax));
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
                VehiculFMSportSeeder.resetVehicule();
                VehiculMMotorinaSeeder.resetVehicule();
                break;
            case "VehiculFMSport":
                VehiculFMSportSeeder.resetVehicule();
                break;
            case "VehiculMMotorina":
                VehiculMMotorinaSeeder.resetVehicule();
                break;
            default:
                break;
        }
    }

    public static boolean addVehicule(String tipVehicul, int nr) {
        return switch (tipVehicul) {
            case "Toate" -> {
                VehiculFMSportSeeder.addVehicule(nr);
                VehiculMMotorinaSeeder.addVehicule(nr);
                yield true;
            }
            case "VehiculFMSport" -> {
                VehiculFMSportSeeder.addVehicule(nr);
                yield true;
            }
            case "VehiculMMotorina" -> {
                VehiculMMotorinaSeeder.addVehicule(nr);
                yield true;
            }
            default -> false;
        };
    }

    public static boolean addVehicule(Mobilitate vehicul) {
        return switch (vehicul.getClass().getSimpleName()) {
            case "VehiculFMSport" -> {
                VehiculFMSportSeeder.addVehicule((VehiculFMSport) vehicul);
                yield true;
            }
            case "VehiculMMotorina" -> {
                VehiculMMotorinaSeeder.addVehicule((VehiculMMotorina) vehicul);
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
