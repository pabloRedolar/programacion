package Base_de_datos;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Conector9 {
    public Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/peronas";
        String user = "root";
        String password = "1234";
        return DriverManager.getConnection(url, user, password);
    }

    public int tablas() {
        int numero_filas = 0;
        try (Connection connection = connect()) {
           Statement statement = connection.createStatement();

           String nombre_tabla = JOptionPane.showInputDialog("Dime el nombre de la tabla");
           int numero_campos = Integer.parseInt(JOptionPane.showInputDialog("Cuantos campos quieres introducir?"));

            List<String> campos = new ArrayList<>();

            for (int i = 1; i <= numero_campos; i++) {
                String campo = JOptionPane.showInputDialog("Dime el nombre y el tipo de campo " + i);
                campos.add(campo);
            }
            String campos_difinicion = String.join(", ", campos);

           statement.execute("CREATE TABLE " + nombre_tabla + " (" + campos_difinicion + ")");

           ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM " + nombre_tabla);
           if (resultSet.next()) {
               numero_filas = resultSet.getInt(1);
           }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numero_filas;
    }
}
