// * Crea un programa que sea capaz de transformar texto natural a código
// * morse y viceversa.
// * - Debe detectar automáticamente de qué tipo se trata y realizar
// *   la conversión.
// * - En morse se soporta raya "—", punto ".", un espacio " " entre letras
// *   o símbolos y dos espacios entre palabras "  ".
// * - El alfabeto morse soportado será el mostrado en https://es.wikipedia.org/wiki/Código_morse.


import java.util.HashMap;

public class Ejer10 {
    private static final HashMap<Character, String> textoAMorse = new HashMap<>();
    private static final HashMap<String, Character> morseATexto = new HashMap<>();

    static {
        textoAMorse.put('A', ".-");
        textoAMorse.put('B', "-...");
        textoAMorse.put('C', "-.-.");
        textoAMorse.put('D', "-..");
        textoAMorse.put('E', ".");
        textoAMorse.put('F', "..-.");
        textoAMorse.put('G', "--.");
        textoAMorse.put('H', "....");
        textoAMorse.put('I', "..");
        textoAMorse.put('J', ".---");
        textoAMorse.put('K', "-.-");
        textoAMorse.put('L', ".-..");
        textoAMorse.put('M', "--");
        textoAMorse.put('N', "-.");
        textoAMorse.put('O', "---");
        textoAMorse.put('P', ".--.");
        textoAMorse.put('Q', "--.-");
        textoAMorse.put('R', ".-.");
        textoAMorse.put('S', "...");
        textoAMorse.put('T', "-");
        textoAMorse.put('U', "..-");
        textoAMorse.put('V', "...-");
        textoAMorse.put('W', ".--");
        textoAMorse.put('X', "-..-");
        textoAMorse.put('Y', "-.--");
        textoAMorse.put('Z', "--..");
        textoAMorse.put('0', "-----");
        textoAMorse.put('1', ".----");
        textoAMorse.put('2', "..---");
        textoAMorse.put('3', "...--");
        textoAMorse.put('4', "....-");
        textoAMorse.put('5', ".....");
        textoAMorse.put('6', "-....");
        textoAMorse.put('7', "--...");
        textoAMorse.put('8', "---..");
        textoAMorse.put('9', "----.");
        textoAMorse.put('.', ".-.-.-");
        textoAMorse.put(',', "--..--");
        textoAMorse.put('?', "..--..");
        textoAMorse.put('\'', ".----.");
        textoAMorse.put('!', "-.-.--");
        textoAMorse.put('/', "-..-.");
        textoAMorse.put('(', "-.--.");
        textoAMorse.put(')', "-.--.-");
        textoAMorse.put('&', ".-...");
        textoAMorse.put(':', "---...");
        textoAMorse.put(';', "-.-.-.");
        textoAMorse.put('=', "-...-");
        textoAMorse.put('+', ".-.-.");
        textoAMorse.put('-', "-....-");
        textoAMorse.put('_', "..--.-");
        textoAMorse.put('"', ".-..-.");
        textoAMorse.put('$', "...-..-");
        textoAMorse.put('@', ".--.-.");

        for (char key : textoAMorse.keySet()) {
            morseATexto.put(textoAMorse.get(key), key);
        }
    }

    public static String textoAMorse(String texto) {
        texto = texto.toUpperCase();
        StringBuilder morse = new StringBuilder();
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c == ' ') {
                morse.append("  "); // Dos espacios entre palabras en Morse
            } else if (textoAMorse.containsKey(c)) {
                morse.append(textoAMorse.get(c)).append(" "); // Un espacio entre caracteres en Morse
            }
        }
        return morse.toString().trim(); // Eliminar espacios extra al principio y al final
    }

    public static String morseATexto(String morse) {
        String[] palabras = morse.split("  "); // Separar palabras
        StringBuilder texto = new StringBuilder();
        for (String palabra : palabras) {
            String[] letras = palabra.split(" "); // Separar letras
            for (String letra : letras) {
                if (morseATexto.containsKey(letra)) {
                    texto.append(morseATexto.get(letra)); // Agregar letra correspondiente al texto
                }
            }
            texto.append(" "); // Agregar espacio entre palabras
        }
        return texto.toString().trim(); // Eliminar espacios extra al principio y al final
    }

    public static String convertir(String entrada) {
        if (entrada.contains(".") || entrada.contains("-")) {
            return morseATexto(entrada);
        } else {
            return textoAMorse(entrada);
        }
    }

    public static void main(String[] args) {
        String texto = "Hola MUNDO";
        System.out.println("Texto: " + texto);
        System.out.println("Texto a Morse: " + convertir(texto));

        String morse = ".... --- .-.. .-  -- ..- -. -.. ---";
        System.out.println("Morse: " + morse);
        System.out.println("Morse a Texto: " + convertir(morse));
    }
}

