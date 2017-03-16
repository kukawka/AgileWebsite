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
import javax.servlet.http.HttpSession;

/**
 *
 * @author Admin
 */

@WebServlet(name = "LookUpStudentResult", urlPatterns = {"/LookUpStudentResult",})
public class LookUpStudentResult extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        HttpSession session = request.getSession();
        //session.setAttribute("LookUp", true); //session to request
        
        String lookupID=request.getParameter("lookupID");
        session.setAttribute("lookupID", lookupID);
        
        //System.out.println("lookupID in servlet: " +lookupID);
        //System.out.println("relevantStudents in servlet bf: " +session.getAttribute("relevantStudents"));
        
        if ((request.getParameter("relevantStudents"))==null)
        {
            //do nothing
            response.sendRedirect("GetResults");
        }
        else
        {
            session.setAttribute("relevantStudents", "yes");  
            //System.out.println("relevantStudents in servlet In: " +session.getAttribute("relevantStudents"));
            response.sendRedirect("RelevantResults");
        }
    
        //RequestDispatcher rd = request.getRequestDispatcher("/staffViewResults.jsp"); 
        //rd.forward(request, response); 
    }
}
