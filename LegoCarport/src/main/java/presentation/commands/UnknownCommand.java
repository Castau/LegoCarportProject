package presentation.commands;

import logic.LegoCustomException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.LogicFacade;
import presentation.Command;

/**
 *
 * @author Camilla
 */
public class UnknownCommand extends Command {

    @Override
    public String execute( HttpServletRequest request, HttpServletResponse response, LogicFacade logic ) throws LegoCustomException {
        String msg = "Unknown command. Contact IT";
        throw new LegoCustomException( msg );
    }

}
