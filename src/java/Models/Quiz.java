package Models ;

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

public class Quiz {
    //Cluster cluster;

    public QuizDetails getQuiz(int quizID){
        QuizDetails quizDetails = new QuizDetails();

        Connection con;
        Statement statement = null;
        Statement statement2 = null;
        ResultSet quizRS = null;
        ResultSet questionRS = null;
        ResultSet answerRS = null;

        try {
            con = DBConnection.createConnection(); //establishing connection
            /*if (con == null) {
                return true;
            }*/
            statement = con.createStatement();
            statement2 = con.createStatement();
            quizRS = statement.executeQuery("select Available, Title, CreationDate from quiz where ID = " + quizID);
            questionRS = statement2.executeQuery("select QuestionText, ExplanationText, Valid, QuestionNumber from question where QuizID = " + quizID);

            quizDetails.setTitle(quizRS.getString("Title"));
            quizDetails.setAvailability(quizRS.getBoolean("Available"));
            quizDetails.setDate(quizRS.getDate("CreationDate").toString());

            ArrayList<Question> questions = new ArrayList<Question>();

            while (questionRS.next()) // Until next row is present otherwise it return false
            {
                Question q = new Question();

                q.setQuestion(quizRS.getString("QuestionText"));
                q.setExplanation(quizRS.getString("ExplanationText"));

                int questionNumber = quizRS.getInt("QuestionNumber");
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
            
            return quizDetails;
        } catch (SQLException e) {
            e.printStackTrace();   
            return null; 
        }

    }

    /**
     *Returns 0 for null Quiz ID, the ID for successful registration of the quiz, or -1 for error.
    **/
    public int RegisterQuiz(String title, String moduleID, int available, LocalDate creationDate) {        
        Connection con = null;
        ResultSet rs = null;
        int id=0;        
        
        try{
            con = DBConnection.createConnection(); //establishing connection
            Statement statement = con.createStatement();
           //////////////////////////////////////
            System.out.println("title: "+title);
            System.out.println("moduleID: "+moduleID);
            System.out.println("creationDate: "+creationDate);
             System.out.println("available: "+available);
             ////////////////////////////////////////////////
             PreparedStatement st;
             st = con.prepareStatement("Insert into quiz (Available, Title, CreationDate, moduleID) values (?,?,?,?)");
             st.setInt(1,available);
             st.setString(2,title);
             java.sql.Date dat = java.sql.Date.valueOf(creationDate);
             st.setDate(3,dat);
             st.setString(4,moduleID);
             st.executeUpdate();
             st.clearParameters();
            //statement.executeUpdate("Insert into quiz (Available, Title, CreationDate, moduleID) values ("+available+ "," +title+ "," +creationDate+ "," +moduleID+ ")" );
            rs = statement.executeQuery("Select ID from quiz where Title = " + title + " AND moduleID = " + moduleID + " AND CreationDate = " + creationDate );
            con.close();
            while (rs.next()) // Until next row is present otherwise it returns false
            {
                //get quiz id
                id = rs.getInt("ID");
                System.out.println("Quiz id: "+id);
            }
        }catch(SQLException e){
            e.printStackTrace();   
            return -1;
            
        }
        return id;
    }

    public int SubmitQuestion(String questionText, String explanationText, int quizID, int questionNumber) {
        Connection con = null;
        ResultSet rs = null;
        int id=0;
        
        try{
            con = DBConnection.createConnection(); //establishing connection
            Statement statement = con.createStatement();
            
            rs = statement.executeQuery("call insertQuestion where question, explanation, quizID, questNum = " +questionText+ "," +explanationText+ "," +quizID+  "," +questionNumber+ ";");
            rs = statement.executeQuery("Select ID from question where QuizID = " + quizID + " AND QuestionNumber = " + questionNumber + ";" );
            
            while (rs.next()) // Until next row is present otherwise it returns false
            {
                id = rs.getInt("ID");
            }
            
        }catch(SQLException e){
            e.printStackTrace();   
            return -1;
            
        }
        finally{
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) { }
            }
             if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) { }
            }
        }
        return id;
    }

    public int SubmitAnswer(String answerText, int correct, int questionID, int questionNumber) {
        Connection con = null;
        ResultSet rs = null;
        int id=0;
        
        try{
            con = DBConnection.createConnection(); //establishing connection
            Statement statement = con.createStatement();
            
            rs = statement.executeQuery("call insertAnswer where answer, isCorrect, quizID, questionNum = " +answerText+ "," +correct+ "," +questionID+  "," +questionNumber+ ";");
            rs = statement.executeQuery("Select ID from answer where QuestionID = " + questionID + " AND AnswerText = " + answerText + ";" );
            
            while (rs.next()) // Until next row is present otherwise it returns false
            {
                id = rs.getInt("ID");
            }
            
        }catch(SQLException e){
            e.printStackTrace();   
            return -1;
            
        }
        finally{
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) { }
            }
             if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) { }
            }
        }
        return id;
    }
}
