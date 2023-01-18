package com.vicce.move;

public abstract class Mobilitate implements Comparable<Mobilitate> {
    protected float vitezaMax;
    protected float pret;

    public Mobilitate() {
        this.vitezaMax = 0;
        this.pret = 0;
    }

    public Mobilitate(Mobilitate a) {
        this.vitezaMax = a.vitezaMax;
        this.pret = a.pret;
    }

    public Mobilitate(float vitezaMax, float pret) {
        this.vitezaMax = vitezaMax;
        this.pret = pret;
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
