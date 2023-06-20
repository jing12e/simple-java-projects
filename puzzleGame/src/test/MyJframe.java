package test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyJframe extends JFrame implements ActionListener {
    JButton jtb1 = new JButton("sign in");
    JButton jtb2 = new JButton("sign up");



    public MyJframe() {
        //Set the width and height of the interface
        this.setSize(603, 680);
        //set the title of the interface
        this.setTitle("Free Jigsaw Puzzles");
        // set the interface to the top
        this.setAlwaysOnTop(true);
        // center the interface
        this.setLocationRelativeTo(null);
        // set the default close operation of the interface: EXIT_ON_CLOSE
        this.setDefaultCloseOperation(3);

        //cancel the default layout:center
        this.setLayout(null);


        jtb1.addActionListener(this);
        jtb1.setBounds(0,0,100,50);

        jtb2.addActionListener(this);
        jtb2.setBounds(500,0,100,50);

        this.getContentPane().add(jtb1);
        this.getContentPane().add(jtb2);

        this.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == jtb1) {
            System.out.println("sign in");
            jtb1.setSize(200,200);
        } else if (source == jtb2) {
            System.out.println("sign up");
            Random r = new Random();
            jtb2.setLocation(r.nextInt(500), r.nextInt(500));
        }



    }
}
