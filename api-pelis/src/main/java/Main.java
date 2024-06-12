import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class Main {
    public static void main(String[] args) {
        try {
            String apiUrl = "https://api.themoviedb.org/3/discover/movie";
            String accessToken = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxNTk4YjJkNDNkOGM3NjNiYmUzY2NiNzRhMDM1Y2U3MSIsInN1YiI6IjY2NTc5ZDc5ZjEyOWMzMWU4N2M0NjYxZSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.Z7h85Uioiz-7J4ON3yG6xmBhL8enPhXibktVleCkJFY";

            int pageNumber = 1;
            int totalPages = Integer.MAX_VALUE; // Inicializamos con un valor alto para el bucle

            while (pageNumber <= totalPages) {
                // Construir la URL de la solicitud con paginación
                URL url = new URL(apiUrl + "?api_key=" + accessToken + "&page=" + pageNumber);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                JSONObject jsonResponse = new JSONObject(response.toString());

                // Obtener el número total de páginas
                totalPages = jsonResponse.getInt("total_pages");

                // Procesar los resultados de la página actual
                JSONArray results = jsonResponse.getJSONArray("results");
                for (int i = 0; i < results.length(); i++) {
                    JSONObject movie = results.getJSONObject(i);
                    String title = movie.getString("title");
                    System.out.println(title);
                    // Aquí puedes procesar más detalles de la película si es necesario
                }

                pageNumber++;

                connection.disconnect();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
