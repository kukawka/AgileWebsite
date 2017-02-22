/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//package uk.ac.dundee.computing.aec.instagrim.servlets;
package Servlets;

//import com.datastax.driver.core.Cluster;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import uk.ac.dundee.computing.aec.instagrim.lib.CassandraHosts;
//import uk.ac.dundee.computing.aec.instagrim.models.User;

//Date and UUID classes
import java.util.Date;
import java.util.UUID;
//Quiz class
import Models.Quiz;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "StaffSubmitQuiz", urlPatterns = {"/StaffSubmitQuiz"})
public class StaffSubmitQuiz extends HttpServlet {
    //Cluster cluster=null;
    public void init(ServletConfig config) throws ServletException {
        // TODO Auto-generated method stub
        //cluster = CassandraHosts.getCluster();
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

        Quiz qz = new Quiz(); //create new object or use previous? info going into DB, not object
        
        int numOfQuestions=Integer.valueOf(request.getParameter("questionsnumber"));
        int quizID=Integer.valueOf(request.getParameter("quizID"));
        
        System.out.println("this is the number of questions: "+numOfQuestions);

        //Make arrays/vectors to insert question/answer info
        for (int i=0; i<numOfQuestions; i++)
        {
            //post the info of every question
            //UUID questionID = UUID.randomUUID(); //get UUID in SQL?
            //RequestDispatcher rd = request.getRequestDispatcher("/staffSubmitQuiz.jsp")
            //request.setAttribute("questionID", questionID);
            int questionID=-1;

            String questionText = request.getParameter("questiontext"+(i+1));
            String explanationText = request.getParameter("explanationtext"+(i+1));
            
            //int questionNumber = Integer.valueOf(request.getParameter("questionnumbertext"+(i+1)+(j+1)));
            
            questionID=qz.SubmitQuestion(questionText, explanationText, quizID, (i+1));
            System.out.println("Question " +(i+1)+ " submitted!");

            for (int j=0; j<4; j++)
            {
                //post the info of every answer

                String answerText = request.getParameter("answertext"+(i+1)+(j+1));
                String correct = request.getParameter("correct"+(i+1)+(j+1)); //will be 1 or null
                
                boolean correctBool;//=true;
                int correctInt;
                if (correct=="1")
                {
                    correctInt=1;
                    correctBool=true;
                }
                else
                {
                    correctInt=0;
                    correctBool=false;
                }
                
                qz.SubmitAnswer(answerText, correctInt, quizID, (i+1));
                System.out.println("Answer " +(j+1)+ " for Question" +(i+1)+ " submitted!");
                
            }
             System.out.println("Quiz " +quizID+ " submitted!");
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        RequestDispatcher rd=request.getRequestDispatcher("/staffSubmitQuiz.jsp");
        rd.forward(request,response);
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
