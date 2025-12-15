package ClientServerSocket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(6000)) {
            System.out.println("Echo Server running on port 6000...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Client: " + message);
                    out.println("Echo: " + message);
                }

                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}