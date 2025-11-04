package URLEncodeDecode;

import java.net.*;
import java.io.*;

public class RelativeURLDemo {
    public static void main(String[] args) {
        try {
            // Base URL
            URL base = new URL("https://apple.com");

            // Relative URL
            String relativePath = "store";

            // Resolve relative URL to absolute URL
            URL absoluteURL = new URL(base, relativePath);
            System.out.println("Base URL: " + base);
            System.out.println("Relative URL: " + relativePath);
            System.out.println("Resolved Absolute URL: " + absoluteURL);

            // Check permissions / accessibility (HTTP response)
            HttpURLConnection connection = (HttpURLConnection) absoluteURL.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();
            String responseMessage = connection.getResponseMessage();

            System.out.println("\n--- URL Permissions / Access Info ---");
            System.out.println("HTTP Response Code: " + responseCode);
            System.out.println("HTTP Response Message: " + responseMessage);

            // Optional: Display allowed methods (if provided)
            String allowHeader = connection.getHeaderField("Allow");
            if (allowHeader != null) {
                System.out.println("Allowed Methods: " + allowHeader);
            } else {
                System.out.println("Allowed Methods: (Not specified by server)");
            }

            connection.disconnect();

        } catch (MalformedURLException e) {
            System.out.println("Invalid URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error connecting to the URL: " + e.getMessage());
        }
    }
}

