/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

/**
 *
 * @author Krasi
 */
public class TakingQuizModel {
    
    public int savingGivenAnswer(int QuestionID,int AnswerID)
    {
        Connection con;
        PreparedStatement st = null;
        try{
            con = DBConnection.createConnection();
            st= con.prepareStatement("INSERT INTO given_answers (completed_questionID,given_answer) values(?,?)");
            st.setInt(1, QuestionID);
            st.setInt(2, AnswerID);
            int result = st.executeUpdate();
            st.clearParameters();
            con.close();
            return result;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return 0;
    }
    
    public int saveCompletedQuiz(int userID,int quizID,int score, LocalDate date)
    {
        Connection con;
        PreparedStatement st = null;
        PreparedStatement check = null;
        try{
            con = DBConnection.createConnection();
            int result = 0;
            int id=0;
            check= con.prepareStatement("Select ID from completed_quiz where userID=? and quizID=?");
            check.setInt(1, userID);
            check.setInt(2, quizID);
            ResultSet ids = check.executeQuery();
            while(ids.next())
            {
                id=ids.getInt("ID");
            }
            System.out.println("The ID of a completed quiz:"+id);
            if(id==0)
            {
            st= con.prepareStatement("INSERT INTO completed_quiz (Attempts,userID,quizID,Score,date) values(1,?,?,?,?)");
            st.setInt(1, userID);
            st.setInt(2, quizID);
            st.setInt(3, score);
            st.setDate(4, java.sql.Date.valueOf(date));
            result = st.executeUpdate();
            }
            else
            {
            int attempt = 0;
            check.clearParameters();
            check= con.prepareStatement("Select Attempts from completed_quiz where ID=?");
            check.setInt(1, id);
            ResultSet attempts = check.executeQuery();
            while(attempts.next())
            {
                attempt=attempts.getInt("Attempts");
            }    
            st= con.prepareStatement("Update completed_quiz Set Attempts=? and Score=? and date=? where ID=?");
            st.setInt(1, (attempt+1));
            st.setInt(2, score);
            st.setDate(3, java.sql.Date.valueOf(date));
            st.setInt(4, id);
            result = st.executeUpdate(); 
            }
            st.clearParameters();
            con.close();
            return result;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return 0;
    }
    
}
