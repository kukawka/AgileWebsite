package Servlets;

import Beans.QuizDetails;
import Models.Quiz;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Refactored 19/03 by Philipp
 * @author musakolo
 */
@WebServlet(name = "StaffEditQuiz", urlPatterns = {"/StaffEditQuiz"})
public class StaffEditQuiz extends HttpServlet 
{
    /**
     * 
     * @param config
     * @throws ServletException 
     */
    public void init(ServletConfig config) throws ServletException 
    {}

    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        Quiz quiz = new Quiz();
        HttpSession session = request.getSession();

        int numOfQuestions = Integer.valueOf(request.getParameter("QuestionNumber"));
        int QuizID = (Integer) session.getAttribute("QuizID");
        QuizDetails quizDetail = (QuizDetails) session.getAttribute("QuizDetails");
        String title = request.getParameter("title");
        
        boolean availability = false;
        if (request.getParameter("availability") != null) 
        {
            availability = true;
        }

        for (int i = 0; i < numOfQuestions; i++) 
        {
            int questionID = Integer.parseInt(request.getParameter("id" + (i)));
            String questionText = request.getParameter("QuestionText" + (i));
            String explanationText = request.getParameter("ExplanationText" + (i));
            if (!(questionText.equals(quizDetail.getQuestions().get(i).getQuestionText()) && explanationText.equals(quizDetail.getQuestions().get(i).getExplanation()))) 
            {
                quiz.EditQuestion(questionText, explanationText, questionID);
            }

            for (int j = 0; j < quizDetail.getQuestions().get(i).getAnswers().size(); j++) 
            {
                int answerID = Integer.parseInt(request.getParameter("answerid" + (i) + "" + (j)));
                String answerText = request.getParameter("answertext" + (i) + "" + (j));
                int correct = 0;
                if (request.getParameter("correct" + (i) + "" + (j)) != null) 
                {
                    correct = 1;
                }

                if (!(answerText.equals(quizDetail.getQuestions().get(i).getAnswers().get(j).getText()) && correct==(quizDetail.getQuestions().get(i).getAnswers().get(j).getCorrect()))) 
                {
                    quiz.EditAnswer(answerText, answerID, correct);
                }
            }
        }
        if (!(availability == (quizDetail.getAvailability()) && title.equals(quizDetail.getTitle()))) 
        {
            quiz.EditQuiz(availability, title, QuizID);
        }
        session.setAttribute("QuizDetails", quiz.getQuiz(QuizID));
        response.sendRedirect("./Quiz");
    }

    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        RequestDispatcher rd = request.getRequestDispatcher("/staffEditQuiz.jsp");
        rd.forward(request, response);
    }

    /** Returns a short description of the servlet.
     * 
     * @return String
     */
    @Override
    public String getServletInfo() 
    {
        return "TODO Add short description here";
    }
}
