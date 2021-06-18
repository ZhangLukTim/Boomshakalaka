package model;

import controller.Dimension2D;
import controller.Point2D;

public class Bullet {

    private double positionX;
    private double positionY;
    private Point2D position;
    private double height;
    private double width;
    private Dimension2D size;

    public Dimension2D getSize() {
        return size;
    }

    public Bullet(double positionX, double positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
        position = new Point2D(positionX, positionY);
        size = new Dimension2D(width, height);
    }

    public Point2D getPosition() {
        return position;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void travel(){}
}
