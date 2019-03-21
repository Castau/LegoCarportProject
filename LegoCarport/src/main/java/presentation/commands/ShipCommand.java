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
public class ShipCommand extends Command{

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, LogicFacade logic) throws LEGO_CustomException {
        User user = (User) request.getSession().getAttribute("user");
        if (User.Role.employee != user.getRole()){
            return "Customer";            
        }
        
        HouseOrder order = new HouseOrder();
        order.setOrderID(Integer.parseInt(request.getParameter("ship")));
        logic.updateOrder(order);
        
        ArrayList<HouseOrder> orders = logic.getAllOrders();
        request.setAttribute("allOrders", orders);
        return "Employee";
    }
}
