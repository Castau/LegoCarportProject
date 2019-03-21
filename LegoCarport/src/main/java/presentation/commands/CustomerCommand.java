/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.commands;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.LEGO_CustomException;
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
    public String execute(HttpServletRequest request, HttpServletResponse response, LogicFacade logic) throws LEGO_CustomException {
        
        User user = (User) request.getSession().getAttribute("user");
        ArrayList<HouseOrder> orders = logic.getAllOrdersByUser(user.getId());
        request.setAttribute("allUserOrders", orders);
        return "Customer";
    }
}
