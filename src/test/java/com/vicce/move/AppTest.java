package com.vicce.move;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

import com.vicce.move.seeder.VehiculFMAgrementSeeder;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Testeaza constructorii de copiere si metodele clasei VehiculFMAgrement
     */
    @Test
    public void VehiculFMAgrementConstructoriDeCopiere() {
        VehiculFMAgrement vfma = new VehiculFMAgrement(100f, 1000f, 4, 5.0, 2010, 2, 10,
                new ArrayList<VehiculFMAgrement.EchipamentProtectie>(), VehiculFMAgrement.TipTeren.pamant,
                VehiculFMAgrement.CategVarsta.adulti);
        VehiculFMAgrement vfma4 = new VehiculFMAgrement(vfma);
        assertTrue(vfma4.getNrRoti() == 4);
        assertTrue(vfma4.getGreutate() == 5);
        assertTrue(vfma4.getAnFabricatie() == 2010);
        assertTrue(vfma4.getNrPedale() == 2);
        assertTrue(vfma4.getAcceleratie() == 10);
        assertEquals(vfma4.getTipTeren(), VehiculFMAgrement.TipTeren.gheata);
        assertTrue(vfma4.getEchipamentProtectie().size() == 0);
    }

    /**
     * Testeaza constructorii cu parametri si metodele clasei VehiculFMAgrement
     */
    @Test
    public void VehiculFMAgrementConstructoriCuParametri() {
        VehiculFMAgrement vfma = new VehiculFMAgrement(100f, 1000f, 4, 5.0, 2010, 2, 10,
                new ArrayList<VehiculFMAgrement.EchipamentProtectie>(), VehiculFMAgrement.TipTeren.pamant,
                VehiculFMAgrement.CategVarsta.adulti);
        assertTrue(vfma.getNrRoti() == 4);
        assertTrue(vfma.getGreutate() == 5);
        assertTrue(vfma.getAnFabricatie() == 2010);
        assertTrue(vfma.getNrPedale() == 2);
        assertTrue(vfma.getAcceleratie() == 10);
        assertEquals(vfma.getTipTeren(), VehiculFMAgrement.TipTeren.gheata);
        assertTrue(vfma.getEchipamentProtectie().size() == 0);
    }

    /**
     * Testeaza constructorii fara parametri si metodele clasei VehiculFMAgrement
     */
    @Test
    public void VehiculFMAgrementConstructoriFaraParametri() {
        VehiculFMAgrement vfma5 = new VehiculFMAgrement();
        assertTrue(vfma5.getNrRoti() == 0);
        assertTrue(vfma5.getGreutate() == 0);
        assertTrue(vfma5.getAnFabricatie() == 0);
        assertTrue(vfma5.getNrPedale() == 0);
        assertTrue(vfma5.getAcceleratie() == 0);
        assertEquals(vfma5.getTipTeren(), VehiculFMAgrement.TipTeren.asfalt);
        assertArrayEquals(vfma5.getEchipamentProtectie().toArray(),
                new ArrayList<VehiculFMAgrement.EchipamentProtectie>() {
                    {
                        add(VehiculFMAgrement.EchipamentProtectie.nimic);
                    }
                }.toArray());
    }

}
