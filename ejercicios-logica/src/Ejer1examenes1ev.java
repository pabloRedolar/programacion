import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ejer1examenes1ev {
    public static void main(String[] args) {
        String frase = JOptionPane.showInputDialog("Dime una frase");
        String frase_minusculas = frase.toLowerCase();

        List<String> lista_abecedario = new ArrayList<>(Arrays.asList(" ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "ñ", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"));

        for (char letra : frase_minusculas.toCharArray()) {
            for (String i : lista_abecedario) {
                if (String.valueOf(letra).equals(i)) {
                    int index = lista_abecedario.indexOf(i);
                    if (index == 0) {
                        System.out.print(" ");
                    }

                    if (index == 25 || index == 26 || index == 27) {
                        index = 0;
                        System.out.print(lista_abecedario.get(index));
                    } else {
                        System.out.print(lista_abecedario.get(index+3));
                    }
                }
            }
        }
    }
}
