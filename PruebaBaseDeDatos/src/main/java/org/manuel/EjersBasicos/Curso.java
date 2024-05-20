package org.manuel.EjersBasicos;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private int id;
    private String nombre;
    private String instructor;


    public Curso(){

    }

    public Curso(int id, String nombre, String instructor) {
        this.id = id;
        this.nombre = nombre;
        this.instructor = instructor;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }


    @Override
    public String toString() {
        return "Curso{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", instructor='" + instructor + '\'' +
                '}';
    }
}
