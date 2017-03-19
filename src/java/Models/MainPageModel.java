package Models;

import Beans.Module;
import Beans.ProgrammeOfStudy;
import Beans.Quiz;
import Util.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Refactored 18/03 by Philipp.
 *
 * @author Krasi + Philipp PairProg
 */
public class MainPageModel 
{
    /** As the MainPage loads all Programmes of Study (PoS) will be pulled from the Database 
     *  to populate the Nav-Bar.
     * 
     * @return ArrayList<ProgrammeOfStudy>
     * @throws SQLException 
     */
    public ArrayList<ProgrammeOfStudy> getPOS() throws SQLException 
    {
        Connection con      = null;
        ResultSet resultPOS = null;
        Statement statement = null;
        ArrayList<ProgrammeOfStudy> poses = new ArrayList<>();

        try 
        {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            resultPOS = statement.executeQuery("SELECT * FROM programme_of_study");

            while (resultPOS.next()) 
            {
                ProgrammeOfStudy pos = new ProgrammeOfStudy();
                pos.setID(resultPOS.getInt("ID"));
                pos.setName(resultPOS.getString("Name"));
                poses.add(pos);
            }
            
            con.close();
            return poses;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally { //finally runs before a return in the try block
            if (con != null && !con.isClosed()) {
                con.close();
            }
        }
        
        return null; // DB Conn failed or no PoS found.
    }
    
    /** Upon selection of a PoS all relevant modules will be pulled from the DB.
     * 
     * @param ID
     * @param userID
     * @return ArrayList<Module>
     */
    public ArrayList<Module> getModules(int ID, String userID) 
    {
        Connection con;
        ResultSet resultModules   = null;
        Statement statement       = null;
        ArrayList<Module> modules = new ArrayList<>();

        try 
        {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            Statement statement1 = con.createStatement();

            resultModules = statement.executeQuery("SELECT ID,Name FROM module WHERE POS=" + ID);
            while (resultModules.next()) 
            {
                Module module = new Module();
                module.setID(resultModules.getInt("ID"));
                module.setName(resultModules.getString("Name"));

                ResultSet choiceResult = statement1.executeQuery("SELECT studentID,moduleID FROM student_modules WHERE studentID =" + userID + " and moduleID=" + resultModules.getInt("ID"));
                if (choiceResult.first() == true) 
                {
                    module.setChoice(1);
                }
                modules.add(module);
            }
            
            con.close();
            return modules;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null; // No modules found or DB Conn failure.
    }

    /** When selecting a module its' quizzes will be pulled from the DB and displayed.
     * 
     * @param ID
     * @param userType
     * @param userID
     * @return ArrayList<Quiz>
     */
    public ArrayList<Quiz> getQuizzes(int ID, String userType, int userID) 
    {
        ResultSet resultQuizzes = null;
        Statement statement     = null;
        ArrayList<Quiz> quizzes = new ArrayList<>();
        Connection con;

        try 
        {
            con = DBConnection.createConnection();
            statement = con.createStatement();

            if (userType.equals("Staff")) 
            {
                resultQuizzes = statement.executeQuery("SELECT ID,Title FROM quiz WHERE moduleID=" + ID);
                while (resultQuizzes.next()) 
                {
                    Quiz quiz = new Quiz();
                    quiz.setID(resultQuizzes.getInt("ID"));
                    quiz.setName(resultQuizzes.getString("Title"));
                    quizzes.add(quiz);
                }
            }
            if (userType.equals("Student")) 
            {
                resultQuizzes = statement.executeQuery("SELECT ID,Title FROM quiz WHERE moduleID=" + ID + " AND Available=1");
                while (resultQuizzes.next()) 
                {
                    Quiz quiz = new Quiz();
                    quiz.setID(resultQuizzes.getInt("ID"));
                    quiz.setName(resultQuizzes.getString("Title"));
                    quizzes.add(quiz);
                }
                ArrayList<Integer> ids = new ArrayList<>();
                
                ResultSet completedQuizzes = statement.executeQuery("SELECT quizID FROM completed_quiz WHERE userID=" + userID);
                while (completedQuizzes.next()) 
                {
                    ids.add(completedQuizzes.getInt("quizID"));
                }
                for (int i = 0; i < quizzes.size(); i++) 
                {
                    if (ids.contains(quizzes.get(i).getID())) 
                    {
                        quizzes.get(i).setCompletion(true);
                    } else 
                    {
                        quizzes.get(i).setCompletion(false);
                    }
                }
            }
            
            con.close();
            return quizzes;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return null;
    }
}
