package Clases;

import java.util.ArrayList;
import java.util.List;

public class Circuito {
    private String nombre_circuito;
    private List<Vehiculo> lista_vehiculos = new ArrayList<>();

    public Circuito() {
    }

    public Circuito(String nombre_circuito, List<Vehiculo> lista_vehiculos) {
        this.nombre_circuito = nombre_circuito;
        this.lista_vehiculos = lista_vehiculos;
    }

    @Override
    public String toString() {
        return "Circuito - " +
                "Nombre: " + nombre_circuito + "\n" +
                "Lista de vehiculos: \n" + lista_vehiculos;
    }

    public void anadirparticipante(Coche vehiculo) {
        this.lista_vehiculos.add(vehiculo);
    }

    public String getNombre_circuito() {
        return nombre_circuito;
    }

    public void setNombre_circuito(String nombre_circuito) {
        this.nombre_circuito = nombre_circuito;
    }

    public List<Vehiculo> getLista_vehiculos() {
        return lista_vehiculos;
    }

    public void setLista_vehiculos(List<Vehiculo> lista_vehiculos) {
        this.lista_vehiculos = lista_vehiculos;
    }
}
