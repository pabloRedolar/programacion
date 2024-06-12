public class Main {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://api.themoviedb.org/3/authentication")
                .get()
                .addHeader("accept", "application/json")
                .addHeader("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxNTk4YjJkNDNkOGM3NjNiYmUzY2NiNzRhMDM1Y2U3MSIsInN1YiI6IjY2NTc5ZDc5ZjEyOWMzMWU4N2M0NjYxZSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.Z7h85Uioiz-7J4ON3yG6xmBhL8enPhXibktVleCkJFY")
                .build();

        Response response = client.newCall(request).execute();
    }
}
