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
public class RegisterCommand extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, LogicFacade logic) throws LegoCustomException {
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        if (password1.equals(password2)) {
            User user = logic.createUser(email, password1);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());
            ArrayList<HouseOrder> orders = logic.getAllOrdersByUser(user.getId());
            request.setAttribute("allUserOrders", orders);
            return "Customer";
        } else {
            throw new LegoCustomException("the two passwords did not match");
        }
    }

}
