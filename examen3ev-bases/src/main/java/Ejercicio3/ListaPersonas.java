package Ejercicio3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * Clase gestión de lista de Personas
 */

/**
 * @author admin
 */
public class ListaPersonas {

    private final ArrayList<Persona> lista;

    public ListaPersonas() {
        lista = new ArrayList();
    }

    public void anadirPersona(Persona p) {
        DataBaseConector dataBaseConector = new DataBaseConector();

        try (Connection connection = dataBaseConector.connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO clientes VALUES (?, ?, ?)");

            preparedStatement.setString(1, p.getDNI());
            preparedStatement.setString(2, p.getNombre());
            preparedStatement.setString(3, p.getApellidos());

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                lista.add(p);
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        System.out.println(p);
    }

    public void mostrarPersonas() {
        DataBaseConector dataBaseConector = new DataBaseConector();
        try (Connection connection = dataBaseConector.connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM clientes");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Persona persona = new Persona();
                lista.add(persona);
                persona.setDNI(resultSet.getString(1));
                persona.setNombre(resultSet.getString(2));
                persona.setApellidos(resultSet.getString(3));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        int i = 0;
        for (Persona p : lista) {
            System.out.println(i + "-" + p);
            i++;
        }

    }

    public int numeroPersonas() {
        return (lista.size());
    }

    public void mostrarPersonasNombre(String nombre) {
        for (Persona p : lista) {
            if (p.getNombre().equals(nombre)) {
                System.out.println(p);
            }
        }
    }

    public Persona personaPosicionI(int i) {
        return (lista.get(i));
    }

    public Persona buscarPersonaDNI(String dni) {
        Persona resultado = null;
        for (Persona p : lista) {
            if (p.getDNI().equals(dni)) {
                resultado = p;
            }
        }
        return resultado;
    }
}
