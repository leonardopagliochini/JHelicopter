/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Controller.ControllerData;
import Utils.proxy.ProxyImage;

import java.awt.*;
import java.awt.image.ImageObserver;

public class Beam extends GameObject {

    public Beam(int x, int y) {
        super(x, y);
        ProxyImage proxyImage = new ProxyImage("/Resources/GameObjectIcons/trave1.png");
        this.image = proxyImage.loadImage().getImage();
        this.width = image.getWidth(null);
        this.height = image.getHeight(null);
    }

    @Override
    public void tick() {
        this.x -= dx;
        if(ControllerData.isCoinIntersect())
        {
            ProxyImage proxyImage = new ProxyImage("/Resources/GameObjectIcons/trave2.png");
            this.image = proxyImage.loadImage().getImage();
        }else{
            ProxyImage proxyImage = new ProxyImage("/Resources/GameObjectIcons/trave1.png");
            this.image = proxyImage.loadImage().getImage();
        }
    }

    @Override
    public void render(Graphics2D g, ImageObserver obs) {
        g.drawImage(image, x, y, obs);

    }

    
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}

