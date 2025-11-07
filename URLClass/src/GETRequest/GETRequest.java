// 7. Communicate with Server-Side Programs through GET. (2022_14_Prakash)
package GETRequest;

import java.net.URL;
import java.net.HttpURLConnection;
import java.io.InputStream;
import java.io.IOException;

public class GETRequest {
    public static void main(String[] args) {
        HttpURLConnection connection = null;
        InputStream inputStream = null;

        try {
            // Server-side script URL with query parameters
            String urlString = "https://httpbin.org/get?name=Scilent&age=22";

            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();

            // Set request method to GET
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(5000);
            connection.setReadTimeout(5000);

            // Get the response code
            int responseCode = connection.getResponseCode();
            System.out.println("HTTP Response Code: " + responseCode);

            // Read response using InputStream only
            inputStream = connection.getInputStream();
            byte[] buffer = new byte[4096];
            int bytesRead;

            System.out.println("Server Response:");
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                // Convert bytes to string and print
                System.out.print(new String(buffer, 0, bytesRead, "UTF-8"));
            }

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
