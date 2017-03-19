package Servlets;

import Beans.LoggedIn;
import Models.MainPageModel;
import Models.Modules;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 * Refactored 19/03 by Philipp.
 * @author Javi
 */
@WebServlet(name = "GetModules", urlPatterns = {"/GetModules", "/Modules", "/EditModules"})
public class GetModules extends HttpServlet 
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
        HttpSession session = request.getSession();
        LoggedIn login = (LoggedIn) session.getAttribute("LoggedIn");
        Modules modules = new Modules();

        String IDs = request.getParameter("moduleChoice");
        String moduleID = request.getParameter("deleteModule");
        if (moduleID != null) 
        {
            modules.removeFavModule(login.getUsername(), moduleID);
        }
        
        if (IDs != null) 
        {
            modules.setFavModules(login.getUsername(), IDs);
        }
        
        MainPageModel mainPageModel = new MainPageModel();
        try {
            request.setAttribute("pos", mainPageModel.getPOS());
        } catch (SQLException ex) {
            Logger.getLogger(GetModules.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("modules", mainPageModel.getModules(Integer.parseInt(request.getParameter("id")), login.getUsername()));
        request.setAttribute("type", "modules");

        RequestDispatcher rd = request.getRequestDispatcher("/studentModules.jsp");
        rd.forward(request, response);
    }

    /**
     * 
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
    {
        HttpSession session = request.getSession();
        LoggedIn login = (LoggedIn) session.getAttribute("LoggedIn");
        MainPageModel mainPageModel = new MainPageModel();
        Modules modules = new Modules();
        
        try {
            request.setAttribute("pos", mainPageModel.getPOS());
        } catch (SQLException ex) {
            Logger.getLogger(GetModules.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.setAttribute("choice", modules.getModules(login.getUsername()));
        
        String servletPath = request.getServletPath();
        if(servletPath.equals("/Modules"))
        {
            RequestDispatcher rd = request.getRequestDispatcher("/studentMainModules.jsp");
            rd.forward(request, response);
        } 
        else
        {
            RequestDispatcher rd = request.getRequestDispatcher("/studentModules.jsp");
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
        return "Allows user to add or remove the modules they want to select/be part of.";
    }

}
