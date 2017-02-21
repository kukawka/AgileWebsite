/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Util.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Krasi+philipp PairProg
 */
public class MainPageModel {
    
public ResultSet getPOS()
    {
        
        ResultSet resultPOS = null;
        Statement statement = null;
        try
        {
           Connection con;
           con = DBConnection.createConnection();
           statement = con.createStatement(); 
           resultPOS = statement.executeQuery("Select * from programme_of_study");
           con.close();
           return resultPOS;
           
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
       
        return null;
    }
    
    public ResultSet getModules(int ID)
    {
        
        ResultSet resultModules = null;
        Statement statement = null;
        try
        {
           Connection con;
           con = DBConnection.createConnection();
           statement = con.createStatement(); 
           resultModules = statement.executeQuery("Select ID,Name from module where POS=" + ID);
           con.close();
           return resultModules;
           
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
       
        return null;
    }
}
