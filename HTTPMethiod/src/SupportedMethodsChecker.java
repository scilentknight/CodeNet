// Write a program to find out which methods does a url support.
// [use HTTPURLConnection and HTTP Options method] (2022_14_Prakash)

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SupportedMethodsChecker {
    public static void main(String[] args) {
        String targetUrl = "http://www.tu.edu.np";

        try {
            // Create URL object
            URL url = new URL(targetUrl);

            // Open connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method to OPTIONS
            connection.setRequestMethod("OPTIONS");
            connection.connect();

            // Get supported methods from Allow header
            String methods = connection.getHeaderField("Allow");

            System.out.println("The following methods are supported by this URL: " + methods);

            connection.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}

