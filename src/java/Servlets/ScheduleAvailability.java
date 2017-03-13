/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Util.Scheduler;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "ScheduleAvailability", urlPatterns = {"/ScheduleAvailability",})
public class ScheduleAvailability extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String dateInString = request.getParameter("date");
        HttpSession session = request.getSession();

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        //String dateInString = "7-Jun-2013";
        Date date = null;

        try {

            date = formatter.parse(dateInString);
            System.out.println(date);
            System.out.println(formatter.format(date));

        } catch (ParseException e) {
            e.printStackTrace();
        }

        //Scheduler test = new Scheduler(date, "test");
        Scheduler test = new Scheduler(new Date(System.currentTimeMillis() + 8000), "blah2");
        test.start();
        RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
        rd.forward(request, response);
    }

}
