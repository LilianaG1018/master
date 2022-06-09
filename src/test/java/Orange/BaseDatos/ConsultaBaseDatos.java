package Orange.BaseDatos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultaBaseDatos {

    private ConectionBd conectionBd;

    public ConsultaBaseDatos() {
        this.conectionBd = new ConectionBd();
    }

    public static void consultUsers() throws SQLException {
        Connection connection = ConectionBd.getConnection();
        if (connection != null) {
            System.out.println("conecto");
            Statement stm = connection.createStatement();
            ResultSet rst = stm.executeQuery("Select * from newEmployee");
            while (rst.next()) {
                System.out.println("employee: " + rst.getString(1) + rst.getString(2));
            }
            connection.close();
        } else {
            System.out.println("NO conecto");
        }

    }

}
