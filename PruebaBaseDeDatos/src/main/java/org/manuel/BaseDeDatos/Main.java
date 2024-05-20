package org.manuel.BaseDeDatos;

import org.manuel.Persona;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataBaseConector dataBaseConector = new DataBaseConector();
        List<Persona> listaPersonas = dataBaseConector.obtenertodo();

        for (Persona persona : dataBaseConector.obtenertodo()){
            System.out.println(persona);
        }

        //Insercion
        Persona persona = new Persona("18459358P","manuel","Julve", "poco", 170 , 70.50f);
        //dataBaseConector.inserta(persona);

        //Delete
        //dataBaseConector.borrar(persona);

        //Update
        Persona persona1 = new Persona("1", "KAKA", "KAKA", "KAKA", 175, 168.0f);
        dataBaseConector.update(persona1);

    }
}
