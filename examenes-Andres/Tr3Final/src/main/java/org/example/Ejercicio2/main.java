package org.example.Ejercicio2;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class main {
    private static String bd = "jdbc:mysql://localhost:3306/openData";
    private static String user = "root";
    private static String password = "1234";

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        Datos datos = new Datos();
        PreparedStatement preparedStatement = null;
        try {
            datos = objectMapper.readValue(new File("src/main/java/org/example/Ejercicio2/Uz.json"), Datos.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(datos.getDatos().toArray().length);

        try {
            preparedStatement = DriverManager.getConnection(bd,user,password).prepareStatement("insert into datos(localidad, tasa_graduacion, media_cursos_matriculados, " +
                    "tipo_estudio, estudio, sexo, tasa_abandono_inicial, alumnos_graduados, curso_academico, alumnos_graduados_en_tiempo, tasa_abandono, " +
                    "alumnos_interrumpen_estudios, alumnos_interrumpen_ests_ano1) values (?,?,?,?,?,?,?,?,?,?,?,?,?)");
            for (Estudios estudio: datos.getDatos()) {
                    preparedStatement.setString(1,estudio.getLocalidad());
                    preparedStatement.setFloat(2, estudio.getTasa_graduacion());
                    preparedStatement.setFloat(3, estudio.getMedia_cursos_matriculados());
                    preparedStatement.setString(4, estudio.getTipo_estudio());
                    preparedStatement.setString(5, estudio.getEstudio());
                    preparedStatement.setString(6, estudio.getSexo());
                    preparedStatement.setFloat(7, estudio.getTasa_abandono_inicial());
                    preparedStatement.setInt(8, estudio.getAlumnos_graduados());
                    preparedStatement.setInt(9, estudio.getCurso_academico());
                    preparedStatement.setInt(10, estudio.getAlumnos_graduados_en_tiempo());
                    preparedStatement.setFloat(11, estudio.getTasa_abandono());
                    preparedStatement.setInt(12, estudio.getAlumnos_interrumpen_estudios());
                    preparedStatement.setInt(13, estudio.getAlumnos_interrumpen_est_ano1());
                    preparedStatement.execute();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if (preparedStatement!=null){try {preparedStatement.close();} catch (SQLException e) {throw new RuntimeException(e);}}
        }

    }
}
