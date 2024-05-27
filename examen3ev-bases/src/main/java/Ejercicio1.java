import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio1 {
    public static void main(String[] args) {
        existebasedatos();
    }

    public static void existebasedatos() {
        DataBaseConector dataBaseConector = new DataBaseConector();
        try (Connection connection = dataBaseConector.connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SHOW DATABASES");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<String> nombres_bases = new ArrayList<>();

            while (resultSet.next()) {
                nombres_bases.add(resultSet.getString(1));
            }
            if (nombres_bases.contains("supernivel")) {
                System.out.println("La base de datos ya existe");
            } else {
                preparedStatement.executeUpdate("CREATE DATABASE supernivel");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
