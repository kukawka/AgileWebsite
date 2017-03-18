package Models;

import Util.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Refactored 18/03 by Philipp.
 * @author Admin
 */
public class Result 
{
    /** Using Student ID and Quiz ID the relevant DB-table ID of the completed quiz for the student are returned.
     * 
    * @ param the Student's ID and the Quiz's ID
    * @ return the Result ID for the specified Student for the specified Quiz
    */
    public int getStudentResult(int studentID, int quizID) 
    {
        int completedQuizID = -1;
        Connection con;
        Statement statement = null;
        ResultSet completedQuizIDs = null;
        
        try 
        {
            con = DBConnection.createConnection(); //establishing connection
            statement = con.createStatement();
            
            completedQuizIDs = statement.executeQuery("SELECT ID FROM completed_quiz WHERE userID = " + studentID + " AND QuizID = " + quizID);
            while (completedQuizIDs.next())
            {
                completedQuizID = completedQuizIDs.getInt("ID"); // Get quiz id
            }
            
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
        
        return completedQuizID;
    }
    
}
