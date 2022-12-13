package com.vicce.move;

import java.beans.Transient;

/**
 * Hello world!
 *
 */
public class App {
    
    //Testez constructorul cu parametri
    public static void main(String[] args) {
        VehiculCuMotor vcm = new VehiculCuMotor(100, 1000, 4, 5);
        vcm.afisare();
        System.out.println(vcm.raportVitezaPret());
    
    }
}
