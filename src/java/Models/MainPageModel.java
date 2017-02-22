/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Beans.Module;
import Beans.ProgrammeOfStudy;
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
public ArrayList<ProgrammeOfStudy> getPOS()
    {
        
        ResultSet resultPOS = null;
        Statement statement = null;
        ArrayList<ProgrammeOfStudy> poses = new ArrayList<ProgrammeOfStudy>();
        try
        {
           Connection con;
           con = DBConnection.createConnection();
           statement = con.createStatement(); 
           resultPOS = statement.executeQuery("SELECT * FROM programme_of_study");
           
           while(resultPOS.next())
           {
               if(resultPOS!=null)
               {
                    ProgrammeOfStudy pos = new ProgrammeOfStudy();
                    System.out.println("ID: " + resultPOS.getInt("ID"));
                    System.out.println("Name" + resultPOS.getString("Name"));
                    pos.setID(resultPOS.getInt("ID"));
                    pos.setName(resultPOS.getString("Name"));
                    poses.add(pos);
               }
           }
           con.close();
           return poses;
           
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
       
        return null;
    }
    
/* Upon selection of a PoS all related modules will be pulled from the DB and used to populate the side Nav-bar further.
 *
*/
public ArrayList<Module> getModules(int ID)
    {
        
        ResultSet resultModules = null;
        Statement statement = null;
        ArrayList<Module> modules = new ArrayList<Module>();
        try
        {
           Connection con;
           con = DBConnection.createConnection();
           statement = con.createStatement(); 
           resultModules = statement.executeQuery("SELECT ID,Name FROM module WHERE POS=" + ID);
           while(resultModules.next())
           {
               if(resultModules!=null)
               {
                    Module module = new Module();
                    //System.out.println("ID: " + resultPOS.getInt("ID"));
                    //System.out.println("Name" + resultPOS.getString("Name"));
                    module.setID(resultModules.getInt("ID"));
                    module.setName(resultModules.getString("Name"));
                    modules.add(module);
               }
           }
           con.close();
           return modules;
           
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
       
        return null;
    }
/* Selecting a module will lead to all quizzes for that module to be pulled from the DB and displayed on the entire page beside the Nav-bar.
 * @params ID of selected module
*/
public ResultSet getQuizzes(int ID)
{   
    ResultSet resultQuizzes = null;
    Statement statement = null;
    try{
    Connection con;
    con = DBConnection.createConnection();
    resultQuizzes = statement.executeQuery("SELECT ID,Title FROM quiz WHERE moduleID="+ID);
    con.close();
    return resultQuizzes;
    
    }catch(SQLException e){
        e.printStackTrace();    
    }
    return null;
}
}
