package com.vicce.move;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

import com.vicce.move.FiltruElectric;

public class ActionListenerFiltrareDate implements ActionListener {
  private JTextField jtex;
  public ActionListenerFiltrareDate(JTextField jtext){
    this.jtex=jtext;
  }


  @Override
  public void actionPerformed(ActionEvent e) {
    // TODO Auto-generated method stub
    InterfataG.listaMasiniFiltrata=FiltruElectric.filtreazaDupaAutonomie(InterfataG.listaMasini,Integer.parseInt(jtex.getText()));
    System.out.println("Date Filtrate");
    System.out.println(InterfataG.listaMasiniFiltrata);
    
  }
  
}
