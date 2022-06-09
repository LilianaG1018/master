package Orange.BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class InsertEmployee {

    private ConectionBd conectionBd;

    public InsertEmployee() {
        this.conectionBd = new ConectionBd();
    }

    public static void insertAddEmployee(String name, String lastName) {
        try {
            Connection connection = ConectionBd.getConnection();
            if (connection != null) {
                String insertSql = "INSERT INTO newEmployee (firstName, lastName) VALUES"
                        + "('" + name + "', '" + lastName + "')";
                PreparedStatement prepsInsertProduct = connection.prepareStatement(insertSql, Statement.RETURN_GENERATED_KEYS);
                {
                    prepsInsertProduct.execute();
                    // Retrieve the generated key from the insert.
                    ResultSet resultSet = prepsInsertProduct.getGeneratedKeys();
                    // Print the ID of the inserted row.
                    while (resultSet.next()) {
                        System.out.println("Generated: " + resultSet.getString(1));
                    }
                }
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
