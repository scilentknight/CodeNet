package SocketConstructors;

import java.net.*;
import java.io.*;

public class InetAddressSocketExample {
    public static void main(String[] args) {
        try {
// Step 1: Get InetAddress object for localhost
            InetAddress addr = InetAddress.getByName("localhost");


// Step 2: Create socket using InetAddress and port number
            Socket s = new Socket(addr, 8080);


// Step 3: Display connection information
            System.out.println("Connected to: " + s.getInetAddress());
            System.out.println("Remote Port: " + s.getPort());
            System.out.println("Local Port: " + s.getLocalPort());


// Step 4: Send message to server
            PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            out.println("Hello Server");


// Step 5: Read response from server
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(s.getInputStream()));
            System.out.println("Server Response: " + in.readLine());


// Step 6: Close socket
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}