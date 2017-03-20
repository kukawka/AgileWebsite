package Servlets;

import Models.Result;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Refactored 19/03 by Philipp
 * @author Admin
 */
@WebServlet(name = "StaffViewStudentResult", urlPatterns = {"/StaffViewStudentResult"})
public class StaffViewStudentResult extends HttpServlet 
{  
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
        int studentID = Integer.valueOf(request.getParameter("studentID"));   
        int quizID    = Integer.valueOf(request.getParameter("quizID"));
        
        Result result       = new Result();
        int questionsnumber = Integer.valueOf(request.getParameter("questionsnumber"));
        int resultID        = result.getStudentResult(studentID, quizID);
        
        RequestDispatcher rd = request.getRequestDispatcher("/staffViewStudentResult.jsp");
        request.setAttribute("resultID", resultID);
        rd.forward(request, response);
        response.sendRedirect("/staffViewStudentResult.jsp");
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
        RequestDispatcher rd = request.getRequestDispatcher("/staffViewStudentResult.jsp");
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
        return "Used to display students quiz results to a member of Staff.";
    }

}
