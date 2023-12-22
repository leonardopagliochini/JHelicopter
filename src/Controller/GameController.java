package Controller;

import Model.BeamColumn;
import Model.Coins;
import Model.Helicopter;
import Model.Player;
import View.Sounds.*;

import java.util.Timer;
import java.util.TimerTask;


public class GameController {

    private static Player player = new Player();

    public static void restartGame() {
        if (!ControllerData.isIsRunning()) {
            ControllerData.setIsRunning(true);
            player.setUsername(UIController.start.usernameTextField.getText());
            UIController.helicopterPanel.helicopter = new Helicopter(349, 300);
            UIController.helicopterPanel.beamColumn = new BeamColumn();
            UIController.helicopterPanel.coins = new Coins();
            ControllerData.setBeamCollision(false);
            ControllerData.setxSpeed(5);
            ControllerData.setySpeed(4);
        }
    }

    public static void endGame() {

        Timer timer = new Timer();
        ControllerData.setEndingGame(true);
        AnimationController.Explosion(ControllerData.getExplosionMstimer());


        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                ControllerData.setEndingGame(false);
                ControllerData.setIsRunning(false);
                if(ControllerData.getScore() > ControllerData.getHighScore()) {
                    RecordSound.play();
                } else {
                    LoserSound.play();
                }
                player.setScore(ControllerData.getScore());
                player.InsertPlayer();
                ControllerData.setHighScore();
                UIController.gameOver();
                ControllerData.setScore(0);
                ControllerData.setExplosionMstimer(0);
                UIController.skins.skinPath = UIController.skins.recoverySkinPath;
                ControllerData.setPaused(false);
            }
        },1000);
    }

    public static void stopGame()
    {
        ControllerData.setxSpeedRecovery(ControllerData.getxSpeed());
        ControllerData.setySpeedRecovery(ControllerData.getySpeed());

        ControllerData.setxSpeed(0);
        ControllerData.setySpeed(0);
        ControllerData.setPaused(true);
        if (ControllerData.isCoinIntersect())
            CoinMusic.stop();
        else
            GameMusic.stop();
    }

    public static void resumeGame()
    {
        ControllerData.setxSpeed(ControllerData.getxSpeedRecovery());
        ControllerData.setySpeed(ControllerData.getySpeedRecovery());
        ControllerData.setPaused(false);
        if (ControllerData.isCoinIntersect())
            CoinMusic.play();
        else
            GameMusic.play();
    }

    public static void closeGameFromPause()
    {
        ControllerData.setIsRunning(false);
        ControllerData.setCoinIntersect(false);
        ControllerData.setCointime(8);
        ControllerData.setScore(0);
        ControllerData.setExplosionMstimer(0);
        ControllerData.setPaused(false);
    }

    public static Player getPlayer() {
        return player;
    }
}
