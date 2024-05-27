import Clases.Circuito;
import Clases.Coche;
import Clases.Vehiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MainEjer4 {
    public static void main(String[] args) {
//        System.out.println(vehiculo.sonidoMotor());
//        System.out.println(vehiculo.acelerar(80));

        Coche coche1 = new Coche("coche juan", 1001, 0, 120, "gasolina", 4, "subida");
        Coche coche2 = new Coche("coche redo", 1002, 30, 200, "diesel", 4, "bajada");
        Coche coche3 = new Coche("coche coche", 1003, 30, 200, "diesel", 4, "bajada");
        Coche coche4 = new Coche("coche maria", 1004, 40, 220, "gasolina", 4, "subida");
        Coche coche5 = new Coche("coche pedro", 1005, 35, 180, "diesel", 4, "bajada");
        Coche coche6 = new Coche("coche ana", 1006, 45, 210, "gasolina", 4, "subida");
        Coche coche7 = new Coche("coche carlos", 1007, 25, 190, "electrico", 4, "bajada");
        Coche coche8 = new Coche("coche laura", 1008, 55, 230, "gasolina", 4, "subida");
        Coche coche9 = new Coche("coche david", 1009, 50, 200, "diesel", 4, "bajada");
        Coche coche10 = new Coche("coche carmen", 1010, 60, 240, "gasolina", 4, "subida");


        Circuito circuito = new Circuito();
        circuito.setNombre_circuito("Montecarlo");

        circuito.anadirparticipante(coche1);
        circuito.anadirparticipante(coche2);
        circuito.anadirparticipante(coche3);
        circuito.anadirparticipante(coche4);
        circuito.anadirparticipante(coche5);
        circuito.anadirparticipante(coche6);
        circuito.anadirparticipante(coche7);
        circuito.anadirparticipante(coche8);
        circuito.anadirparticipante(coche9);
        circuito.anadirparticipante(coche10);

        System.out.println(circuito);


        ConectorBaseDatos conectorBaseDatos = new ConectorBaseDatos();

        try (Connection connection = conectorBaseDatos.connect()) {
            // CREATE TABLE coches (id INT AUTO_INCREMENT,
            // dorsal INT,
            // nombre VARCHAR(100),
            // velocidad_actual INT,
            // velocidad_maxima INT,
            // tipo_combustible VARCHAR(50),
            // numero_ruedas INT,
            // ventanillas VARCHAR(50)
            // PRIMARY KEY (id, )
            // );

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO coches (dorsal, nombre, velocidad_actual, velocidad_maxima, tipo_combustible, numero_ruedas, ventanillas) VALUES (?, ?, ?, ?, ?, ?, ?)");

            for (Coche coche : circuito.getLista_vehiculos()) {
                preparedStatement.setInt(1, coche.getDorsal());
                preparedStatement.setString(2, coche.getNombre());
                preparedStatement.setInt(3, coche.getVelocidadActual());
                preparedStatement.setInt(4, coche.getVelocidadMaxima());
                preparedStatement.setString(5, coche.getTipoCombustible());
                preparedStatement.setInt(6, coche.getNumeroRuedas());
                preparedStatement.setString(7, coche.getVentanilla());
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
