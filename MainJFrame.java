package com.mason.ui;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class MainJFrame extends JFrame implements KeyListener {

    int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

    Random ram = new Random ();

    int steps = 0;

    public MainJFrame (){

        initWindow();

        initMenu();

        initImage();

        this.setVisible (true);
    }


    private void initImage() {

        JLabel stepCount = new JLabel("Steps: " + steps);
        stepCount.setBounds(0, 0, 500, 25);
        this.getContentPane().add(stepCount);

        //打乱arr数组的顺序
        for (int i = 0; i < arr.length; i++) {
            int index1 = ram.nextInt(arr.length);
            int temp = arr[i];
            arr[i] = arr[index1];
            arr[index1] = temp;
        }

        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            ImageIcon pic = new ImageIcon ("src/Images/Me/" + temp + ".jpeg");
            JLabel picLabel = new JLabel(pic);
            if (i <= 2){
                picLabel.setBounds(256*(i), 25, 256, 256);
            } else if (i <= 5) {
                picLabel.setBounds(256*(i-3), 256 + 25, 256, 256);
            } else {
                picLabel.setBounds(256*(i-6), 256 * 2 + 25, 256, 256);
            }
            this.getContentPane().add(picLabel);
            }
    }

    private void initMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu options = new JMenu("Options");
        JMenu about = new JMenu("About");

        JMenu changePic = new JMenu("Change pictures");
        JMenu restart = new JMenu("Restart");
        JMenu reLogin = new JMenu("Relogin");
        JMenu quit = new JMenu("quit");

        JMenu scan = new JMenu("Wechat");

        options.add(changePic);
        options.add(restart);
        options.add(reLogin);
        options.add(quit);

        about.add(scan);

        menuBar.add(options);
        menuBar.add(about);

        this.setJMenuBar(menuBar);
    }

    private void initWindow() {
        this.setSize(256*3, 256*3 + 75);
        this.setTitle("Jigsaw");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(3);
        this.setLayout(null);
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int findBlank = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 9){
                findBlank = i;
            }
        }
        int input = e.getKeyCode();
        if(input == 37 && (findBlank != 0 && findBlank != 3 && findBlank != 6)){
            arr[findBlank] = arr[findBlank - 1];
            arr[findBlank - 1] = 9;
            steps++;
        } else if (input == 38 && (findBlank != 0 && findBlank != 1 && findBlank != 2)) {
            arr[findBlank] = arr[findBlank - 3];
            arr[findBlank - 3] = 9;
            steps++;
        } else if (input == 39 && (findBlank != 2 && findBlank != 5 && findBlank != 8)) {
            arr[findBlank] = arr[findBlank + 1];
            arr[findBlank + 1] = 9;
            steps++;
        } else if (input == 40 && (findBlank != 6 && findBlank != 7 && findBlank != 8)) {
            arr[findBlank] = arr[findBlank + 3];
            arr[findBlank + 3] = 9;
            steps++;
        }
        this.getContentPane().removeAll();
        JLabel stepCount = new JLabel("steps: " + steps);
        stepCount.setBounds(0, 0, 500, 25);
        this.getContentPane().add(stepCount);
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            ImageIcon pic = new ImageIcon ("src/Images/Me/" + temp + ".jpeg");
            JLabel picLabel = new JLabel(pic);
            if (i <= 2){
                picLabel.setBounds(256*(i), 25, 256, 256);
            } else if (i <= 5) {
                picLabel.setBounds(256*(i-3), 256 + 25, 256, 256);
            } else {
                picLabel.setBounds(256*(i-6), 256 * 2 +25, 256, 256);
            }
            this.getContentPane().add(picLabel);
            this.getContentPane().repaint();
        }
    }
}
