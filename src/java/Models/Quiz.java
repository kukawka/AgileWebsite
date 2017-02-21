package Models;

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

    public QuizDetails getQuiz(int quizID) {
        QuizDetails quizDetails = new QuizDetails();

        Connection con;
        Statement statement = null;
        Statement statement2 = null;
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

                q.setQuestion(questionRS.getString("QuestionText"));
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

    public boolean RegisterQuiz(String title, String moduleID) {
        //prepare query
        //PreparedStatement ps = session.prepare("insert into quiz (title,moduleID) Values(?,?)");

        //prepared statement from ^
        //BoundStatement boundStatement = new BoundStatement(ps); 
        //session.execute(  boundStatement.bind(title,moduleID));
        return true;
    }

    public boolean SubmitQuestion(UUID questionID, String questionText, String explanationText, boolean valid, UUID quizID) {
        //prepare query
        //PreparedStatement ps = session.prepare("insert into question (questionID,questionText,explanationText,valid,quizID) Values(?,?,?,?,?)");

        //prepared statement from ^
        //BoundStatement boundStatement = new BoundStatement(ps); 
        //session.execute(  boundStatement.bind(questionID,questionText,explanationText,valid,quizID));
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
