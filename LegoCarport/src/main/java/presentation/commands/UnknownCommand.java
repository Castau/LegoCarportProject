package presentation.commands;

import logic.LEGO_CustomException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.LogicFacade;
import presentation.Command;

/**
 The purpose of UnknownCommand is to...

 @author kasper
 */
public class UnknownCommand extends Command {

    @Override
    public String execute( HttpServletRequest request, HttpServletResponse response, LogicFacade logic ) throws LEGO_CustomException {
        String msg = "Unknown command. Contact IT";
        throw new LEGO_CustomException( msg );
    }

}
