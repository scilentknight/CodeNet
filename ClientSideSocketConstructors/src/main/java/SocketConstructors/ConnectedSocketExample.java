package SocketConstructors;

import java.net.*;
import java.io.*;

public class ConnectedSocketExample {
    public static void main(String[] args) {
        try {
// Step 1: Create socket and connect to server
            Socket s = new Socket("www.google.com", 80);


// Step 2: Display connection details
            System.out.println("Connected to: " + s.getInetAddress());
            System.out.println("Remote Port: " + s.getPort());
            System.out.println("Local Port: " + s.getLocalPort());


// Step 3: Get output stream and send HTTP request
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            out.println("GET / HTTP/1.1");
            out.println("Host: www.google.com");
            out.println();


// Step 4: Read response from server
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(s.getInputStream()));


            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                if (line.isEmpty()) break; // Stop after headers
            }


// Step 5: Close socket
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}