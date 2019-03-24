package presentation.commands;

import java.util.ArrayList;
import logic.LegoCustomException;
import logic.models.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.LogicFacade;
import logic.models.HouseOrder;
import presentation.Command;

/**
 *
 * @author Camilla
 */
public class LoginCommand extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, LogicFacade logic) throws LegoCustomException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = logic.login(email, password);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        session.setAttribute("role", user.getRole());

        // Checking roles and returning different lists for each role
        if (User.Role.employee == user.getRole()) {
            ArrayList<HouseOrder> orders = logic.getAllOrders();
            request.setAttribute("allOrders", orders);
            return "/jsp/" + "Employee";
        } else {
            ArrayList<HouseOrder> orders = logic.getAllOrdersByUser(user.getId());
            request.setAttribute("allUserOrders", orders);
        }
        return "/jsp/" + "Customer";
    }
}
