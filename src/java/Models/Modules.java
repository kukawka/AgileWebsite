package Models;

import Util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class Modules {
    //Cluster cluster;

    /**
     * @ param the ID of the Quiz selected
     * @ return the details of the Quiz
     */
    public void setModules(String user, String IDs) {
        Connection con;

        String[] arr = IDs.replaceFirst("^,", "").split(",");

        Statement statement = null;

        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            PreparedStatement st;

            for (int x = 0; x < arr.length; x++) {
                int choice = Integer.parseInt(arr[x]);

                System.out.println("TEEEESSSSTTTT " + user + ", " + arr[x]);

                st = con.prepareStatement("INSERT INTO student_modules (studentID, moduleID) values (?,?)");
                st.setString(1, user);
                st.setInt(2, choice);
                st.executeUpdate();
                st.clearParameters();
            }

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

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
