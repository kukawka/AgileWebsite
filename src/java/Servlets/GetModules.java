/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.LoggedIn;
import Models.MainPageModel;
import Models.Modules;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Javi
 */
@WebServlet(name = "GetModules", urlPatterns = {"/GetModules", "/Modules"})
public class GetModules extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String IDs = request.getParameter("moduleChoice");

        MainPageModel mnm = new MainPageModel();
        request.setAttribute("pos", mnm.getPOS());
        request.setAttribute("modules", mnm.getModules(Integer.parseInt(request.getParameter("id"))));
        request.setAttribute("type", "modules");

        HttpSession session = request.getSession();
        LoggedIn login = (LoggedIn) session.getAttribute("LoggedIn");
        
        if (IDs != null) 
        {
            Modules modules = new Modules();
            modules.setModules(login.getUsername(), IDs);
        }

        RequestDispatcher rd = request.getRequestDispatcher("/studentModules.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MainPageModel mnm = new MainPageModel();
        request.setAttribute("pos", mnm.getPOS());
        RequestDispatcher rd = request.getRequestDispatcher("/studentModules.jsp");
        rd.forward(request, response);

    }

}
