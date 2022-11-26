package com.vicce.move;

public abstract class Mobilitate {
    float vitezaMax;
    float pret;

    public Mobilitate(float vitezaMax, float pret) {
        this.vitezaMax = vitezaMax;
        this.pret = pret;
    }

    public float getVitezaMax() {
        return vitezaMax;
    }

    public void setVitezaMax(float vitezaMax) {
        this.vitezaMax = vitezaMax;
    }

    public float getPret() {
        return pret;
    }

    public void setPret(float pret) {
        this.pret = pret;
    }

    public abstract void afisare();

}
