package presentation.commands;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.LegoCustomException;
import logic.LogicFacade;
import logic.models.HouseOrder;
import logic.models.User;
import presentation.Command;

/**
 *
 * @author Camilla
 */
public class ShipCommand extends Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, LogicFacade logic) throws LegoCustomException {
        User user = (User) request.getSession().getAttribute("user");
        
        // check if user has rights to ship an order
        if (User.Role.employee != user.getRole()){
            return "/jsp/" + "Customer";            
        }
        
        HouseOrder order = new HouseOrder();
        order.setOrderID(Integer.parseInt(request.getParameter("ship")));
        logic.updateOrder(order);
        
        ArrayList<HouseOrder> orders = logic.getAllOrders();
        request.setAttribute("allOrders", orders);
        return "/jsp/" + "Employee";
    }
}
