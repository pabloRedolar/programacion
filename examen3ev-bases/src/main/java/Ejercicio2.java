import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Ejercicio2 {
    public static void main(String[] args) throws IOException {
        DataBaseConector dataBaseConector = new DataBaseConector();
        ObjectMapper objectMapper = new ObjectMapper();

        try (Connection connection = dataBaseConector.connect()){
            Datos datos = objectMapper.readValue(new File("Uz.json"), Datos.class);
            System.out.println(datos);

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO datos VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            for (Estudios e : datos.getDatos()) {
                preparedStatement.setString(1, e.getLocalidad());
                preparedStatement.setFloat(2, e.getTasa_graduacion());
                preparedStatement.setFloat(3, e.getMedia_cursos_matriculados());
                preparedStatement.setString(4, e.getTipo_estudio());
                preparedStatement.setString(5, e.getEstudio());
                preparedStatement.setString(6, e.getSexo());
                preparedStatement.setFloat(7, e.getTasa_abandono_inicial());
                preparedStatement.setInt(8, e.getAlumnos_graduados());
                preparedStatement.setInt(9, e.getCurso_academico());
                preparedStatement.setInt(10, e.getAlumnos_graduados_en_tiempo());
                preparedStatement.setFloat(11, e.getTasa_abandono());
                preparedStatement.setInt(12, e.getAlumnos_interrumpen_estudios());
                preparedStatement.setInt(13, e.getAlumnos_interrumpen_est_ano1());

                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
