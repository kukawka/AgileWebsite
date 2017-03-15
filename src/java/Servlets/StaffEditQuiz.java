/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.Question;
import Beans.QuizDetails;
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
import javax.servlet.http.HttpSession;

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
        HttpSession session = request.getSession();

        int numOfQuestions = Integer.valueOf(request.getParameter("QuestionNumber"));
        int QuizID = (Integer) session.getAttribute("QuizID");
        QuizDetails quizDetail = (QuizDetails) session.getAttribute("QuizDetails");
        //int QuizID = Integer.valueOf(request.getParameter("QuizID"));

        System.out.println("Number of questions: " + numOfQuestions);

        String title = request.getParameter("title");
        boolean availability = false;
        if (request.getParameter("availability") != null) {
                    availability = true;
                }
        
        for (int i = 0; i < numOfQuestions; i++) {
            int questionID = Integer.parseInt(request.getParameter("id" + (i)));
            String questionText = request.getParameter("QuestionText" + (i));
            String explanationText = request.getParameter("ExplanationText" + (i));
            //int QuizID = Integer.valueOf(request.getParameter("ID" + (i + 1)));
            //int questionNumber = Integer.valueOf(request.getParameter("questionnumbertext"+(i+1)+(j+1)));
            // questionID = quiz.EditQuestion(QuizID, (i + 1);
            quiz.EditQuestion(questionText, explanationText, questionID);
            System.out.println("Question " + (i) + " Updated!");

            for (int j = 0; j < quizDetail.getQuestions().get(i).getAnswers().size(); j++) {
                int answerID = Integer.parseInt(request.getParameter("answerid" + (i) + "" + (j)));
                String answerText = request.getParameter("answertext" + (i) + "" + (j));
                int correct = 0;
                if (request.getParameter("correct" + (i) + "" + (j)) != null) {
                    correct = 1;
                }

                quiz.EditAnswer(answerText, answerID, correct);
                System.out.println("Answer " + (j) + " for Question" + (i) + " updated!");
            }
            System.out.println("Quiz " + QuizID + " updated!");
        }
        quiz.EditQuiz(availability, title, QuizID); 
        session.setAttribute("QuizDetails", quiz.getQuiz(QuizID));
        response.sendRedirect("./Quiz");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/staffEditQuiz.jsp");
        rd.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
