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
 * @author Dagi
 */
public class LoginModel {

    public String authenticateLogin(String username, String password) {

        Connection con;
        Statement statement = null;
        ResultSet resultSet = null;

        String userNameDB = "";
        String passwordDB = "";
        String typeDB = "";

        try {
            con = DBConnection.createConnection(); //establishing connection
            /*if (con == null) {
                return true;
            }*/
            statement = con.createStatement();
            resultSet = statement.executeQuery("select ID,Password, Type from user"); //Here table name is users and userName,password are columns. fetching all the records and storing in a resultSet.
            while (resultSet.next()) // Until next row is present otherwise it return false
            {
                userNameDB = resultSet.getString("ID"); //fetch the values present in database
                passwordDB = resultSet.getString("Password");
                typeDB=resultSet.getString("Type");

                if (username.equals(userNameDB)
                        && password.equals(passwordDB)) {
                    return typeDB; ////If the user entered values are already present in database, which means user has already registered so I will return SUCCESS message.
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Just returning appropriate message otherwise
    }

}
