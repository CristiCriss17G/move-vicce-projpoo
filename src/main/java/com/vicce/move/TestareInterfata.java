package com.vicce.move;

import java.util.ArrayList;
import javax.swing.*;


public class TestareInterfata {
    public static ArrayList<VehiculMBenzina> listaVehicule;
    public static ArrayList<VehiculMBenzina> listaMasini;

    TestareInterfata(){
        JFrame frame =new JFrame();

        JLabel nr=new JLabel("Nr. masini:");
        nr.setBounds(20,20,80,20);

        JTextField nrTF =new JTextField();
        nrTF.setBounds(120,20,100,20);

        JButton genereazaBT =new JButton("Genereaza date");
        genereazaBT.setBounds(20,50,200,30);
        genereazaBT.addActionListener(new ActionListenerFiltrareDate(nrTF));


        JLabel capacitate = new JLabel("Capacitate motor:");
		capacitate.setBounds(20, 100, 80, 20);	
	
		JTextField capacitateTF = new JTextField();
		capacitateTF.setBounds(120, 100, 100, 20);

		JButton capacitateBT = new JButton("Filtreaza dupa capacitate: ");
		capacitateBT.setBounds(20, 130, 200, 30);	
		capacitateBT.addActionListener(new ActionListenerFiltrareDate(capacitateTF));
		
		
		frame.add(nr);				
		frame.add(nrTF);
		frame.add(genereazaBT);
		
		frame.add(capacitate);
		frame.add(capacitateTF);
		frame.add(capacitateBT);
		
		frame.setSize(255, 250);
		frame.setTitle("Vehicule cu motor pe benzina");
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestareInterfata i1 = new TestareInterfata();
	}

    
}
