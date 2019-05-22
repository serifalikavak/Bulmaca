package controller;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import static java.util.Collections.shuffle;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author serifalikavak
 */
public class KutuTuretici {

    private JTextField kutuAdet;
    private JPanel jPanel1;
    private JButton btnBaslat;
    private JComboBox jComboBox1;
    private int adet;
    private JToggleButton[] btnKutu;
    private ArrayList<Integer> sayilar = new ArrayList<Integer>();
    static int kontrolcu = 0;
    private JLabel jLabel6;
    private JLabel jLabel3;
    Zamanlayici zn;
    static int sayac = 0;

    public KutuTuretici(JPanel jPanel1, JTextField kutuAdet, JComboBox jComboBox1, JLabel jLabel6, JButton btnBaslat, JLabel jLabel3) {
        this.jPanel1 = jPanel1;
        this.kutuAdet = kutuAdet;
        this.jComboBox1 = jComboBox1;
        this.jLabel6 = jLabel6;
        this.btnBaslat = btnBaslat;
        this.jLabel3 = jLabel3;
        String str = jComboBox1.getSelectedItem().toString();

        adet = Integer.parseInt(kutuAdet.getText());
        if (Integer.parseInt(kutuAdet.getText()) % 2 == 0) {
            btnKutu = new JToggleButton[Integer.parseInt(kutuAdet.getText())];
        } else {
            btnKutu = new JToggleButton[Integer.parseInt(kutuAdet.getText() + 1)];
        }
        if (adet % 2 == 1) {
            adet = (adet + 1);
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < (adet / 2) + 1; j++) {
                sayilar.add(j);
            }
        }
        shuffle(sayilar);

        Listener lr = new Listener(this.btnKutu, this.sayilar, this.jLabel6);
        for (int i = 0; i < adet; i++) {
            btnKutu[i] = new JToggleButton("      ");
            btnKutu[i].setFont(new Font("Serif", Font.BOLD, 28));
            btnKutu[i].addActionListener(lr);

        }
        zn = new Zamanlayici(this.jLabel3, btnKutu, this.btnBaslat);

        if (str.toString() == "GridLayout") {
            jPanel1.setLayout(new GridLayout(2, 2));
        }
        if (str.toString() == "FlowLayout") {
            jPanel1.setLayout(new FlowLayout());
        }
        for (int i = 0; i < adet; i++) {
            if (kontrolcu < 1) {
                jPanel1.add(btnKutu[i]);
            }
        }
        jPanel1.validate();
        jPanel1.repaint();
        kontrolcu = 1;
    }

    public void resetBox() {
        zn.textSet();
    }

    public void timer() {
        zn.timer();
    }
}
