package Controller;

import View.Sounds.JumpSound;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameKeyController extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            GameController.restartGame();
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE && ControllerData.isIsRunning()) {
            JumpSound.play();
        }
        if (e.getKeyCode() == KeyEvent.VK_P && ControllerData.isIsRunning()) {
            UIController.pause();
            GameController.stopGame();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE && ControllerData.isIsRunning()) {
            UIController.helicopterPanel.getHelicopter().jump();
        }
    }

}
