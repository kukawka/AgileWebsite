/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.LoggedIn;
import Models.Result;
import Models.TakingQuizModel;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Krasi
 */
@WebServlet(name = "StudentSummary", urlPatterns = {"/StudentSummary"})
public class StudentSummary extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(); 
        LoggedIn lg = (LoggedIn) session.getAttribute("LoggedIn");
        int quizID = (Integer) session.getAttribute("QuizID");
        
        Result result = new Result();
        TakingQuizModel takenModel = new TakingQuizModel();
        
        int completedID = takenModel.getSavedQuizID(lg.getUsername(), quizID);
        ArrayList<String> results= result.getStudentAnswers(completedID);
        String date = result.getQuizDate(completedID);
        int score = result.getStudentScore(completedID);
        
        
        RequestDispatcher rd = request.getRequestDispatcher("/studentSummary.jsp");
        request.setAttribute("Score",score);
        request.setAttribute("Date",date);
        request.setAttribute("GivenAnswers",results);
        rd.forward(request, response);
        
    }

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
        
        HttpSession session = request.getSession(); 
        LoggedIn lg = (LoggedIn) session.getAttribute("LoggedIn");
        int quizID = (Integer) session.getAttribute("QuizID");
        
        Result result = new Result();
        TakingQuizModel takenModel = new TakingQuizModel();
        
        int completedID = takenModel.getSavedQuizID(lg.getUsername(), quizID);
        ArrayList<String> results= result.getStudentAnswers(completedID);
        String date = result.getQuizDate(completedID);
        int score = result.getStudentScore(completedID);
        
        
        RequestDispatcher rd = request.getRequestDispatcher("/studentSummary.jsp");
        request.setAttribute("Score",score);
        request.setAttribute("Date",date);
        request.setAttribute("GivenAnswers",results);
        rd.forward(request, response);
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Displays the summary for the certain completed quiz";
    }// </editor-fold>

}
