import javax.swing.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String frase1 = JOptionPane.showInputDialog("Introduce la primera frase:");
        String frase2 = JOptionPane.showInputDialog("Introduce la segunda frase:");
        String[] frase1_dividida = frase1.split(" ");
        boolean finded = false;

        for (String palabra: frase1_dividida) {
            Pattern pattern = Pattern.compile("\\b"+palabra+"\\b", Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(frase2);
            if (matcher.find()){
                System.out.println("La primera palabra coincidente es: "+palabra);
                finded = true;
                break;
            }
        }
        if (!finded){System.out.println("No se encontro ninguna");}
    }
}
