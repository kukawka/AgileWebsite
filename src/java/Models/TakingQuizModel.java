package Models;

import Util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

/**
 * Refactored:
 * - 18/03 by Philipp
 * - 19/03 by Krasi + Philipp
 * @author Krasi
 */
public class TakingQuizModel 
{
    /** A method to store the answers a student has given for a certain quiz,
     *  so that later they can be retrieved and reviewed by the student.
     * 
     * @param QuestionID
     * @param AnswerID
     */
    public void saveGivenAnswer(int CompletedID, int QuestionNum, String answers) 
    {
        Connection con;
        PreparedStatement prepStatement = null;
        PreparedStatement checkAttempts = null;
        PreparedStatement identifier    = null;
        int attemptNum = 0;

        try 
        {
            con = DBConnection.createConnection();
            checkAttempts = con.prepareStatement("SELECT Attempts FROM completed_quiz WHERE ID=?");
            checkAttempts.setInt(1, CompletedID);
            
            ResultSet attempts = checkAttempts.executeQuery();
            while (attempts.next()) 
            {
                attemptNum = attempts.getInt("Attempts");
            }
            if (attemptNum == 1) 
            {
                prepStatement = con.prepareStatement("INSERT INTO given_answer (completed_quizID,questionNum,answers) VALUES(?,?,?)");
                prepStatement.setInt(1, CompletedID);
                prepStatement.setInt(2, QuestionNum);
                prepStatement.setString(3, answers);
                prepStatement.executeUpdate();
            } else 
            {
                int SavedQuizID = 0;
                identifier = con.prepareStatement("SELECT ID FROM given_answer WHERE completed_quizID=? AND questionNum=?");
                identifier.setInt(1, CompletedID);
                identifier.setInt(2, QuestionNum);
                
                ResultSet rSetIDs = identifier.executeQuery();
                while (rSetIDs.next()) 
                {
                    SavedQuizID = rSetIDs.getInt("ID");
                }
                prepStatement = con.prepareStatement("UPDATE given_answer SET completed_quizID=?, questionNum=?, answers=? WHERE ID=?");
                prepStatement.setInt(1, CompletedID);
                prepStatement.setInt(2, QuestionNum);
                prepStatement.setString(3, answers);
                prepStatement.setInt(4, SavedQuizID);
                prepStatement.executeUpdate();
            }
            
            prepStatement.clearParameters();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    /** Retrieve the completed_quiz Table ID for the specific user and quiz.
     * 
     * @param userID
     * @param quizID
     * @return 
     */
    public int getSavedQuizID(String userID, int quizID) 
    {
        Connection con;
        PreparedStatement prepStatement = null;
        int SavedQuizID = 0;
        
        try 
        {
            con = DBConnection.createConnection();
            prepStatement = con.prepareStatement("SELECT ID FROM completed_quiz WHERE userID=? AND quizID=?");
            prepStatement.setString(1, userID);
            prepStatement.setInt(2, quizID);
            
            ResultSet rSetIDs = prepStatement.executeQuery();
            while (rSetIDs.next()) 
            {
                SavedQuizID = rSetIDs.getInt("ID");
            }
            
            con.close();
            return SavedQuizID;
        } catch (SQLException e) {
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
     * @return success
     */
    public int saveCompletedQuiz(String userID, int quizID, int score, LocalDate date) 
    {
        Connection con;
        PreparedStatement prepStatement  = null;
        PreparedStatement prepStatement2 = null;
        
        try 
        {
            con = DBConnection.createConnection();
            int success     = 0;
            int SavedQuizID = 0;
            prepStatement2  = con.prepareStatement("SELECT ID FROM completed_quiz WHERE userID=? AND quizID=?");
            prepStatement2.setString(1, userID);
            prepStatement2.setInt(2, quizID);
            
            ResultSet rSetIDs = prepStatement2.executeQuery();
            while (rSetIDs.next()) 
            {
                SavedQuizID = rSetIDs.getInt("ID");
            }
            if (SavedQuizID == 0) 
            {
                prepStatement = con.prepareStatement("INSERT INTO completed_quiz (Attempts,userID,quizID,Score,date) VALUES(1,?,?,?,?)");
                prepStatement.setString(1, userID);
                prepStatement.setInt(2, quizID);
                prepStatement.setInt(3, score);
                prepStatement.setDate(4, java.sql.Date.valueOf(date));
                success = prepStatement.executeUpdate(); // Returns 0 for failure or row count (rows that were affected) if it worked.
            } else 
            {
                prepStatement = con.prepareStatement("UPDATE completed_quiz SET Score=? , date=? WHERE ID=?");
                prepStatement.setInt(1, score);
                prepStatement.setDate(2, java.sql.Date.valueOf(date));
                prepStatement.setInt(3, SavedQuizID);
                success = prepStatement.executeUpdate(); // Returns 0 for failure or row count (rows that were affected) if it worked.
            }
            
            prepStatement.clearParameters();
            con.close();
            return success;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; // DB-connection problem or update failure.
    }

}
