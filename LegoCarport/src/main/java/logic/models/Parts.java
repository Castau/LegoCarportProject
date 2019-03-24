package logic.models;

/**
 *
 * @author Camilla
 */

// Object for the view holding all bricks for a building and info about the 
// existence of door and window
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Parts other = (Parts) obj;
        if (this.ones != other.ones) {
            return false;
        }
        if (this.twos != other.twos) {
            return false;
        }
        if (this.fours != other.fours) {
            return false;
        }
        if (this.door != other.door) {
            return false;
        }
        if (this.window != other.window) {
            return false;
        }
        return true;
    }
    
    
    
}
