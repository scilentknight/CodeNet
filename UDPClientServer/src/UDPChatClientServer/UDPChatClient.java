package UDPChatClientServer;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UDPChatClient {

    public static void main(String[] args) {
        int port = 3000;

        try (DatagramSocket socket = new DatagramSocket()) {

            InetAddress serverAddr = InetAddress.getLocalHost();
            Scanner scanner = new Scanner(System.in);
            byte[] buffer = new byte[1024];

            System.out.println("Connected to UDP Chat Server");

            while (true) {

                // Send message to server
                System.out.print("Client: ");
                String msg = scanner.nextLine();
                byte[] data = msg.getBytes(StandardCharsets.US_ASCII);

                DatagramPacket request =
                        new DatagramPacket(data, data.length, serverAddr, port);
                socket.send(request);

                // Receive reply from server
                DatagramPacket response =
                        new DatagramPacket(buffer, buffer.length);
                socket.receive(response);

                String serverMsg = new String(
                        response.getData(),
                        0,
                        response.getLength(),
                        StandardCharsets.US_ASCII
                );

                System.out.println("Server: " + serverMsg);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

