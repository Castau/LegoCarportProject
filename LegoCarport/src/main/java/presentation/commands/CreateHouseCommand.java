package presentation.commands;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.LogicFacade;
import logic.LEGO_CustomException;
import logic.models.HouseOrder;
import logic.models.User;
import presentation.Command;

/**
 *
 * @author Camilla
 */
public class CreateHouseCommand extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, LogicFacade logic) throws LEGO_CustomException {
        response.setContentType("text/html;charset=UTF-8");

        User user = (User) request.getSession().getAttribute("user");

        HouseOrder order = new HouseOrder();
        order.setHeight(Integer.parseInt(request.getParameter("height")));
        order.setLength(Integer.parseInt(request.getParameter("length")));
        order.setWidth(Integer.parseInt(request.getParameter("width")));
        order.setDoor(request.getParameter("door") != null);
        order.setWindow(request.getParameter("window") != null);
        order.setUserID(user.getId());

        logic.saveHouse(order);

        ArrayList<HouseOrder> orders = logic.getAllOrdersByUser(user.getId());
        request.setAttribute("allUserOrders", orders);

        return "Customer";
    }

}
