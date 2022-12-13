package com.vicce.move;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test  //testez constructorul cu parametrii din clasa Vehicul cu motor
    public void VehiculMElectricConstrParametrii(){
        VehiculMElectric vme =new VehiculMElectric(250f,2500f,4,7,4,2500,450,1500d,7,800,15000d,2018,2,250);
        new ArrayList<VehiculMElectric.Electric>();
        assertTrue(vme.getNrRoti() == 5);
        assertTrue(vme.getNrLocuri() == 7);
    }

    
    @Test   //teste constructorul fara parametrii 
    public void VehiculMElectricConstrFParametrii(){
        VehiculMElectric vme2= new VehiculMElectric();
        assertTrue(vme2.getNrRoti() == 0);
        assertTrue(vme2.getNrLocuri() == 0);
        
    }

    @Test    //teste constructorul de copiere 
    public void VehiculMElectricConstrCopiere(){
        VehiculMElectric vme =new VehiculMElectric(250f,2500f,4,7,4,2500,450,1500d,7,800,15000d,2018,2,250);
        new ArrayList<VehiculMElectric.Electric>();
        VehiculMElectric vme3 = new VehiculMElectric(vme);
        assertTrue(vme3.getNrRoti() == 5);
        assertTrue(vme3.getNrLocuri() == 7);
    }


    /**
     * Testeaza constructorii cu parametri si metodele clasei VehiculCuMotor
     */
    @Test
    public void VehiculFMSportConstructoriCuParametri() {
        VehiculFMSport vfm = new VehiculFMSport(100f, 1000f, 4, 5.0, 2010, 2, 10, VehiculFMSport.TipTeren.nisip,
                new ArrayList<VehiculFMSport.EchipamentProtectie>());
        assertTrue(vfm.getNrRoti() == 4);
        assertTrue(vfm.getGreutate() == 5);
        assertTrue(vfm.getAnFabricatie() == 2010);
        assertTrue(vfm.getNrPedale() == 2);
        assertTrue(vfm.getAcceleratie() == 10);
        assertEquals(vfm.getTipTeren(), VehiculFMSport.TipTeren.nisip);
        assertTrue(vfm.getEchipamentProtectie().size() == 0);
    }

    /**
     * Testeaza constructorii de copiere si metodele clasei VehiculCuMotor
     */    
    @Test
    public void VehiculFMSportConstructoriDeCopiere() {
        VehiculFMSport vfm = new VehiculFMSport(100f, 1000f, 4, 5.0, 2010, 2, 10, VehiculFMSport.TipTeren.nisip,
                new ArrayList<VehiculFMSport.EchipamentProtectie>());
        VehiculFMSport vfm2 = new VehiculFMSport(vfm);
        assertTrue(vfm2.getNrRoti() == 4);
        assertTrue(vfm2.getGreutate() == 5);
        assertTrue(vfm2.getAnFabricatie() == 2010);
        assertTrue(vfm2.getNrPedale() == 2);
        assertTrue(vfm2.getAcceleratie() == 10);
        assertEquals(vfm2.getTipTeren(), VehiculFMSport.TipTeren.nisip);
        assertTrue(vfm2.getEchipamentProtectie().size() == 0);
    }

    /**
     * Testeaza constructorii fara parametri si metodele clasei VehiculCuMotor
     */
    @Test
    public void VehiculFMSportConstructoriFaraParametri() {
        VehiculFMSport vfm3 = new VehiculFMSport();
        assertTrue(vfm3.getNrRoti() == 0);
        assertTrue(vfm3.getGreutate() == 0);
        assertTrue(vfm3.getAnFabricatie() == 0);
        assertTrue(vfm3.getNrPedale() == 0);
        assertTrue(vfm3.getAcceleratie() == 0);
        assertEquals(vfm3.getTipTeren(), VehiculFMSport.TipTeren.asfalt);
        assertArrayEquals(vfm3.getEchipamentProtectie().toArray(), new ArrayList<VehiculFMSport.EchipamentProtectie>() {
            {
                add(VehiculFMSport.EchipamentProtectie.nimic);
            }
        }.toArray());

    }
}
