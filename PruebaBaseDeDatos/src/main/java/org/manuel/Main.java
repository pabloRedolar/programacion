package org.manuel;

import java.sql.*;

public class Main {
    private static final String url = "jdbc:mysql://localhost:3306/tienda";
    private static final String user ="root";
    private static final String password ="1234";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url,user,password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from producto");

            while (resultSet.next()){
                System.out.print(resultSet.getInt("codigo") + " ");
                System.out.print(resultSet.getString("nombre") + " ");
                System.out.print(resultSet.getDouble("precio") + " ");
                System.out.println(resultSet.getInt("codigo_fabricante") + " ");
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}