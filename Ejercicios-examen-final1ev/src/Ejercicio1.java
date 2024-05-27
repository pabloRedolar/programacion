public class Ejercicio1 {
    public static void main(String[] args) {

        System.out.println(suma_recursiva(10));
    }

    public static int suma_recursiva(int num1) {
        if (num1 <= 0) {
            return 0;
        }
        return num1 + suma_recursiva((num1 - 1));
    }
}
