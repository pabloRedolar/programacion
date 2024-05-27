package Abstractas;
public abstract class Animal {
    String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public abstract void comunicarse();
    public abstract String dieta();

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'';
    }

}
