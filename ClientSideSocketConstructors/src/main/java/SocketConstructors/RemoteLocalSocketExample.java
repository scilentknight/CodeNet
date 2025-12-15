package SocketConstructors;

import java.net.*;
import java.io.*;

public class RemoteLocalSocketExample {
    public static void main(String[] args) {
        try {
// Step 1: Get remote and local addresses
            InetAddress remote = InetAddress.getByName("example.com");
            InetAddress local = InetAddress.getLocalHost();


// Step 2: Connect to remote host on port 80 using local port 6000
            Socket s = new Socket(remote, 80, local, 6000);


// Step 3: Display connection information
            System.out.println("Connected to: " + s.getInetAddress());
            System.out.println("Remote Port: " + s.getPort());
            System.out.println("Local Address: " + s.getLocalAddress());
            System.out.println("Local Port: " + s.getLocalPort());


// Step 4: Send simple HTTP GET request
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            out.println("GET / HTTP/1.1");
            out.println("Host: example.com");
            out.println();


// Step 5: Read and display response headers only
            BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
                if (line.isEmpty()) break; // Stop after headers
            }


// Step 6: Close the socket
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}