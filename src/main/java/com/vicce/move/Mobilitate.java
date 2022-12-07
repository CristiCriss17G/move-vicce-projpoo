package com.vicce.move;

public abstract class Mobilitate {
    float vitezaMax;
    float pret;

    public Mobilitate(){
        vitezaMax=300;
        pret=5000;
    }

    public Mobilitate(float vitezaMax, float pret) {
        this.vitezaMax = vitezaMax;
        this.pret = pret;
    }

    public Mobilitate(Mobilitate a){
        this.vitezaMax=a.vitezaMax;
        this.pret=a.pret;
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

    public abstract float raportVitezaPret();

    public abstract void afisare();

}
