package Models;

import Beans.Question;
import Beans.QuizDetails;
import Beans.QuizResults;
import Util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class Result {
    
    /**
    * @ param the Student's ID and the Quiz's ID
    * @ return the Result ID for the specified Student for the specified Quiz
    */
    public int getStudentResult(int studentID, int quizID) {
        int resultID=-1;
        
        Connection con;
        Statement statement = null;
        ResultSet rs = null;
        
         try {
            con = DBConnection.createConnection(); //establishing connection
            statement = con.createStatement();
            rs = statement.executeQuery("Select ID from completed_quiz where userID = " + studentID + " AND QuizID = " + quizID);
            
            while (rs.next()) // Until next row is present otherwise it returns false
            {
                //get quiz id value
                resultID = rs.getInt("ID");
                System.out.println("Result ID: " + resultID);
            }
            con.close();
            
         }catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
        
        return resultID;
    }
    
}
