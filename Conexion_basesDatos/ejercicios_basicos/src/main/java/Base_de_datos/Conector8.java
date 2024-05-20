package Base_de_datos;

import Modelos.Alumno;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Conector8 {
    public Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/peronas";
        String user = "root";
        String password = "1234";
        return DriverManager.getConnection(url, user, password);
    }

    public List<Alumno> listaAlumnos() {
        List<Alumno> listaAlumnos = new ArrayList<>();
        try (Connection connection = connect()) {
            String pedir = JOptionPane.showInputDialog("Quieres buscar por id o por nombre completo");
            Statement statement = null;
            if (pedir.equalsIgnoreCase("id")) {
                int id_param = Integer.parseInt(JOptionPane.showInputDialog("Dime el id"));

                statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM alumnos WHERE id = " + id_param);

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nombre = resultSet.getString("nombre");
                    String apellidos = resultSet.getString("apellidos");
                    String direccion = resultSet.getString("direccion");

                    Alumno alumno = new Alumno(id, nombre, apellidos, direccion);
                    listaAlumnos.add(alumno);
                }
            } else if (pedir.equalsIgnoreCase("nombre completo")) {
                String nombre_param = JOptionPane.showInputDialog("Dime el nombre");

                PreparedStatement preparedStatement = connect().prepareStatement("SELECT * FROM alumnos WHERE CONCAT(nombre, ' ', apellidos) LIKE ?");
                preparedStatement.setString(1, "%" + nombre_param + "%");

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nombre = resultSet.getString("nombre");
                    String apellidos = resultSet.getString("apellidos");
                    String direccion = resultSet.getString("direccion");

                    Alumno alumno = new Alumno(id, nombre, apellidos, direccion);
                    listaAlumnos.add(alumno);

//                String nombre_param = String.valueOf(JOptionPane.showInputDialog("Dime el nombre"));
//
//                statement = connection.createStatement();
//                ResultSet resultSet = statement.executeQuery("SELECT * FROM alumnos WHERE CONCAT(nombre, apellidos) = " + nombre_param);
//
//                while (resultSet.next()) {
//                    int id = resultSet.getInt("id");
//                    String nombre = resultSet.getString("nombre");
//                    String apellidos = resultSet.getString("apellidos");
//                    String direccion = resultSet.getString("direccion");
//
//                    Alumno alumno = new Alumno(id, nombre, apellidos, direccion);
//                    listaAlumnos.add(alumno);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listaAlumnos;
    }
}
