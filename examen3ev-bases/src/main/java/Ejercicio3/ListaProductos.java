package Ejercicio3;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * Clase gestión de lista de Productos
 */

/**
 *
 */

public class ListaProductos {

    private final ArrayList<Producto> lista;

    public ListaProductos() {
        lista = new ArrayList();
    }

    public void anadirProducto(Producto p) {
        DataBaseConector dataBaseConector = new DataBaseConector();
        try (Connection connection = dataBaseConector.connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO productos VALUES (?, ?, ?, ?, ?)");

            String codigo = JOptionPane.showInputDialog("Dime el codigo");
            String nombre = JOptionPane.showInputDialog("Dime el nombre");
            String descripcion = JOptionPane.showInputDialog("Dime el descripcion");
            String marca = JOptionPane.showInputDialog("Dime la marca");
            Double precio = Double.valueOf(JOptionPane.showInputDialog("Dime el precio"));

            Producto producto = new Producto(codigo, nombre, descripcion, marca, precio);
            lista.add(producto);
            preparedStatement.setString(1, codigo);
            preparedStatement.setString(2, nombre);
            preparedStatement.setString(3, descripcion);
            preparedStatement.setString(4, marca);
            preparedStatement.setDouble(5, precio);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(lista);
    }

    public void mostrarProductos() {
        DataBaseConector dataBaseConector = new DataBaseConector();
        try (Connection connection = dataBaseConector.connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM productos");

            ResultSet resultSet = preparedStatement.executeQuery();
            Producto producto = new Producto();
            while (resultSet.next()) {
                producto.setCodigo(resultSet.getString(1));
                producto.setNombre(resultSet.getString(2));
                producto.setDescripcion(resultSet.getString(3));
                producto.setMarca(resultSet.getString(4));
                producto.setPrecio(resultSet.getDouble(5));

                System.out.println(producto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        int i = 0;
        for (Producto p : lista) {
            System.out.println(i + " - " + p);
            i++;
        }

    }

    public int numeroProductos() {
        return (lista.size());
    }

    public void mostrarProductosNombre(String nombre) {
        for (Producto p : lista) {
            if (p.getNombre().equals(nombre)) {
                System.out.println(p);
            }
        }
    }

    public Producto productoPosicionI(int i) {
        return (lista.get(i));
    }

    public double precioLista() {
        double suma = 0.0;
        for (Producto p : lista) {
            suma = suma + p.getPrecio();
        }
        return suma;
    }

    public void buscarProductoPorPrecio() {
        DataBaseConector dataBaseConector = new DataBaseConector();

        try (Connection connection = dataBaseConector.connect()) {
            Double precio_a_buscar = Double.valueOf(JOptionPane.showInputDialog("Dime un precio"));

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM productos WHERE precio > " + precio_a_buscar);

            ResultSet resultSet = preparedStatement.executeQuery();
            Producto producto = new Producto();
            while (resultSet.next()) {
                producto.setCodigo(resultSet.getString(1));
                producto.setNombre(resultSet.getString(2));
                producto.setDescripcion(resultSet.getString(3));
                producto.setMarca(resultSet.getString(4));
                producto.setPrecio(resultSet.getDouble(5));

                System.out.println(producto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toString() {
        return "ListaProductos{" + "lista=" + lista + '}';
    }

    public Producto buscarProcuctoCodigo(String codigo) {
        Producto resultado = null;
        for (Producto p : lista) {
            if (p.getCodigo().equals(codigo)) {
                resultado = p;
            }
        }
        return resultado;
    }

}
