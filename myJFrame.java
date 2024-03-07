package com.mason.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class myJFrame extends JFrame implements ActionListener {

    JButton btn1 = new JButton("try");

    JButton btn2 = new JButton("try2");
    public myJFrame() {
        JFrame testWindow2 = new JFrame();
        testWindow2.setSize(400, 400);
        testWindow2.setTitle("Button");
        testWindow2.setAlwaysOnTop(true);
        testWindow2.setLocationRelativeTo(null);
        testWindow2.setDefaultCloseOperation(3);
        testWindow2.setLayout(null);

        btn1.setBounds(0,0,100,50);
        btn1.addActionListener(this);

        btn2.setBounds(100,0,100,50);
        btn2.addActionListener(this);

        testWindow2.getContentPane().add(btn1);
        testWindow2.getContentPane().add(btn2);

        testWindow2.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == btn1){
            btn1.setSize(200,30);
        } else if (source == btn2) {
            Random r = new Random();
            btn2.setLocation(r.nextInt(400), r.nextInt(400));
        }
    }
}

