package com.vicce.move;

public class VehiculMBenzina extends VehiculCuMotor {
    int caiPutere;
    int capacitateMotor;
    String marca;
    String model;
    int anFabricatie;
    double consumUrban;


    VehiculMBenzina(){
        super();
        caiPutere=100;
        capacitateMotor=1600;
        marca="VW";
        model="Passat";
        anFabricatie=2000;
        consumUrban=5.6;
    }

    VehiculMBenzina(float vitezaMax, float pret, int nrRoti, int nrLocuri,int putere,int capacitate,String marca,String model,int an, double consum){
        super(vitezaMax,pret,nrRoti,nrLocuri);
        this.caiPutere=putere;
        this.capacitateMotor=capacitate;
        this.marca=marca;
        this.model=model;
        this.anFabricatie=an;
        this.consumUrban=consum;
    }

    VehiculMBenzina(VehiculMBenzina m){
        super(m);
        this.caiPutere=m.caiPutere;
        this.capacitateMotor=m.capacitateMotor;
        this.marca=m.marca;
        this.model=m.model;
        this.anFabricatie=m.anFabricatie;
        this.consumUrban=m.consumUrban;
    }

    public int getCaiPutere(){
        return caiPutere;
    }

    public void setCaiPutere(int putere){
        this.caiPutere=putere;
    }

    public int getCapacitateMotor(){
        return capacitateMotor;
    }

    public void setCapacitateMotor(int capacitate){
        this.capacitateMotor=capacitate;
    }

    public String getMarca(){
        return marca;
    }

    public void setMarca(String marca){
        this.marca=marca;
    }

    public String getModel(){
        return model;
    }

    public void setModel(String model){
        this.model=model;
    }

    public int getAnFabricatie(){
        return anFabricatie;
    }
    
    public void setAnFabricatie(int an){
        this.anFabricatie=an;
    }

    public double getConsumUrban(){
        return consumUrban;
    }
    
    public void setConsumUrban(double consum){
        this.consumUrban=consum;
    }

    @Override
    public String toString(){
        return "Vehicul cu motor pe benzina "+marca+" "+ model+" fabricat in anul "+anFabricatie+" cu "+caiPutere+" cai putere"+" si o capacitate de "+capacitateMotor+ " si un consum urban de "+consumUrban+"l/100km";

    }
    

    @Override
    public void afisare(){
        System.out.println("Vehicul cu motor pe benzina "+marca+" "+ model+" fabricat in anul "+anFabricatie+" cu "+caiPutere+"cai putere"+" si o capacitate de "+capacitateMotor+ " si un consum urban de "+consumUrban+"l/100km");
    }

}
