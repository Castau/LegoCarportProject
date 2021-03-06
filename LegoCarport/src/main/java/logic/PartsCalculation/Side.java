package logic.PartsCalculation;

import java.util.ArrayList;

/**
 *
 * @author Camilla
 */

// Object that holds all the rows that go in to one side (taking height into account)
public class Side {
    
    ArrayList<Row> rows;

    public Side() {
        rows = new ArrayList();
    }

    public ArrayList<Row> getRows() {
        return rows;
    }
    
    // these methods are for adding all the bricks of the same size togehter
    public int amountFours(){
        int fours = 0;
        for (int i = 0; i < rows.size(); i++) {
            fours = fours + rows.get(i).fours;
        }
        return fours;
    }
    
    public int amountTwos(){
        int twos = 0;
        for (int i = 0; i < rows.size(); i++) {
            twos = twos + rows.get(i).twos;
        }
        return twos;
    }
    
    public int amountOnes(){
        int ones = 0;
        for (int i = 0; i < rows.size(); i++) {
            ones = ones + rows.get(i).ones;
        }
        return ones;
    }
}
