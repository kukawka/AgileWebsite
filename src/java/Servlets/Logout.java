package Servlets;

import Beans.LoggedIn;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Refactored 19/03 by Philipp
 * @author Javier and Dagi
 */
@WebServlet(name = "Logout", urlPatterns = {"/Logout",})
public class Logout extends HttpServlet 
{
    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        LoggedIn login = new LoggedIn();
        login.setLogedout();
        session.setAttribute("LoggedIn", null);
        
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }
    
    /** Returns a short description of the servlet.
     * 
     * @return String
     */
    @Override
    public String getServletInfo() 
    {
        return "Logs out user or staff";
    }

}