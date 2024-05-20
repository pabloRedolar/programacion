package Base_de_datos;

import javax.swing.*;
import java.sql.*;


public class Conector11 {
    public Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/peronas";
        String user = "root";
        String password = "1234";
        return DriverManager.getConnection(url, user, password);
    }
    public int insertar_alumno_curso() {
        int numero_filas = 0;

        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO alumnos_pertenecen_cursos (id_alumno, id_curso) VALUES (?, ?)");
            int id_alumno = Integer.parseInt(JOptionPane.showInputDialog("Dime el id de un usuario para meterlo a un curso"));
            int id_curso = Integer.parseInt(JOptionPane.showInputDialog("Dime el id del curso"));

            preparedStatement.setInt(1, id_alumno);
            preparedStatement.setInt(2, id_curso);

            numero_filas = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numero_filas;
    }
}
