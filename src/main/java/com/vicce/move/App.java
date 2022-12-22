package com.vicce.move;
import java.util.ArrayList;
import java.util.Iterator;


public class App {
    public static void main(String[] args) {

        //Testare tema 3

        VehiculMBenzina v1= new VehiculMBenzina(200,7000,4,5,250,1600,"VW Golf 5",2015,9.8);
        VehiculMBenzina v2= new VehiculMBenzina(250,8000,4,5,143,1968,"Audi A3",2008,5.6);
        VehiculMBenzina v3= new VehiculMBenzina(180,6000,4,5,150,1595,"Ford Focus", 2012,5.6);
        VehiculMBenzina v4= new VehiculMBenzina();
        VehiculMBenzina v5= new VehiculMBenzina(220,12000,4,5,170,1995,"BMW Seria 3",2014,7.1);
        VehiculMBenzina v6= new VehiculMBenzina(v2);
        VehiculMBenzina v7= new VehiculMBenzina(200,15400,4,5,123,1598,"Hyundai Elantra",2019,7.2);
        VehiculMBenzina v8= new VehiculMBenzina(170,4200,4,5,85,1400,"Citroen C3",2007,6.3);
        VehiculMBenzina v9= new VehiculMBenzina(v5);
        VehiculMBenzina v10= new VehiculMBenzina(220,11350,4,5,160,1798,"Skoda Superb",2014,10.4);


        ArrayList<VehiculMBenzina> masini =new ArrayList<VehiculMBenzina>(10);
        masini.add(v1);
        masini.add(v2);
        masini.add(v3);
        masini.add(v4);
        masini.add(v5);
        masini.add(v6);
        masini.add(v7);
        masini.add(v8);
        masini.add(v9);
        masini.add(v10);

        //Afisare elemente din vector (forEach loop)

        for(VehiculMBenzina i:masini){
            System.out.println(i.toString());
        }
        
        //Afisare elemente din vector cu Iterator

        System.out.println("\n");
        Iterator<VehiculMBenzina> itr=masini.iterator();

        while(itr.hasNext()){
            VehiculMBenzina obj=itr.next();
            System.out.println(obj.toString());
        }

        //Testare generator 

        ArrayList<VehiculMBenzina> listaVehicule = Generator.genereazaRandomMasini(10);		
		System.out.println("\nlista de masini:");
		System.out.println(listaVehicule);
		
		System.out.println("\nfolosim for each pe lista");
		for(VehiculMBenzina masina:listaVehicule)
			System.out.println(masina);
		
		System.out.println("\nfolosim for old style pe lista");
		for(int i=0;i<listaVehicule.size();i++)
			System.out.println(listaVehicule.get(i));

        

        //Testare tema 4
       
        System.out.print("\n");
        System.out.println("Filtrare dupa capacitatea motorului:\n");
        FiltrareMasini.filtreazaDupaCapacitate(masini,1200,3000);
        System.out.println("\nFiltrare dupa model:\n");
        FiltrareMasini.filtreazaDupaModel(masini,"BMW Seria 3");
        

    }
}
