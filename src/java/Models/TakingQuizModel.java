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
import java.time.LocalDate;

/**
 * Refactored 18/03 by Philipp
 *
 * @author Krasi
 */
public class TakingQuizModel {

    /**
     * A method to store the answers a student has given for a certain quiz, - *
     * so that later they can be retrieved and reviewed by the student. - * - *
     * @param QuestionID - * @param AnswerID - * @return 0 or row count of
     * affected rows -
     */
    public void saveGivenAnswer(int CompletedID, int QuestionNum, String answers) {
        Connection con;
        PreparedStatement prepStatement = null;
        PreparedStatement check = null;
        PreparedStatement identifier = null;
        int attemptNum = 0;

        try {

            con = DBConnection.createConnection();
            check = con.prepareStatement("SELECT Attempts FROM completed_quiz WHERE ID=?");
            check.setInt(1, CompletedID);
            ResultSet attempts = check.executeQuery();
            while (attempts.next()) {
                attemptNum = attempts.getInt("Attempts");
            }
            if (attemptNum == 1) {
                prepStatement = con.prepareStatement("INSERT INTO given_answer (completed_quizID,questionNum,answers) VALUES(?,?,?)");
                prepStatement.setInt(1, CompletedID);
                prepStatement.setInt(2, QuestionNum);
                prepStatement.setString(3, answers);
                prepStatement.executeUpdate();
            } else {
                int SavedQuizID = 0;
                identifier = con.prepareStatement("SELECT ID from given_answer WHERE completed_quizID=? AND questionNum=?");
                identifier.setInt(1, CompletedID);
                identifier.setInt(2, QuestionNum);
                ResultSet ids = identifier.executeQuery();
                while (ids.next()) {
                    SavedQuizID = ids.getInt("ID");
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

    public int getSavedQuizID(String userID, int quizID) {
        Connection con;
        PreparedStatement prepStatement = null;
        int SavedQuizID = 0;
        try {
            con = DBConnection.createConnection();
            prepStatement = con.prepareStatement("SELECT ID FROM completed_quiz WHERE userID=? AND quizID=?");
            prepStatement.setString(1, userID);
            prepStatement.setInt(2, quizID);
            ResultSet ids = prepStatement.executeQuery();
            while (ids.next()) {
                SavedQuizID = ids.getInt("ID");
            }
            con.close();
            return SavedQuizID;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; // DB-connection problem or update failure.
    }

    public int saveCompletedQuiz(String userID, int quizID, int score, LocalDate date) {
        Connection con;
        PreparedStatement prepStatement  = null;
        PreparedStatement check = null;
        try {
            con = DBConnection.createConnection();
            int result = 0;
            int SavedQuizID = 0;
            check = con.prepareStatement("Select ID from completed_quiz where userID=? and quizID=?");
            check.setString(1, userID);
            check.setInt(2, quizID);
            ResultSet ids = check.executeQuery();
            while (ids.next()) {
                SavedQuizID = ids.getInt("ID");
            }
            if (SavedQuizID == 0) {
                prepStatement = con.prepareStatement("INSERT INTO completed_quiz (Attempts,userID,quizID,Score,date) VALUES(1,?,?,?,?)");
                prepStatement.setString(1, userID);
                prepStatement.setInt(2, quizID);
                prepStatement.setInt(3, score);
                prepStatement.setDate(4, java.sql.Date.valueOf(date));
                result = prepStatement.executeUpdate(); // Returns 0 for failure or row count (rows that were affected) if it worked.
            } else {
                prepStatement = con.prepareStatement("UPDATE completed_quiz Set Score=? , date=? WHERE ID=?");
                prepStatement.setInt(1, score);
                prepStatement.setDate(2, java.sql.Date.valueOf(date));
                prepStatement.setInt(3, SavedQuizID);
                result = prepStatement.executeUpdate(); // Returns 0 for failure or row count (rows that were affected) if it worked.
            }
            prepStatement.clearParameters();
            con.close();
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; // DB-connection problem or update failure.
    }

}
