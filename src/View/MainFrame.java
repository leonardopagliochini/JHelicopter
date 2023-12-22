package View;

import javax.swing.*;

public class MainFrame extends JFrame {

     public MainFrame()
     {
         super("JHelicopter");
         pack();
         setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
         setTitle("JHelicopter");
         setSize(800,600);
         setVisible(true);
         setResizable(false);
         setLocationRelativeTo(null);
     }

}
