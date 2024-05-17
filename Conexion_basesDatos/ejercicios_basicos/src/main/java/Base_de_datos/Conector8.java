package Base_de_datos;

import Modelos.Alumno;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Conector8 {
    public Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/personas";
        String user = "root";
        String password = "1234";
        return DriverManager.getConnection(url, user, password);
    }

    public List<Alumno> listaAlumnos() {
        List<Alumno> listaAlumnos = new ArrayList<>();
        try (Connection connection = connect()){
            Statement statement = connection.createStatement();
            String pedir = JOptionPane.showInputDialog("Quieres buscar por id, nombre apellidos o por todo");
            if (pedir.equalsIgnoreCase("id")) {
                int id_param = Integer.parseInt(JOptionPane.showInputDialog("Dime el id"));
                ResultSet resultSet = null;
                resultSet = ("SELECT * FROM alumnos WHERE id = " + id_param);
                ResultSet
                preparedStatement.executeQuery();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listaAlumnos;
    }
}
