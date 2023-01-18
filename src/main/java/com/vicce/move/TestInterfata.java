package com.vicce.move;
import java.util.ArrayList;
import javax.swing.*;


public class TestInterfata {
    public static ArrayList<VehiculMMotorina> listaInitvehicule;
    public static ArrayList<VehiculMMotorina> listaVehicule;

    TestInterfata(){
        JFrame frame=new JFrame();
      
        JLabel nr=new JLabel("Nr. masini:");
        nr.setBounds(20,20,80,20);
      
        JTextField nrTF= new JTextField();
        nrTF.setBounds(120,20,100,20);
      
        JButton genereazaBT= new JButton("Genereaza date");
        genereazaBT.setBounds(20,50,200,30);
        genereazaBT.addActionListener(new ActionListnerGenerareDate(nrTF));
      
      
        JLabel putereM = new JLabel("Putere:");
        putereM.setBounds(20,100,80,20);
      
        JTextField putereMTF = new JTextField();
        putereMTF.setBounds(20,130,200,30);
      
        JButton putereMBT= new JButton("Filtreaza dupa putere ");
        putereMBT.setBounds(20,130,200,30);
        putereMBT.addActionListener(new ActionLisnerFiltrareDate(putereMTF));
      
        frame.add(nr);
        frame.add(nrTF);
        frame.add(genereazaBT);
      
        frame.add(putereM);
        frame.add(putereMTF);
        frame.add(putereMBT);
      
        frame.setSize(255,250);
        frame.setTitle("Masini Motorina");
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setResizable(false);
      
      }
        public static void main(String[] args){
          TestInterfata first= new TestInterfata();
        }
      }
    
    

