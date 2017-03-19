package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Refactored 19/03 by Philipp
 * @author Dagi
 */
@WebServlet(name = "ClearTheFilter", urlPatterns = {"/ClearTheFilter",})
public class ClearTheFilter extends HttpServlet 
{
    /** Clears the filters used by Staff for filtering results of quizzes.
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
        throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        session.setAttribute("Filtered", false);

        response.sendRedirect("GetResults");
    }
    
    /** Returns a short description of the servlet.
     * 
     * @return String
     */
    @Override
    public String getServletInfo() 
    {
        return "Sets the filter attribute to false to remove the filter";
    }
    
}
