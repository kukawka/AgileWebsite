import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import uk.ac.dundee.computing.aec.instagrim.lib.CassandraHosts;
//import uk.ac.dundee.computing.aec.instagrim.models.User;

//Date and UUID classes
import java.util.Date;
import java.util.UUID;
//Quiz class
import Models.Quiz;
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
        boolean availableBool;
        int availableInt;

        if (available.equals("1"))
        {
            availableBool=true;
            availableInt=1;
        }
        else
        {
            availableBool=false;
            availableInt=0;
        }
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate creationDate = LocalDate.now();
        //System.out.println(dtf.format(localDate));
        //Date creationDate = new Date();

        int questionsnumber = Integer.valueOf(request.getParameter("questionsnumber"));

        /////////////////Check if Quiz can be made/////////////////////////////////////
        int quizID=0;
        Quiz qz=new Quiz();
        quizID = qz.RegisterQuiz(title, moduleID, availableInt, creationDate);
        
        if (quizID>0)
        {
             //response.sendRedirect("/SubmissionSuccess");
        }
        else
        {
              //response.sendRedirect("/SubmissionError");
        }
        /////////////////////////////////////////////////////////////////////////////
        
        
        RequestDispatcher rd = request.getRequestDispatcher("/staffSubmitQuiz.jsp");
        //request.setAttribute("title", title);
        //request.setAttribute("moduleID", moduleID);
        //request.setAttribute("available", available);
        request.setAttribute("quizID", quizID);
        //request.setAttribute("creationDate", creationDate);
        request.setAttribute("questionsnumber", questionsnumber);

        rd.forward(request, response);
        

        response.sendRedirect("/staffSubmitQuiz.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        //Quiz qz = new Quiz();
        //HttpSession session = request.getSession();
        //get UUID from session attribute as an object. convert to string and acquire in UUID form
        //UUID quizID= UUID.fromString(session.getAttribute("quizID").toString()); 
        
        RequestDispatcher rd=request.getRequestDispatcher("/staffStartQuiz.jsp");
        //request.setAttribute("title", qz.getTitle(quizID));
        //request.setAttribute("moduleID", qz.getModuleID(quizID));
        //request.setAttribute("available", qz.getAvailable(quizID));
        //request.setAttribute("creationDate", qz.getCreationDate(quizID));
        //request.setAttribute("questionNumber", qz.getQuestionNumber(quizID));
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
