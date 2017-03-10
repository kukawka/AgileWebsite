/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.LoggedIn;
import Beans.QuizResults;
import Models.LoginModel;
import Models.Quiz;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Dagi
 */
@WebServlet(name = "GetResults", urlPatterns = {"/GetResults","/QuizResults","/RelevantResults"})
public class GetResults extends HttpServlet {

    /*@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int quizID = Integer.parseInt(request.getParameter("ID"));
        //String type = request.getParameter("type");
        HttpSession session = request.getSession();

        QuizResults qResults=new QuizResults() ;
        Quiz q=new Quiz() ;
        qResults= q.getQuizResults(quizID);
            session.setAttribute("QuizResults", qResults);
            response.sendRedirect("/AgileWebsite/GetResults");
    }*/
    
        @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //if(request.getContextPath().equals("AgileWebsite/Quiz")){
        if(request.getServletPath().equals("/GetResults")){
        RequestDispatcher rd = request.getRequestDispatcher("/staffViewResults.jsp");
        rd.forward(request, response);
        }
        else if(request.getServletPath().equals("/RelevantResults")){
            RequestDispatcher rd = request.getRequestDispatcher("/staffViewRelevantResults.jsp");
        rd.forward(request, response);
            
        }
    }

}
