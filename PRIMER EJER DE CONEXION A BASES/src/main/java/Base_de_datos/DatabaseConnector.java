package Base_de_datos;

import Modelos.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnector {

    public Connection connect() throws SQLException {
        String password = "1234";
        String url = "jdbc:mysql://localhost:3306/personas";
        String user = "root";
        return DriverManager.getConnection(url, user, password);
    }

    public List<Persona> obtenerTodo() {
        List<Persona> listaPersonas = new ArrayList<>();
        try {
            Connection connection = connect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("Select * from persona");
            while (resultSet.next()) {
                String dni = resultSet.getString("dni");
                String nombre = resultSet.getString("nombre");
                String apellidos = resultSet.getString("apellidos");
                String sexo = resultSet.getString("sexo");
                int altura = resultSet.getInt("altura");
                float peso = resultSet.getInt("peso");
                Persona persona = new Persona(dni, nombre, apellidos, sexo, altura, peso);
                listaPersonas.add(persona);

            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaPersonas;
    }

    public void inserta(Persona persona) {
        int numeroFilas = 0;

        try {
            Connection connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into persona(dni, nombre, apellidos, sexo, altura, peso)" +
                            "values (?,?,?,?,?,?)");
            preparedStatement.setString(1, persona.getDni());
            preparedStatement.setString(2, persona.getNombre());
            preparedStatement.setString(3, persona.getApellidos());
            preparedStatement.setString(4, persona.getSexo());
            preparedStatement.setInt(5, persona.getAltura());
            preparedStatement.setDouble(6, persona.getPeso());

            // Ejecutamos la consulta
            numeroFilas = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void borra(Persona persona) {
        int numeroFilas = 0;
        try {
            Connection connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "delete from persona where dni = ?");
            preparedStatement.setString(1, persona.getDni());
            // Ejecutamos la consulta
            numeroFilas = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void update(Persona persona) {
        int numeroFilas = 0;

        try {
            Connection connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "update persona set nombre = ?, apellidos = ?, sexo = ?, altura = ?, peso = ? where dni = ?");

            preparedStatement.setString(1, persona.getNombre());
            preparedStatement.setString(2, persona.getApellidos());
            preparedStatement.setString(3, persona.getSexo());
            preparedStatement.setInt(4, persona.getAltura());
            preparedStatement.setDouble(5, persona.getPeso());
            preparedStatement.setString(6, persona.getDni());

            // Ejecutamos la consulta
            numeroFilas = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}