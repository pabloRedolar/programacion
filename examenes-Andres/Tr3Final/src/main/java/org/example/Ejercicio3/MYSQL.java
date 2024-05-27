package org.example.Ejercicio3;

import java.sql.*;
import java.util.ArrayList;

public class MYSQL {
    private static String bd = "jdbc:mysql://localhost:3306/supermercado";
    private static String user = "root";
    private static String password = "1234";
    public static Connection conectar(){
        try {
            return DriverManager.getConnection(bd,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static ArrayList<Persona> cargarClientes(){
        ArrayList<Persona> lista_personas = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conectar().prepareStatement("select * from clientes");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Persona persona = new Persona();
                persona.setDNI(resultSet.getString(1));
                persona.setNombre(resultSet.getString(2));
                persona.setApellidos(resultSet.getString(3));
                lista_personas.add(persona);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (preparedStatement!=null){try {preparedStatement.close();} catch (SQLException e) {throw new RuntimeException(e);}}
        }
        return lista_personas;
    }
    public static  ArrayList<Producto> cargarProductos(){
        ArrayList<Producto> lista_productos = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conectar().prepareStatement("select * from productos");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Producto producto = new Producto();
                producto.setCodigo(resultSet.getString(1));
                producto.setNombre(resultSet.getString(2));
                producto.setDescripcion(resultSet.getString(3));
                producto.setMarca(resultSet.getString(4));
                producto.setPrecio(resultSet.getFloat(5));
                lista_productos.add(producto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (preparedStatement!=null){try {preparedStatement.close();} catch (SQLException e) {throw new RuntimeException(e);}}
        }
        return lista_productos;
    }
    public static  ArrayList<Carro> cargarCarros(){
        ArrayList<Carro> lista_carro = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conectar().prepareStatement("select cl.* from clientes cl inner join carros ca on cl.dni=ca.idcliente group by cl.dni");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Persona persona = new Persona();
                persona.setDNI(resultSet.getString(1));
                persona.setNombre(resultSet.getString(2));
                persona.setApellidos(resultSet.getString(3));

                preparedStatement = conectar().prepareStatement("select p.* from productos p inner join carros ca on p.codigo=ca.idproducto where ca.idcliente=?");
                preparedStatement.setString(1,persona.getDNI());
                ResultSet productos = preparedStatement.executeQuery();
                ArrayList<Producto> lista_productos = new ArrayList<>();
                while (productos.next()){
                    Producto producto = new Producto();
                    producto.setCodigo(productos.getString(1));
                    producto.setNombre(productos.getString(2));
                    producto.setDescripcion(productos.getString(3));
                    producto.setMarca(productos.getString(4));
                    producto.setPrecio(productos.getFloat(5));
                    lista_productos.add(producto);
                }
                ListaProductos listaProductos = new ListaProductos();
                listaProductos.setLista(lista_productos);

                Carro carro = new Carro();
                carro.setCliente(persona);
                carro.setProductos(listaProductos);
                lista_carro.add(carro);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (preparedStatement!=null){try {preparedStatement.close();} catch (SQLException e) {throw new RuntimeException(e);}}
        }
        return lista_carro;
    }
    public static void addproducto(Producto producto){
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conectar().prepareStatement("insert into productos values(?,?,?,?,?)");
            preparedStatement.setString(1,producto.getCodigo());
            preparedStatement.setString(2, producto.getNombre());
            preparedStatement.setString(3, producto.getDescripcion());
            preparedStatement.setString(4, producto.getMarca());
            preparedStatement.setDouble(5, producto.getPrecio());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (preparedStatement!=null){try {preparedStatement.close();} catch (SQLException e) {throw new RuntimeException(e);}}
        }
    }
    public static void addcliente(Persona persona){
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conectar().prepareStatement("insert into clientes values(?,?,?)");
            preparedStatement.setString(1,persona.getDNI());
            preparedStatement.setString(2, persona.getNombre());
            preparedStatement.setString(3, persona.getApellidos());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (preparedStatement!=null){try {preparedStatement.close();} catch (SQLException e) {throw new RuntimeException(e);}}
        }
    }
    public static void addCarro(Carro carro){
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = conectar().prepareStatement("insert into carros values(?,?)");
            preparedStatement.setString(1,carro.getCliente().getDNI());
            for (Producto producto:carro.getProductos().getLista()) {
                preparedStatement.setString(2, producto.getCodigo());
                preparedStatement.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (preparedStatement!=null){try {preparedStatement.close();} catch (SQLException e) {throw new RuntimeException(e);}}
        }
    }

}
