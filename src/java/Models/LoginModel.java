package Models;

import Util.DBConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Refactored 18/03 by Philipp.
 * @author Dagi
 */
public class LoginModel 
{
    public String authenticateLogin(String username, String password) 
    {
        Connection con;
        Statement statement = null;
        ResultSet resultSet = null;

        String userNameDB = "";
        String passwordDB = "";
        String typeDB     = "";

        try 
        {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("select ID,Password, Type from user"); 
            
            while (resultSet.next())
            {
                userNameDB = resultSet.getString("ID");
                passwordDB = resultSet.getString("Password");
                typeDB     = resultSet.getString("Type");

                if (username.equals(userNameDB) && password.equals(passwordDB)) 
                {
                    return typeDB; // User credentials found in DB.
                }
            }
            resultSet.close();
            statement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // User/Password not found or wrong.
    }

}
