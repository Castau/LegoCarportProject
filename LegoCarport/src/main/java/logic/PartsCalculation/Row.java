/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.PartsCalculation;

/**
 *
 * @author Camilla
 */
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

    public int getFours() {
        return fours;
    }

    public int getTwos() {
        return twos;
    }

    public int getOnes() {
        return ones;
    }
    
    public void addRowToRow(Row newRow){
        fours = fours + newRow.getFours();
        twos = twos + newRow.getTwos();
        ones = ones + newRow.getOnes();
    }
}
