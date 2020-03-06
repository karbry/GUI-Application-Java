/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.awt.*;
import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JComponent;
import java.util.stream.Collectors;
import java.util.List;
import java.util.stream.IntStream;
import javax.swing.JList;



class NewClass {
    double BMR=0;
    double BMI=0;
    String rodzajbmi="";
    int sum=0;
    ArrayList<Integer> list = new ArrayList<>();
        
        
    public static void main(String[] args){
        NewClass programm = new NewClass();
        programm.start();
    } 
    
    
    public void start() {    
   
    
    JFrame f= new JFrame("Doradca zywieniowy");
    f.getContentPane().setBackground(Color.lightGray);
    // lista
    DefaultListModel<String> model = new DefaultListModel<>();
    JList<String> list1 = new JList<>( model );
    list1.setBounds(300, 340, 100, 200);
    DefaultListModel<String> model2 = new DefaultListModel<>();
    JList<String> list2 = new JList<>( model2 );
    list2.setBounds(400, 340, 100, 200);
    //wybor ilosci aktywnosci fizycznej
    String[] aktywnosc = { "Brak aktywnosci fizycznej", "Ćwiczenia 1-3 razy tygodniowo", "Ćwiczenia 3-5 razy tygodniowo", "Ćwiczenia codziennie" };
    JComboBox akt = new JComboBox(aktywnosc);
    akt.setBounds(10, 185, 200, 30);
    akt.setBackground(Color.WHITE);
    // labele, buttony i text fieldy
    JLabel l1, l2, l3, l4, l5, l6,l7,l8,l9,l10,l11,l12;
    JTextField t1,t2,t3,t4,t5,t6;
    JButton b1,b2, b3;
    
    // wybor plci
    JRadioButton k = new JRadioButton("kobieta");
    k.setSelected(true);
    JRadioButton m = new JRadioButton("mężczyzna");
    ButtonGroup group = new ButtonGroup();
    group.add(k);group.add(m);
    k.setBounds(10, 150, 80, 30);
    k.setBackground(Color.lightGray);
    m.setBounds(90, 150, 100, 30);
    m.setBackground(Color.lightGray);
    // deklaracja label, button i textfield
    l1=new JLabel ("Oblicz BMI i BMR");
    l1.setBounds(10,10,200,30);
    l1.setFont(new Font("TimesRoman", Font.PLAIN, 13));
    l1.setForeground(Color.red);
    l7=new JLabel("wiek");
    l7.setBounds(10, 50, 70, 30);
    t1=new JTextField("");  
    t1.setBounds(80,50, 100,30);
    t2=new JTextField(""); 
    l8=new JLabel("waga(kg)");
    l8.setBounds(10,80,70,30);
    t2.setBounds(80,80, 100,30);
    t3=new JTextField(""); 
    l9=new JLabel("wzrost(cm)");
    l9.setBounds(10,110,70,30);
    t3.setBounds(80,110, 100,30);
    b1=new JButton("Zatwierdz");
    b1.setBounds(10, 220, 150, 30);
    b1.setBackground(Color.GREEN.brighter());
    b1.setForeground(Color.WHITE);
    l2=new JLabel("");
    l2.setBounds(10, 250, 800, 30);
    l3=new JLabel("");
    l3.setBounds(10, 280, 800, 30);
    l4=new JLabel("Oblicz łączną ilość spożytych kcal");
    l4.setBounds(10, 320, 800, 30);
    l4.setForeground(Color.red);
    l4.setFont(new Font("TimesRoman", Font.PLAIN, 13)); 
    t4=new JTextField("");
    t4.setBounds(100, 350, 150, 30);
    l10=new JLabel("Nazwa");
    l10.setBounds(10,350,90,30);
    t5=new JTextField("");
    t5.setBounds(100, 380, 150, 30);
    l11=new JLabel("kcal/100g");
    l11.setBounds(10, 380, 90, 30);
    t6=new JTextField("");
    t6.setBounds(100, 410, 150, 30);
    l12=new JLabel("spożyte gramy");
    l12.setBounds(10,410,90,30);
    b2=new JButton("Oblicz");
    b2.setBounds(10, 450, 150, 30);
    b2.setBackground(Color.BLUE.brighter());
    b2.setForeground(Color.WHITE);
    l5=new JLabel("");
    l5.setBounds(10, 480, 200, 30);
    l6=new JLabel("");
    l6.setBounds(10, 510, 200, 30);
    b3=new JButton("Wyczyść");
    b3.setBackground(Color.BLACK.brighter());
    b3.setForeground(Color.WHITE);
    b3.setBounds(160, 450, 90, 30);
    //akcja po wcisnieciu b1
    b1.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        double wiek; double waga; double wzrost;
        try{
            waga = Double.parseDouble(t2.getText());
        }

        catch (NumberFormatException a) {
          JOptionPane.showMessageDialog(null,
                "Error: Nieprawidłowa waga");
            return;
        }

        try{
            wzrost = Double.parseDouble(t3.getText());
        }

        catch (NumberFormatException a) {
          JOptionPane.showMessageDialog(null,
                "Error: Nieprawidłowy wzrost");
            return;
        }

        try{
            wiek = Double.parseDouble(t1.getText());
        }
        catch (NumberFormatException a) {
          JOptionPane.showMessageDialog(null,
                "Error: Nieprawidłowy wiek");
            return;
        }

        if(k.isSelected()){
            BMR = 10*waga + 6.25*wzrost - 5*wiek - 161;
                if(akt.getSelectedItem()=="Brak aktywnosci fizycznej"){
                    BMR=BMR+250;
                }
                else if (akt.getSelectedItem()=="Ćwiczenia 1-3 razy tygodniowo") {
                    BMR=BMR+550;
                }
                else if (akt.getSelectedItem()=="Ćwiczenia 3-5 razy tygodniowo") {
                    BMR=BMR+900;
                }
                else {
                    BMR=BMR+1100;
                }
            String wynik1 = Double.toString(BMR);
            l3.setText("Twoje dzienne zapotrzebowanie kaloryczne to "+wynik1+"kcal");
            BMI = waga / (wzrost*wzrost)*10000;

            if (BMI<18.50){
                rodzajbmi = "niedowage.";
            }
            else if (BMI<25 && BMI>18.50){
                rodzajbmi = "wage w normie.";
            }
            else {
                rodzajbmi = "nadwage lub otylosc.";
            }
            
            int BMI2 = (int) Math.round(BMI);
            String BMI3 = Integer.toString(BMI2);
            l2.setText("Twoje BMI to "+BMI3+". Oznacza "+rodzajbmi);
        }

        if(m.isSelected()){
            BMR = 10*waga + 6.25*wzrost - 5*wiek + 5;
            if(akt.getSelectedItem()=="Brak aktywnosci fizycznej"){
                    BMR=BMR+400;
                }
                else if (akt.getSelectedItem()=="Ćwiczenia 1-3 razy tygodniowo") {
                    BMR=BMR+950;
                }
                else if (akt.getSelectedItem()=="Ćwiczenia 3-5 razy tygodniowo") {
                    BMR=BMR+1300;
                }
                else {
                    BMR=BMR+1500;
                }
            String wynik2 = Double.toString(BMR);
            l3.setText("Twoje dzienne zapotrzebowanie kaloryczne to "+wynik2+"kcal");
            BMI = waga / (wzrost*wzrost)*10000;

            if (BMI<18.50){
                rodzajbmi = "niedowage.";
            }
            else if (BMI<25 && BMI>18.50){
                rodzajbmi = "wage w normie.";
            }
            else {
                rodzajbmi = "nadwage lub otylosc.";
            }

            int BMI2 = (int) Math.round(BMI);
            String BMI3 = Integer.toString(BMI2);
            l2.setText("Twoje BMI to "+BMI3+". Oznacza "+rodzajbmi);
    }
        f.add(l6);
    }
    });
    //akcja po wcisnieciu b2
    b2.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
        String nazwa; int kcalna100; int gramy; int kcal; 
        
              
 

        try{
            kcalna100 = Integer.parseInt(t5.getText());
        }

        catch (NumberFormatException a) {
          JOptionPane.showMessageDialog(null,
                "Error: Nieprawidłowa wartość");
            return;
        }

        try{
            gramy = Integer.parseInt(
                t6.getText());
        }

        catch (NumberFormatException a) {
          JOptionPane.showMessageDialog(null,
                "Error: Nieprawidłowy wzrost");
            return;
        }
        f.add(list1);
        f.add(list2);
        nazwa = t4.getText();

        kcal = (kcalna100 * gramy) / 100;
        
        
        model.addElement(nazwa + "" );
        
        model2.addElement(kcal + " kalorii" );
        
        
        
        list.add(kcal);

        sum = list.stream().mapToInt(Integer::intValue).sum();
        

        l5.setText("Razem " + sum + " kalorii");
        t4.setText("");
        t5.setText("");
        t6.setText("");
            if(sum<BMR-100){
                l6.setText("Zjadłeś dzisiaj za mało");
            }
            else if(sum<BMR+100){
                l6.setText("Nie jedz nic więcej");
            }
            else {
                l6.setText("Zjadłeś za dużo :(");
            }
    }
});
    
    //akcja po b3
    b3.addActionListener(new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent e) {
       model.clear();
       model2.clear();
       l5.setText("");
       list.clear();
       l6.setText("");
        
    }
    });
    // dodawanie do frame
    f.add(t1); f.add(t2); f.add(l1); f.add(t3); f.add(k); f.add(m); f.add(akt); f.add(b1); f.add(l2); f.add(l3); f.add(l4); f.add(t4);f.add(t5);f.add(t6);f.add(b2);f.add(l5);f.add(l7);f.add(l8);f.add(l9);f.add(l10);f.add(l11);f.add(l12);f.add(b3);
    f.setSize(600,600);  
    f.setLayout(null);  
    f.setVisible(true);  
    }  
    
} 

