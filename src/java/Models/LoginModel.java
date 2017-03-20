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
    /** Verify entered Login credentials.
     * 
     * @param username
     * @param password
     * @return String
     */
    public String authenticateLogin(String username, String password) 
    {
        Connection con;
        Statement statement = null;
        ResultSet resultSet = null;

        String userNameDB = "";
        String passwordDB = "";
        String typeDB     = "";
        boolean matched   = false;
        
        try 
        {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            resultSet = statement.executeQuery("SELECT ID,Password,Type FROM user"); 
            
            while (resultSet.next())
            {
                userNameDB = resultSet.getString("ID");
                passwordDB = resultSet.getString("Password");
                typeDB     = resultSet.getString("Type");

                if (username.equals(userNameDB) && password.equals(passwordDB)) 
                {
                    matched = true;// User credential match found in DB.
                    break;
                }
            }
            
            resultSet.close();
            statement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        if(matched == true)
            return typeDB;
        else
            return null; // User/Password not found or wrong.
    }

}
