/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Models.LoginModel;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dagi
 */
@WebServlet(name = "Login", urlPatterns = {"/Login",
})
public class Login extends HttpServlet{
    
        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        
        LoginModel loginModel = new LoginModel(); //creating object for LoginDao. This class contains main logic of the application.
        //String userValidate = loginModel.authenticateLogin(loginModel);
    }
    }
    