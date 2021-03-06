package presentation;

import logic.LegoCustomException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logic.LogicFacade;
import logic.LogicFacade_Impl;

/**
 *
 * @author Camilla
 */
@WebServlet(name = "FrontController", urlPatterns = {"/Home"})
public class FrontController extends HttpServlet {

    // only instance of LogicFacade is created here and sent to all the commands
    private final LogicFacade logic = new LogicFacade_Impl();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            validateSession(request);
            Command command = Command.from(request);
            String view = command.execute(request, response, logic);
            request.getRequestDispatcher(view + ".jsp").forward(request, response);

        } catch (LegoCustomException ex) {
            request.setAttribute("error", ex.getMessage());
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    // private method to validate the Session
    private void validateSession(HttpServletRequest request) throws LegoCustomException {
        HttpSession session = request.getSession();
        if (!(request.getParameter("command").equals("login") || request.getParameter("command").equals("register"))) {
            if (session == null || session.getAttribute("user") == null) {
                throw new LegoCustomException("Session Invalid");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
