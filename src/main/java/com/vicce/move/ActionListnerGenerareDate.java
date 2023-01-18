package com.vicce.move;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import com.vicce.move.GeneratorElectric;

public class ActionListnerGenerareDate implements ActionListener{

  private JTextField jtext;
  public ActionListnerGenerareDate(JTextField jtext){
    this.jtext=jtext;
  }
  @Override
  public void actionPerformed(ActionEvent e) {
    InterfataG.listaMasini=GeneratorElectric.genereazaRandomMasini(Integer.parseInt(jtext.getText()));
    System.out.println(InterfataG.listaMasini);
  } 
  
}
