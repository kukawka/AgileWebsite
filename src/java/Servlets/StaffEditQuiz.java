/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.UUID;
import Models.Quiz;

/**
 *
 * @author musakolo
 */
@WebServlet(name = "StaffEditQuiz", urlPatterns = {"/StaffEditQuiz"})
public class StaffEditQuiz extends HttpServlet {

    public void init(ServletConfig config) throws ServletException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Quiz quiz = new Quiz();

        int numOfQuestions = Integer.valueOf(request.getParameter("QuestionNumber"));
        int QuizID = Integer.valueOf(request.getParameter("QuizID"));

        System.out.println("Number of questions: " + numOfQuestions);

        for (int i = 0; i < numOfQuestions; i++) {
            int questionID = -1;

            String questionText = request.getParameter("QuestionText" + (i + 1));
            String explanationText = request.getParameter("ExplanationText" + (i + 1));

            //int questionNumber = Integer.valueOf(request.getParameter("questionnumbertext"+(i+1)+(j+1)));
            questionID = quiz.SubmitQuestion(questionText, explanationText, QuizID, (i + 1));
            System.out.println("Question " + (i + 1) + " Updated!");

            for (int j = 0; j < 4; j++) {

                String answerText = request.getParameter("answertext" + (i + 1) + (j + 1));
                String correct = request.getParameter("correct" + (i + 1) + (j + 1));

                int correctInt;

                if (correct != null) {
                    correctInt = 1;
                } else {
                    correctInt = 0;
                }

                quiz.SubmitAnswer(answerText, correctInt, questionID);
                System.out.println("Answer " + (j + 1) + " for Question" + (i + 1) + " updated!");

            }
            System.out.println("Quiz " + QuizID + " updated!");
            
        }
        RequestDispatcher rd=request.getRequestDispatcher("./Quiz");
        rd.forward(request,response);
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        RequestDispatcher rd=request.getRequestDispatcher("/staffEditQuiz.jsp");
        rd.forward(request,response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
