package Servlets;

import Beans.LoggedIn;
import Models.LoginModel;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Refactored 19/03 by Philipp
 * @author Dagi
 */
@WebServlet(name = "Login", urlPatterns = {"/Login",})
public class Login extends HttpServlet 
{
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
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        LoginModel loginModel = new LoginModel(); // This class contains main logic of the feature.
        
        String type = loginModel.authenticateLogin(userName, password);
        if (type != null) 
        {
            LoggedIn login = new LoggedIn();
            login.setLogedin();
            login.setUsername(userName);
            login.setType(type);
            session.setAttribute("LoggedIn", login);
            response.sendRedirect(request.getContextPath()+"/MainPage");
        } 
        else 
        {
            request.setAttribute("check", false);
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
            rd.forward(request, response);
        }
    }

}