/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.QuizDetails;
import Models.MainPageModel;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Models.Quiz;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Javi
 */
@WebServlet(name = "GetQuizDetails", urlPatterns = {"/GetQuizDetails","/Quiz"})
public class GetQuizDetails extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //int quizID = Integer.parseInt(request.getParameter("quizID"));
        int quizID=1 ;

        Quiz quiz = new Quiz();

        QuizDetails quizDetails = new QuizDetails() ;
        
        quizDetails=quiz.getQuiz(quizID);

        HttpSession session = request.getSession();
        session.setAttribute("QuizDetails", quizDetails);
        response.sendRedirect("/AgileWebsite/Quiz");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/staffViewQuiz.jsp");
        rd.forward(request, response);
        
    }

}
