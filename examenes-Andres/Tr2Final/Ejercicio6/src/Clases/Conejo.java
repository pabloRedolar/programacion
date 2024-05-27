package Clases;

import Abstractas.Animal;
import Interfaces.Herbivoro;

public class Conejo extends Animal implements Herbivoro{
    public Conejo(String nombre) {
        super(nombre);
    }

    @Override
    public void comunicarse() {
        System.out.println("El conejo hace ruido");
    }

    @Override
    public String dieta() {
        return "Dieta: Zanahorias";
    }

    @Override
    public void pastar() {
        System.out.println("El conejo esta comiendo del cesped");
    }

    @Override
    public String toString() {
        return "Conejo " + super.toString();
    }
}
