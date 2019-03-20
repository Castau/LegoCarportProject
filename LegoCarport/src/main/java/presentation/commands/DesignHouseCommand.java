/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.LogicFacade;
import logic.LEGO_CustomException;
import presentation.Command;

/**
 *
 * @author Camilla
 */
public class DesignHouseCommand extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, LogicFacade logic) throws LEGO_CustomException {
        return "DesignHouse";

    }

}
