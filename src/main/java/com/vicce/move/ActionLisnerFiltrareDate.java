package com.vicce.move;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;



public class ActionLisnerFiltrareDate implements ActionListener{

	private JTextField jtext;
	
	public ActionLisnerFiltrareDate(JTextField jtext) {
		this.jtext=jtext;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		TestInterfata.listaInitvehicule = FiltrareMasini.filtreazaDupaPutere(TestInterfata.listaVehicule,Integer.parseInt(jtext.getText()));	
		System.out.println(" Date filtrate ");
		System.out.println(TestInterfata.listaInitvehicule);
	}
}