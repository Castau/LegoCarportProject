package logic;

import java.util.ArrayList;
import logic.models.HouseOrder;
import logic.models.Parts;
import logic.models.User;

/**
 *
 * @author Camilla
 */

// interface presenting methods in the LogicFaade to the presentaion
public interface LogicFacade {

    public User login(String email, String password) throws LegoCustomException;

    public User createUser(String email, String password) throws LegoCustomException;
    
    public void saveHouse (HouseOrder order) throws LegoCustomException;

    public ArrayList<HouseOrder> getAllOrders() throws LegoCustomException;
    
    public ArrayList<HouseOrder> getAllOrdersByUser(int userID) throws LegoCustomException;

    public void updateOrder(HouseOrder order) throws LegoCustomException;

    public Parts getPartsList(int parseInt)throws LegoCustomException;
    
    public HouseOrder getOrderByID(int orderID) throws LegoCustomException;
}
