package com.vicce.move;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        VehiculFMSport vfm = new VehiculFMSport(200f, 2000f, 4, 5.0, 2010, 2, 10, VehiculFMSport.TipTeren.nisip,
                new ArrayList<VehiculFMSport.EchipamentProtectie>() {
                    {
                        add(VehiculFMSport.EchipamentProtectie.nimic);
                    }
                });
        System.out.println(vfm.raportVitezaPret());
    }
}
