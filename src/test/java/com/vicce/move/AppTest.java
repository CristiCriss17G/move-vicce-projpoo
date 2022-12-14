package com.vicce.move;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

import com.vicce.move.seeder.VehiculFMSportSeeder;

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
        assertTrue(vfm.getEchipamentProtectie().size() == 1);
        assertArrayEquals(vfm.getEchipamentProtectie().toArray(), new VehiculFMSport.EchipamentProtectie[] {
                VehiculFMSport.EchipamentProtectie.nimic });
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
        assertTrue(vfm2.getEchipamentProtectie().size() == 1);
        assertArrayEquals(vfm2.getEchipamentProtectie().toArray(), new VehiculFMSport.EchipamentProtectie[] {
                VehiculFMSport.EchipamentProtectie.nimic });
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

    /**
     * Testeaza metodele clasei parinte Mobilitate
     */
    @Test
    public void MobilitateTest() {
        VehiculFMSport vfm = new VehiculFMSport(100f, 1000f, 4, 5.0, 2010, 2, 10, VehiculFMSport.TipTeren.nisip,
                new ArrayList<VehiculFMSport.EchipamentProtectie>());
        assertTrue(vfm.getVitezaMax() == 100);
        assertTrue(vfm.getPret() == 1000);
        vfm.setVitezaMax(200);
        vfm.setPret(2000);
        assertTrue(vfm.getVitezaMax() == 200);
        assertTrue(vfm.getPret() == 2000);
        assertTrue(vfm.raportVitezaPret() == 0.1f);
        vfm.afisare();
        final long id = vfm.getId();
        assertEquals(vfm.toString(),
                "VehiculFMSport " + id
                        + " [tipTeren=nisip, echipamentProtectie=[nimic], nrRoti=4, greutate=5.0, anFabricatie=2010, nrPedale=2, acceleratie=10, vitezaMax=200.0, pret=2000.0]");
    }

    /**
     * Testeaza toate metodele clasei VehiculFMSport
     */
    @Test
    public void VehiculFMSportTest() {
        VehiculFMSport vfm = new VehiculFMSport(100f, 1000f, 4, 5.0, 2010, 2, 10, VehiculFMSport.TipTeren.nisip,
                new ArrayList<VehiculFMSport.EchipamentProtectie>());
        assertTrue(vfm.getNrRoti() == 4);
        assertTrue(vfm.getGreutate() == 5);
        assertTrue(vfm.getAnFabricatie() == 2010);
        assertTrue(vfm.getNrPedale() == 2);
        assertTrue(vfm.getAcceleratie() == 10);
        assertEquals(vfm.getTipTeren(), VehiculFMSport.TipTeren.nisip);
        assertTrue(vfm.getEchipamentProtectie().size() == 1);
        assertArrayEquals(vfm.getEchipamentProtectie().toArray(), new ArrayList<VehiculFMSport.EchipamentProtectie>() {
            {
                add(VehiculFMSport.EchipamentProtectie.nimic);
            }
        }.toArray());
        vfm.setNrRoti(2);
        vfm.setGreutate(2.0);
        vfm.setAnFabricatie(2000);
        vfm.setNrPedale(1);
        vfm.setAcceleratie(5);
        vfm.setTipTeren(VehiculFMSport.TipTeren.asfalt);
        vfm.setEchipamentProtectie(new ArrayList<VehiculFMSport.EchipamentProtectie>() {
            {
                add(VehiculFMSport.EchipamentProtectie.casca);
                add(VehiculFMSport.EchipamentProtectie.manusi);
            }
        });
        assertTrue(vfm.getNrRoti() == 2);
        assertTrue(vfm.getGreutate() == 2);
        assertTrue(vfm.getAnFabricatie() == 2000);
        assertTrue(vfm.getNrPedale() == 1);
        assertTrue(vfm.getAcceleratie() == 5);
        assertEquals(vfm.getTipTeren(), VehiculFMSport.TipTeren.asfalt);
        assertTrue(vfm.getEchipamentProtectie().size() == 2);
        assertArrayEquals(vfm.getEchipamentProtectie().toArray(), new ArrayList<VehiculFMSport.EchipamentProtectie>() {
            {
                add(VehiculFMSport.EchipamentProtectie.casca);
                add(VehiculFMSport.EchipamentProtectie.manusi);
            }
        }.toArray());
        vfm.afisare();
        final long id = vfm.getId();
        assertEquals(
                "VehiculFMSport " + id
                        + " [tipTeren=asfalt, echipamentProtectie=[casca, manusi], nrRoti=2, greutate=2.0, anFabricatie=2000, nrPedale=1, acceleratie=5, vitezaMax=100.0, pret=1000.0]",
                vfm.toString());
    }

    /**
     * Testeaza seed-ul
     */
    @Test
    public void SeedTest() {
        VehiculFMSport.resetIdPool();
        ArrayList<VehiculFMSport> vehicule = VehiculFMSportSeeder.seed(10);
        assertTrue(vehicule.size() == 10);
        VehiculFMSportSeeder.JSONseed(vehicule, "vehiculeTesteAutomate.test.json");
        VehiculFMSport.resetIdPool();
        ArrayList<VehiculFMSport> vehiculeCitite = VehiculFMSportSeeder.JSONReadSeed("vehiculeTesteAutomate.test.json");
        for (int i = 0; i < vehicule.size(); i++) {
            assertEquals(vehicule.get(i).toString(), vehiculeCitite.get(i).toString());
        }
    }
}
