import java.io.*;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        //Localizamos la carpeta data y comprobamos el numero de archivos
        File data = new File("src/data");
        System.out.println("Hay "+data.listFiles().length+" archivos.");

        //Creamos el fichero de destino
        File salida_Ej2 = new File("src/salida_Ej2.txt");
        try {salida_Ej2.createNewFile();}
        catch (IOException e) {throw new RuntimeException(e);}
        BufferedWriter writer = null;
        BufferedReader reader = null;

        //Abrimos el fichero para escribir
        try {writer = new BufferedWriter(new FileWriter(salida_Ej2));} catch (IOException e) {throw new RuntimeException(e);}

        //Leemos y escribimos en fichero
        if (writer!=null) {
            for (File archivo : Objects.requireNonNull(data.listFiles())) {
                try {
                    reader = new BufferedReader(new FileReader(archivo));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        writer.write(line);
                        writer.newLine();
                        writer.flush();
                    }

                } catch (IOException e) {
                    throw new RuntimeException(e);
                } finally {
                    if (reader != null) {
                        try {reader.close();} catch (IOException e) {throw new RuntimeException(e);}
                    }
                }
            }
            try {writer.close();} catch (IOException e) {throw new RuntimeException(e);}
        }
    }
}
