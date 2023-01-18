package com.vicce.move.seeder;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.nio.file.NoSuchFileException;

import com.vicce.move.VehiculFMSport;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.json.JSONObject;
import org.json.JSONArray;

public class VehiculFMSportSeeder {
    private static Random random = new Random();
    private static final int MAX = 100;
    private static final int MIN = 1;
    private static final int MAX_VITEZA = 300;
    private static final int MIN_VITEZA = 100;
    private static final int MAX_PRET = 10000;
    private static final int MIN_PRET = 500;
    private static final int MAX_AN = 2020;
    private static final int MIN_AN = 1990;
    private static final int MAX_NRROTI = 8;
    private static final int MIN_NRROTI = 1;
    private static final int MAX_GREUTATE = 10;
    private static final int MIN_GREUTATE = 1;
    private static final int MAX_NRPEDALE = 10;
    private static final int MIN_NRPEDALE = 1;
    private static final int MAX_ACCELERATIE = 20;
    private static final int MIN_ACCELERATIE = 1;
    private static final VehiculFMSport.TipTeren[] tipuriTeren = VehiculFMSport.TipTeren.values();
    private static final VehiculFMSport.EchipamentProtectie[] echipamenteProtectie = VehiculFMSport.EchipamentProtectie
            .values();

    public static ArrayList<VehiculFMSport> seed(int nr) {
        if (nr > MAX || nr < MIN) {
            throw new IllegalArgumentException("Numarul de vehicule trebuie sa fie intre " + MIN + " si " + MAX);
        }
        ArrayList<VehiculFMSport> vehicule = new ArrayList<VehiculFMSport>();
        for (int i = 0; i < nr; i++) {
            float vitezaMax = random.nextFloat() * (MAX_VITEZA - MIN_VITEZA) + MIN_VITEZA;
            float pret = random.nextFloat() * (MAX_PRET - MIN_PRET) + MIN_PRET;
            int nrRoti = random.nextInt(MAX_NRROTI - MIN_NRROTI) + MIN_NRROTI;
            float greutate = random.nextFloat() * (MAX_GREUTATE - MIN_GREUTATE) + MIN_GREUTATE;
            int an = random.nextInt(MAX_AN - MIN_AN) + MIN_AN;
            int nrPedale = random.nextInt(MAX_NRPEDALE - MIN_NRPEDALE) + MIN_NRPEDALE;
            int acceleratie = random.nextInt(MAX_ACCELERATIE - MIN_ACCELERATIE) + MIN_ACCELERATIE;
            VehiculFMSport.TipTeren tipTeren = tipuriTeren[random.nextInt(tipuriTeren.length)];
            ArrayList<VehiculFMSport.EchipamentProtectie> echipamente = new ArrayList<VehiculFMSport.EchipamentProtectie>();
            int nrEchipamente = random.nextInt(echipamenteProtectie.length);
            for (int j = 0; j < nrEchipamente; j++) {
                echipamente.add(echipamenteProtectie[random.nextInt(echipamenteProtectie.length)]);
            }
            VehiculFMSport vfm = new VehiculFMSport(vitezaMax, pret, nrRoti, greutate, an, nrPedale, acceleratie,
                    tipTeren,
                    echipamente);
            // vfm.afisare();
            // System.out.println(vfm.raportVitezaPret());
            vehicule.add(vfm);
        }
        return vehicule;
    }

    public static void JSONseed(int nr) {
        if (nr > MAX || nr < MIN) {
            throw new IllegalArgumentException("Numarul de vehicule trebuie sa fie intre " + MIN + " si " + MAX);
        }
        ArrayList<VehiculFMSport> vehicule = seed(nr);
        JSONseed(vehicule);
    }

    public static void JSONseed(ArrayList<VehiculFMSport> vehicule) {
        JSONseed(vehicule, "vehicule.test.json");
    }

