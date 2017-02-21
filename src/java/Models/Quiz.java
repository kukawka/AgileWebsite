package Models ;

import Beans.Question;
import Beans.QuizDetails;
import Util.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    public int RegisterQuiz(String title, String moduleID, boolean available, Date creationDate, UUID quizID) {
        Connection con = null;
        ResultSet rs = null;
        
        
        try{
            con = DBConnection.createConnection(); //establishing connection
            Statement statement = con.createStatement();
            
            rs = statement.executeQuery("insert into quiz (title, moduleID, available, creationDate) values ('title', 'moduleID', 'available', 'creationDate')");
            rs = statement.executeQuery("Select ID from quiz where Title = " + title + " AND moduleID = " + moduleID + " AND CreationDate = " + creationDate + ";" );
            int id;
            while (rs.next()) // Until next row is present otherwise it return false
            {
                //id = rs.getInteger("ID");
            }
        }catch(SQLException e){
            e.printStackTrace();   
            return -1;
            
        }
        finally{
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) { /* ignored */}
            }
             if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
        return 1;
    }

    public boolean SubmitQuestion(UUID questionID, String questionText, String explanationText, boolean valid, UUID quizID) {
        Connection con = null;
        ResultSet rs = null;
        
        try{
            con = DBConnection.createConnection(); //establishing connection
            Statement statement = con.createStatement();
            
            //rs = statement.executeQuery("insert into quiz (title, moduleID, available, creationDate, quizID) values ('title', 'moduleID', 'available', 'creationDate', 'quizID')");
            //rs = 
            
            
        }catch(SQLException e){
            e.printStackTrace();   
            return false;
            
        }
        finally{
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) { /* ignored */}
            }
             if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
        return true;
    }

    public boolean SubmitAnswer(UUID answerID, String answerText, boolean correct, UUID questionID) {
        //prepare query
        //PreparedStatement ps = session.prepare("insert into answer (answerID,answerText,correct,questionID) Values(?,?,?,?)");

        //prepared statement from ^
        //BoundStatement boundStatement = new BoundStatement(ps); 
        //session.execute(  boundStatement.bind(answerID,answerText,correct,questionID));
        return true;
    }
}
