package logic;

import java.util.ArrayList;
import logic.models.HouseOrder;
import logic.models.Parts;
import logic.models.User;

/**
 *
 * @author Camilla
 */
public interface LogicFacade {

    public User login(String email, String password) throws LEGO_CustomException;

    public User createUser(String email, String password) throws LEGO_CustomException;
    
    public void saveHouse (HouseOrder order) throws LEGO_CustomException;

    public ArrayList<HouseOrder> getAllOrders() throws LEGO_CustomException;
    
    public ArrayList<HouseOrder> getAllOrdersByUser(int userID) throws LEGO_CustomException;

    public void updateOrder(HouseOrder order) throws LEGO_CustomException;

    public Parts getPartsList(int parseInt)throws LEGO_CustomException;
    
}
