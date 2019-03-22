/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.mappers.OrderMapper;
import data.mappers.UserMapper;
import java.util.ArrayList;
import logic.PartsCalculation.Row;
import logic.PartsCalculation.Side;
import logic.models.HouseOrder;
import logic.models.Parts;
import logic.models.User;
import logic.models.User.Role;

/**
 *
 * @author Camilla
 */
public class Logic_Impl implements LogicFacade {

    @Override
    public User login(String email, String password) throws LEGO_CustomException {
        return UserMapper.getInstance().login(email, password);
    }

    @Override
    public User createUser(String email, String password) throws LEGO_CustomException {
        User user = new User(email, password, Role.customer);
        UserMapper.getInstance().createUser(user);
        return user;
    }

    @Override
    public void saveHouse(HouseOrder order) throws LEGO_CustomException {
        OrderMapper.getInstance().createOrder(order);
    }

    @Override
    public ArrayList<HouseOrder> getAllOrders() throws LEGO_CustomException {
        return OrderMapper.getInstance().getAllOrders();
    }

    @Override
    public ArrayList<HouseOrder> getAllOrdersByUser(int userID) throws LEGO_CustomException {
        return OrderMapper.getInstance().getAllOrdersByUserID(userID);
    }

    @Override
    public void updateOrder(HouseOrder order) throws LEGO_CustomException {
        OrderMapper.getInstance().empUpdateOrder(order);
    }

    @Override
    public Parts getPartsList(int orderID) throws LEGO_CustomException {

        // first edition
        HouseOrder houseOrder = OrderMapper.getInstance().getOrderByOrderID(orderID);
        int length = houseOrder.getLength();
        int width = houseOrder.getWidth();
        int height = houseOrder.getHeight();
        boolean door = houseOrder.isDoor();
        boolean window = houseOrder.isWindow();

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
