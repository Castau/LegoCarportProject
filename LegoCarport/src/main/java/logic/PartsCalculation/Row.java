package logic.PartsCalculation;

/**
 *
 * @author Camilla
 */

// Object that holds the three types of bricks
public class Row {
    
    int fours;
    int twos;
    int ones;

    public Row(){
        fours = 0;
        twos = 0;
        ones = 0;
    }
    
    public Row(int fours, int twos, int ones) {
        this.fours = fours;
        this.twos = twos;
        this.ones = ones;
    }

    // A row can add a row to itself. This is necessary when an element is placed
    // since the row then is split in two and calculated separately on each side
    // of the element. When the two rows are calculated, they are added together
    // to make up one row again
    public void addRowToRow(Row newRow){
        fours = fours + newRow.getFours();
        twos = twos + newRow.getTwos();
        ones = ones + newRow.getOnes();
    }
    
    public int getFours() {
        return fours;
    }

    public int getTwos() {
        return twos;
    }

    public int getOnes() {
        return ones;
    }
}
