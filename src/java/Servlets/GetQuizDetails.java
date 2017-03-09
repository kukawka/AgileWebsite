/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.QuizDetails;
import Beans.QuizResults;
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/staffViewQuiz.jsp");
        rd.forward(request, response);
        
    }

        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int quizID = Integer.parseInt(request.getParameter("quizID"));
        Quiz quiz = new Quiz();

        QuizDetails quizDetails = new QuizDetails() ;
        QuizResults qResults=new QuizResults() ;
        QuizResults relQResults=new QuizResults() ;
        
        //get details
        quizDetails=quiz.getQuiz(quizID);
        
        //get results and stats
        Quiz q=new Quiz() ;
        qResults= q.getQuizResults(quizID);
        relQResults=q.getRelevantQuizResults(quizID);
        

        HttpSession session = request.getSession();
        session.setAttribute("QuizID", quizID);
        session.setAttribute("QuizDetails", quizDetails);
        session.setAttribute("QuizResults", qResults);
        session.setAttribute("RelevantQuizResults", relQResults);
        response.sendRedirect("./Quiz");
    }
}
