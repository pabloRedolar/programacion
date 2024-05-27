//package Clases;
//
//import java.util.*;
//
//public class Ejer3 {
//    public static void main(String[] args) {
//        Random random = new Random();
//
//        List<Integer> lista_num = new ArrayList<>();
//        List<Integer> lista_sindup = new ArrayList<>();
//
//        List<Integer> contador_num = new ArrayList<>();
//
//        for (int i = 0; i < 30; i++) {
//            int num = random.nextInt(10);
//            lista_num.add(num);
//            if (!lista_sindup.contains(num)) {
//                lista_sindup.add(num);
//            }
//        }
//
//        for (int numerico : lista_sindup) {
//            int contador = 0;
//
//            for (int numerico1 : lista_num) {
//                if (numerico == numerico1) {
//                    contador++;
//                }
//            }
//
//            contador_num.add(contador);
//            System.out.println(numerico + " " + contador);
//
//        }
//
//        System.out.println(lista_sindup);
//        System.out.println(contador_num);
//
//    }
//}


import java.util.*;

public class Ejer3 {
    public static void main(String[] args) {
        Random random = new Random();

        List<Integer> lista_num = new ArrayList<>();
        List<Integer> lista_sindup = new ArrayList<>();

        Map<Integer, Integer> contadorMap = new HashMap<>();

        for (int i = 0; i < 30; i++) {
            int num = random.nextInt(10);
            lista_num.add(num);
            if (!lista_sindup.contains(num)) {
                lista_sindup.add(num);
            }
        }

        for (int numerico : lista_sindup) {
            int contador = 0;

            for (int numerico1 : lista_num) {
                if (numerico == numerico1) {
                    contador++;
                }
            }

            contadorMap.put(numerico, contador);
        }

        // Ordenar el mapa por valor (contador)
        List<Map.Entry<Integer, Integer>> list =
                new LinkedList<>(contadorMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // Mostrar los elementos ordenados del mapa
        for (Map.Entry<Integer, Integer> entry : list) {
            System.out.println(entry.getKey() + " - " + entry.getValue() + " veces");
        }
    }
}

