package Controller;

import View.Sounds.CoinMusic;
import View.Sounds.GameMusic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TimeController implements ActionListener {

    public void start() {
        Timer timer = new Timer(15, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Toolkit.getDefaultToolkit().sync();
        if (ControllerData.isIsRunning()) {
            ////////////////////////////////
            UIController.helicopterPanel.getCoins().tick();
            UIController.helicopterPanel.getHelicopter().tick();
            UIController.helicopterPanel.getBeamColumn().tick();
            if (!ControllerData.isExceedColumn())
                CollisionController.checkBeamExceed();

            if (ControllerData.isBeamCollision()) {
                GameController.endGame();
                ControllerData.setBeamCollision(false);
            }
            if (!ControllerData.isEndingGame())
                CollisionController.checkCollision();
            ControllerData.setScore(UIController.helicopterPanel.beamColumn.getPoints());
            if (ControllerData.isCoinIntersect() && !ControllerData.isPaused()) {
                ControllerData.incrementCoinMstimer();
                AnimationController.CoinRotation(ControllerData.getCoinMstimer());
                ControllerData.setCointime(ControllerData.getCointime() - 0.015);
            } else if(!ControllerData.isCoinIntersect() && !ControllerData.isPaused()) {
                ControllerData.setCoinMstimer(0);
                ControllerData.setCointime(8);
            }
            if (ControllerData.getCointime()<=0)
            {
                ControllerData.setCoinIntersect(false);
                CoinMusic.stop();
                GameMusic.play();
            }

            if (ControllerData.isEndingGame())
            {
                ControllerData.incrementExplosionMstimer();
                AnimationController.Explosion(ControllerData.getExplosionMstimer());
            }
            UIController.helicopterPanel.repaint();
        }
    }
}
