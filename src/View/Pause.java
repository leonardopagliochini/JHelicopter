/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Controller.GameController;
import Controller.UIController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author pagli
 */
public class Pause extends javax.swing.JPanel {

    /**
     * Creates new form GameOver
     */
    public Pause() {

        this.setBackground(new Color(180,201,202));
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startButton = new javax.swing.JButton();
        playAgainButton = new javax.swing.JButton();
        logoLabel = new javax.swing.JLabel();

        setBackground(new java.awt.Color(180, 201, 202));

        startButton.setBackground(new java.awt.Color(0, 0, 0));
        startButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/MenuIcons/icons8-menu-60.png"))); // NOI18N
        startButton.setBorderPainted(false);
        startButton.setOpaque(false);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIController.backFromPause();
            }
        });

        playAgainButton.setBackground(new java.awt.Color(0, 0, 0));
        playAgainButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/MenuIcons/icons8-play-60.png"))); // NOI18N
        playAgainButton.setBorderPainted(false);
        playAgainButton.setOpaque(false);
        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UIController.resume();
                GameController.resumeGame();
            }
        });

        logoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Backgrounds/pausa.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(113, 113, 113)
                .addComponent(startButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(playAgainButton)
                .addGap(89, 89, 89))
            .addGroup(layout.createSequentialGroup()
                .addComponent(logoLabel)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(logoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(startButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(playAgainButton, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(88, 88, 88))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_startButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel logoLabel;
    private javax.swing.JButton playAgainButton;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}