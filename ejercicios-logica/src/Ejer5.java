import javax.swing.*;

public class Ejer5 {
    public static void main(String[] args) {
        String poligono = (JOptionPane.showInputDialog("Dime el tipo de poligono"));

        float area = areapoligono(poligono);

        System.out.println(area);
    }

    public static float areapoligono(String tipopoligono) {
        float area = 0;
        if (tipopoligono.equalsIgnoreCase("cuadrado") || tipopoligono.equalsIgnoreCase("rectangulo")) {
            float lado1 = Float.parseFloat((JOptionPane.showInputDialog("Lado 1")));
            float lado2 = Float.parseFloat((JOptionPane.showInputDialog("Lado 2")));

            area = lado1 * lado2;
        } else if (tipopoligono.equalsIgnoreCase("triangulo")) {
            float base = Float.parseFloat((JOptionPane.showInputDialog("Dime la base")));
            float altura = Float.parseFloat((JOptionPane.showInputDialog("Dime la altura")));

            area = base * altura / 2;
        }
        return area;
    }
}
