package java_intro.week12.practical_12;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.stream.Collectors;

public class HttpClientExample {
    public static void main(String[] args) throws IOException {
        System.out.println("Response from /: " +
                sendGetRequest("http://localhost:8000/"));
        System.out.println("Response from /time: " +
                sendGetRequest("http://localhost:8000/time"));
        System.out.println("Response from /echo?message=Hello: " +
                sendGetRequest("http://localhost:8000/echo?message=Hello"));
    }

    private static String sendGetRequest(String urlString)
            throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection)
                url.openConnection();
        connection.setRequestMethod("GET");
        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            try (BufferedReader reader = new BufferedReader(new
                    InputStreamReader(connection.getInputStream()))) {
                return
                        reader.lines().collect(Collectors.joining("\n"));
            }
        } else {
            return "Error: HTTP " + responseCode;
        }
    }
}
