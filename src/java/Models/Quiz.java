import java.util.Date;
import java.util.UUID;

public class Quiz {
    //Cluster cluster;

    public Quiz(){
        //initialise variables
        
    }
    
    public boolean RegisterQuiz(String title, String moduleID)
    {
    	//prepare query
        PreparedStatement ps = session.prepare("insert into quiz (title,moduleID) Values(?,?)");
       
        //prepared statement from ^
        BoundStatement boundStatement = new BoundStatement(ps); 
        session.execute(  boundStatement.bind(title,moduleID));
    }

    public boolean SubmitQuestion(UUID questionID, String questionText, String explanationText, boolean valid, UUID quizID)
    {
    	//prepare query
        PreparedStatement ps = session.prepare("insert into question (questionID,questionText,explanationText,valid,quizID) Values(?,?,?,?,?)");
       
        //prepared statement from ^
        BoundStatement boundStatement = new BoundStatement(ps); 
        session.execute(  boundStatement.bind(questionID,questionText,explanationText,valid,quizID));
    }

    public boolean SubmitAnswer(UUID answerID, String answerText, boolean correct, UUID questionID)
    {
    	//prepare query
        PreparedStatement ps = session.prepare("insert into answer (answerID,answerText,correct,questionID) Values(?,?,?,?)");
       
        //prepared statement from ^
        BoundStatement boundStatement = new BoundStatement(ps); 
        session.execute(  boundStatement.bind(answerID,answerText,correct,questionID));
    }

