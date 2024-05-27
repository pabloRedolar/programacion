import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class serializar_de_base_a_xml {
    public static void main(String[] args) {
        DataBaseConector dataBaseConector = new DataBaseConector();

        try (Connection connection = dataBaseConector.connect()){
            JAXBContext jaxbContext = JAXBContext.newInstance(Datos.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM datos");
            ResultSet resultSet = preparedStatement.executeQuery();

            List<Estudios> lista = new ArrayList<>();

            while (resultSet.next()) {
                String localidad = resultSet.getString(1);
                Float tasa_graduacion = resultSet.getFloat(2);
                Float media_cursos_matriculados = resultSet.getFloat(3);
                String tipo_estudio = resultSet.getString(4);
                String estudio = resultSet.getString(5);
                String sexo = resultSet.getString(6);
                Float tasa_abandono_inicial = resultSet.getFloat(7);
                int alumnos_graduados = resultSet.getInt(8);
                int curso_academico = resultSet.getInt(9);
                int alumnos_graduados_en_tiempo = resultSet.getInt(10);
                Float tasa_abandono = resultSet.getFloat(11);
                int alumnos_interrumpen_estudios = resultSet.getInt(12);
                int alumnos_interrumpen_est_ano1 = resultSet.getInt(13);

                Estudios estudios = new Estudios(localidad, tasa_graduacion, media_cursos_matriculados, tipo_estudio, estudio, sexo, tasa_abandono_inicial, alumnos_graduados, curso_academico, alumnos_graduados_en_tiempo,
                        tasa_abandono, alumnos_interrumpen_estudios, alumnos_interrumpen_est_ano1);

                lista.add(estudios);

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
