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

        JButton genereazaBT =new JButton("Genereaza masini");
        genereazaBT.setBounds(20,50,200,30);
        genereazaBT.addActionListener(new ActionListenerGenerareDate(nrTF));


        JLabel model = new JLabel("Model:");
		model.setBounds(20, 100, 80, 20);	
	
		JTextField modelTF = new JTextField();
		modelTF.setBounds(120, 100, 100, 20);

		JButton modelBT = new JButton("Filtreaza dupa model: ");
		modelBT.setBounds(20, 130, 200, 30);	
		modelBT.addActionListener(new ActionListenerFiltrareDate(modelTF));
		
		
		frame.add(nr);				
		frame.add(nrTF);
		frame.add(genereazaBT);
		
		frame.add(model);
		frame.add(modelTF);
		frame.add(modelBT);

		
		frame.setSize(300, 250);
		frame.setTitle("Vehicule cu motor pe benzina");
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
	}

	public static void main(String[] args) {
		TestareInterfata i1 = new TestareInterfata();
	}

    
}