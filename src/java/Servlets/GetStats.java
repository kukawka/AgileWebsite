package Servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Refactored 19/03 by Philipp
 * @author Dagi
 */
@WebServlet(name = "GetStats", urlPatterns = {"/Stats","/RelevantStats"})
public class GetStats extends HttpServlet
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
        if(request.getServletPath().equals("/Stats"))
        {
            RequestDispatcher rd = request.getRequestDispatcher("/staffViewStats.jsp");
            rd.forward(request, response);
        }
        // Show only stats of students who take the module.
        else if(request.getServletPath().equals("/RelevantStats"))
        {
            RequestDispatcher rd = request.getRequestDispatcher("/staffViewRelevantStats.jsp");
            rd.forward(request, response);
        }
    }
    
    /** Returns a short description of the servlet.
     * 
     * @return String
     */
    @Override
    public String getServletInfo() 
    {
        return "Applies the restful interface";
    }
    
}