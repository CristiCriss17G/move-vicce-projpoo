import java.util.Random;

import javax.naming.ldap.Rdn;
public class generator {
    static private float [] vitezaMaxima={150,170,180,200,240,250,270,280,300,320};
    static private float [] pret={3000,4000,6000,8000,10000,12000,15000,19000,2400,28000};
    static private int [] nrRoti={4,5};
    static private int [] nrLocuri={2,5,7};
    static private int [] nrUsi={2,4};
    static private int [] capacitateMotor={2000,2200,2400,2600,2800,3000,3200,3400,3600,4000};
    static private int [] autonomie={250,300,350,400,450,500,550,600,650,700};
    static private double [] greutate ={800,1000,1400,1600,1800,2000,2500,2600,3000,3200};
    static private int [] nrScaune={2,5,7};
    static private int [] litriPortbagaj={350,450,550,650,750,850,950,1000,1200,1400};
    static private double [] kmReali={1000,1500,2400,3600,5800,6100,7800,8300,9700,10400};
    static private int [] anFabricatie={2010,2011,2012,2014,2016,2018,2019,2020,2021,2022};
    
    public static Masini[] genereazaMasini(int n){
        Masini[] listaMasini =new Masini[n];
        for(int i=0;i<n;i++){
            float viteza = vitezaMaxima[new Random().nextFloat(vitezaMaxima.length)];
            float pretul = pret[new Random().nextFloat(pret.length)];
            int roti = nrRoti[new Random().nextInt(nrRoti.length)];
            int locuri = nrLocuri[new Random().nextInt(nrLocuri.length)];
            int usi = nrUsi[new Random().nextInt(nrUsi.length)];
            int capacitate = capacitateMotor[new Random().nextInt(capacitateMotor.length)];
            int Autonomie = autonomie[new Random().nextInt(autonomie.length)];
            double Greutate = greutate[new Random().nextDouble(greutate.length)];
            int scaune = nrScaune[new Random().nextInt(nrScaune.length)];
            int portbagaj = litriPortbagaj[new Random().nextInt(litriPortbagaj.length)];
            double km = kmReali[new Random().nextDouble(kmReali.length)];
            int an = anFabricatie[new Random().nextInt(anFabricatie.length)];

            Masini masini = new Masini(viteza,pretul,roti,locuri,usi,capacitate,Autonomie,Greutate,scaune,portbagaj,km,an);
            listaMasini[i]= masini;
        }
        return listaMasini;
    }




}
