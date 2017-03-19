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
@WebServlet(name = "FilterByDate", urlPatterns = {"/FilterByDate",})
public class FilterByDate extends HttpServlet 
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
        String dateFrom = request.getParameter("dateFrom"); // Start date,
        String dateTo = request.getParameter("dateTo");     // End date of filter.

        HttpSession session = request.getSession();
        session.setAttribute("Filtered", true);
        session.setAttribute("dateFrom", dateFrom);
        session.setAttribute("dateTo", dateTo);

        response.sendRedirect("GetResults");
    }
    
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
        RequestDispatcher rd = request.getRequestDispatcher("/GetResults");
        rd.forward(request, response);
    }
    
    /** Returns a short description of the servlet.
     * 
     * @return String
     */
    @Override
    public String getServletInfo() 
    {
        return "Sets the attributes to enabling filtering according to users preference";
    }

}
