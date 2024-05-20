package Base_de_datos;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CRUDejer10 {
    public Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/peronas";
        String user = "root";
        String password = "1234";
        return DriverManager.getConnection(url, user, password);
    }

    public int insertar_curso() {
        int numero_filas = 0;

        try (Connection connection = connect()){
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO cursos (nombre, instructor) VALUES (?, ?)");
            String nombre_curso = JOptionPane.showInputDialog("Dime el nombre del curso");
            String instructor_curso = JOptionPane.showInputDialog("Dime el instructor del curso");
            preparedStatement.setString(1, nombre_curso);
            preparedStatement.setString(2, instructor_curso);

            numero_filas = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numero_filas;
    }

    public int borrar_curso() {
        int numero_filas = 0;
        try (Connection connection = connect()){
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM cursos WHERE nombre = ?");
            String nombre_curso = JOptionPane.showInputDialog("Dime el nombre del curso a borrar");
            preparedStatement.setString(1, nombre_curso);

            numero_filas = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numero_filas;
    }

    public int editar_cursos() {
        int numero_filas = 0;

        try (Connection connection = connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE cursos SET nombre = ?, SET instructor = ? WHERE id = ?");
            int id_curso_editar = Integer.parseInt(JOptionPane.showInputDialog("Dime el id del curso a editar"));
            String nuevo_nombre = JOptionPane.showInputDialog("Dime el nuevo nombre");
            String nuevo_instructor = JOptionPane.showInputDialog("Dime el nuevo instructor");

            preparedStatement.setString(1, nuevo_nombre);
            preparedStatement.setString(2, nuevo_instructor);
            preparedStatement.setInt(3, id_curso_editar);

            numero_filas = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numero_filas;
    }
}
