package Servlets;

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
 * @author Dagi
 */
@WebServlet(name = "GetResults", urlPatterns = {"/GetResults","/QuizResults","/RelevantResults"})
public class GetResults extends HttpServlet 
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
       
        if(request.getServletPath().equals("/GetResults"))
        {
            RequestDispatcher rd = request.getRequestDispatcher("/staffViewResults.jsp");
            rd.forward(request, response);
        }
        // Show only results of students who take the module.
        else if(request.getServletPath().equals("/RelevantResults") || session.getAttribute("relevantStudents")!=null)
        {
            session.setAttribute("relevantStudents", null);
            RequestDispatcher rd = request.getRequestDispatcher("/staffViewRelevantResults.jsp");
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
        return "Applies the RESTful interface";
    }

}