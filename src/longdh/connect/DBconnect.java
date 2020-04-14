package longdh.connect;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DBconnect implements Serializable {

    public static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String url = "jdbc:sqlserver://localhost:1433;databaseName=Ass2;user=sa;password=123456";

    public static Connection openConnect() {
        try {
            Class.forName(driver);
            Connection c = DriverManager.getConnection(url);
            return c;
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Cannot connect to database (" + e + ")");
        }
        return null;
    }
}
