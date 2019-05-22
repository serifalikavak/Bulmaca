/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author serifalikavak
 */
public class OyunKontrol {
    private int sayac3;
    private int sayac2;
    private int btnLength;
    public static int x;
    public static int skorArtis = 0;
    public static int skorAzalis = 0;
    private JLabel jLabel6;
    Zamanlayici zn;
    public OyunKontrol(int sayac3,int sayac2,JLabel jLabel6,int btnLength) {
        this.sayac3=sayac3;
        this.sayac2=sayac2;
        this.jLabel6=jLabel6;
        this.btnLength=btnLength;
    }
    
    public void OyunBitti(){
        if(sayac3 + 1 ==(btnLength/2))
            sayac2++;
        if(sayac2 == 2){
            x=1;
            JOptionPane.showMessageDialog(null, "Oyun Bitti");
            int skor=(skorArtis-skorAzalis)*btnLength;
            jLabel6.setText(Integer.toString(skor));
           
        }
    }
    
}
