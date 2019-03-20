package presentation.commands;


import logic.LEGOAllPurposeException;
import logic.models.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.LogicFacade;
import presentation.Command;

/**
 The purpose of Login is to...

 @author kasper
 */
public class LoginCommand extends Command {

    @Override
    public String execute( HttpServletRequest request, HttpServletResponse response,LogicFacade logic ) throws LEGOAllPurposeException {
        String email = request.getParameter( "email" );
        String password = request.getParameter( "password" );
        User user = logic.login( email, password );
        HttpSession session = request.getSession();
        session.setAttribute( "user", user );
        session.setAttribute( "role", user.getRole() );
        
        
        // NEED FIX WHEN USER IS UPDATED TO HAVE ROLE ENUM
        if(user.getRole().equals("customer")){
            return "Customer";
        }else{
            return "Employee";
        }
        //return user.getRole() + "page";
    }

}
