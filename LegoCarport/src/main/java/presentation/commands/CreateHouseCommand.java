/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.LogicFacade;
import logic.LEGOAllPurposeException;
import logic.models.HouseOrder;
import logic.models.User;
import presentation.Command;

/**
 *
 * @author Camilla
 */
public class CreateHouseCommand extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, LogicFacade logic) throws LEGOAllPurposeException {
        response.setContentType("text/html;charset=UTF-8");

        HouseOrder order = new HouseOrder();
        order.setHeight(Integer.parseInt(request.getParameter("height")));
        order.setLength(Integer.parseInt(request.getParameter("length")));
        order.setWidth(Integer.parseInt(request.getParameter("width")));
        order.setDoor(request.getParameter("door") != null);
        order.setWindow(request.getParameter("window") != null);
        order.setUser((User) request.getSession().getAttribute("user"));
        
        logic.saveHouse(order);

        return "Customer";
    }

}
