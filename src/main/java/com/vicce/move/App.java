package com.vicce.move;


public class App {
    public static void main(String[] args) {
        VehiculCuMotor vcm = new VehiculCuMotor(100, 1000, 4, 5);

        vcm.afisare();

        System.out.println(vcm.raportVitezaPret());

        VehiculMMotorina m1=new VehiculMMotorina(100,20000,4,5,"Audi","A4",4,2004,100,200);
        VehiculMMotorina m2=new VehiculMMotorina(150,30000,4,2,"BMW","Seria 2",5,2020,200,175);
        VehiculMMotorina m3=new VehiculMMotorina(250,25000,4,4,"Audi","A4",3,2014,400,290);
        VehiculMMotorina m4=new VehiculMMotorina(200,40000,4,5,"Ford","Focus",2,2017,300,3500);
        VehiculMMotorina m5=new VehiculMMotorina(180,20000,4,5,"Ford","Fiesta",5,2019,500,2500);
        VehiculMMotorina m6=new VehiculMMotorina();
        VehiculMMotorina m7=new VehiculMMotorina(m3);
        VehiculMMotorina m8=new VehiculMMotorina(100,50000,4,4,"Dacia","Logan",6,2021,100,200);
        VehiculMMotorina m9=new VehiculMMotorina(150,15000,4,5,"BMW","Seria 5",7,2002,100,200);
        VehiculMMotorina m10=new VehiculMMotorina(m8);
        VehiculMMotorina[] vmm={m1,m2,m3,m4,m5,m6,m7,m8,m9,m10};

        System.out.println("Afisare elemente din vector:");
        for (int i=0;i<vmm.length; i++){
            vmm[i].afisare();
        }
        System.out.println("\nAfisare elemente din vector care au mai mult de 200 de cai putere:");
        for (int i=0;i<vmm.length; i++){
            if (vmm[i].getPutere()>200){
            vmm[i].afisare();
        }
        }
        System.out.println("\nAfisare elemente din vector care au pret mai mic de 20000:");
        for (int i=0;i<vmm.length; i++){
            if (vmm[i].getPret()<20000){
            vmm[i].afisare();
        }
        }
    }

}