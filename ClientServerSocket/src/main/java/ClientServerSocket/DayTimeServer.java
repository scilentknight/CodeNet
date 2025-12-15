package ClientServerSocket;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class DayTimeServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            System.out.println("DayTime Server running on port 5000...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");

                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println(new Date().toString());   // Send current date and time

                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
