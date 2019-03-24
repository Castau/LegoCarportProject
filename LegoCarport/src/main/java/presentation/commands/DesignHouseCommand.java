package presentation.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.LogicFacade;
import logic.LegoCustomException;
import presentation.Command;

/**
 *
 * @author Camilla
 */
public class DesignHouseCommand extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, LogicFacade logic) throws LegoCustomException {
        return "DesignHouse";

    }

}
