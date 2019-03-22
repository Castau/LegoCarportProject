package logic.models;

/**
 *
 * @author Camilla
 */
public class Parts {
    int ones;
    int twos;
    int fours;
    boolean door;
    boolean window;

    public Parts(int ones, int twos, int fours, boolean door, boolean window) {
        this.ones = ones;
        this.twos = twos;
        this.fours = fours;
        this.door = door;
        this.window = window;
    }

    public int getOnes() {
        return ones;
    }

    public int getTwos() {
        return twos;
    }

    public int getFours() {
        return fours;
    }

    public boolean isDoor() {
        return door;
    }

    public boolean isWindow() {
        return window;
    }
    
    
    
}
