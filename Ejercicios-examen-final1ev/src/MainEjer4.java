import Clases.Circuito;
import Clases.Coche;

public class MainEjer4 {
    public static void main(String[] args) {
//        System.out.println(vehiculo.sonidoMotor());
//        System.out.println(vehiculo.acelerar(80));

        Coche coche1 = new Coche("coche1", 1, 0, 120, "gasolina", 4, "subida");
        Coche coche2 = new Coche("coche juan", 1, 30, 200, "diesel", 4, "bajada");
        Coche coche3 = new Coche("coche juan", 1, 30, 200, "diesel", 4, "bajada");
        Coche coche4 = new Coche("coche maria", 2, 40, 220, "gasolina", 4, "subida");
        Coche coche5 = new Coche("coche pedro", 3, 35, 180, "diesel", 4, "bajada");
        Coche coche6 = new Coche("coche ana", 4, 45, 210, "gasolina", 4, "subida");
        Coche coche7 = new Coche("coche carlos", 5, 25, 190, "electrico", 4, "bajada");
        Coche coche8 = new Coche("coche laura", 6, 55, 230, "gasolina", 4, "subida");
        Coche coche9 = new Coche("coche david", 7, 50, 200, "diesel", 4, "bajada");
        Coche coche10 = new Coche("coche carmen", 8, 60, 240, "gasolina", 4, "subida");


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
    }
}
