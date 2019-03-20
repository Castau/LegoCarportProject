package presentation;

import presentation.commands.UnknownCommand;
import presentation.commands.DesignHouseCommand;
import presentation.commands.LoginCommand;
import presentation.commands.RegisterCommand;
import presentation.commands.CreateHouseCommand;
import logic.LEGO_CustomException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.LogicFacade;

public abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new LoginCommand() );
        commands.put( "register", new RegisterCommand() );
        commands.put( "design", new DesignHouseCommand() );
        commands.put( "create", new CreateHouseCommand() );
    }

    static Command from( HttpServletRequest request ) {
        String commandName = request.getParameter( "command" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand() );
    }

    public abstract String execute( HttpServletRequest request, HttpServletResponse response, LogicFacade logic) 
            throws LEGO_CustomException;

}
