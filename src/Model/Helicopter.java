package Model;

import Controller.ControllerData;
import Controller.UIController;
import Utils.proxy.ProxyImage;

import java.awt.*;
import java.awt.image.ImageObserver;
/*import View.FirstFrame;*/

public class Helicopter extends GameObject {

    private String path = UIController.skins.skinPath;

    public Helicopter(int x, int y){
        super(x, y);
        ProxyImage proxyImage = new ProxyImage(path);
        this.image = proxyImage.loadImage().getImage();
        this.width = image.getWidth(null);
        this.height = image.getHeight(null);
        this.x -= width;
        this.y -= height;
        this.dy = ControllerData.getySpeed();
        this.dx = 0;
    }
    @Override
    public void tick() {
        path = UIController.skins.skinPath;
        ProxyImage proxyImage = new ProxyImage(path);
        this.image = proxyImage.loadImage().getImage();
        if(ControllerData.getySpeed() < 5 && !ControllerData.isPaused()) {
            ControllerData.setySpeed(ControllerData.getySpeed()+2);
            /*dy += 2;*/
        }
        dy = ControllerData.getySpeed();
        this.y += dy;

        this.x -= dx;

        checkWindowBorder();
    }
    public void jump() {
        if(ControllerData.getySpeed() > 0) {
            ControllerData.setySpeed(0);
        }
        /*dy -= 15;*/
        if (!ControllerData.isPaused())
            ControllerData.setySpeed(ControllerData.getySpeed()-15);
    }

    private void checkWindowBorder() {
        if(this.x > 800) {
            this.x = 800;
        }
        if(this.x < 0) {
            this.x = 0;
        }
        if(this.y > 600 - 100) {
            this.y = 600 - 100;
        }
        if(this.y < 0) {
            this.y = 0;
        }
    }

    @Override
    public void render(Graphics2D g, ImageObserver obs) {
        g.drawImage(image, x, y, obs);
    }


    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    @Override
    public void setDy(int dy) {
        super.setDy(dy);
    }
}