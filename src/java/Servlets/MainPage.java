/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.LoggedIn;
import Beans.Quiz;
import Models.MainPageModel;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Krasi+philipp PairProg
 */
@WebServlet(name = "MainPage", urlPatterns = {"/MainPage"})
public class MainPage extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
            throws ServletException, IOException {
       
         /*System.out.println("In model blaaaaaa");
        if((request.getParameter("check"))!=null)
        {
            if((request.getParameter("id"))==null)
            {
            System.out.println("I got here.");
            Map<String, String> Programmes;
            Programmes = new LinkedHashMap<>();
            ArrayList<ProgrammeOfStudy> poses = mnm.getPOS();
            for(int i=0;i<poses.size();i++)
            {
               String pos_id = Integer.toString(poses.get(i).getID());
               Programmes.put(pos_id,poses.get(i).getName());
            }
            String json = new Gson().toJson(Programmes);
            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write(json);
            
            }
            else if ((request.getParameter("id"))!=null)
            {
                
                System.out.println("MODULES.");
                Map<String, String> Modules;
                Modules = new LinkedHashMap<>();
                ArrayList<Module> mods = mnm.getModules(Integer.parseInt(request.getParameter("id")));
                for(int i=0;i<mods.size();i++)
                {
                   String mod_id = Integer.toString(mods.get(i).getID());
                   Modules.put(mod_id,mods.get(i).getName());
                }
                String json = new Gson().toJson(Modules);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(json);
            }
            
        }
        else
        {
             
            
        }*/
         request.setAttribute("type",null);
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
            throws ServletException, IOException {
         MainPageModel mnm = new MainPageModel();
        if(request.getParameter("sorting")!=null)
        {
            System.out.println("HEFAFSFASFASFASFAS");
           RequestDispatcher rd = request.getRequestDispatcher("/main.jsp");
         rd.forward(request, response);
        }
       
        if(request.getParameter("type").equals("Programme of Study"))
        {
           request.setAttribute("type","pos");
           request.setAttribute("items",mnm.getPOS());   
        }
        else if(request.getParameter("type").equals("module"))
        {
           request.setAttribute("type","module");
           request.setAttribute("heading", request.getParameter("info"));
           request.setAttribute("items",mnm.getModules(Integer.parseInt(request.getParameter("id"))));   
        }
        else if(request.getParameter("type").equals("quiz"))
        {
           HttpSession session = request.getSession();
           LoggedIn log = (LoggedIn) session.getAttribute("LoggedIn");
           request.setAttribute("type","quiz");
           request.setAttribute("heading", request.getParameter("info"));
           ArrayList<Quiz> quizzes =  mnm.getQuizzes(Integer.parseInt(request.getParameter("id")),log.getType());
           request.setAttribute("items",quizzes);   
        }
         RequestDispatcher rd = request.getRequestDispatcher("/mainpage.jsp");
         rd.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
