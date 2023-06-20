package ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;



public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    int[][] data = new int[4][4];

    //location of blank picture in array
    int x = 0;
    int y = 0;

    //String path = "img\\cat\\cat1\\";
    String path = "img\\dog\\dog1\\";

    int[][] win = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,0}

    };

    //define a variable to count steps
    int step = 0;



    //create JMenuItem
    JMenuItem replayItem = new JMenuItem("Play Again");
    JMenuItem reloginItem = new JMenuItem("Log In Again");
    JMenuItem exitItem = new JMenuItem("Exit");
    JMenuItem aboutItem = new JMenuItem("Github");


    //test if array 'data' as same as array 'win'
    public boolean victory() {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data.length; j++) {
                if (data[i][j] != win[i][j]) {
                    return false;

                }

            }

        }
        return true;

    }


    public GameJFrame() {
        //1. Initialize interface
        initJFrame();

        //2. initialize menu
        initJMenuBar();


        //3.1 initialize data
        initData();

        //3.2 initialize picture
        initImage();


        //Let the interface display, it is recommended to write at the end
        this.setVisible(true);

    }

    private void initData() {
        int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        Random random = new Random();
        for (int i = 0; i < tempArr.length; i++) {
            int index = random.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;

        }


        for (int i = 0; i < tempArr.length; i++) {

            if(tempArr[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
            data[i / 4][i % 4] = tempArr[i];


        }

    }

    private void initImage() {
        //remove all pictures
        this.getContentPane().removeAll();
        if (victory()) {
            JLabel winJlabel = new JLabel(new ImageIcon("C:\\Users\\Administrator\\Desktop\\simple-java-projects\\puzzleGame\\img\\background\\Snipaste_2023-06-20_22-53-38_pixian.png"));
            winJlabel.setBounds(100, 240, 394, 146);
            this.getContentPane().add(winJlabel);
        }

        JLabel stepCount = new JLabel("Step: " + step);
        stepCount.setBounds(50,20,100,20);
        this.getContentPane().add(stepCount);

        //add puzzles
        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 4; j++) {

                int number = data[i][j];

                //create an object of JLabel
                JLabel jLabel = new JLabel(new ImageIcon(path + number + ".jpg"));

                //set the location of the image
                jLabel.setBounds(j * 105 + 83, i * 105 + 134, 105, 105);
                jLabel.setBorder(new BevelBorder(0));

                //add JLabel to the interface
                this.getContentPane().add(jLabel);

            }

        }

        // add background
        ImageIcon bg = new ImageIcon("img\\background\\wepik-export-202306201144190TWL.png");
        JLabel background = new JLabel(bg);
        background.setBounds(40, 40,508,560);
        this.getContentPane().add(background);

        //repaint all pictures
        this.getContentPane().repaint();

    }

    private void initJMenuBar() {
        //set the menu, using JMenuBar, JMenu and JMenuItem
        //create JMenuBar
        JMenuBar jMenuBar = new JMenuBar();

        //create JMenu
        JMenu menu1 = new JMenu("Menu");
        JMenu menu2 = new JMenu("About");

        //add actionlistener
        replayItem.addActionListener(this);
        reloginItem.addActionListener(this);
        exitItem.addActionListener(this);
        aboutItem.addActionListener(this);



        // add jMenu to jMenuBar
        jMenuBar.add(menu1);
        jMenuBar.add(menu2);

        // add jMenuItem to jMenu
        menu1.add(replayItem);
        menu1.add(reloginItem);
        menu1.add(exitItem);
        menu2.add(aboutItem);
        //set JMenuBar
        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
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

        // add keylistener
        this.addKeyListener(this);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(victory()) {
            //stop method
            return;
        }
        int code = e.getKeyCode();
        if(code == 65) {
            //remove all
            this.getContentPane().removeAll();

            //add whole picture
            JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
            all.setBounds(83, 134, 420, 420);
            this.getContentPane().add(all);

            JLabel stepCount = new JLabel("Step: " + step);
            stepCount.setBounds(50,20,100,20);
            this.getContentPane().add(stepCount);

            //add background
            ImageIcon bg = new ImageIcon("img\\background\\wepik-export-202306201144190TWL.png");
            JLabel background = new JLabel(bg);
            background.setBounds(40, 40,508,560);
            this.getContentPane().add(background);
            this.getContentPane().repaint();

        }


    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(victory()) {
            //stop method
            return;
        }
        //left:37 up:38 right:39 down:40
        //sout (code)
        int code = e.getKeyCode();
        if (code == 37) {
            if (y == 0) {
                return;
            }
            data[x][y] = data[x][y - 1];
            data[x][y - 1] = 0;
            y--;

            step++;

            initImage();

        } else if (code == 38) {
            if (x == 0) {
                return;
            }
            data[x][y] = data[x - 1][y];
            data[x - 1][y] = 0;
            x--;

            step++;

            initImage();


        } else if (code == 39) {
            if (y == 3) {
                return;
            }
            data[x][y] = data[x][y + 1];
            data[x][y + 1] = 0;
            y++;

            step++;

            initImage();

        } else if (code == 40) {
            if (x == 3) {
                return;
            }
            data[x][y] = data[x + 1][y];
            data[x + 1][y] = 0;
            x++;

            step++;

            initImage();

        } else if (code == 65) {
            initImage();

        } else if (code == 87) {

            data = new int[][]{
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,0}

            };

            initImage();

        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if(obj == replayItem){
            step = 0;
            initData();
            initImage();


        } else if (obj == reloginItem) {
            this.setVisible(false);
            new LoginJFrame();

        } else if (obj == exitItem) {
            System.exit(0);

        } else if (obj == aboutItem) {
            JDialog jDialog = new JDialog();
            JLabel jLabel = new JLabel("https://github.com/jing12e");

            jDialog.getContentPane().add(jLabel);
            jDialog.setSize(200,100);
            jDialog.setAlwaysOnTop(true);
            jDialog.setLocationRelativeTo(null);
            jDialog.setModal(true);
            jDialog.setTitle("My Github");
            jDialog.setVisible(true);



        }


    }
}
