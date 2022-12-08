package com.vicce.move;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Unit test for simple App.
 */
public class AppTest {
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
        assertNull(vfm3.getEchipamentProtectie());
    }
}
