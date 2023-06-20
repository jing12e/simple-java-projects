package test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test4 extends JFrame {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(603, 680);
        //set the title of the interface
        jFrame.setTitle("Free Jigsaw Puzzles");
        // set the interface to the top
        jFrame.setAlwaysOnTop(true);
        // center the interface
        jFrame.setLocationRelativeTo(null);
        // set the default close operation of the interface: EXIT_ON_CLOSE
        jFrame.setDefaultCloseOperation(3);

        //cancel the default layout:center
        jFrame.setLayout(null);

        JButton jtb = new JButton("Sign in");
        jtb.setBounds(0, 0, 100, 50);
        jtb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("sign in");
            }
        });


        jFrame.getContentPane().add(jtb);
        jFrame.setVisible(true);
    }

}
