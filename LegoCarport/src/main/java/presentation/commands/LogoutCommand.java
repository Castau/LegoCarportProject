package presentation.commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.LegoCustomException;
import logic.LogicFacade;
import presentation.Command;

/**
 *
 * @author Camilla
 */
public class LogoutCommand extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response, LogicFacade logic) throws LegoCustomException {
        HttpSession session = request.getSession();
        
        try {
            session.setAttribute("user", null);
            session.invalidate();
            return "index";
            
        } catch (IllegalStateException ex) {
            throw new LegoCustomException("Session Invalid");
        }
    }
}
