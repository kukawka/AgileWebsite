/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.QuizDetails;
import Models.Quiz;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */
@WebServlet(name = "TakeQuiz", urlPatterns = {"/TakeQuiz","/AttemptQuiz"})
public class TakeQuiz extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int quizID = Integer.parseInt(request.getParameter("quizID"));
        Quiz quiz = new Quiz();

        QuizDetails quizDetails = new QuizDetails() ;
        
        quizDetails=quiz.getQuiz(quizID);

        HttpSession session = request.getSession();
        session.setAttribute("QuizDetails", quizDetails);
        response.sendRedirect("./AttemptQuiz");
    }
    
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/userAttemptQuiz.jsp");
        rd.forward(request, response);
        
    }
    
    
    

}
