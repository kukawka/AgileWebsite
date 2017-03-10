/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author Krasi+philipp PairProg
 */
public class MainPageModel {

    /* Upon mainpage loading the Programmes of Study (PoS) will be pulled from the Database and used to populate the 
     * available buttons in the Nav-bar on the side.
    COMMENTICO
     * 
     */
    public ArrayList<ProgrammeOfStudy> getPOS() {

        ResultSet resultPOS = null;
        Statement statement = null;
        ArrayList<ProgrammeOfStudy> poses = new ArrayList<ProgrammeOfStudy>();
        try {
            Connection con;
            con = DBConnection.createConnection();
            statement = con.createStatement();
            resultPOS = statement.executeQuery("SELECT * FROM programme_of_study");

            while (resultPOS.next()) {
                if (resultPOS != null) {
                    ProgrammeOfStudy pos = new ProgrammeOfStudy();
                    System.out.println("ID: " + resultPOS.getInt("ID"));
                    System.out.println("Name" + resultPOS.getString("Name"));
                    pos.setID(resultPOS.getInt("ID"));
                    pos.setName(resultPOS.getString("Name"));
                    // pos.setModules(getModules(resultPOS.getInt("ID")));
                    poses.add(pos);
                }
            }
            con.close();
            return poses;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /* Upon selection of a PoS all related modules will be pulled from the DB and used to populate the side Nav-bar further.
 *
     */
    public ArrayList<Module> getModules(int ID) {

        ResultSet resultModules = null;
        Statement statement = null;
        ArrayList<Module> modules = new ArrayList<Module>();
        try {
            Connection con;
            con = DBConnection.createConnection();
            statement = con.createStatement();
            resultModules = statement.executeQuery("SELECT ID,Name FROM module WHERE POS=" + ID);
            while (resultModules.next()) {
                if (resultModules != null) {
                    Module module = new Module();
                    System.out.println("POS ID:" + ID);
                    System.out.println("ID: " + resultModules.getInt("ID"));
                    System.out.println("Name" + resultModules.getString("Name"));
                    module.setID(resultModules.getInt("ID"));
                    module.setName(resultModules.getString("Name"));
                    //module.setQuizzes(getQuizzes(resultModules.getInt("ID")));
                    modules.add(module);
                }
            }
            con.close();
            return modules;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    /* Selecting a module will lead to all quizzes for that module to be pulled from the DB and displayed on the entire page beside the Nav-bar.
 * @params ID of selected module
     */
    public ArrayList<Quiz> getQuizzes(int ID, String userType, int userID) {
        ResultSet resultQuizzes = null;
        Statement statement = null;
        ArrayList<Quiz> quizzes = new ArrayList<Quiz>();
        try {
            Connection con;
            con = DBConnection.createConnection();
            statement = con.createStatement();
            if (userType.equals("Staff")) {
                resultQuizzes = statement.executeQuery("SELECT ID,Title FROM quiz WHERE moduleID=" + ID);
                while (resultQuizzes.next()) {
                    if (resultQuizzes != null) {
                        Quiz quiz = new Quiz();
                        System.out.println("POS ID:" + ID);
                        System.out.println("ID: " + resultQuizzes.getInt("ID"));
                        System.out.println("Name" + resultQuizzes.getString("Title"));
                        quiz.setID(resultQuizzes.getInt("ID"));
                        quiz.setName(resultQuizzes.getString("Title"));
                        //module.setQuizzes(getQuizzes(resultModules.getInt("ID")));
                        quizzes.add(quiz);
                    }
                }
            }
            if (userType.equals("Student")) {
                resultQuizzes = statement.executeQuery("SELECT ID,Title FROM quiz WHERE moduleID=" + ID + " AND Available=1");
                while (resultQuizzes.next()) {
                    if (resultQuizzes != null) {
                        Quiz quiz = new Quiz();
                        System.out.println("POS ID:" + ID);
                        System.out.println("ID: " + resultQuizzes.getInt("ID"));
                        System.out.println("Name" + resultQuizzes.getString("Title"));
                        quiz.setID(resultQuizzes.getInt("ID"));
                        quiz.setName(resultQuizzes.getString("Title"));
                        //module.setQuizzes(getQuizzes(resultModules.getInt("ID")));
                        quizzes.add(quiz);
                    }
                }
                ResultSet completedQuizzes = statement.executeQuery("SELECT quizID FROM completed_quiz WHERE userID=" + userID);
                ArrayList<Integer> ids = new ArrayList<Integer>();
                while (completedQuizzes.next()) {
                    if (completedQuizzes != null) {
                        ids.add(completedQuizzes.getInt("quizID"));
                    }
                }
                for(int i=0;i<quizzes.size();i++)
                {
                    if(ids.contains(quizzes.get(i).getID())) quizzes.get(i).setCompletion(true);
                    else quizzes.get(i).setCompletion(false);
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
