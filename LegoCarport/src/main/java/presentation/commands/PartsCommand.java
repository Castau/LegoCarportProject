package presentation.commands;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.LegoCustomException;
import logic.LogicFacade;
import logic.models.HouseOrder;
import logic.models.Parts;
import logic.models.User;
import presentation.Command;

/**
 *
 * @author Camilla
 */
public class PartsCommand extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, LogicFacade logic) throws LegoCustomException {

        User user = (User) request.getSession().getAttribute("user");

        // check for if user has rights to view this partslist
        if (User.Role.employee != user.getRole() && !userHasOrder(logic, user)) {
            ArrayList<HouseOrder> orders = logic.getAllOrdersByUser(user.getId());
            request.setAttribute("allUserOrders", orders);
            return "/jsp/" + "Customer";
        }
        HouseOrder houseOrder = logic.getOrderByID(Integer.parseInt(request.getParameter("orderID")));
        Parts partslist = logic.getPartsList(Integer.parseInt(request.getParameter("orderID")));
        request.setAttribute("parts", partslist);
        request.setAttribute("houseorder", houseOrder);

        return "/jsp/" + "Parts";
    }

    // help method for checking if a user has any orders
    private boolean userHasOrder(LogicFacade logic, User user) throws LegoCustomException {
        ArrayList<HouseOrder> orders = logic.getAllOrdersByUser(user.getId());
        boolean hasOrder = false;
        for (HouseOrder houseOrder : orders) {
            hasOrder = (houseOrder.getUserID() == user.getId());
        }
        return hasOrder;
    }
}
