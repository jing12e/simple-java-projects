package ui;

import javax.swing.*;

public class LoginJFrame extends JFrame {

    public LoginJFrame() {
        this.setSize(488, 430);
        //set the title of the interface
        this.setTitle("Log In");
        // set the interface to the top
        this.setAlwaysOnTop(true);
        // center the interface
        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(3);

        this.setVisible(true);
    }
}
