package presentation.commands;

import logic.LEGO_CustomException;
import logic.models.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.LogicFacade;
import presentation.Command;

/**
 * 
 * 
 * @author Camilla
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

        if (User.Role.employee == user.getRole()) {
            Command command = new EmployeeCommand();
            command.execute(request, response, logic);
            return "Employee";
        }
        else{
            Command command = new CustomerCommand();
            command.execute(request, response, logic);
        }
        return "Customer";
    }
}
