package com.vicce.move.seeder;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;

import com.vicce.move.VehiculFMAgrement;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import org.json.JSONObject;
import org.json.JSONArray;

public class VehiculFMAgrementSeeder {
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
    private static final VehiculFMAgrement.TipTeren[] tipuriTeren = VehiculFMAgrement.TipTeren.values();
    private static final VehiculFMAgrement.CategVarsta[] categoriiVarsta = VehiculFMAgrement.CategVarsta.values();
    private static final VehiculFMAgrement.EchipamentProtectie[] echipamenteProtectie = VehiculFMAgrement.EchipamentProtectie
            .values();

    public static ArrayList<VehiculFMAgrement> seed(int nr) {
        if (nr > MAX || nr < MIN) {
            throw new IllegalArgumentException("Numarul de vehicule trebuie sa fie intre " + MIN + " si " + MAX);
        }
        ArrayList<VehiculFMAgrement> vehicule = new ArrayList<VehiculFMAgrement>();
        for (int i = 0; i < nr; i++) {
            float vitezaMax = random.nextFloat() * (MAX_VITEZA - MIN_VITEZA) + MIN_VITEZA;
            float pret = random.nextFloat() * (MAX_PRET - MIN_PRET) + MIN_PRET;
            int nrRoti = random.nextInt(MAX_NRROTI - MIN_NRROTI) + MIN_NRROTI;
            float greutate = random.nextFloat() * (MAX_GREUTATE - MIN_GREUTATE) + MIN_GREUTATE;
            int an = random.nextInt(MAX_AN - MIN_AN) + MIN_AN;
            int nrPedale = random.nextInt(MAX_NRPEDALE - MIN_NRPEDALE) + MIN_NRPEDALE;
            int acceleratie = random.nextInt(MAX_ACCELERATIE - MIN_ACCELERATIE) + MIN_ACCELERATIE;
            VehiculFMAgrement.TipTeren tipTeren = tipuriTeren[random.nextInt(tipuriTeren.length)];
            ArrayList<VehiculFMAgrement.EchipamentProtectie> echipamente = new ArrayList<VehiculFMAgrement.EchipamentProtectie>();
            VehiculFMAgrement.CategVarsta categVarsta = categoriiVarsta[random.nextInt(categoriiVarsta.length)];
            int nrEchipamente = random.nextInt(echipamenteProtectie.length);
            for (int j = 0; j < nrEchipamente; j++) {
                echipamente.add(echipamenteProtectie[random.nextInt(echipamenteProtectie.length)]);
            }
            VehiculFMAgrement vfm = new VehiculFMAgrement(vitezaMax, pret, nrRoti, greutate, an, nrPedale, acceleratie,echipamente,tipTeren,categVarsta);
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
        ArrayList<VehiculFMAgrement> vehicule = seed(nr);
        JSONseed(vehicule);
    }

    public static void JSONseed(ArrayList<VehiculFMAgrement> vehicule) {
        JSONseed(vehicule, "vehicule.test.json");
    }

    public static void JSONseed(ArrayList<VehiculFMAgrement> vehicule, String path) {
        if (vehicule == null || vehicule.size() == 0) {
            throw new IllegalArgumentException("Lista de vehicule nu poate fi nula sau goala");
        }
        JSONArray vehiculeJSON = new JSONArray();
        for (int i = 0; i < vehicule.size(); i++) {
            VehiculFMAgrement vfm = vehicule.get(i);

            JSONObject vehicul = new JSONObject();
            vehicul.put("vitezaMax", vfm.getVitezaMax());
            vehicul.put("pret", vfm.getPret());
            vehicul.put("nrRoti", vfm.getNrRoti());
            vehicul.put("greutate", vfm.getGreutate());
            vehicul.put("an", vfm.getAnFabricatie());
            vehicul.put("nrPedale", vfm.getNrPedale());
            vehicul.put("acceleratie", vfm.getAcceleratie());
            vehicul.put("tipTeren", vfm.getTipTeren());
            vehicul.put("echipamente", vfm.getEchipamentProtectie());
            vehicul.put("categVarsta", vfm.getCategVarsta());
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

    public static ArrayList<VehiculFMAgrement> JSONReadSeed(String path) {
        if (path == null || path.isEmpty()) {
            throw new IllegalArgumentException("Path-ul nu poate fi nul sau gol");
        }
        ArrayList<VehiculFMAgrement> vehicule = new ArrayList<VehiculFMAgrement>();
        try {
            Scanner scanner = new Scanner(Paths.get(path), StandardCharsets.UTF_8.name());
            String content = scanner.useDelimiter("\\A").next();
            scanner.close();
            JSONArray vehiculeJSON = new JSONArray(content);
            for (int i = 0; i < vehiculeJSON.length(); i++) {
                JSONObject vehicul = vehiculeJSON.getJSONObject(i);
                float vitezaMax = (float) vehicul.getDouble("vitezaMax");
                float pret = (float) vehicul.getDouble("pret");
                int nrRoti = vehicul.getInt("nrRoti");
                float greutate = (float) vehicul.getDouble("greutate");
                int an = vehicul.getInt("an");
                int nrPedale = vehicul.getInt("nrPedale");
                int acceleratie = vehicul.getInt("acceleratie");
                VehiculFMAgrement.TipTeren tipTeren = VehiculFMAgrement.TipTeren.valueOf(vehicul.getString("tipTeren"));
                VehiculFMAgrement.CategVarsta categVarsta = VehiculFMAgrement.CategVarsta.valueOf(vehicul.getString("categVarsta"));
                JSONArray echipamenteJSON = vehicul.getJSONArray("echipamente");
                ArrayList<VehiculFMAgrement.EchipamentProtectie> echipamente = new ArrayList<VehiculFMAgrement.EchipamentProtectie>();
                for (int j = 0; j < echipamenteJSON.length(); j++) {
                    echipamente.add(VehiculFMAgrement.EchipamentProtectie.valueOf(echipamenteJSON.getString(j)));
                }
                VehiculFMAgrement vfm = new VehiculFMAgrement(vitezaMax, pret, nrRoti, greutate, an, nrPedale, acceleratie,echipamente,tipTeren,categVarsta);
                vehicule.add(vfm);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return vehicule;
    }
}