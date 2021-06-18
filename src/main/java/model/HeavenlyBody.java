package model;

public abstract class HeavenlyBody {
    private double xPosition;
    private double yPosition;
    private double size;
    private int gravitionalForce;

    public boolean checkSurrounding(){
        return false;
    }
}
