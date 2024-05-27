public class Ejer3 {
    public static void main(String[] args) {
        int primerValor = 0;
        int segundoValor = 1;
        System.out.println(primerValor);
        System.out.println(segundoValor);

        for (int i = 3; i <= 50; i++) {
            int siguientevalor = primerValor + segundoValor;
            System.out.println(siguientevalor);

            primerValor = segundoValor;
            segundoValor = siguientevalor;
        }
    }
}
