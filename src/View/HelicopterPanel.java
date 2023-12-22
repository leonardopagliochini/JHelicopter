package View;

import Controller.ControllerData;
import Controller.GameKeyController;
import Model.*;
import Utils.proxy.ProxyImage;

import javax.swing.*;
import java.awt.*;

/**
 *
 *
 */
public class HelicopterPanel extends JPanel {

    private final ProxyImage proxyImage;
    private final Image background;
    public Helicopter helicopter;
    public BeamColumn beamColumn;
    public Coins coins;
    private final GameKeyController gameKeyController = new GameKeyController();

    public HelicopterPanel() {

        proxyImage = new ProxyImage("/Resources/Backgrounds/citta22.png");
        background = proxyImage.loadImage().getImage();
        setFocusable(true);
        setDoubleBuffered(false);
        addKeyListener(gameKeyController);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(background, 0, 0, null);
        if (ControllerData.isIsRunning()) {
            ///////////////////////////////
            this.helicopter.render(g2, this);
            this.beamColumn.render(g2, this);
            this.coins.render(g2, this);
            g2.setColor(Color.black);
            g.setFont(new Font("Arial", Font.BOLD, 20));
            g2.drawString("Your score: " + ControllerData.getScore(), 10, 20);
            g.setFont(new Font("Arial", Font.BOLD, 30));
            if (ControllerData.isCoinIntersect())
            {
                g2.drawString("Remaining Time: " + Math.round(ControllerData.getCointime()), 250, 30);
            }

            ///////////////////////////////
        } else {
            g2.setColor(Color.white);
            g.setFont(new Font("Bold Serif", Font.BOLD, 20));
            g2.drawString("Press Enter to Start the Game", 800 / 2 - 150, 600 / 2 - 80);
            g2.setColor(Color.white);
            g.setFont(new Font("Arial", Font.BOLD, 15));
            g2.drawString("", 800 - 200, 600 - 50);
        }
        g2.setColor(Color.black);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g2.drawString("High Score: " + ControllerData.getHighScore(), 800 - 160, 20);
        g.dispose();
    }

    public Helicopter getHelicopter() {
        return helicopter;
    }

    public BeamColumn getBeamColumn() {
        return beamColumn;
    }

    public Coins getCoins() {
        return coins;
    }
}
