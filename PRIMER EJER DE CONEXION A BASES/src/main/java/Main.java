import java.util.List;

import Base_de_datos.DatabaseConnector;
import Modelos.Persona;

public class Main {
  public static void main(String[] args) {
    DatabaseConnector bdcrud = new DatabaseConnector();
    List<Persona> listPersonas = bdcrud.obtenerTodo();
    System.out.println(listPersonas);

    Persona persona = new Persona("1", "Pablo", "Redolar", "masculino", 1, 1.1);
    bdcrud.inserta(persona);
    bdcrud.borra(persona);
    bdcrud.update(persona);
  }
}