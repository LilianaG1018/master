package Orange.BaseDatos;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectionBd {
    private static Connection con;
    public static Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1434;databaseName=OrangeHrm", "Sap", "1234");
        } catch (Exception e) {
            con = null;
            e.printStackTrace();
        }
        return con;
    }

}
