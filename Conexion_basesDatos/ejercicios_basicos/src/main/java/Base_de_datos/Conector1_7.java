package Base_de_datos;

import Modelos.Alumno;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Conector1_7 {
    public Connection connect() throws SQLException {
        String password = "1234";
        String url = "jdbc:mysql://localhost:3306/peronas";
        String user = "root";
        return DriverManager.getConnection(url, user, password);
    }


    public int insertalumnos() {
        int numeroFilas = 0;
        try {
            Connection connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO alumnos (nombre, apellidos, direccion) VALUES (?, ?, ?)");
            String nombre = JOptionPane.showInputDialog("Pon un nombre");
            String apellidos = JOptionPane.showInputDialog("Pon un apellido");
            String direccion = JOptionPane.showInputDialog("Pon una dirección");
            preparedStatement.setString(1, nombre);
            preparedStatement.setString(2, apellidos);
            preparedStatement.setString(3, direccion);

            // Ejecutamos la consulta
            numeroFilas = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numeroFilas;
    }

    public int actualizaAlumnos() {
        int numeroFilas = 0;
        String opciones = JOptionPane.showInputDialog("Dime que quieres modificar: Nombre, apellidos, dirección o todo. Tambien puedes listar con: listar");

        try {
            switch (opciones.toLowerCase()) {
                case "nombre" -> {
                    Connection connection = connect();
                    PreparedStatement preparedStatement = connection.prepareStatement("UPDATE alumnos SET nombre = ? WHERE id = ?");
                    String id = JOptionPane.showInputDialog("Dime el ID del alumno que quieres modificar");
                    String nombre = JOptionPane.showInputDialog("Escribe un nombre");
                    preparedStatement.setString(1, nombre);
                    preparedStatement.setString(2, id);
                    numeroFilas = preparedStatement.executeUpdate();
                }
                case "apellidos" -> {
                    Connection connection = connect();
                    PreparedStatement preparedStatement = connection.prepareStatement("UPDATE alumnos SET apellidos = ? WHERE id = ?");
                    String id = JOptionPane.showInputDialog("Dime el ID del alumno que quieres modificar");
                    String apellidos = JOptionPane.showInputDialog("Escribe los apellidos");
                    preparedStatement.setString(1, apellidos);
                    preparedStatement.setString(2, id);
                    numeroFilas = preparedStatement.executeUpdate();
                }
                case "direccion" -> {
                    Connection connection = connect();
                    PreparedStatement preparedStatement = connection.prepareStatement("UPDATE alumnos SET direccion = ? WHERE id = ?");
                    String id = JOptionPane.showInputDialog("Dime el ID del alumno que quieres modificar");
                    String direccion = JOptionPane.showInputDialog("Escribe los apellidos");
                    preparedStatement.setString(1, direccion);
                    preparedStatement.setString(2, id);
                    numeroFilas = preparedStatement.executeUpdate();
                }
                case "todo" -> {
                    Connection connection = connect();
                    PreparedStatement preparedStatement = connect().prepareStatement("UPDATE alumnos SET nombre = ?, apellidos = ?, direccion = ? WHERE id = ?");
                    String id = JOptionPane.showInputDialog("Dime el ID del alumno que quieres modificar");
                    String nombre = JOptionPane.showInputDialog("Dime el nombre del alumno");
                    String apellidos = JOptionPane.showInputDialog("Dime los apellidos del alumno");
                    String direccion = JOptionPane.showInputDialog("Dime la direccion del alumno");
                    preparedStatement.setString(1, nombre);
                    preparedStatement.setString(2, apellidos);
                    preparedStatement.setString(3, direccion);
                    preparedStatement.setString(4, id);
                    numeroFilas = preparedStatement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numeroFilas;
    }

    public int eliminarAlumno() {
        int numeroFilas = 0;
        try {
            Connection connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE alumnos SET nombre = null, apellidos = null, direccion = null WHERE id = ?");
            String id = JOptionPane.showInputDialog("Dime el id del alumno que quieres eliminar: ");

            preparedStatement.setString(1, id);

            // Ejecutamos la consulta
            numeroFilas = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numeroFilas;
    }

    public List<Alumno> listarAlumnos() {
        List<Alumno> listaAlumnos = new ArrayList<>();
        try (Connection connection = connect()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM alumnos");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nombre = resultSet.getNString("nombre");
                String apellidos = resultSet.getString("apellidos");
                String direccion = resultSet.getString("direccion");

                Alumno alumno = new Alumno(id, nombre, apellidos, direccion);
                listaAlumnos.add(alumno);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaAlumnos;
    }

    public void opciones() {
        String seleccionar_opciones = JOptionPane.showInputDialog("Dime que quieres hacer: Insertar, actualizar, eliminar un alumno o listar toda la tabla");

        try {
            if (seleccionar_opciones.equalsIgnoreCase("insertar")) {
                insertalumnos();
            } else if (seleccionar_opciones.equalsIgnoreCase("actualizar")) {
                actualizaAlumnos();
            } else if (seleccionar_opciones.equalsIgnoreCase("eliminar")) {
                eliminarAlumno();
            } else if (seleccionar_opciones.equalsIgnoreCase("listar")) {
                System.out.println(listarAlumnos());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void mostrarInfo() {

    }
}