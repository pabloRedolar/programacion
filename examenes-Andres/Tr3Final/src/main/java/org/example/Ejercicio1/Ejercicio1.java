package org.example.Ejercicio1;

import java.sql.*;

public class Ejercicio1 {
    private static String bd = "jdbc:mysql://localhost:3306/";
    private static String user = "root";
    private static String password = "1234";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(bd,user,password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("show databases like 'supernivel'");
            boolean encontrado = false;
            while (resultSet.next()){
                if (resultSet.getString(1).equals("supernivel")){
                    encontrado=true;
                    System.out.println("No se ha creado la base de datos 'supernivel' ya que existia previamente");
                    break;
                }
            }
            if (!encontrado){
                statement.execute("create database supernivel");
                System.out.println("Se ha creado la BBDD 'supernivel'");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
