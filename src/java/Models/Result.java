package Models;

import Util.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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

    /** Using ID of the completed Quiz the answers that the student has given of the completed quiz for the student are returned.
     * 
     * @param quizID
     * @return studentAnswers
     */
    public ArrayList<String> getStudentAnswers(int quizID) 
    {
        Connection con;
        Statement statement  = null;
        ResultSet completedQuizSet = null;
        ArrayList<String> studentAnswers= new ArrayList<>();
        ArrayList<String> result= new ArrayList<>();
        ArrayList<Integer> questionNum= new ArrayList<>();
         try 
         {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            completedQuizSet = statement.executeQuery("SELECT answers, questionNum  FROM given_answer WHERE completed_quizID= " + quizID);
            while (completedQuizSet.next())
            {

                result.add(completedQuizSet.getString("answers"));
                questionNum.add(completedQuizSet.getInt("questionNum"));

            }
            for(int i=0;i<questionNum.size();i++)
            {
                for(int j=0;j<questionNum.size();j++)
                {
                    if(i+1==questionNum.get(j))studentAnswers.add(result.get(j));
                }
            }
            con.close();
            return studentAnswers;
         } catch (SQLException e) {
            e.printStackTrace();
            
        }
        
        return null;
    }
    
    /** Using the ID of the completed quiz the score for that student was returned.
     * 
     * @param quizID
     * @return studentScore
     */
    public int getStudentScore(int quizID) 
    {
        Connection con;
        Statement statement  = null;
        ResultSet completedQuizSet = null;
        int studentScore= 0;
        
         try 
         {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            completedQuizSet = statement.executeQuery("SELECT Score FROM completed_quiz WHERE ID= " + quizID);

            while (completedQuizSet.next())
            {

                studentScore=completedQuizSet.getInt("Score");

            }
            
            con.close();
            return studentScore;
         } catch (SQLException e) {
            e.printStackTrace();
            
        }
        
        return studentScore;
    }
    


/** Using the ID of the completed quiz the date of completion of the quiz was returned.
     * 
     * @param quizID
     * @return completedQuizID
     */
    public String getQuizDate(int quizID) 
    {
        Connection con;
        Statement statement  = null;
        ResultSet completedQuizSet = null;
        String studentDate = null;
        
         try 
         {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            completedQuizSet = statement.executeQuery("SELECT date FROM completed_quiz WHERE ID= " + quizID);
            
            while (completedQuizSet.next())
            {
                studentDate= completedQuizSet.getDate("date").toString();

            }
            
            con.close();
            return studentDate;
         } catch (SQLException e) {
            e.printStackTrace();
            
        }
        
        return studentDate;
    }
    
}