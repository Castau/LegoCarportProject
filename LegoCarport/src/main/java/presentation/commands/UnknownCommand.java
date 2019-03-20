package presentation.commands;

import logic.LEGOAllPurposeException;
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
    public String execute( HttpServletRequest request, HttpServletResponse response, LogicFacade logic ) throws LEGOAllPurposeException {
        String msg = "Unknown command. Contact IT";
        throw new LEGOAllPurposeException( msg );
    }

}
