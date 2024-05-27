import java.util.*;
import java.util.random.RandomGenerator;

public class main {
    public static void main(String[] args) {

        //Almacenamiento de los numeros aleatorios almacenando como key el numero y como valor el numero de veces repetido
        int mayor_frecuencia = 0;
        List<Integer> lista_aleatoria = new ArrayList<>();
        LinkedHashMap<Integer, Integer> lista_numeros_limpia = new LinkedHashMap<>();

        //Generacion de numeros aleatorios
        for (int i = 1; i < 40+1; i++) {
            lista_aleatoria.add((RandomGenerator.getDefault().nextInt(0,49+1)));
        }

        //Añadimos los numeros a la lista limpia y hacemos un conteo
        Collections.sort(lista_aleatoria);
        for (Integer numeros:lista_aleatoria) {
            int frecuencia = Collections.frequency(lista_aleatoria,numeros);
            lista_numeros_limpia.put(numeros,frecuencia);
            if (mayor_frecuencia<Collections.frequency(lista_aleatoria,numeros)){mayor_frecuencia=frecuencia;}
        }

        //Ordenamos
        String palabra_veces = "veces";
        for (int i = 0; i < mayor_frecuencia; i++) {
            for (Map.Entry<Integer, Integer> numeros: lista_numeros_limpia.entrySet()) {
                if (i==numeros.getValue()){
                    if (i==1){palabra_veces="vez";}
                    System.out.println(numeros.getKey()+" - "+ numeros.getValue()+" "+palabra_veces);
                }
            }
        }

    }
}
