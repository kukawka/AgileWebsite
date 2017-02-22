package Models;

import Beans.Question;
import Beans.QuizDetails;
import Util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import java.sql.CallableStatement;

public class Quiz {
    //Cluster cluster;

    public QuizDetails getQuiz(int quizID) {
        QuizDetails quizDetails = new QuizDetails();

        Connection con;
        Statement statement = null;
        ResultSet quizRS = null;
        ResultSet questionRS = null;
        ResultSet answerRS = null;

        String title = "";

        try {
            con = DBConnection.createConnection(); //establishing connection
            /*if (con == null) {
                return true;
            }*/
            statement = con.createStatement();
            //statement2 = con.createStatement();
            quizRS = statement.executeQuery("select Available, Title, CreationDate from quiz where ID=" + quizID);

            while (quizRS.next()) {
                title = quizRS.getString("Title");
                quizDetails.setTitle(title);
                quizDetails.setAvailability(quizRS.getBoolean("Available"));
                quizDetails.setDate(quizRS.getDate("CreationDate").toString());
            }

            // con.close() ;
            //con = DBConnection.createConnection();
            statement = con.createStatement();
            questionRS = statement.executeQuery("select QuestionText, ExplanationText, Valid, QuestionNumber from question where QuizID = " + quizID);

            //quizDetails.setTitle(quizRS.getString("Title"));
            ArrayList<Question> questions = new ArrayList<Question>();

            while (questionRS.next()) // Until next row is present otherwise it return false
            {
                Question q = new Question();

                q.setQuestionText(questionRS.getString("QuestionText"));
                q.setExplanation(questionRS.getString("ExplanationText"));

                int questionNumber = questionRS.getInt("QuestionNumber");
                statement = con.createStatement();
                answerRS = statement.executeQuery("select AnswerText, Correct from answer where QuestionID = " + questionNumber);

                int c = 0;
                String[] answers = new String[4];
                while (answerRS.next()) {
                    boolean correct = answerRS.getBoolean("Correct");
                    if (correct) {
                        q.setCorrectAnswerID(c);
                    }
                    answers[c] = answerRS.getString("AnswerText");
                    c++;
                }
                q.setAnswers(answers);
                questions.add(q);
            }

            quizDetails.setQuestions(questions);
            con.close();
            return quizDetails;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * Returns 0 for null Quiz ID, the ID for successful registration of the
     * quiz, or -1 for error.
    *
     */
    public int RegisterQuiz(String title, String moduleID, int available, LocalDate creationDate) {
        Connection con = null;
        ResultSet rs = null;
        int id = 0;

        try {
            con = DBConnection.createConnection(); //establishing connection
            Statement statement = con.createStatement();
            PreparedStatement st;
            
            st = con.prepareStatement("Insert into quiz (Available, Title, CreationDate, moduleID) values (?,?,?,?)");
            st.setInt(1, available);
            st.setString(2, title);
            java.sql.Date dat = java.sql.Date.valueOf(creationDate);
            st.setDate(3, dat);
            st.setString(4, moduleID);
            st.executeUpdate();
            st.clearParameters();
            
           //statement.executeUpdate("Insert into quiz (Available, Title, CreationDate, moduleID) values ("+available+ "," +title+ "," +creationDate+ "," +moduleID+ ")" );

            rs = statement.executeQuery("Select ID from quiz where Title = '" + title + "' AND moduleID = " + moduleID + " AND CreationDate = '" + creationDate+"'");
            
            
            
            while (rs.next()) // Until next row is present otherwise it returns false
            {
                //get quiz id
                id = rs.getInt("ID");
                System.out.println("Quiz id: " + id);
            }
            con.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;

        }
        return id;
    }

    public int SubmitQuestion(String questionText, String explanationText, int quizID, int questionNumber) {
        Connection con = null;
        ResultSet rs = null;
        int id = 0;
        
        CallableStatement cstmt = null;
        
        try {
            con = DBConnection.createConnection(); //establishing connection
            Statement statement = con.createStatement();
            
            PreparedStatement st;
            //st = con.prepareStatement("call insertQuestion ('" + questionText + "','" + explanationText + "'," + quizID + "," + questionNumber + ")");
            //st = con.prepareStatement("{call insertQuestion ('" + questionText + "','" + explanationText + "'," + quizID + "," + questionNumber + ")}"); //added brackets
            //
            st = con.prepareStatement("{call insertQuestion (?,?,?,?)}"); // removed values, added brackets //step 2: callable statement
            //String SQL = "{call insertQuestion (?,?,?,?)}";
            //cstmt = con.prepareCall (SQL);
            
           
            st.setString(1, questionText);
            st.setString(2, explanationText);
            st.setInt(3, quizID);
            st.setInt(4, questionNumber);
            st.executeUpdate();
            st.clearParameters();
            
            /*
            cstmt.setString(1, questionText);
            cstmt.setString(2, explanationText);
            cstmt.setInt(3, quizID);
            cstmt.setInt(4, questionNumber);
            cstmt.executeUpdate();
            cstmt.clearParameters();
            */
            
            
            
            //rs = statement.executeQuery("call insertQuestion ('" + questionText + "','" + explanationText + "'," + quizID + "," + questionNumber + ")");
            rs = statement.executeQuery("Select ID from question where QuizID = " + quizID + " AND QuestionNumber = " + questionNumber);

            while (rs.next()) // Until next row is present otherwise it returns false
            {
                id = rs.getInt("ID");
            }
            System.out.println("question id: "+id);
            
            //cstmt.close();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;

        }
        return id;
    }

    public int SubmitAnswer(String answerText, int correct, int quizID, int questionNumber) {
                Connection con = null;
        ResultSet rs = null;
        int id = 0;

        try {
            con = DBConnection.createConnection(); //establishing connection
            Statement statement = con.createStatement();

            
            PreparedStatement st;
            //st = con.prepareStatement("call insertAnswer ('" + answerText + "','" + correct + "'," + questionID + "," + questionNumber + ")");
            st = con.prepareStatement("{call insertAnswer (?,?,?,?)}");
            st.setString(1, answerText);
            st.setInt(2, correct);
            st.setInt(3, quizID);
            st.setInt(4, questionNumber);
            st.executeUpdate();
            st.clearParameters();
            
            //rs = statement.executeQuery("call insertAnswer where answer, isCorrect, quizID, questionNum = " + answerText + "," + correct + "," + questionID + "," + questionNumber + ";");
            //rs = statement.executeQuery("Select ID from answer where QuestionID = " + quizID + " AND AnswerText = " + answerText + ";");

            /*
            while (rs.next()) // Until next row is present otherwise it returns false
            {
                id = rs.getInt("ID");
            }
            
            System.out.println("answerid: " +id);
            */
            
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
            return -1;

        } 
        return id;
    }
}
