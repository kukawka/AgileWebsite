package Servlets;

import Models.Quiz;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Refactored 19/03 by Philipp & Sophia
 * @author sophia
 */
@WebServlet(name = "StaffStartQuiz", urlPatterns = {"/StaffStartQuiz"})
public class StaffStartQuiz extends HttpServlet 
{
    public void init(ServletConfig config) throws ServletException 
    {}

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
            throws ServletException, IOException 
    {
        String title     = request.getParameter("title");
        String moduleID  = request.getParameter("moduleID");
        String available = request.getParameter("available"); // Will be 1 or null.
        int isAvailable;

        if (available == null)
        {
            isAvailable = 0;
        }
        else
        {
            isAvailable = 1;
        }
        
        DateTimeFormatter dtf  = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate creationDate = LocalDate.now();

        int questionsnumber = Integer.valueOf(request.getParameter("questionsnumber"));       
        
        int quizID = 0;
        Quiz quiz  = new Quiz();
        quizID     = quiz.RegisterQuiz(title, moduleID, isAvailable, creationDate);     
        
        RequestDispatcher rd = request.getRequestDispatcher("/staffSubmitQuiz.jsp");
        
        request.setAttribute("quizID", quizID);
        request.setAttribute("questionsnumber", questionsnumber);

        rd.forward(request, response);
        response.sendRedirect("/staffSubmitQuiz.jsp");
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
        String moduleID = request.getParameter("moduleID");
        request.setAttribute("moduleID", moduleID);
        
        RequestDispatcher rd = request.getRequestDispatcher("/staffStartQuiz.jsp");
        rd.forward(request,response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return String
     */
    @Override
    public String getServletInfo() 
    {
        return "Acquires the initial information needed to start Creating a Quiz"
                + "from a Staff member (title, availability, # of questions).";
    }

}
