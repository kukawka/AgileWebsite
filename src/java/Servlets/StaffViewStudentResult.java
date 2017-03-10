/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Models.Result;
import Models.Quiz;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Admin
 */
@WebServlet(name = "StaffViewStudentResult", urlPatterns = {"/StaffViewStudentResult"})
public class StaffViewStudentResult extends HttpServlet {  
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
        
        //HttpSession session=request.getSession();
        
        int studentID=Integer.valueOf(request.getParameter("studentID"));   
        int quizID=Integer.valueOf(request.getParameter("quizID"));
        //String moduleID=request.getParameter("moduleID");
     
        Result rz = new Result();
        
        int questionsnumber = Integer.valueOf(request.getParameter("questionsnumber"));
        int resultID = rz.getStudentResult(studentID, quizID);
        
        RequestDispatcher rd = request.getRequestDispatcher("/staffViewStudentResult.jsp");
        
        request.setAttribute("resultID", resultID);

        rd.forward(request, response);
        response.sendRedirect("/staffViewStudentResult.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {    
        //String quizID=request.getParameter("quizID");
        //request.setAttribute("quizID", quizID);
        
        RequestDispatcher rd=request.getRequestDispatcher("/staffViewStudentResult.jsp");
        rd.forward(request,response);
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
