package Servlets;

import Beans.LoggedIn;
import Beans.Quiz;
import Models.MainPageModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Refactored 19/03 by Philipp
 * @author Krasi+philipp PairProg
 */
@WebServlet(name = "MainPage", urlPatterns = {"/MainPage"})
public class MainPage extends HttpServlet 
{
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
            throws ServletException, IOException 
    {
        request.setAttribute("type", null);
        RequestDispatcher rd = request.getRequestDispatcher("/mainpage.jsp");
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
            throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        LoggedIn log = (LoggedIn) session.getAttribute("LoggedIn");
        MainPageModel mainPageModel = new MainPageModel();
        
        if (request.getParameter("sorting") != null) 
        {
            RequestDispatcher rd = request.getRequestDispatcher("/main.jsp");
            rd.forward(request, response);
        }

        if (request.getParameter("type").equals("Programme of Study")) 
        {
            request.setAttribute("type", "pos");
            try 
            {
                request.setAttribute("items", mainPageModel.getPOS());
            } catch (SQLException ex) {
                Logger.getLogger(MainPage.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            RequestDispatcher rd = request.getRequestDispatcher("/mainpage.jsp");
            rd.forward(request, response);
        } 
        else if (request.getParameter("type").equals("module")) 
        {
            request.setAttribute("type", "module");
            request.setAttribute("heading", request.getParameter("info"));
            request.setAttribute("items", mainPageModel.getModules(Integer.parseInt(request.getParameter("id")),log.getUsername()));
            
            RequestDispatcher rd = request.getRequestDispatcher("/mainpage.jsp");
            rd.forward(request, response);
        } 
        else if (request.getParameter("type").equals("quiz")) 
        {
            request.setAttribute("heading", request.getParameter("info"));
            ArrayList<Quiz> quizzes = mainPageModel.getQuizzes(Integer.parseInt(request.getParameter("id")), log.getType(), Integer.parseInt(log.getUsername()));
            request.setAttribute("items", quizzes);
            
            RequestDispatcher rd = request.getRequestDispatcher("/mainpage_quiz.jsp");
            rd.forward(request, response);
        }
    }

    /** Returns a short description of the servlet.
     * 
     * @return String
     */
    @Override
    public String getServletInfo() 
    {
        return "Displays Programmes of Study, Modules, Quizzes on the according jsp pages.";
    }

}