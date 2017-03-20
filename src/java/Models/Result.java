package Models;

import Util.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Refactored:
 * - 18/03 by Philipp
 * - 19/03 by Krasi + Philipp
 * @author Admin
 */
public class Result 
{
    /** Using Student ID and Quiz ID the relevant DB-table ID of the completed quiz for the student are returned.
     * 
     * @param studentID
     * @param quizID
     * @return completedQuizID
     */
    public int getStudentResult(int studentID, int quizID) 
    {
        Connection con;
        int completedQuizID          = -1  ;
        Statement statement          = null;
        ResultSet completedQuizIDSet = null;
        
         try 
         {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            
            completedQuizIDSet = statement.executeQuery("SELECT ID FROM completed_quiz WHERE userID = " + studentID + " AND QuizID = " + quizID);
            while (completedQuizIDSet.next())
            {
                completedQuizID = completedQuizIDSet.getInt("ID");
            }
            
            con.close();
         } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
        
        return completedQuizID;
    }
    
}