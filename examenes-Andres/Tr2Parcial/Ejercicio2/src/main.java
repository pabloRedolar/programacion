import Clases.Gatos;

public class main {
    public static void main(String[] args) {
        Gatos gato1 = new Gatos();
        Gatos gato2 = new Gatos("voulture","","");
        Gatos gato3 = new Gatos("macho");
        Gatos gato4 = new Gatos("macho","voulture");

        System.out.println(gato1);
        System.out.println(gato2);
        System.out.println(gato3);
        System.out.println(gato4+"\n");

        Gatos gato5 = gato1.apareaCon(gato3);
        Gatos gato6 = gato1.apareaCon(gato2);

        System.out.println("\n"+gato5);
        System.out.println(gato6);
    }
}
