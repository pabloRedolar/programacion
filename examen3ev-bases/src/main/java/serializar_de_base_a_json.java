import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class serializar_de_base_a_json {
    public static void main(String[] args) {
        DataBaseConector dataBaseConector = new DataBaseConector();
        ObjectMapper objectMapper = new ObjectMapper();
        Datos datos = new Datos();
        List<Estudios> list = new ArrayList<>();
        try (Connection connection = dataBaseConector.connect()){

            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM datos");
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String localidad = resultSet.getString(2);
                Float tasa_graduacion = resultSet.getFloat(3);
                Float media_cursos_matriculados = (resultSet.getFloat(4));
                String tipo_estudio = resultSet.getString(5);
                String estudio = resultSet.getString(6);
                String sexo = resultSet.getString(7);
                Float tasa_abandono_inicial = (resultSet.getFloat(8));
                int alumnos_graduados = (resultSet.getInt(9));
                int curso_academico = resultSet.getInt(10);
                int alumnos_graduados_en_tiempo = resultSet.getInt(11);
                float tasa_abandono = resultSet.getInt(12);
                int alumnos_interrumpen_estudios = resultSet.getInt(13);
                int alumnos_interrumpen_estudios_est_ano1 = resultSet.getInt(14);

                Estudios estudios = new Estudios(localidad,tasa_graduacion,media_cursos_matriculados,tipo_estudio,estudio
                        ,sexo,tasa_abandono_inicial,alumnos_graduados,curso_academico,alumnos_graduados_en_tiempo,tasa_abandono,alumnos_interrumpen_estudios,alumnos_interrumpen_estudios_est_ano1);
                System.out.println(estudios);

                list.add(estudios);

            }
            datos.setDatos(list);
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("palomos.json"),datos);

        } catch (SQLException | IOException e) {
            throw new RuntimeException(e);
        }


    }

}