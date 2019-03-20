package presentation.commands;

import logic.LEGO_CustomException;
import logic.models.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.LogicFacade;
import presentation.Command;

/**
 * The purpose of Login is to...
 *
 * @author kasper
 */
public class LoginCommand extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, LogicFacade logic) throws LEGO_CustomException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = logic.login(email, password);
        HttpSession session = request.getSession();
        session.setAttribute("user", user);
        session.setAttribute("role", user.getRole());

        if (User.Role.employee != user.getRole()) {
            return "Customer";
        } else {
            return "Employee";
        }
    }
}
