package Modelos;

public class Cursos {
    private int id;
    private String nombre;
    private String instructor;

    public Cursos() {
    }

    public Cursos(int id, String nombre, String instructor) {
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
        return "Cursos{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", instructor='" + instructor + '\'' +
                '}';
    }
}
