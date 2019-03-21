/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import data.mappers.OrderMapper;
import data.mappers.UserMapper;
import java.util.ArrayList;
import logic.models.HouseOrder;
import logic.models.Parts;
import logic.models.User;
import logic.models.User.Role;

/**
 *
 * @author Camilla
 */
public class Logic_Impl implements LogicFacade{

    @Override
    public User login(String email, String password) throws LEGO_CustomException {
        return UserMapper.getInstance().login( email, password );
    }

    @Override
    public User createUser(String email, String password) throws LEGO_CustomException {
        User user = new User(email, password, Role.customer);
        UserMapper.getInstance().createUser( user );
        return user;
    }

    @Override
    public void saveHouse(HouseOrder order) throws LEGO_CustomException {
        OrderMapper.getInstance().createOrder(order);
    }

    @Override
    public ArrayList<HouseOrder> getAllOrders() throws LEGO_CustomException{
        return OrderMapper.getInstance().getAllOrders();
    }

    @Override
    public ArrayList<HouseOrder> getAllOrdersByUser(int userID) throws LEGO_CustomException{
        return OrderMapper.getInstance().getAllOrdersByUserID(userID);
    }

    @Override
    public void updateOrder(HouseOrder order) throws LEGO_CustomException{
        OrderMapper.getInstance().empUpdateOrder(order);
    }

    @Override
    public Parts getPartsList(int orderID) throws LEGO_CustomException{
        
        // first edition
        
        HouseOrder houseOrder = OrderMapper.getInstance().getOrderByOrderID(orderID);
        int length = houseOrder.getLength();
        int width = houseOrder.getWidth();
        int height = houseOrder.getHeight();
        boolean door = houseOrder.isDoor();
        boolean window = houseOrder.isWindow();
        
        // to make rows stack in "forbandt"
        int calcLength = length-2;
        int calcWidth = width-2;
        
        // amount of 4x2 bricks pr. side
        int amountFoursLength = calcLength/4;
        int amountFoursWidth = calcWidth/4;
        
        // remainder after four bricks are placed pr. side
        int remainderTwosLength = calcLength%4;
        int remainderTwosWidth = calcWidth%4;
        
        // amount of 2x2 bricks pr. side
        int amountTwosLength = remainderTwosLength/2;
        int amountTwosWidth = remainderTwosWidth/2;
        
        // amount(remainder) of 1x2 bricks pr. side
        int amountOnesLength = remainderTwosLength%2;
        int amountOnesWidth = remainderTwosWidth%2;
        
        // total amount of the different bricks pr. layer
        int layerAmountFours = (amountFoursWidth + amountFoursLength)*2;
        int layerAmountTwos = (amountTwosLength + amountTwosWidth)*2;
        int layerAmountOnes = (amountOnesLength + amountOnesWidth)*2;
        
        // TO DO:
        // make room for door and window 
        // set condition for house (also in frontend) size with and without door & window
        // get rid of wasteful integers
        
        return new Parts((layerAmountOnes*height), (layerAmountTwos*height), (layerAmountFours*height), door, window); //dummy data
    }
    
    
}
