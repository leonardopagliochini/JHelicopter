package Model;

import Controller.ControllerData;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Coins
{
        private List <Coin> coins;
        private final Random random;
        private int speed = 5;

        public Coins()
        {
                coins = new ArrayList<>();
                random = new Random();
        }

        private void initCoin()
        {
                int position = random.nextInt(600-30);
                Coin tempCoin = new Coin(800-40,position);
                tempCoin.setDx(speed);
                coins.add(tempCoin);
        }

        public void tick()
        {
             for (int i = 0 ; i < coins.size();i++)
             {
                     speed = ControllerData.getxSpeed();
                     coins.get(i).setDx(speed);
                     coins.get(i).tick();
                     if (coins.get(i).getX() < -6500)
                             coins.remove(coins.get(i));
             }
             if (coins.isEmpty())
             {
                     initCoin();
             }

        }
        public void render(Graphics2D g, ImageObserver obs)
        {
                for (int i = 0; i < coins.size(); i++) {
                        coins.get(i).render(g, obs);
                }
        }

        public List<Coin> getCoins() {
                return coins;
        }
}
