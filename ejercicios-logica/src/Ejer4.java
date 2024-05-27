import java.util.Scanner;

public class Ejer4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número para verificar si es primo: ");
        int numerocomprobar = scanner.nextInt();

        boolean esPrimo = true;

        for (int i = 2; i * i <= numerocomprobar; i++) {
            if (numerocomprobar % i == 0) {
                esPrimo = false;
                break;
            }
        }

        if (esPrimo && numerocomprobar > 1) {
            System.out.println("El número " + numerocomprobar + " es primo");
        } else {
            System.out.println("El número " + numerocomprobar + " no es primo");
        }

        for (int i = 2; i * i <= numerocomprobar; i++) {
            if (numerocomprobar % i == 0) {
                esPrimo = false;
                break;
            }
        }
    }
}
