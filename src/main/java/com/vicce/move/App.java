package com.vicce.move;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        VehiculCuMotor vcm = new VehiculCuMotor(100, 1000, 4, 5);

        vcm.afisare();

        System.out.println(vcm.raportVitezaPret());
    }
}
