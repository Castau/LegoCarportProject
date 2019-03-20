package presentation.commands;


import logic.LEGO_CustomException;
import logic.models.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.LogicFacade;
import presentation.Command;

public class RegisterCommand extends Command {

    @Override
    public String execute( HttpServletRequest request, HttpServletResponse response, LogicFacade logic ) throws LEGO_CustomException {
        String email = request.getParameter( "email" );
        String password1 = request.getParameter( "password1" );
        String password2 = request.getParameter( "password2" );
        if ( password1.equals( password2 ) ) {
            User user = logic.createUser( email, password1 );
            HttpSession session = request.getSession();
            session.setAttribute( "user", user );
            session.setAttribute( "role", user.getRole() );
            return user.getRole() + "page";
        } else {
            throw new LEGO_CustomException( "the two passwords did not match" );
        }
    }

}
