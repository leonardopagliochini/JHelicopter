package Controller;

import Model.Beam;
import Model.Coin;
import View.Sounds.CoinMusic;
import View.Sounds.CoinSound;
import View.Sounds.GameMusic;

import java.awt.*;

public class CollisionController {

    private static Rectangle rectHelicopter;
    private static Rectangle rectBeam;
    private static Rectangle rectCoin;

    public static void checkCollision()
    {
        rectHelicopter = UIController.helicopterPanel.helicopter.getBounds();
        if (!ControllerData.isCoinIntersect())
        {
            for (int i = 0 ; i < UIController.helicopterPanel.coins.getCoins().size() ; i++) {
                Coin tempCoin = UIController.helicopterPanel.coins.getCoins().get(i);
                rectCoin = tempCoin.getBounds();
                if (rectHelicopter.intersects(rectCoin)) {
                    GameMusic.stop();
                    ControllerData.setCoinIntersect(true);
                    ControllerData.setCointime(8);
                    CoinSound.play();
                    CoinMusic.play();
                }
            }
        }

        for (int i = 0; i < UIController.helicopterPanel.beamColumn.getBeam().size(); i++) {
            Beam tempBeam = UIController.helicopterPanel.beamColumn.getBeam().get(i);
            rectBeam = tempBeam.getBounds();
            if (rectHelicopter.intersects(rectBeam)) {
                if (!ControllerData.isCoinIntersect())
                {
                    ControllerData.setBeamCollision(true);
                    break;
                }
            }
        }
    }

    public static void checkBeamExceed()
    {
        for (int i = 0; i < UIController.helicopterPanel.getBeamColumn().getBeam().size(); i++) {
            Beam tempBeam = UIController.helicopterPanel.getBeamColumn().getBeam().get(i);
            if (tempBeam.getX() + tempBeam.getWidth() < UIController.helicopterPanel.helicopter.getX())
            {
                CoinSound.play();
                ControllerData.setExceedColumn(true);
                break;
            }
        }
    }


}
