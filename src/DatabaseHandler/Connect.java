package DatabaseHandler;

import Model.LoginUser;

import javax.swing.*;
import java.sql.*;

public class Connect {
    public static final String DB_NAME = "mydatabase";
    public static final String DB_URL = "jdbc:mysql://localhost/";
    public static final String DB_PACKAGE = "com.mysql.cj.jdbc.Driver";
    public static final String DB_USER = "root";
    private Connection connect;
    public Connect()
    {
        try {
            Class.forName(DB_PACKAGE);
            connect = DriverManager.getConnection(DB_URL+DB_NAME,DB_USER, "");
            JOptionPane.showMessageDialog(null, "Database Connected");
            //connect.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }


    public void userAuthentication(LoginUser lu)
    {
        String query = "SELECT * FROM test";
        /*String query = "SELECT * FROM test WHERE username = "+"\'"+lu.getUsername()+
                "\' and password = \'"+lu.getPassword()+"\'";
        */
        try {
            Statement statement = connect.createStatement();
            ResultSet rs = statement.executeQuery(query);

            //testing the output
            JOptionPane.showMessageDialog(null,rs.getString(2));
            JOptionPane.showMessageDialog(null,rs.getString(3));
            if(rs.getString("username")==lu.getUsername())
            {
                if(rs.getString("password")==lu.getPassword())
                    JOptionPane.showMessageDialog(null,"Access Granted");
                else
                    JOptionPane.showMessageDialog(null, "Invalid Password");
            }
            else
                JOptionPane.showMessageDialog(null, "Invalid Credentials");

        }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage());
            e.printStackTrace();
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, e.getMessage().toString());
        }

    }

}
