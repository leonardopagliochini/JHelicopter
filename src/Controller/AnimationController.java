package Controller;

import View.Sounds.ExplosionSound;
import View.Sounds.GameMusic;

public class AnimationController {

    public static void Explosion(int timer) {

        GameController.stopGame();

        if (Math.floor(timer) == 0) {
            GameMusic.stop();
            ExplosionSound.play();
        }
        if (Math.floor(timer / 10) < 5) {
            UIController.skins.skinPath = ("/Resources/ExplosionAnimation/explosion" + ((int) Math.floor(timer / 10)) + ".png");
        }
    }

    public static void CoinRotation(int timer) {
        ControllerData.setCoinPath("/Resources/GameObjectIcons/coin/coin" + timer % 30 + ".png");
        for (int i = 0; i < UIController.helicopterPanel.coins.getCoins().size(); i++) {
            UIController.helicopterPanel.coins.getCoins().get(i).setDy(4);
        }
    }
}
