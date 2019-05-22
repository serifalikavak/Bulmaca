/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JToggleButton;

/**
 *
 * @author serifalikavak
 */
public class Listener implements ActionListener{
    
    private JToggleButton[] btnKutu;
     private int[] btnId = new int[2];
    private int[] btnDeger = new int[2];
    private ArrayList<Integer> sayilar = new ArrayList<Integer>();
    private JLabel jLabel6;
    private int btnLength;
    private int sayac3 = 0;
    private int sayac2 = 0;
    private int sayac = 0;
    OyunKontrol oyun;
    
    public Listener(JToggleButton[] btnKutu,ArrayList<Integer> sayilar,JLabel jLabel6){
        this.btnKutu=btnKutu;
        this.sayilar=sayilar;
        this.jLabel6=jLabel6;
        this.btnLength=this.btnKutu.length;
    }
    

 @Override
        public void actionPerformed(ActionEvent e) {
            oyun = new OyunKontrol(sayac3, sayac2, jLabel6,btnLength);
            for (int i = 0; i < btnKutu.length; i++) {
                if (btnKutu[i] == e.getSource()) {
                    btnKutu[i].setText("    " + sayilar.get(i) + "    ");
                    btnKutu[i].setEnabled(false);
                    btnKutu[i].setSelected(true);
                    sayac++;
                    if (sayac == 3) {
                        if (SayiKarsilastir()) {
                            btnKutu[btnId[0]].setEnabled(false);
                            btnKutu[btnId[1]].setEnabled(false);
                            btnKutu[btnId[0]].setSelected(false);
                            btnKutu[btnId[1]].setSelected(false);
                            oyun.skorArtis=oyun.skorArtis+50;
                        } else {
                            btnKutu[btnId[0]].setEnabled(true);
                            btnKutu[btnId[0]].setText("");
                            btnKutu[btnId[1]].setEnabled(true);
                            btnKutu[btnId[1]].setText("");
                            btnKutu[btnId[0]].setSelected(false);
                            btnKutu[btnId[1]].setSelected(false);
                            oyun.skorAzalis=oyun.skorAzalis+20;
                        }
                        sayac = 1;
                    }
                    if (sayac == 1) {
                        btnId[0] = i;
                        btnDeger[0] = sayilar.get(i);
                    }
                    if (sayac == 2) {
                        btnId[1] = i;
                        btnDeger[1] = sayilar.get(i);
                    }

                }
                oyun.OyunBitti();
            }
        }
 public boolean SayiKarsilastir() {
            if (btnDeger[0] == btnDeger[1]) {
                sayac3++;
            return true;
        } else {
            return false;
        }
    }
    
}
