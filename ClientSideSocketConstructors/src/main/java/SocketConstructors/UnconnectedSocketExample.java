package SocketConstructors;

import java.net.*;
import java.io.*;

public class UnconnectedSocketExample {
    public static void main(String[] args) {
        try {
// Step 1: Create an unconnected socket
            Socket s = new Socket();


// Step 2: Specify server address and port
            SocketAddress serverAddress =
                    new InetSocketAddress("www.google.com", 80);


// Step 3: Connect the socket to the server
            s.connect(serverAddress);


// Step 4: Check connection status
            System.out.println("Connected to server: " + s.isConnected());


// Step 5: Close the socket
            s.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
