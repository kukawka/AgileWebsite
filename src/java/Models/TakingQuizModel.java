package Models;

import Util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Refactored 18/03 by Philipp
 * @author Krasi
 */
public class TakingQuizModel 
{
    /** A method to store the answers a student has given for a certain quiz, 
     *  so that later they can be retrieved and reviewed by the student.
     * 
     * @param QuestionID
     * @param AnswerID
     * @return 0 or row count of affected rows
     */
    public int saveGivenAnswer(int QuestionID, int AnswerID)
    {
        Connection con;
        PreparedStatement prepStatement = null;
        int result;
                
        try
        {
            con = DBConnection.createConnection();
            
            prepStatement = con.prepareStatement("INSERT INTO given_answers (completed_questionID,given_answer) VALUES(?,?)");
            prepStatement.setInt(1, QuestionID);
            prepStatement.setInt(2, AnswerID);
            result = prepStatement.executeUpdate(); // Returns 0 for failure or row count (rows that were affected) if it worked.
            prepStatement.clearParameters();
            
            con.close();
            return result;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return 0; // DB-connection problem or update failure.
    }
    
    /** This method saves details of a by a student completed quiz to the DB. E.g. number of Attempts, Score and more.
     * 
     * @param userID
     * @param quizID
     * @param score
     * @param date
     * @return 0 or row count of affected rows
     */
    public int saveCompletedQuiz(int userID,int quizID,int score, LocalDate date)
    {
        Connection con;
        PreparedStatement prepStatement = null;
        PreparedStatement check = null;
        try
        {
            con = DBConnection.createConnection();
            int result = 0;
            int id = 0;
            check = con.prepareStatement("SELECT ID FROM completed_quiz WHERE userID=? AND quizID=?");
            check.setInt(1, userID);
            check.setInt(2, quizID);
            
            ResultSet ids = check.executeQuery();
            while(ids.next())
            {
                id = ids.getInt("ID");
            }
            if(id == 0)
            {
                prepStatement= con.prepareStatement("INSERT INTO completed_quiz (Attempts,userID,quizID,Score,date) VALUES(1,?,?,?,?)");
                prepStatement.setInt(1, userID);
                prepStatement.setInt(2, quizID);
                prepStatement.setInt(3, score);
                prepStatement.setDate(4, java.sql.Date.valueOf(date));
                result = prepStatement.executeUpdate(); // Returns 0 for failure or row count (rows that were affected) if it worked.
            }
            else
            {
                int attempt = 0;
                check.clearParameters();
                check = con.prepareStatement("SELECT Attempts FROM completed_quiz WHERE ID=?");
                check.setInt(1, id);
                
                ResultSet attempts = check.executeQuery();
                while(attempts.next())
                {
                    attempt = attempts.getInt("Attempts");
                }    
                prepStatement = con.prepareStatement("UPDATE completed_quiz SET Attempts=? AND Score=? AND date=? WHERE ID=?");
                prepStatement.setInt(1, (attempt+1));
                prepStatement.setInt(2, score);
                prepStatement.setDate(3, java.sql.Date.valueOf(date));
                prepStatement.setInt(4, id);
                result = prepStatement.executeUpdate(); // Returns 0 for failure or row count (rows that were affected) if it worked.
            }
            prepStatement.clearParameters();
            
            con.close();
            return result;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return 0; // DB-connection problem or update failure.
    }
    
}
