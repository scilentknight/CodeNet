package URLInfo;

import java.net.*;

public class URLInfo {
    public static void main(String[] args) {
        try {
            // Create a URL object
            URL url = new URL("https://www.pathakprakash.com.np");

            // Display different parts of the URL
            System.out.println("Full URL: " + url.toString());
            System.out.println("Protocol: " + url.getProtocol());
            System.out.println("Host: " + url.getHost());
            System.out.println("Port: " + url.getPort());
            System.out.println("Default Port: " + url.getDefaultPort());
            System.out.println("Path: " + url.getPath());
            System.out.println("Query: " + url.getQuery());
            System.out.println("File: " + url.getFile());
            System.out.println("Ref (Anchor): " + url.getRef());
            System.out.println("Authority: " + url.getAuthority());
        }
        catch (MalformedURLException e) {
            System.out.println("Invalid URL format: " + e.getMessage());
        }
    }
}
