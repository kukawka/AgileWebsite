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
@WebServlet(name = "Logout", urlPatterns = {"/Logout",})
public class Logout extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session=request.getSession();
            LoggedIn login= new LoggedIn();
            login.setLogedout();
            session.setAttribute("LoggedIn", null);
            RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");  
            rd.forward(request,response);
    }
}
