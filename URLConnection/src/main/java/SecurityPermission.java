// WAP to read the security permissions of server addresses [https://kathford.edu.np/contact-us/ and https://kathford.edu.np]. (2022_14_Prakash)

import java.net.*;
import java.io.*;

public class SecurityPermission {
    public static void main(String[] args) {
        String urlString1 = "https://kathford.edu.np/contact-us/";
        String urlString2 = "https://kathford.edu.np";
        try {
            URL url1 = new URL(urlString1);
            URL url2 = new URL(urlString2);
            System.out.println("Security permission for " + urlString1 + ": " + url1.openConnection().getPermission());
            System.out.println("Security permission for " + urlString2 + ": " + url2.openConnection().getPermission());

        } catch (MalformedURLException e) {
            System.out.println("Error while parsing url");
        } catch (IOException e) {
            System.out.println("Error while opening connection");
        }
    }
}
