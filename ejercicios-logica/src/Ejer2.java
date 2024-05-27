import java.util.Arrays;

public class Ejer2 {
    public static void main(String[] args) {
        String palabra1 = "mola";
        String palabra2 = "loma";

        boolean resultado = Anagrama(palabra1, palabra2);
        System.out.println("Son anagramas las 2 palabras? " + resultado);

    }

    private static boolean Anagrama(String palabra1, String palabra2) {
        if (palabra1.length() != palabra2.length()) {
            return false;
        } else if (palabra1.equalsIgnoreCase(palabra2)) {
            return false;
        }

        char[] lista1 = palabra1.toCharArray();
        char[] lista2 = palabra2.toCharArray();

        Arrays.sort(lista1);
        Arrays.sort(lista2);

        return Arrays.equals(lista1, lista2);
    }
}
