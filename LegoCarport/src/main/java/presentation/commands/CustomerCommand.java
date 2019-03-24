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

public class CustomerCommand extends Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, LogicFacade logic) throws LegoCustomException {
        
        User user = (User) request.getSession().getAttribute("user");
        ArrayList<HouseOrder> orders = logic.getAllOrdersByUser(user.getId());
        request.setAttribute("allUserOrders", orders);
        return "Customer";
    }
}
