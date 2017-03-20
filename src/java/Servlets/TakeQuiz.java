/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.LoggedIn;
import Beans.QuizDetails;
import Models.Quiz;
import Models.Result;
import Models.TakingQuizModel;
import java.io.IOException;
import java.time.LocalDate;
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
        TakingQuizModel taking = new TakingQuizModel();
        HttpSession session = request.getSession();
        LoggedIn lg = (LoggedIn) session.getAttribute("LoggedIn");
        int score = Integer.parseInt(request.getParameter("score"));
        int quizID = (Integer) session.getAttribute("QuizID");
        QuizDetails quizDetails = (QuizDetails) session.getAttribute("QuizDetails") ;
        LocalDate date = LocalDate.now();
        taking.saveCompletedQuiz(lg.getUsername(), quizID, score, date);
        int id=taking.getSavedQuizID(lg.getUsername(), quizID);
        for(int i=0; i<quizDetails.getQuestions().size();i++)
        {
            taking.saveGivenAnswer(id,(i+1),request.getParameter("SavedQuestion"+i));
        }
        
       response.sendRedirect("./StudentSummary");
    }
    
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int quizID = Integer.parseInt(request.getParameter("quizID"));
        HttpSession session = request.getSession(); 
        LoggedIn lg = (LoggedIn) session.getAttribute("LoggedIn");
        Quiz quiz = new Quiz();
        Result result = new Result();
        int taken = result.getStudentResult(Integer.parseInt(lg.getUsername()),quizID);
        QuizDetails quizDetails = new QuizDetails() ;
        
        quizDetails=quiz.getQuiz(quizID);
        
        session.setAttribute("taken",taken);
        session.setAttribute("QuizID",quizID);
        session.setAttribute("QuizDetails", quizDetails);
        
       
        RequestDispatcher rd = request.getRequestDispatcher("/userAttemptQuiz.jsp");
        rd.forward(request, response);
        
    }  

}


