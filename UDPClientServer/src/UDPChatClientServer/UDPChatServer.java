package UDPChatClientServer;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UDPChatServer {

    public static void main(String[] args) {
        int port = 3000;

        try (DatagramSocket socket = new DatagramSocket(port)) {

            System.out.println("UDP Chat Server started on port " + port);

            Scanner scanner = new Scanner(System.in);
            byte[] buffer = new byte[1024];

            while (true) {

                // Receive message from client
                DatagramPacket request =
                        new DatagramPacket(buffer, buffer.length);
                socket.receive(request);

                String clientMsg = new String(
                        request.getData(),
                        0,
                        request.getLength(),
                        StandardCharsets.US_ASCII
                );

                System.out.println("Client: " + clientMsg);

                // Send message to client
                System.out.print("Server: ");
                String serverMsg = scanner.nextLine();
                byte[] data = serverMsg.getBytes(StandardCharsets.US_ASCII);

                DatagramPacket response =
                        new DatagramPacket(
                                data,
                                data.length,
                                request.getAddress(),
                                request.getPort()
                        );

                socket.send(response);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

