package ConsoleWHOISClient;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class WHOISClient {

    public static void main(String[] args) {

        String server = "whois.internic.net";
        int port = 43;

        // Read domain name from user
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter domain name: ");
        String domain = sc.nextLine();

        try {
            // Create socket connection to WHOIS server
            Socket socket = new Socket(server, port);

            // Output stream to send request
            PrintWriter out = new PrintWriter(
                    socket.getOutputStream(), true);

            // Input stream to read response
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(socket.getInputStream()));

            // Send domain name to WHOIS server
            out.println(domain);

            System.out.println("\nWHOIS Information:\n");

            // Read and display server response
            String response;
            while ((response = in.readLine()) != null) {
                System.out.println(response);
            }

            // Close resources
            socket.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
