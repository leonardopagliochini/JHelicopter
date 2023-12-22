package Model;

import Controller.ControllerData;
import Utils.proxy.ProxyImage;

import java.awt.*;
import java.awt.image.ImageObserver;

public class Coin extends GameObject {

    public Coin(int x , int y) {
        super(x,y);
        ProxyImage proxyImage = new ProxyImage( ControllerData.getCoinPath());
        this.image = proxyImage.loadImage().getImage();
        this.width = image.getWidth(null);
        this.height = image.getHeight(null);


    }

    @Override
    public void tick() {
        ProxyImage proxyImage = new ProxyImage(ControllerData.getCoinPath());
        this.image = proxyImage.loadImage().getImage();
        this.x -= dx;
        this.y -= dy;

    }

    @Override
    public void render(Graphics2D g, ImageObserver observer) {
        g.drawImage(image, x, y, observer);
    }
    public Rectangle getBounds()
    {
        return new Rectangle(x, y, width, height);
    }

}
