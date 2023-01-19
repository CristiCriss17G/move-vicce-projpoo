package com.vicce.move;

import java.util.ArrayList;
import javax.swing.*;

import com.vicce.move.ActionListnerGenerareDate;


public class InterfataG {
  public static ArrayList<VehiculMElectric>listaMasini;
  public static ArrayList<VehiculMElectric>listaMasiniFiltrata;

InterfataG(){
  JFrame frame=new JFrame();

  JLabel nr=new JLabel("Numarul de masici:");
  nr.setBounds(20,20,80,20);

  JTextField nrTF= new JTextField();
  nrTF.setBounds(120,20,100,20);

  JButton genereazaBT= new JButton("Export date:");
  genereazaBT.setBounds(20,50,200,30);
  genereazaBT.addActionListener(new ActionListnerGenerareDate(nrTF));


  JLabel capacitateM = new JLabel("Capacitatea:");
  capacitateM.setBounds(20,100,80,20);

  JTextField capacitateMTF = new JTextField();
  capacitateMTF.setBounds(120,100,100,20);

  JButton capacitateMBT= new JButton("Filtreaza capacitatea:");
  capacitateMBT.setBounds(20,130,200,30);
  capacitateMBT.addActionListener(new ActionListenerFiltrareDate(capacitateMTF));

  frame.add(nr);
  frame.add(nrTF);
  frame.add(genereazaBT);

  frame.add(capacitateM);
  frame.add(capacitateMTF);
  frame.add(capacitateMBT);

  frame.setSize(350,350);
  frame.setTitle("Electric cars");
  frame.setLayout(null);
  frame.setVisible(true);
  frame.setResizable(false);

}
  public static void main(String[] args){
    InterfataG first= new InterfataG();
  }
}