    public static void JSONseed(boolean canBeNull, ArrayList<VehiculFMSport> vehicule) {
        JSONseed(canBeNull, vehicule, "vehicule.test.json");
    }

    public static void JSONseed(ArrayList<VehiculFMSport> vehicule, String path) {
        JSONseed(false, vehicule, path);
    }

    public static void JSONseed(boolean canBeNull, ArrayList<VehiculFMSport> vehicule, String path)
            throws IllegalArgumentException {
        if ((vehicule == null || vehicule.size() == 0) && !canBeNull) {
            throw new IllegalArgumentException("Lista de vehicule nu poate fi nula sau goala");
        }
        JSONArray vehiculeJSON = new JSONArray();
        for (int i = 0; i < vehicule.size(); i++) {
            VehiculFMSport vfm = vehicule.get(i);

            JSONObject vehicul = new JSONObject();
            vehicul.put("id", vfm.getId());
            vehicul.put("vitezaMax", vfm.getVitezaMax());
            vehicul.put("pret", vfm.getPret());
            vehicul.put("nrRoti", vfm.getNrRoti());
            vehicul.put("greutate", vfm.getGreutate());
            vehicul.put("an", vfm.getAnFabricatie());
            vehicul.put("nrPedale", vfm.getNrPedale());
            vehicul.put("acceleratie", vfm.getAcceleratie());
            vehicul.put("tipTeren", vfm.getTipTeren());
            vehicul.put("echipamente", vfm.getEchipamentProtectie());
            vehiculeJSON.put(vehicul);
        }
        try {
            FileWriter file = new FileWriter(path);
            file.write(vehiculeJSON.toString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<VehiculFMSport> JSONReadSeed(String path) {
        if (path == null || path.isEmpty()) {
            throw new IllegalArgumentException("Path-ul nu poate fi nul sau gol");
        }
        ArrayList<VehiculFMSport> vehicule = new ArrayList<VehiculFMSport>();
        try {
            Scanner scanner = new Scanner(Paths.get(path), StandardCharsets.UTF_8.name());
            String content = scanner.useDelimiter("\\A").next();
            scanner.close();
            JSONArray vehiculeJSON = new JSONArray(content);
            for (int i = 0; i < vehiculeJSON.length(); i++) {
                JSONObject vehicul = vehiculeJSON.getJSONObject(i);
                long id = vehicul.getLong("id");
                float vitezaMax = (float) vehicul.getDouble("vitezaMax");
                float pret = (float) vehicul.getDouble("pret");
                int nrRoti = vehicul.getInt("nrRoti");
                float greutate = (float) vehicul.getDouble("greutate");
                int an = vehicul.getInt("an");
                int nrPedale = vehicul.getInt("nrPedale");
                int acceleratie = vehicul.getInt("acceleratie");
                VehiculFMSport.TipTeren tipTeren = VehiculFMSport.TipTeren.valueOf(vehicul.getString("tipTeren"));
                JSONArray echipamenteJSON = vehicul.getJSONArray("echipamente");
                ArrayList<VehiculFMSport.EchipamentProtectie> echipamente = new ArrayList<VehiculFMSport.EchipamentProtectie>();
                for (int j = 0; j < echipamenteJSON.length(); j++) {
                    echipamente.add(VehiculFMSport.EchipamentProtectie.valueOf(echipamenteJSON.getString(j)));
                }
                VehiculFMSport vfm = new VehiculFMSport(vitezaMax, pret, nrRoti, greutate, an, nrPedale,
                        acceleratie,
                        tipTeren,
                        echipamente, id);
                vehicule.add(vfm);
            }
        } catch (NoSuchFileException e) {
            // e.printStackTrace();
            throw new IllegalArgumentException("Fisierul nu exista; eroare de I/O: " + e.getMessage());
        } catch (IOException e) {
            // e.printStackTrace();
            throw new IllegalArgumentException("Fisierul nu poate fi citit; eroare de I/O: " + e.getMessage());
        }

        return vehicule;
    }
}
