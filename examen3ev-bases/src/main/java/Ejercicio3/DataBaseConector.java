package Ejercicio3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConector {
    String url = "jdbc:mysql://localhost:3306/supermercado";
    String user = "root";
    String password = "1234";
    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
}
