package Servlets;

import Beans.QuizDetails;
import Beans.QuizResults;
import Models.Quiz;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 * Refactored 19/03 by Philipp
 * @author Javi
 */
@WebServlet(name = "GetQuizDetails", urlPatterns = {"/GetQuizDetails","/Quiz"})
public class GetQuizDetails extends HttpServlet 
{
    /** Acquire quiz results for Staff to inspect.
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
        int quizID = Integer.parseInt(request.getParameter("quizID"));
        Quiz quiz = new Quiz();

        QuizDetails quizDetails = new QuizDetails();
        QuizResults quizResults = new QuizResults();
        QuizResults relQResults = new QuizResults();
        
        // Get quiz details.
        quizDetails = quiz.getQuiz(quizID);
        quizResults = quiz.getQuizResults(quizID);
        relQResults = quiz.getRelevantQuizResults(quizID);
        
        HttpSession session = request.getSession();
        session.setAttribute("QuizID", quizID);
        session.setAttribute("QuizDetails", quizDetails);
        session.setAttribute("QuizResults", quizResults);
        session.setAttribute("RelevantQuizResults", relQResults);
        
        response.sendRedirect("./Quiz");
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
        RequestDispatcher rd = request.getRequestDispatcher("/staffViewQuiz.jsp");
        rd.forward(request, response);
    }
    
    /** Returns a short description of the servlet.
     * 
     * @return String
     */
    @Override
    public String getServletInfo() 
    {
        return "Gets all the details for a chosen Quiz as session attributes";
    }

}