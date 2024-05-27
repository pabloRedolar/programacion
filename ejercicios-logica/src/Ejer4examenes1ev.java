import javax.swing.*;
import java.util.Arrays;
import java.util.List;

public class Ejer4examenes1ev {
    public static void main(String[] args) {
        String frase = JOptionPane.showInputDialog("Dime la frase");

        List<String> listaVocales = Arrays.asList("a", "e", "i", "o", "u", "á", "é", "í", "ó", "ú");

        StringBuilder fraseSinVocales = new StringBuilder();

        for (char i : frase.toLowerCase().toCharArray()) {
            if (!listaVocales.contains(String.valueOf(i))) {
                fraseSinVocales.append(i);
            }
        }

        System.out.println(fraseSinVocales);
    }
}
