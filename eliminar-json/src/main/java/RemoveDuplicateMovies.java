import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateMovies {
    public static void main(String[] args) {
        // Lee el JSON desde un archivo
        String jsonStr = readJsonFromFile("src\\main\\java\\series.json");

        // Verifica y elimina las películas duplicadas
        JSONArray uniqueMovies = removeDuplicates(jsonStr);

        // Escribe el nuevo JSON con las películas únicas
        writeJsonToFile(uniqueMovies.toString(), "series_bien.json");
    }

    private static JSONArray removeDuplicates(String jsonStr) {
        JSONArray jsonArray = new JSONArray(jsonStr);
        Set<String> movieTitles = new HashSet<>();
        JSONArray uniqueMovies = new JSONArray();

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject movie = jsonArray.getJSONObject(i);
            String title = movie.getString("titulo");

            // Verifica si el título ya existe en el conjunto
            if (!movieTitles.contains(title)) {
                // Si no existe, agrega la película al conjunto y al nuevo JSON
                movieTitles.add(title);
                uniqueMovies.put(movie);
            }
        }

        return uniqueMovies;
    }

    private static String readJsonFromFile(String filePath) {
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    private static void writeJsonToFile(String jsonStr, String filePath) {
        try (FileWriter file = new FileWriter(filePath)) {
            file.write(jsonStr);
            System.out.println("Se ha creado el archivo '" + filePath + "' correctamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
