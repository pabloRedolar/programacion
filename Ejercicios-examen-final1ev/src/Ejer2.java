import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Ejer2 {
    public static void main(String[] args) {
        List<Integer> lista1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 1));
        List<Integer> lista2 = new ArrayList<>(Arrays.asList(3, 4, 6, 6, 7, 8));
//        combinar_listas_ordenadas(lista1, lista2);
        ArrayList<Integer> lista_ordenada = new ArrayList<>();
        lista_ordenada.addAll(lista1);
        lista_ordenada.addAll(lista2);
        Collections.sort(lista_ordenada);
        lista_ordenada = (ArrayList<Integer>) lista_ordenada.stream().distinct().collect(Collectors.toList());
        System.out.println(lista_ordenada);

//        lista_ordenada = (ArrayList<Integer>) lista_ordenada.stream().distinct().collect(Collectors.toList());

//        combinar_listas_ordenadas(lista_ordenada);

    }
    public static void combinar_listas_ordenadas(List<Integer> lis1) {
        List<Integer> lista_sin_duplicado = new ArrayList<>();

        for (int numero : lis1) {
            if (! lista_sin_duplicado.contains(numero)) {
                lista_sin_duplicado.add(numero);
            } else {
                System.out.println(numero + " duplicado");
            }
        }
        System.out.println(lista_sin_duplicado);
    }
}
