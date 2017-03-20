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
 * @author Admin
 */

@WebServlet(name = "LookUpStudentResult", urlPatterns = {"/LookUpStudentResult",})
public class LookUpStudentResult extends HttpServlet 
{
    /**
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
        
        String lookupID = request.getParameter("lookupID");
        session.setAttribute("lookupID", lookupID);
        
        if ((request.getParameter("relevantStudents")) == null)
        {
            response.sendRedirect("GetResults");
        }
        else
        {
            session.setAttribute("relevantStudents", "yes");  
            response.sendRedirect("RelevantResults");
        }
    }
    
    /** Returns a short description of the servlet.
     * 
     * @return String
     */
    @Override
    public String getServletInfo() 
    {
        return "Retrieves results of a quiz for Staff to inspect.";
    }
    
}