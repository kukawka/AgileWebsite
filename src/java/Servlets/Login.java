/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author Dagi
 */
@WebServlet(name = "Login", urlPatterns = {"/Login",})
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String type = request.getParameter("type");
        HttpSession session = request.getSession();

        //String userName= "2" ;
        //String password="test" ;
        LoginModel loginModel = new LoginModel(); //creating object for LoginDao. This class contains main logic of the application.
        boolean validUser = loginModel.authenticateLogin(userName, password, type);
        if (validUser) {
            LoggedIn login = new LoggedIn();
            login.setLogedin();
            login.setUsername(userName);
            session.setAttribute("LoggedIn", login);
            response.sendRedirect("/AgileWebsite/main.jsp");
        } else {
            request.setAttribute("check", false);
            
            if (type.equals("staff")) {
                RequestDispatcher rd = request.getRequestDispatcher("/staff_index.jsp");
                rd.forward(request, response);
            } else{
                RequestDispatcher rd = request.getRequestDispatcher("/student_index.jsp");
                rd.forward(request, response);
            }

        }
    }

}
