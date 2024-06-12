import javax.swing.*;
import java.awt.*;

public class EjemploImagen extends JFrame {
    public EjemploImagen() {
        setTitle("Ejemplo de imagen en Java");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Crea un JLabel para mostrar la imagen
        JLabel imagenLabel = new JLabel();

        // Carga la imagen desde el archivo "imagen.png"
        ImageIcon imagenIcono = new ImageIcon("src\\main\\java\\img.png");

        // Asigna el icono al JLabel
        imagenLabel.setIcon(imagenIcono);

        // Añade el JLabel a la ventana
        add(imagenLabel, BorderLayout.CENTER);

        // Ajusta automáticamente el tamaño de la ventana para adaptarse a la imagen
        pack();

        // Hace visible la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        // Crea una instancia de la clase EjemploImagen
        SwingUtilities.invokeLater(EjemploImagen::new);
    }
}
