package br.ufrn.imd.ui;

import javax.swing.*;

public class UI {
    public JFrame CreateUI(){
        JFrame frame = new JFrame();
        frame.setTitle("Average Fuel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setSize(800,600);

        return frame;
    }
}
