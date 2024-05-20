package Base_de_datos;

import Modelos.Cursos;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE cursos SET nombre = ?, instructor = ? WHERE id = ?");
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

    public List<Cursos> listarCursos() {
        List<Cursos> lista_de_cursos = new ArrayList<>();

        try (Connection connection = connect()){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM cursos");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getString("nombre");
                String instructor = resultSet.getString("instructor");

                Cursos nuevo_curso = new Cursos(id, nombre, instructor);
                lista_de_cursos.add(nuevo_curso);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return lista_de_cursos;
    }
}
