
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

    public Quiz() {
        //initialise variables

    }

    public QuizDetails getQuiz(int quizID) {
        QuizDetails quizDetails = null;

        Connection con;
        Statement statement = null;
        ResultSet quizRS = null;
        ResultSet questionRS = null;
        ResultSet answerRS= null;

        try {
            con = DBConnection.createConnection(); //establishing connection
            /*if (con == null) {
                return true;
            }*/
            statement = con.createStatement();
            quizRS = statement.executeQuery("select Available, Title, CreationDate from quiz where ID = " + quizID);
            questionRS = statement.executeQuery("select QuestionText, ExplanationText, Valid, QuestionNumber from question where QuizID = " + quizID);
            
            quizDetails.setTitle(quizRS.getString("Title")) ;
            quizDetails.setAvailability(quizRS.getBoolean("Available"));
            quizDetails.setDate(quizRS.getDate("CreationDate").toString());
            
            
            
             while (questionRS.next()) // Until next row is present otherwise it return false
            {
                ArrayList<Question> questions = new ArrayList<Question>();
                int questionNumber = quizRS.getInt("QuestionNumber");
                answerRS = statement.executeQuery("select Available, Title, CreationDate from quiz where ID = " + quizID);
                /*String userNameDB = resultSet.getString("ID"); //fetch the values present in database
                passwordDB = resultSet.getString("Password");
                typeDB = resultSet.getString("Type");*/
/*
                if (username.equals(userNameDB)
                        && password.equals(passwordDB)) {
                    return typeDB; ////If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
                }
            }
            return quizDetails;
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        return null; // Just returning appropriate message otherwise

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
