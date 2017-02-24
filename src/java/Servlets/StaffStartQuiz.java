import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Quiz class
import Models.Quiz;
//Date
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "StaffStartQuiz", urlPatterns = {"/StaffStartQuiz"})
public class StaffStartQuiz extends HttpServlet {
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
        
        //HttpSession session=request.getSession();
        
        String title=request.getParameter("title");
        String moduleID=request.getParameter("moduleID");
        String available=request.getParameter("available"); //will be 1 or null
        int availableInt;

        if (available==null)
        {
            availableInt=0;
        }
        else
        {
            availableInt=1;
        }
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate creationDate = LocalDate.now();

        int questionsnumber = Integer.valueOf(request.getParameter("questionsnumber"));

        
        
        int quizID=0;
        Quiz qz=new Quiz();
        quizID = qz.RegisterQuiz(title, moduleID, availableInt, creationDate);
        System.out.println("Quiz " +quizID+ " initial information submitted!");
        ///////////////Check if Quiz can be made - future development////////////////
        /* 
        if (quizID>0)
        {
             //response.sendRedirect("/SubmissionSuccess");
        }
        else
        {
              //response.sendRedirect("/SubmissionError");
        }
        */
        /////////////////////////////////////////////////////////////////////////////
        
        
        RequestDispatcher rd = request.getRequestDispatcher("/staffSubmitQuiz.jsp");
        
        request.setAttribute("quizID", quizID);
        request.setAttribute("questionsnumber", questionsnumber);

        rd.forward(request, response);
        response.sendRedirect("/staffSubmitQuiz.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {    
        RequestDispatcher rd=request.getRequestDispatcher("/staffStartQuiz.jsp");
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
