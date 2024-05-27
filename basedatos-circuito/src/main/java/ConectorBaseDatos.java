import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectorBaseDatos {
    public Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/circuito";
        String user = "root";
        String password = "1234";

        return DriverManager.getConnection(url, user, password);
    }
}
