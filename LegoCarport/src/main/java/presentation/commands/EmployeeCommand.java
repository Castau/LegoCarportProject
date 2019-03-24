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
public class EmployeeCommand extends Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, LogicFacade logic) throws LegoCustomException {
        User user = (User) request.getSession().getAttribute("user");
        
        // checking if it's an employee or a customer and returning customers to 
        // the Customer Home Page
        if (User.Role.employee != user.getRole()){
            return "Customer";
            
        }
        ArrayList<HouseOrder> orders = logic.getAllOrders();
        request.setAttribute("allOrders", orders);
        return "/jsp/" + "Employee";
    }
}
