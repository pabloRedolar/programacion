import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class main {
    public static void main(String[] args) {

        File Data_Science = new File("src/data/Languages for Data Science.txt");

        //Entiendo que por palabra minimo a de tener un caracter, por ejemplo s es un is en Ingles. Si se consideraran que han de ser dos podria ser: "\\b\\w{1,}s\\b"
        Pattern palabras_terminadas_s = Pattern.compile("\\b\\w*s\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher;

        int contador = 0;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(Data_Science)) ){
            String line;
            while ((line= bufferedReader.readLine())!=null){
                matcher = palabras_terminadas_s.matcher(line);
                int ultima_ubicacion = 0;
                //La ultima ubicacion permite que continue buscando desde la ultima palabra que encontro
                // en una linea pueden haber varios casos coincidentes
                for (int i = 0; i < line.length(); i++) {
                    if (matcher.find(ultima_ubicacion)){
                        System.out.println(matcher.toString());
                        ultima_ubicacion = matcher.end();
                        contador++;
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("En el fichero hay "+contador+" palabras terminadas en s");
    }
}
