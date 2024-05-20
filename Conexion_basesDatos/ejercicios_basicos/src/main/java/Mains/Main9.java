package Mains;

import Base_de_datos.Conector9;

public class Main9 {
    public static void main(String[] args) {
        Conector9 conector9 = new Conector9();
        int filas = conector9.tablas();

        System.out.println("Numero de filas en la tabla: " + filas);
    }
}
