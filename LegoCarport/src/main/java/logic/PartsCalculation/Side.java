/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.PartsCalculation;

import java.util.ArrayList;

/**
 *
 * @author Camilla
 */
public class Side {
    
    ArrayList<Row> rows;

    public Side() {
        rows = new ArrayList();
    }

    public ArrayList<Row> getRows() {
        return rows;
    }
    
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
