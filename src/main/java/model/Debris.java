package model;

import controller.Dimension2D;
import controller.Point2D;

public class Debris {
    private double length;
    private double width;
    private double xPosition;
    private double yPosition;
    private String iconLocation;
    private Point2D position;
    private Dimension2D size =new Dimension2D(10,10);

    public Dimension2D getSize() {
        return size;
    }

    public Debris(double length, double width, double xPosition, double yPosition) {
        this.length = length;
        this.width = width;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    public String getIconLocation() {
        return iconLocation;
    }

    public Point2D getPosition() {
        return position;
    }

    public void getSmaller() {

    }

    public void detectBullet(){

    }

    public void move(){}

    public void updateDirection(){}

    public void evaporate(){}


}
