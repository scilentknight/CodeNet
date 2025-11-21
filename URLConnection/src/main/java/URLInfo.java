// WAP to find out the content type, content length and last modified and access date of a URL. (2022_14_Prakash)
import java.net.*;
import java.io.*;

public class URLInfo {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://kathford.edu.np");
            URLConnection connection = url.openConnection();
            connection.connect();

            System.out.println("Content Type: " + connection.getContentType());
            System.out.println("Content Length: " + connection.getContentLength());
            System.out.println("Last Modified: " + connection.getLastModified());
            System.out.println("Date of Access: " + connection.getDate());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

