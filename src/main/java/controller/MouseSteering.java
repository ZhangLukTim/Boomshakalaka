package controller;

import model.Spaceship;
import controller.Point2D;
import view.GameviewUI;
import javafx.scene.input.MouseEvent;

/**
 * This class is responsible for the handling the MOUSE_PRESSED Event, i.e. the
 * steering of the user's car.
 */
public class MouseSteering {

    private static final int ANGLE_90_DEGREES = 90;
    private static final int ANGLE_270_DEGREES = 270;

    private final Spaceship spaceship;

    /**
     * Creates a MouseSteering instance for a specific GameBoardUI and a car that
     * the user needs to steer with their mouse.
     *
     * @param gameviewUI the game board UI to listen to mouse presses
     * @param userSpaceship     the car that should be steered by the user
     */
    public MouseSteering(GameviewUI gameviewUI, Spaceship userSpaceship) {
        this.spaceship = userSpaceship;
        gameviewUI.addEventHandler(MouseEvent.MOUSE_PRESSED, this::mousePressed);
    }

    private void mousePressed(MouseEvent clickEvent) {
        Point2D carPosition = spaceship.getPosition();
        Point2D clickPosition = new Point2D(clickEvent.getX(), clickEvent.getY());
        double deltaX = clickPosition.getX() - carPosition.getX();
        deltaX = Math.abs(deltaX);
        double deltaY = clickPosition.getY() - carPosition.getY();
        int degree = (int) Math.toDegrees(Math.atan2(deltaY, deltaX));

        if (clickPosition.getX() > carPosition.getX()) {
            degree = ANGLE_90_DEGREES - degree;
        } else {
            degree = ANGLE_270_DEGREES + degree;
        }

        //spaceship.setDirection(degree);
    }
}
