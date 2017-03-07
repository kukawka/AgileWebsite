package Models;

import Beans.Question;
import Beans.ProgrammeOfStudy;
import Util.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

import java.sql.CallableStatement;

public class Modules {
    //Cluster cluster;

    /**
     * @ param the ID of the Quiz selected
     * @ return the details of the Quiz
     */
    /*public ProgrammeOfStudy getModules(int posID) {
        
        ProgrammeOfStudy modules = new ProgrammeOfStudy();

        Connection con;
        Statement statement = null;
        ResultSet posRS = null;
        ResultSet modulesRS = null;

        String title = "";

        try {
            con = DBConnection.createConnection(); //establishing connection
            statement = con.createStatement();
            modulesRS = statement.executeQuery("select ID, Name from module where POS=" + posID);

            while (modulesRS.next()) {
                title = quizRS.getString("Title");
                quizDetails.setTitle(title);
                quizDetails.setAvailability(quizRS.getBoolean("Available"));
                quizDetails.setDate(quizRS.getDate("CreationDate").toString());
            }

            statement = con.createStatement();
            questionRS = statement.executeQuery("select ID,QuestionText, ExplanationText, Valid, QuestionNumber from question where QuizID = " + quizID);

            ArrayList<Question> questions = new ArrayList<>();

            while (questionRS.next()) // Until next row is present otherwise it return false
            {
                Question q = new Question();

                q.setQuestionText(questionRS.getString("QuestionText"));
                q.setExplanation(questionRS.getString("ExplanationText"));

                int questionNumber = questionRS.getInt("QuestionNumber");
                statement = con.createStatement();
                answerRS = statement.executeQuery("select AnswerText, Correct from answer where QuestionID = " + questionRS.getInt("ID"));

                int c = 0;
                //String[] answers = new String[4];
                ArrayList<String> answers = new ArrayList<>();
                ArrayList<Integer> correctAnswers = new ArrayList<>();

                while (answerRS.next()) {
                    boolean correct = answerRS.getBoolean("Correct");
                    if (correct) {
                        correctAnswers.add(c);
                    }
                    answers.add(answerRS.getString("AnswerText"));
                    c++;
                }
                q.setCorrectAnswers(correctAnswers);
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
    }*/

}
