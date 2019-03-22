package logic;

import data.mappers.OrderMapper;
import data.mappers.UserMapper;
import java.util.ArrayList;
import logic.PartsCalculation.PartsGenerator;
import logic.models.HouseOrder;
import logic.models.Parts;
import logic.models.User;
import logic.models.User.Role;

/**
 *
 * @author Camilla
 */
public class LogicFacade_Impl implements LogicFacade {

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
        HouseOrder houseOrder = OrderMapper.getInstance().getOrderByOrderID(orderID);
        PartsGenerator partsGenerator = new PartsGenerator();
        return partsGenerator.generateParts(houseOrder);
    }
}
