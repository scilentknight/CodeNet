// 2. WAP to implement UDP chat server client using DatagramSocket.(2022_14_Prakash)
package UDPEchoClientServer;

import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UDPEchoClient {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();
        InetAddress server = InetAddress.getByName("localhost");
        int port = 2013;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter message (type 'exit' to quit): ");
            String message = scanner.nextLine();

            if (message.equalsIgnoreCase("exit")) {
                break;
            }

            byte[] data = message.getBytes(StandardCharsets.UTF_8);
            DatagramPacket request = new DatagramPacket(data, data.length, server, port);
            socket.send(request);

            DatagramPacket response = new DatagramPacket(new byte[1024], 1024);
            socket.receive(response);

            String echoed = new String(
                    response.getData(),
                    0,
                    response.getLength(),
                    StandardCharsets.UTF_8
            );

            System.out.println("Echoed from server: " + echoed);
        }

        socket.close();
    }
}
