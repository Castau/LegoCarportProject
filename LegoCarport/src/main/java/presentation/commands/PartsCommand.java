package presentation.commands;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.LEGO_CustomException;
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
    public String execute(HttpServletRequest request, HttpServletResponse response, LogicFacade logic) throws LEGO_CustomException {

        User user = (User) request.getSession().getAttribute("user");

        if (User.Role.employee != user.getRole() && !userHasOrder(request, logic, user)) {
            ArrayList<HouseOrder> orders = logic.getAllOrdersByUser(user.getId());
            request.setAttribute("allUserOrders", orders);
            return "Customer";
        }
        
        Parts partslist = logic.getPartsList(Integer.parseInt(request.getParameter("orderID")));
        request.setAttribute("parts", partslist);

        return "Parts";
    }

    private boolean userHasOrder(HttpServletRequest request, LogicFacade logic, User user) throws LEGO_CustomException {
        ArrayList<HouseOrder> orders = logic.getAllOrdersByUser(user.getId());
        boolean hasOrder = false;
        for (HouseOrder houseOrder : orders) {
            hasOrder = (houseOrder.getUserID() == user.getId());
        }
        return hasOrder;
    }
}
