/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dagi
 */
@WebServlet(name = "GetStats", urlPatterns = {"/Stats","/RelevantStats"})
public class GetStats extends HttpServlet{
    
            @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //if(request.getContextPath().equals("AgileWebsite/Quiz")){
        if(request.getServletPath().equals("/Stats")){
        RequestDispatcher rd = request.getRequestDispatcher("/staffViewStats.jsp");
        rd.forward(request, response);
        }
        else if(request.getServletPath().equals("/RelevantStats")){
            RequestDispatcher rd = request.getRequestDispatcher("/staffViewRelevantStats.jsp");
        rd.forward(request, response);
            
        }
    }
    
}
