package Model;

import java.awt.*;
import java.awt.image.ImageObserver;

public abstract class GameObject{
    protected int x;
    protected int y;
    protected int dx, dy;
    protected int width;
    protected int height;
    protected Image image;
    public GameObject(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void tick();

    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public int getX() {
        return x;
    }

    public int getDx() {
        return dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public abstract void render(Graphics2D g, ImageObserver observer);
}
