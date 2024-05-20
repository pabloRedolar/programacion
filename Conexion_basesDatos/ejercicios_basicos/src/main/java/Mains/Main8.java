package Mains;

import Base_de_datos.Conector8;

import javax.swing.*;
import java.awt.*;

public class Main8 {
    public static void main(String[] args) {
        Conector8 conector8 = new Conector8();
        System.out.println(conector8.listaAlumnos());
    }
}
