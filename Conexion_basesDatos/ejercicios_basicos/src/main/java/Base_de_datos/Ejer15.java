package Base_de_datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Ejer15 {
    public Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/peronas";
        String user = "root";
        String password = "1234";
        return DriverManager.getConnection(url, user, password);
    }
    public int listarCursos() {
        int numero_filas = 0;

    }
}
