package logic.PartsCalculation;

import logic.LegoCustomException;
import logic.models.HouseOrder;
import logic.models.Parts;

/**
 *
 * @author Camilla
 */
public class PartsGenerator {
    

    public Parts generateParts(HouseOrder order) throws LegoCustomException{
        if(!(order.getHeight()>= 5 && order.getLength()>= 8 && order.getWidth() >= 8)){
            throw new LegoCustomException("House dimensions does not meet minimum requirements");           
        }

        int length = order.getLength();
        int width = order.getWidth();
        int height = order.getHeight();
        boolean door = order.isDoor();
        boolean window = order.isWindow();

        // to make rows stack in Running bond pattern, while also taking 
        // the width of each brick in to account in the calculations,
        // this makes the corners overlap automaticly switching between layers
        int calcLength = length - 2;
        int calcWidth = width - 2;

        // makes two Side objects for length and two for width
        Side lengthOne = new Side(); // if door is chosen it's always placed on this object
        Side lengthTwo = new Side();
        Side widthOne = new Side(); // if window is chosen it's always placed on this object
        Side widthTwo = new Side();

        // loop for each layer (height)
        // if door or window is chosen, the more complex method is called for the
        // specific Side object, otherwise the simple method is called
        // the Parts object is assembled with help from the buildParts method
        for (int i = 0; i < height; i++) {
            if(door){
               lengthOne.getRows().add(calculateRowWithElement(calcLength, i, 2, 4)); 
            }
            else{
                lengthOne.getRows().add(calculateRow(calcLength));
            }
            if(window){
                widthOne.getRows().add(calculateRowWithElement(calcWidth, i, 2, 2)); 
            }
            else{
                widthOne.getRows().add(calculateRow(calcWidth));
            }
            lengthTwo.getRows().add(calculateRow(calcLength));
            widthTwo.getRows().add(calculateRow(calcWidth));
        }
        
        Parts parts = buildParts(lengthOne, lengthTwo, widthOne, widthTwo, door, window);

        return parts; 
    }
    
    // the simple method for when door and window is not chosen, and for the Side
    // objects that never have a door or a window
    private Row calculateRow(int length) {
        int amountFours = length / 4; // the multiples of 4 in length (is equal to amount of four-bricks)
        int remainderTwos = length % 4; // the remainder after above division
        int amountTwos = remainderTwos / 2; // the multiples of 2 in the remainder (is equal to amount of two-bricks)
        int amountOnes = remainderTwos % 2; // the remainder after above division (is equal to amount of one-bricks)

        return new Row(amountFours, amountTwos, amountOnes);
    }
    
    // the more complex method for calculating amount of bricks while making 
    // room for door and/or window - called element in this method, since it's 
    // the same calculation
    private Row calculateRowWithElement(int sideLength, int height, int elementWidth, int elementHeight) {
        int lengthNoElement = sideLength - elementWidth; // length of the Side with room for the element subtracted
        int lengthLeft = lengthNoElement/2; // length of the Side to the left of the element
        int lengthRigth = lengthNoElement-lengthLeft; // length of the Side to the right of the element (takes uneven lengths into account)
        
        if (height >= elementHeight) {
            return calculateRow(sideLength); // calculates with simple metod for layers above the element
        }

        if (height % 2 == 0) { // calculate each side of the element in even layers
            Row left = calculateRow(lengthLeft); 
            Row right = calculateRow(lengthRigth);
            left.addRowToRow(right);
            
            return left;
            
        } else { // calculate each side of the element in uneven layers (with a shift in each of their length)
            //this is to make sure the that the room for the element stays in the  
            // same position when taking the corner-overlap-shift into account
            Row left = calculateRow(lengthLeft - 2);
            Row right = calculateRow(lengthRigth + 2);
            left.addRowToRow(right);   
            
            return left;
        }
    }
    
    // help method for adding all the bricks of the same size together and creating a Parts object
    private Parts buildParts(Side lengthOne, Side lengthTwo, Side widthOne, Side widthTwo, boolean door, boolean window) {
        int fours = lengthOne.amountFours() + lengthTwo.amountFours() + widthOne.amountFours() + widthTwo.amountFours();
        int twos = lengthOne.amountTwos() + lengthTwo.amountTwos() + widthOne.amountTwos() + widthTwo.amountTwos();
        int ones = lengthOne.amountOnes() + lengthTwo.amountOnes() + widthOne.amountOnes() + widthTwo.amountOnes();

        return new Parts(ones, twos, fours, door, window);
    }

}

