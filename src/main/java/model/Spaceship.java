package model;

import controller.Point2D;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Spaceship {
    private double speed;
    private double xPosition;
    private double yPosition;
    private boolean flightDetection;
    private String iconLocation;
    private Point2D position = new Point2D(this.xPosition, this.yPosition);
    private Stack<Bullet> bullets = new Stack<>();

    public String getIconLocation() {
        return iconLocation;
    }

    public void steer(){}
    public Bullet shoot(){
        if(bullets.empty())
            throw new ArrayIndexOutOfBoundsException("No more bullet");
        return bullets.pop();
    }
    public void accelerate(){}

    public Point2D getPosition() {
        return position;
    }

    public void setup(){}
}
