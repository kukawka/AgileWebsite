package Servlets;

import Models.Quiz;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Refactored 19/03 by Philipp
 * @author sophia
 */
@WebServlet(name = "StaffSubmitQuiz", urlPatterns = {"/StaffSubmitQuiz"})
public class StaffSubmitQuiz extends HttpServlet 
{
    
    public void init(ServletConfig config) throws ServletException 
    {}

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
            throws ServletException, IOException 
    {

        Quiz quiz          = new Quiz();
        int numOfQuestions = Integer.valueOf(request.getParameter("questionsnumber")); 
        int quizID         = Integer.valueOf(request.getParameter("quizID"));

        for (int i = 0; i < numOfQuestions; i++)
        {
            int questionID = -1;
            String questionText    = request.getParameter("questiontext"+(i+1));
            String explanationText = request.getParameter("explanationtext"+(i+1));
            
            questionID = quiz.SubmitQuestion(questionText, explanationText, quizID, (i+1));
            
            int numOfAnswers = Integer.parseInt(request.getParameter("numOfAnswers"+(i+1)));
            for (int j = 0; j < numOfAnswers; j++)
            {
                //post the info of every answer
                String answerText = request.getParameter("answertext"+(i+1)+(j+1));
                String correct    = request.getParameter("correct"+(i+1)+(j+1)); // Will be 1 or null.
                int correctInt;

                if (correct!=null)
                {
                    correctInt = 1;
                }
                else
                {
                    correctInt = 0;
                }
                quiz.SubmitAnswer(answerText, correctInt, questionID);
            }
        }
        
        RequestDispatcher rd=request.getRequestDispatcher("/successfulcreation.jsp");
        rd.forward(request,response);
    }
    
    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        RequestDispatcher rd = request.getRequestDispatcher("/staffSubmitQuiz.jsp");
        rd.forward(request,response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return String
     */
    @Override
    public String getServletInfo() 
    {
        return "Acquires the core information needed to Create a Quiz"
                + "from a Staff member (question texts & explanations, answers).";
    }

}