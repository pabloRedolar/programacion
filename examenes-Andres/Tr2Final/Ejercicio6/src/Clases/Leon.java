package Clases;

import Abstractas.Animal;
import Interfaces.Carnivoro;
import Interfaces.Herbivoro;

public class Leon extends Animal implements Carnivoro{
    public Leon(String nombre) {
        super(nombre);
    }

    @Override
    public void comunicarse() {
        System.out.println("El leon se dedica a rugir");
    }

    @Override
    public String dieta() {
        return "Dieta: Carne";
    }

    @Override
    public void cazar() {
        System.out.println("El Leon esta cazando");
    }

    @Override
    public String toString() {
        return "Leon " + super.toString();
    }
}
