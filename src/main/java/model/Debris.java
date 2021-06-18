package model;

import controller.Dimension2D;
import controller.Point2D;

public class Debris {
    protected static final int MAX_ANGLE = 360;
    protected static final int HALF_ANGLE = MAX_ANGLE / 2;
    private double length;
    private double width;
    private double xPosition;
    private double yPosition;
    private String iconLocation;
    private Point2D position;
    private Dimension2D size =new Dimension2D(Math.random(),Math.random());
    private boolean crunched;
    private int minSpeed;
    private int maxSpeed;
    private int speed;
    private int direction;



    public Dimension2D getSize() {
        return size;
    }

    public Debris(double length, double width, double xPosition, double yPosition) {
        this.length = length;
        this.width = width;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.position = new Point2D(xPosition, yPosition);
    }

    public String getIconLocation() {
        return iconLocation;
    }

    public Point2D getPosition() {
        return position;
    }

    public void getSmaller() {
        length/=2;
        width/=2;
    }

    public void detectBullet(){

    }

    public boolean isCrunched() {
        return crunched;
    }

    public void move (Dimension2D gameBoardSize) {
        if (this.crunched) {
            return;
        }
        double maxX = gameBoardSize.getWidth();
        double maxY = gameBoardSize.getHeight();
        // calculate delta between old coordinates and new ones based on speed and
        // direction
        double deltaX = this.speed * Math.sin(Math.toRadians(this.direction));
        double deltaY = this.speed * Math.cos(Math.toRadians(this.direction));
        double newX = this.position.getX() + deltaX;
        double newY = this.position.getY() + deltaY;

        // calculate position in case the boarder of the game board has been reached
        if (newX < 0) {
            newX = -newX;
            this.direction = MAX_ANGLE - this.direction;
        } else if (newX + this.size.getWidth() > maxX) {
            newX = 2 * maxX - newX - 2 * this.size.getWidth();
            this.direction = MAX_ANGLE - this.direction;
        }

        if (newY < 0) {
            newY = -newY;
            this.direction = HALF_ANGLE - this.direction;
            if (this.direction < 0) {
                this.direction = MAX_ANGLE + this.direction;
            }
        } else if (newY + this.size.getHeight() > maxY) {
            newY = 2 * maxY - newY - 2 * this.size.getHeight();
            this.direction = HALF_ANGLE - this.direction;
            if (this.direction < 0) {
                this.direction = MAX_ANGLE + this.direction;
            }
        }
        // set coordinates
        this.position = new Point2D(newX, newY);
    }

    public void updateDirection(){}

    public void evaporate(){}


}
