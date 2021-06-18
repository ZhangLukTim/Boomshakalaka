package controller;

import model.Debris;
import model.HeavenlyBody;
import model.Spaceship;

import java.util.ArrayList;
import java.util.List;

//import de.tum.in.ase.eist.audio.AudioPlayerInterface;

/**
 * Creates all car objects, detects collisions, updates car positions, notifies
 * player about victory or defeat.
 */
public class GameBoard {

    private static final int NUMBER_OF_SLOW_CARS = 5;

    /**
     * List of all active cars, does not contain player car.
     */
    private final List<Debris> debrisList = new ArrayList<>();

    /**
     * The player object with player's car.
     */
    private final Spaceship spaceship;

    /**
     * AudioPlayer responsible for handling music and game sounds.
     */
    //private AudioPlayerInterface audioPlayer;

    /**
     * Dimension of the GameBoard.
     */
    private final Dimension2D size;

    /**
     * true if game is running, false if game is stopped.
     */
    private boolean running;

    /**
     * Creates the game board based on the given size.
     *
     * @param size of the game board
     */
    public GameBoard(Dimension2D size) {
        this.size = size;
        Spaceship spaceship = new Spaceship();
        this.spaceship = new Spaceship();
        this.spaceship.setup();
        createdebirses();
    }

    /**
     * Creates as many cars as specified by {@link #NUMBER_OF_SLOW_CARS} and adds
     * them to the cars list.
     */
    private void createdebirses() {
        for (int i = 0; i < NUMBER_OF_SLOW_CARS; i++) {
            //example
            this.debrisList.add(new Debris(1,1,1,1));
        }
    }

    public Dimension2D getSize() {
        return size;
    }

    /**
     * Returns if game is currently running.
     *
     * @return true if the game is currently running, false otherwise
     */
    public boolean isRunning() {
        return this.running;
    }

    /**
     * Sets whether the game should be currently running.
     * <p>
     * Also used for testing on Artemis.
     *
     * @param running true if the game should be running
     */
    public void setRunning(boolean running) {
        this.running = running;
    }

    /**
     * Returns all cars on the game board except the player's car as a list.
     *
     * @return the list of all non-player cars
     */
    public List<Debris> getDebrisList() {
        return this.debrisList;
    }

    public Spaceship getSpaceship() {
        return this.spaceship;
    }

//    public AudioPlayerInterface getAudioPlayer() {
//        return this.audioPlayer;
//    }
//
//    public void setAudioPlayer(AudioPlayerInterface audioPlayer) {
//        this.audioPlayer = audioPlayer;
//    }

    /**
     * Updates the position of each car.
     */
    public void update() {
        moveDebris();
    }

    /**
     * Starts the game. Cars start to move and background music starts to play.
     */
    public void startGame() {
        //playMusic();
        this.running = true;
    }

    /**
     * Stops the game. Cars stop moving and background music stops playing.
     */
    public void stopGame() {
        //stopMusic();
        this.running = false;
    }

    /**
     * Starts the background music.
     */
//    public void playMusic() {
//        this.audioPlayer.playBackgroundMusic();
//    }

    /**
     * Stops the background music.
     */
//    public void stopMusic() {
//        this.audioPlayer.stopBackgroundMusic();
//    }

    /**
     * Moves all cars on this game board one step further.
     */
    public void moveDebris() {
        // update the positions of the player car and the autonomous cars
        for (Debris debris : this.debrisList) {
            debris.move(size);
        }
        //this.spaceship.getCar().drive(size);

        // iterate through all cars (except player car) and check if it is crunched
        for (Debris debris : debrisList) {
            if (debris.isCrunched()) {
                // because there is no need to check for a collision
                continue;
            }

            Collision collision = new Collision(spaceship.shoot(), debris);

//            if (collision.isCrash()) {
//                Car winner = collision.evaluate();
//                printWinner(winner);
//                audioPlayer.playCrashSound();
//                // TODO Backlog Item 12: Play crash sound
//                // Hint: take a look at AudioPlayer
//            }
        }
    }

//    private void printWinner(Car winner) {
//        if (winner == this.player.getCar()) {
//            System.out.println("The player's car won the collision!");
//        } else if (winner != null) {
//            System.out.println(winner.getClass().getSimpleName() + " won the collision!");
//        } else {
//            System.err.println("Winner car was null!");
//        }
//    }
}

