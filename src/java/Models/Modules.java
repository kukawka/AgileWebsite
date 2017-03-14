package Models;

import Beans.Module;
import Beans.ModuleChoices;
import Beans.ProgrammeOfStudy;
import Util.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Modules {
    //Cluster cluster;

    /**
     * @ param the ID of the Quiz selected
     * @ return the details of the Quiz
     */
    public void setModules(String user, String IDs) {
        Connection con;

        String[] arr = IDs.replaceFirst("^,", "").split(",");

        Statement statement = null;

        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            PreparedStatement st;

            for (int x = 0; x < arr.length; x++) {
                int choice = Integer.parseInt(arr[x]);

                System.out.println("TEEEESSSSTTTT " + user + ", " + arr[x]);

                st = con.prepareStatement("INSERT INTO student_modules (studentID, moduleID) values (?,?)");
                st.setString(1, user);
                st.setInt(2, choice);
                st.executeUpdate();
                st.clearParameters();
            }

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void setModulesChoice(String user, String module) {
        Connection con;

        int mod = Integer.parseInt(module);

        Statement statement = null;

        try {
            con = DBConnection.createConnection();
            statement = con.createStatement();
            PreparedStatement st;

            System.out.println("CHOOOOOIIIIIICEE " + user + ", " + mod);

            st = con.prepareStatement("DELETE from student_modules where studentID = ? and moduleID = ?");
            st.setString(1, user);
            st.setInt(2, mod);
            st.executeUpdate();
            st.clearParameters();

            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Module> getChoices(String user) {

        ResultSet resultPOS = null;
        Statement statement = null;
        ArrayList<Module> modCho = new ArrayList<Module>();

        try {
            Connection con;
            con = DBConnection.createConnection();
            statement = con.createStatement();

            resultPOS = statement.executeQuery("SELECT moduleID FROM student_modules WHERE studentID =" + user);

            while (resultPOS.next()) {
                if (resultPOS != null) {

                    // int i = resultPOS.getInt("moduleID");
                    Statement statement1 = con.createStatement();
                    ResultSet addModules = statement1.executeQuery("SELECT Name FROM module WHERE ID=" + resultPOS.getInt("moduleID"));
                    while (addModules.next()) {
                        Module mod = new Module();

                        System.out.println("QQQQQQQ");
                        System.out.println("Module ID:" + resultPOS.getInt("moduleID"));
                        System.out.println("Name: " + addModules.getString("Name"));

                        mod.setID(resultPOS.getInt("moduleID"));
                        mod.setName(addModules.getString("Name"));
                        modCho.add(mod);
                    }
                }
            }
            con.close();
            return modCho;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
