import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        //Metodo de organizacion
        TreeMap<String, Integer> lista_de_palabras = new TreeMap<>();
        Pattern pattern = Pattern.compile("\\b\\w+\\b", Pattern.CASE_INSENSITIVE);
        //Recorremos el archivo
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/Metadata in DBMS.txt"))){
            String linea;
            while ((linea= bufferedReader.readLine())!=null){
                Matcher matcher = pattern.matcher(linea);
                while (matcher.find()){
                    lista_de_palabras.put(matcher.group().toLowerCase(), lista_de_palabras.getOrDefault(matcher.group().toLowerCase(),0)+1);
                }
            }
        } catch (IOException e) {throw new RuntimeException(e);}
        //Resultado
        System.out.println(lista_de_palabras);
    }
}
