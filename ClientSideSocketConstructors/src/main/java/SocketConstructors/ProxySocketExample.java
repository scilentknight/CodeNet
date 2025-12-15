package SocketConstructors;

import java.net.*;
import java.io.*;

public class ProxySocketExample {
    public static void main(String[] args) {
        try {
            // Step 1: Define proxy server (SOCKS)
            String proxyHost = "127.0.0.1"; // Replace with your proxy IP
            int proxyPort = 1080;           // Replace with your proxy port
            Proxy proxy = new Proxy(Proxy.Type.SOCKS, new InetSocketAddress(proxyHost, proxyPort));

            // Step 2: Connect to example.com on port 80 using the proxy
            Socket s = new Socket(proxy);
            s.connect(new InetSocketAddress("example.com", 80));

            // Step 3: Display connection information
            System.out.println("Connected to: " + s.getInetAddress());
            System.out.println("Remote Port: " + s.getPort());
            System.out.println("Local Address: " + s.getLocalAddress());
            System.out.println("Local Port: " + s.getLocalPort());
            System.out.println("Via Proxy: " + proxyHost + ":" + proxyPort);

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
