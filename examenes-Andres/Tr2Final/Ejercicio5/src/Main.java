import Excepcion.CorreoIncorrectoException;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String correo = JOptionPane.showInputDialog("Dime una direccion de correo electronico").trim();

        //Comprobaciones \b[a-zA-Z1-9-_]+@[a-zA-Z1-9-_]+(.[a-zA-Z]{2,6}){1,3}\b
        Pattern pattern = Pattern.compile("\\b[a-zA-Z1-9-_]+@[a-zA-Z1-9-_]+(.[a-zA-Z]{2,6}){1,3}\\b", Pattern.CASE_INSENSITIVE);
        Matcher correo_valido = pattern.matcher(correo);

        //Validacion
        if (correo_valido.matches()){System.out.println("El correo: "+correo+" es valido");}
        else {
            try {throw new CorreoIncorrectoException("El correo: "+correo+" es incorrecto");
            } catch (CorreoIncorrectoException e) {System.out.println(e.fillInStackTrace());}
        }
    }
}
