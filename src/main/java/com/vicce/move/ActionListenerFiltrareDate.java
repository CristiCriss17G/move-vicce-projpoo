package com.vicce.move;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class ActionListenerFiltrareDate implements ActionListener {

    private JTextField jtext;

    public ActionListenerFiltrareDate(JTextField jtext){
        this.jtext=jtext;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        TestareInterfata.listaMasini=FiltrareMasini.filtreazaDupaCapacitate(TestareInterfata.listaVehicule, 1600, Integer.parseInt(jtext.getText()));
        System.out.println("Date filtrate ");
        System.out.println(TestareInterfata.listaMasini);
    }

}
