package controller;

import model.Bullet;
import model.Debris;

public class Collision {
    protected final Bullet bullet;
    protected final Debris debris;
    private final boolean crash;

    public Collision(Bullet bullet, Debris debris) {
        this.bullet = bullet;
        this.debris = debris;
        this.crash = detectCollision();
    }

    public boolean isCrash() {
        return crash;
    }

    public boolean detectCollision() {
        Point2D p1 = bullet.getPosition();
        Dimension2D d1 = bullet.getSize();

        Point2D p2 = debris.getPosition();
        Dimension2D d2 = debris.getSize();

        boolean above = p1.getY() + d1.getHeight() < p2.getY();
        boolean below = p1.getY() > p2.getY() + d2.getHeight();
        boolean right = p1.getX() + d1.getWidth() < p2.getX();
        boolean left = p1.getX() > p2.getX() + d2.getWidth();

        return !above && !below && !right && !left;
    }

    /**
     * Evaluates winner of the collision.
     *
     * @return winner Car
     */
//    public Car evaluate() {
//        Point2D p1 = this.car1.getPosition();
//        Point2D p2 = this.car2.getPosition();
//
//        Car winnerCar = null;
//        if (p1.getX() > p2.getX()) {
//            winnerCar = this.car2;
//        } else {
//            winnerCar = this.car1;
//        }
//        return winnerCar;
//    }

    /**
     * Evaluates loser of the collision.
     *
     * @return loser Car
     */
//    public Car evaluateLoser() {
//        Car winner = evaluate();
//        if (this.car1 == winner) {
//            return this.car2;
//        }
//        return this.car1;
//    }
}
