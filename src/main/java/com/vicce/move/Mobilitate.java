package com.vicce.move;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Mobilitate implements Comparable<Mobilitate>, Serializable {
    private static long idPool = 1;

    /**
     * Temporary for testing purposes
     */
    public final static void resetIdPool() {
        idPool = 1;
    }

    protected final long id;
    protected float vitezaMax;
    protected float pret;

    public Mobilitate() {
        this.id = idPool++;
        this.vitezaMax = 0;
        this.pret = 0;
    }

    public Mobilitate(Mobilitate a) {
        this.id = a.id;
        this.vitezaMax = a.vitezaMax;
        this.pret = a.pret;
    }

    public Mobilitate(float vitezaMax, float pret) {
        this.id = idPool++;
        this.vitezaMax = vitezaMax;
        this.pret = pret;
    }

    public Mobilitate(float vitezaMax, float pret, long id) {
        this.id = idPool++;
        this.vitezaMax = vitezaMax;
        this.pret = pret;
        if (idPool <= id)
        idPool = id + 1;
    }

    public final long getId() {
        return this.id;
    }
    
    public float getVitezaMax() {
        return this.vitezaMax;
    }

    public void setVitezaMax(float vitezaMax) {
        this.vitezaMax = vitezaMax;
    }

    public float getPret() {
        return this.pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    @Override
    public int compareTo(Mobilitate o) {
        if (this.raportVitezaPret() > o.raportVitezaPret())
            return 1;
        if (this.raportVitezaPret() < o.raportVitezaPret())
            return -1;
        return 0;
    }

    public abstract float raportVitezaPret();

    public abstract void afisare();

    @Override
    public abstract String toString();

}
