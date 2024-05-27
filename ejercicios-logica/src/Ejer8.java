import java.util.ArrayList;

public class Ejer8 {
    public static void main(String[] args) {
        String frase = "Hola buenos dias, que tal dias estamos? todos bien bien? hola hola";
        String frase_limpia = frase.toLowerCase().replaceAll("[^a-z0-9' ]", "");
        ArrayList<String> lista_palabras = new ArrayList<>();
        ArrayList<String> lista_repes = new ArrayList<>();

        int contador_palabras_duplicadas = 0;

        for (String palabra : frase_limpia.split(" ")) {

            if (lista_palabras.isEmpty()) {
                lista_palabras.add(palabra);
            } else if ((lista_palabras.contains(palabra))) {
                lista_repes.add(palabra);
                contador_palabras_duplicadas += 1;
                System.out.println(palabra);
                System.out.println("Palabra duplicada");
            } else {
                lista_palabras.add(palabra);
            }
        }
        System.out.println(frase);
        System.out.println(contador_palabras_duplicadas);
        System.out.println(lista_repes);
        System.out.println(lista_palabras);

    }
}
