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
        try (Connection connection = connect()) {
            Statement statement = connection.createStatement();
            String pedir = JOptionPane.showInputDialog("Quieres buscar por id, nombre apellidos o por todo");
            if (pedir.equalsIgnoreCase("id")) {
                int id_param = Integer.parseInt(JOptionPane.showInputDialog("Dime el id"));
                ResultSet resultSet = statement.executeQuery("SELECT * FROM alumnos WHERE ID = " + id_param);

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nombre = resultSet.getString("nombre");
                    String apellidos = resultSet.getString("apellidos");
                    String direccion = resultSet.getString("direccion");

                    Alumno alumno = new Alumno(id, nombre, apellidos, direccion);
                    listaAlumnos.add(alumno);
                }
            } else if (pedir.equalsIgnoreCase("nombre")) {
                String nombre_param = String.valueOf(JOptionPane.showInputDialog("Dime el nombre"));
//                String apellidos_param = String.format(JOptionPane.showInputDialog("Dime los apellidos"));

                ResultSet resultSet = statement.executeQuery("SELECT * FROM alumnos WHERE nombre = " + nombre_param);

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String nombre = resultSet.getString("nombre");
                    String apellidos = resultSet.getString("apellidos");
                    String direccion = resultSet.getString("direccion");

                    Alumno alumno = new Alumno(id, nombre, apellidos, direccion);
                    listaAlumnos.add(alumno);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listaAlumnos;
    }
}
