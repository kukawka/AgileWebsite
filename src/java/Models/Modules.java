package Models;

import Beans.Module;
import Util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Javier
 */

public class Modules 
{
    /** Adds modules selected as favourite to DB.
     *  
     * @param user
     * @param IDs 
     */
    public void setFavModules(String user, String IDs)
    {
        Connection con;
        String[] idArray = IDs.replaceFirst("^,", "").split(",");

        try 
        {
            con = DBConnection.createConnection();
            PreparedStatement prepStatement;

            for (int x = 0; x < idArray.length; x++) 
            {
                int choice = Integer.parseInt(idArray[x]);
                prepStatement = con.prepareStatement("INSERT INTO student_modules (studentID, moduleID) VALUES (?,?)");
                prepStatement.setString(1, user);
                prepStatement.setInt(2, choice);
                prepStatement.executeUpdate();
                prepStatement.clearParameters();
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /** Removes selected modules from favourites.
     * 
     * @param user
     * @param module 
     */
    public void removeFavModule(String user, String module)
    {
        Connection con;
        int moduleID = Integer.parseInt(module);

        try 
        {
            con = DBConnection.createConnection();
            PreparedStatement prepStatement;

            prepStatement = con.prepareStatement("DELETE from student_modules where studentID = ? and moduleID = ?");
            prepStatement.setString(1, user);
            prepStatement.setInt(2, moduleID);
            prepStatement.executeUpdate();
            prepStatement.clearParameters();

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /** Pull modules from DB and return them.
     * 
     * @param user
     * @return ArrayList<Module>
     */
    public ArrayList<Module> getModules(String user)
    {
        ResultSet resultPOS     = null;
        ResultSet resultModules = null;
        Statement statement     = null;
        Statement statement1    = null;
        ArrayList<Module> moduleList = new ArrayList<>();

        try {
            Connection con;
            con = DBConnection.createConnection();
            statement = con.createStatement();
            

            resultPOS = statement.executeQuery("SELECT moduleID FROM student_modules WHERE studentID =" + user);
            while (resultPOS.next()) 
            {
                if (resultPOS != null) 
                {
                    statement1 = con.createStatement();
                    resultModules = statement1.executeQuery("SELECT Name FROM module WHERE ID=" + resultPOS.getInt("moduleID"));
                    while (resultModules.next()) 
                    {
                        Module module = new Module();
                        module.setID( resultPOS.getInt("moduleID") );
                        module.setName( resultModules.getString("Name") );
                        moduleList.add(module);
                    }
                }
            }
            con.close();
            return moduleList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
