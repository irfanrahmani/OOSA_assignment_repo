package DatabaseHandler;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
    public static final String DB_NAME = "mydatabase";
    public static final String DB_URL = "jdbc:mysql://localhost/";
    public static final String DB_PACKAGE = "com.mysql.cj.jdbc.Driver";
    public static final String DB_USER = "root";

    public Connect()
    {
        try {
            Class.forName(DB_PACKAGE);
            Connection connect = null;
            connect = DriverManager.getConnection(DB_URL+DB_NAME,DB_USER, "");
            JOptionPane.showMessageDialog(null, "Database Connected");
            connect.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

}
