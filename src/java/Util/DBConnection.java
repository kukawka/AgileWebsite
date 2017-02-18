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
import static java.lang.System.out;

import java.sql.*;

public class DBConnection {

    public static Connection createConnection() {
        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();

            con = DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306/16agileteam3db", "16agileteam3", "0498.at3.8940");
            if(!con.isClosed()) out.println("Success");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }
}
