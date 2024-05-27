import Clases.Conejo;
import Clases.Leon;

public class App {
    public static void main(String[] args) {
        Leon leon = new Leon("Simba");
        Conejo conejo = new Conejo("Hamst");

        leon.comunicarse();
        conejo.comunicarse();
        leon.cazar();
        conejo.pastar();
        System.out.println("\n"+leon.dieta());
        System.out.println(conejo.dieta()+"\n");
        System.out.println(leon.toString());
        System.out.println(conejo.toString());

    }
}
