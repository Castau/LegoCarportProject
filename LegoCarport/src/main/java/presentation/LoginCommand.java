package presentation;

import logic.LogicFacade;
import logic.LoginSampleException;
import logic.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 The purpose of Login is to...

 @author kasper
 */
public class LoginCommand extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String email = request.getParameter( "email" );
        String password = request.getParameter( "password" );
        User user = LogicFacade.login( email, password );
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
