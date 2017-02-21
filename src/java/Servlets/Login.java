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
        //String type = request.getParameter("type");
        HttpSession session = request.getSession();

        //String userName= "2" ;
        //String password="test" ;
        LoginModel loginModel = new LoginModel(); //creating object for LoginDao. This class contains main logic of the application.
        String type = loginModel.authenticateLogin(userName, password);
        if (type!=null) {
            LoggedIn login = new LoggedIn();
            login.setLogedin();
            login.setUsername(userName);
            login.setType(type);
            session.setAttribute("LoggedIn", login);
            response.sendRedirect("/AgileWebsite/MainPage");
        } else {
            request.setAttribute("check", false);

                RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                rd.forward(request, response);

        }
    }

}
