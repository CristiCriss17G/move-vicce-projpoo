package com.vicce.move;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;


public class ActionListenerGenerareDate implements ActionListener{
    
    private JTextField jtext;

    public ActionListenerGenerareDate(JTextField jtext){
        this.jtext=jtext;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        TestareInterfata.listaVehicule=Generator.genereazaRandomMasini(Integer.parseInt(jtext.getText()));
        System.out.println(TestareInterfata.listaVehicule);
    }

}
