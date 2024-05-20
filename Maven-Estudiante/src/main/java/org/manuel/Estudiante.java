package org.manuel;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Estudiante {
    private String nombre;
    private ArrayList<String> asignaturas = null;
    private boolean aprobado;


    public Estudiante(String nombre, ArrayList<String> asignaturas, boolean aprobado) {
        this.nombre = nombre;
        this.asignaturas = asignaturas;
        this.aprobado = aprobado;
    }

    public Estudiante() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(ArrayList<String> asignaturas) {
        this.asignaturas = asignaturas;
    }

    public boolean isAprobado() {
        return aprobado;
    }

    public void setAprobado(boolean aprobado) {
        this.aprobado = aprobado;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", asignaturas=" + asignaturas +
                ", aprobado=" + aprobado +
                '}';
    }

    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante();
        ArrayList<String> asignaturas = new ArrayList<>();
        estudiante.setNombre("Manuel");
        asignaturas.add("Fisica");
        asignaturas.add("Mates");
        asignaturas.add("Lengua");
        estudiante.setAsignaturas(asignaturas);
        estudiante.setAprobado(true);
        ObjectMapper objectMapper = new ObjectMapper();

       /** try {
            String json = objectMapper.writeValueAsString(estudiante);
            System.out.println(json);
            objectMapper.writeValue(Paths.get("estudiante.json").toFile(),estudiante);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        */
        try {
            Estudiante estudiante1 = objectMapper.readValue(new File("estudiante.json"), Estudiante.class);
            System.out.println(estudiante1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
