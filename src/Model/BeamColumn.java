/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.ControllerData;
import Controller.UIController;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BeamColumn {

    private final int base = 600 - 60;
    private List<Beam> beams;
    private final Random random;
    private int points = 0;
    private int speed = 5;
    private int changeSpeed = 5;

    public BeamColumn() {
        beams = new ArrayList<>();
        random = new Random();
        initColumn();
    }

    private void initColumn() {

        int last = base;
        int randWay = random.nextInt(10);
        ControllerData.setExceedColumn(false);

        for (int i = 0; i < 20; i++) {

            Beam tempBeam = new Beam(900, last);
            tempBeam.setDx(speed);
            last = tempBeam.getY() - tempBeam.getHeight();
            if (i < randWay || i > randWay + 4) {
                beams.add(tempBeam);
            }

        }

    }

    public void tick() {

        speed = ControllerData.getxSpeed();
        for (int i = 0; i < beams.size(); i++) {
            beams.get(i).setDx(speed);
            beams.get(i).tick();

            if (beams.get(i).getX() < 0) {
                beams.remove(beams.get(i));
            }
        }
        if (beams.isEmpty()) {
            this.points += 1;
            if (changeSpeed == points) {
                ControllerData.setxSpeed(ControllerData.getxSpeed()+1);
                changeSpeed += 5;
                /*UIController.helicopterPanel.getCoins().setSpeed(this.speed);*/
            }
            initColumn();
        }

    }

    public void render(Graphics2D g, ImageObserver obs)
    {
        for (int i = 0; i < beams.size(); i++) {
            beams.get(i).render(g, obs);
        }

    }

    public List<Beam> getBeam() {
        return beams;
    }

    public void setBeam(List<Beam> beams) {
        this.beams = beams;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
