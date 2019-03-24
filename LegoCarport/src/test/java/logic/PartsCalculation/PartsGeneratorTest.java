/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.PartsCalculation;

import logic.models.HouseOrder;
import logic.models.Parts;
import org.junit.Before;
import static org.junit.Assert.*;

/**
 *
 * @author Camilla
 */
public class PartsGeneratorTest {
    
    PartsGenerator partsGenerator;
    HouseOrder houseOrder;
    
    public PartsGeneratorTest() {
    }
    @Before
    public void setUp() {
        partsGenerator = new PartsGenerator();
        houseOrder = new HouseOrder();
    }

    /**
     * Test of generateParts method, of class PartsGenerator.
     */
    
    // test with door and window
    @org.junit.Test
    public void testGenerateParts_doorAndWndow() throws Exception {

        houseOrder.setLength(10);
        houseOrder.setWidth(10);
        houseOrder.setHeight(5);
        houseOrder.setDoor(true);
        houseOrder.setWindow(true);
        
        Parts expResult = new Parts(12, 6, 31, true, true);
        Parts result = partsGenerator.generateParts(houseOrder);
        assertEquals(expResult, result);
    }
    
    // test with only door
    @org.junit.Test
    public void testGenerateParts_onlyDoor() throws Exception {

        houseOrder.setLength(16);
        houseOrder.setWidth(23);
        houseOrder.setHeight(9);
        houseOrder.setDoor(true);
        houseOrder.setWindow(false);
        
        Parts expResult = new Parts(18, 18, 142, true, false);
        Parts result = partsGenerator.generateParts(houseOrder);
        assertEquals(expResult, result);
    }
    
    // test with only window
    @org.junit.Test
    public void testGenerateParts_onlyWindow() throws Exception {

        houseOrder.setLength(8);
        houseOrder.setWidth(11);
        houseOrder.setHeight(6);
        houseOrder.setDoor(false);
        houseOrder.setWindow(true);
        
        Parts expResult = new Parts(12, 14, 34, false, true);
        Parts result = partsGenerator.generateParts(houseOrder);
        assertEquals(expResult, result);
    }
    
    // test with no door or window
    @org.junit.Test
    public void testGenerateParts_noDoorNoWindow() throws Exception {

        houseOrder.setLength(13);
        houseOrder.setWidth(12);
        houseOrder.setHeight(5);
        houseOrder.setDoor(false);
        houseOrder.setWindow(false);
        
        Parts expResult = new Parts(10, 20, 40, false, false);
        Parts result = partsGenerator.generateParts(houseOrder);
        assertEquals(expResult, result);
    }
    
}
