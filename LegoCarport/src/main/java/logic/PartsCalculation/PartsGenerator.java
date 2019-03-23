package logic.PartsCalculation;

import logic.LEGO_CustomException;
import logic.models.HouseOrder;
import logic.models.Parts;

/**
 *
 * @author Camilla
 */
public class PartsGenerator {
    

    public Parts generateParts(HouseOrder order) throws LEGO_CustomException{
        if(!(order.getHeight()>= 5 && order.getLength()>= 8 && order.getWidth() >= 8)){
            throw new LEGO_CustomException("House dimensions does not meet minimum requirements");           
        }
        int length = order.getLength();
        int width = order.getWidth();
        int height = order.getHeight();
        boolean door = order.isDoor();
        boolean window = order.isWindow();

        // to make rows stack in "forbandt"
        int calcLength = length - 2;
        int calcWidth = width - 2;

        Side lengthOne = new Side();
        Side lengthTwo = new Side();
        Side widthOne = new Side();
        Side widthTwo = new Side();

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
    
    private Row calculateRow(int length) {
        int amountFours = length / 4;
        int remainderTwos = length % 4;
        int amountTwos = remainderTwos / 2;
        int amountOnes = remainderTwos % 2;

        return new Row(amountFours, amountTwos, amountOnes);
    }

    private Row calculateRowWithElement(int width, int height, int elementWidth, int elementHeight) {
        int lengthNoElement = width - elementWidth;
        int lengthLeft = lengthNoElement/2;
        int lengthRigth = lengthNoElement-lengthLeft;
        
        if (height >= elementHeight) {
            return calculateRow(width);
        }

        if (height % 2 == 0) {
            Row left = calculateRow(lengthLeft);
            Row right = calculateRow(lengthRigth);
            left.addRowToRow(right);
            
            return left;
            
        } else {
            Row left = calculateRow(lengthLeft - 2);
            Row right = calculateRow(lengthRigth + 2);
            left.addRowToRow(right);   
            
            return left;
        }
    }

    private Parts buildParts(Side lengthOne, Side lengthTwo, Side widthOne, Side widthTwo, boolean door, boolean window) {
        int fours = lengthOne.amountFours() + lengthTwo.amountFours() + widthOne.amountFours() + widthTwo.amountFours();
        int twos = lengthOne.amountTwos() + lengthTwo.amountTwos() + widthOne.amountTwos() + widthTwo.amountTwos();
        int ones = lengthOne.amountOnes() + lengthTwo.amountOnes() + widthOne.amountOnes() + widthTwo.amountOnes();

        return new Parts(ones, twos, fours, door, window);
    }

}

