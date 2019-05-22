/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JToggleButton;
import javax.swing.Timer;

/**
 *
 * @author serifalikavak
 */
public class Zamanlayici {

    private JLabel jLabel3;
    private JToggleButton[] btnKutu;
    private JButton btnBaslat;
    private Timer timer = null;
            private int saniye = 0;
            private int dakika = 0;
            private int saat = 0;
            
        
    public Zamanlayici(JLabel jLabel3,JToggleButton[] btnKutu,JButton btnBaslat){
        this.jLabel3=jLabel3;
        this.btnBaslat=btnBaslat;
        this.btnKutu=btnKutu;
    }
    public void textSet() {
       for (int i = 0; i < btnKutu.length; i++) {
            btnKutu[i].setText("     ");
        }
 
    }
    
    public void timer(){
        btnBaslat.setEnabled(false);
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
      //           System.out.println("test");
                
            String str1 = "0"+saat+":"+dakika+":"+saniye;
            String str2 = "0"+saat+":"+dakika+":0"+saniye;
            String str3 = "0"+saat+":0"+dakika+":"+saniye;
            String str4 = "0"+saat+":0"+dakika+":0"+saniye;
                
                saniye++;
                if (saniye ==60){
                    saniye = 0;
                    dakika++;
                }
                else if (dakika == 60){
                    dakika = 0;
                    saat++;
                }
                if (dakika >=10){
                    if (saniye >=10){
                       jLabel3.setText(str1);
                    }else{
                       jLabel3.setText(str2);
                    }
                }else {
                    if(saniye >=11){
                        jLabel3.setText(str3);
                    }else{
                        jLabel3.setText(str4);
                    }
                }
            }
        });
        timer.start();
    }

}
