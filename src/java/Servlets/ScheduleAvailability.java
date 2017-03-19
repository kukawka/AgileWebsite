package Servlets;

import Util.Scheduler;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "ScheduleAvailability", urlPatterns = {"/ScheduleAvailability",})
public class ScheduleAvailability extends HttpServlet 
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
        String dateInString = request.getParameter("date");
        HttpSession session = request.getSession();

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = null;

        try 
        {
            date = formatter.parse(dateInString);

        } catch (ParseException e) {
            e.printStackTrace();
        }

        Scheduler test = new Scheduler(new Date(System.currentTimeMillis() + 8000), "blah2");
        test.start();
        
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
        return "Used to schedule when a quiz becomes available.";
    }
}