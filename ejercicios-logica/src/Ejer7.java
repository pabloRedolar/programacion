public class Ejer7 {
    public static void main(String[] args) {
        String texto = "Hola mundo";
        String textoInvertido = invertirCadena(texto);

        System.out.println("Texto original: " + texto);
        System.out.println("Texto invertido: " + textoInvertido);
    }

    public static String invertirCadena(String texto) {
        StringBuilder textoInvertido = new StringBuilder();

        for (int i = texto.length() - 1; i > 0; i--) {

            System.out.println(i + " " + texto.charAt(i));

            textoInvertido.append(texto.charAt(i));
        }
        return textoInvertido.toString();
    }
}
