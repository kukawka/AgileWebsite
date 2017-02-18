/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author Dagi
 */
//The following code is applicable while connecting to SQL server only.
 
import java.sql.Connection;
 import java.sql.DriverManager;
 
public class DBConnection {
 
public static Connection createConnection()
 {
 Connection con = null;
 String url = "silva.computing.dundee.ac.uk/16agileteam3db"; //for SQL and oracle or any other db server this url differs. where ravi is the database name and 3306 is the port where mysql is running
 String username = "16agileteam3"; //username of database user
 String password = "0498.at3.8940"; //password
 /*
 U: 16agileteam3
P: 0498.at3.8940
D: 16agileteam3db
S: silva.computing.dundee.ac.uk*/
 
try
 {
 try
 {
 Class.forName("com.mysql.jdbc.Driver");// differs from DB server to server
 }
 catch (ClassNotFoundException e)
 {
 e.printStackTrace();
 }
 
con = DriverManager.getConnection(url, username, password);
 
}
 catch (Exception e)
 {
 e.printStackTrace();
 }
 
return con;
 }
 }
