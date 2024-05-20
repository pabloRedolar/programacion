package org.manuel.BaseDeDatos;

import org.manuel.Persona;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataBaseConector {
    private final String url = "jdbc:mysql://localhost:3306/personas";
    private final String user = "root";
    private final String password = "1234";

    public Connection connect() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }
    public List<Persona> obtenertodo() {
        List<Persona> listapersonas = new ArrayList<>();
        try {
            Connection connection = connect();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from persona");
            while (resultSet.next()){
                String dni = resultSet.getString("dni");
                String nombre = resultSet.getString("nombre");
                String apellidos = resultSet.getString("apellidos");
                String sexo = resultSet.getString("sexo");
                int altura = resultSet.getInt("altura");
                float peso = resultSet.getInt("peso");
                Persona persona = new Persona(dni,nombre,apellidos,sexo,altura,peso);
                listapersonas.add(persona);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listapersonas;
    }
    public int inserta(Persona persona){
        int numfilas = 0;
        try {
            Connection connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into persona (dni,nombre,apellidos,sexo,altura,peso) VALUES (?,?,?,?,?,?)");
            preparedStatement.setString(1, persona.getDni());
            preparedStatement.setString(2, persona.getNombre());
            preparedStatement.setString(3, persona.getApellidos());
            preparedStatement.setString(4, persona.getSexo());
            preparedStatement.setInt(5, persona.getAltura());
            preparedStatement.setFloat(6, persona.getPeso());
            //Ejecutamos la consulta
            int numflias = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numfilas;
    }
    public int borrar(Persona persona){
        int numfilas = 0;
        try {
            Connection connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement("delete from persona WHERE dni = ?");
            preparedStatement.setString(1, persona.getDni());

            //Ejecutamos la consulta
            int numflias = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numfilas;
    }

    public int update(Persona persona){
        int numfilas = 0;
        try {
            Connection connection = connect();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE persona set nombre = ?, apellidos = ?, sexo = ?, altura = ?, peso = ? WHERE dni = ?");
            preparedStatement.setString(1, persona.getNombre());
            preparedStatement.setString(2, persona.getApellidos());
            preparedStatement.setString(3, persona.getSexo());
            preparedStatement.setInt(4, persona.getAltura());
            preparedStatement.setFloat(5, persona.getPeso());
            preparedStatement.setString(6, persona.getDni());

            //Ejecutamos la consulta
            int numflias = preparedStatement.executeUpdate();

            preparedStatement.close();
            connection.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return numfilas;
    }

}
